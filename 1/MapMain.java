import java.util.Scanner;

class MapMain
{
    // Helper functions to manipulate string and read the keyboard

    // Purpose:  Turns the first  character in a string to uppercase
    // Parameters: s - string to be capitalized
    // Returns: Capitalized string
    // Side effects: None
    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    // Purpose: Read a single number from the prompt
    // Parameters: None
    // Returns: User input integer, negative integers as error values
    // Side effects: Reads STDIN
    public static int getPositiveNumber()
    {
        try {
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        }
        catch(Exception e) {
            // Negative values are used as error values and will make the
            // program ask the question again
            return -1;
        }
    }

    // Purpose: Read a single character from the prompt
    // Parameters: None
    // Returns: User input character, null byte ass error value
    // Side effects: Reads STDIN
    public static char getChar()
    {
        try {
            return (char) System.in.read();
        }
        catch(Exception e)
            {
                // The null byte is used as an error value and will make the
                // program ask the question again
                return '\0';
            }
    }

    // Helper functions that print to the screen and take input according to a template

    // Purpose: Dimension input template for width and height
    // Parameters: dimName - dimension name (width, height) to apply to template
    // Returns: Positive non zero integer of denoting size of dimension
    // Side effects: Reads STDIN, writes to STDOUT
    public static int askDimensionTemplate(String dimName)
    {
        int dim;
        while(true) {
            System.out.printf("Please input the maximum number of %ss: ", dimName);
            dim = getPositiveNumber();

            // If dimension is invalid, report error and try again
            if(dim <=0)
                System.out.printf("A %s must be an integer greater than 0.\n", dimName);
            else return dim;
        }
    }

    // Purpose: Coordinate input template for row and column coordinates
    // Parameters: componentName - dimension name (row, column) to apply to template
    //             maxValue - maximum allowed value for this coordinate (dimension - 1)
    // Returns: Positive non zero integer below maximum value denoting coordinate value
    // Side effects: Reads STDIN, writes to STDOUT
    public static int askCoordinateTemplate(String componentName, int maxValue)
    {
        int component;          // keeps the input integer for coordinate
        while(true) {
            System.out.printf("%s: ", capitalize(componentName));
            component = getPositiveNumber();

            // Check if coordinate is in valid
            // If coordinate is invalid, report error and try again
            if(component < 0 || component >= maxValue)
                System.out.printf("Invalid %s! it must be an integer between 0 and %d\n", componentName, maxValue - 1);
            else return component;
        }
    }

    // Purpose: Receives tile character and validates it
    // Parameters: None
    // Returns: Character that is Map.TILE_WATER, Map.TILE_GRASS, Map.TILE_TREE
    // Side effects: Reads STDIN, writes to STDOUT
    public static char askTile()
    {
        char tile;
        while(true) {
            System.out.print("Character: ");
            tile = getChar();
            // If tile is invalid, report and try again
            if(!Map.isCharAValidTile(tile))
                System.out.println("Invalid character! It must be either ~ or G or #.");
            else return tile;
        }
    }

    // Purpose: Asks the user to continue or stop
    // Parameters: None
    // Returns: Boolean false for stop, true for continue
    // Side effects: Reads STDIN, writes to STDOUT
    public static boolean askContinue()
    {
        char answer;
        while(true) {
            System.out.println("Would you like to enter another character (Y/N): ");
            answer = getChar();
            // If answer is invalid, report and try again. Otherwise, return
            // true if Y and false if N
            if(answer != 'Y' && answer != 'N')
                System.out.println("Invalid character! It must be either Y or N.");
            else
                return answer == 'Y';
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to Map!");

        int nRows = askDimensionTemplate("row");         // get valid height
        int nColumns = askDimensionTemplate("column");   // get valid width

        // Map throws IllegalArgumentException for invalid dimensions
        // We also validate its state via its own method
        Map map = new Map(nRows, nColumns);
        if(!map.isValid())
            {
                System.out.println("Failed to initialize map. Exiting.");
                return;
            }
        System.out.println("Map has been created.");

        System.out.println("Please add an object to the map (~ for water, G for grass, # for tree)");

        // Interrogate the user for tiles and coordinates until the user decides to stop
        while(true)
            {
                // Collect data
                int y = askCoordinateTemplate("row", map.getMaxHeight());      // get valid row number
                int x = askCoordinateTemplate("column", map.getMaxWidth());    //get valid column number
                char tile = askTile();           // get valid tile identity
                map.setTile(x, y, tile);         // write into map

                System.out.printf("Your %c was added to (%d,%d) in the map.\n", tile, y, x);

                // Exit infinite loop if the user wishes to stop
                if(!askContinue())
                    break;
            }
        System.out.println("Map is below: ");
        map.printMap();                          // show the map to the user
    }

}
