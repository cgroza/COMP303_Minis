import java.lang.UnsupportedOperationException;
class Map
{
    private char[][] map;

    // These two variables store the dimensions of the array representation of
    // the map
    private int maxHeight;         // stores map height
    private int maxWidth;          // stores map width

    // ASCII representation of tiles in the map
    public static final char TILE_WATER = '~';
    public static final char TILE_GRASS = 'G';
    public static final char TILE_TREE  = '#';

    // Purpose: Constructs a Map with valid height and width
    // Parameters: aHeight - maximum height of the map (positive, non-zero)
    //             aWidth  - maximum width of the map (positive, non-zero)
    // Returns: Constructed object, throws IllegalArgumentException when arguments are invalid
    // Side effects: Allocates memory 2D array, may throw exceptions if requested map is too big
    public Map(int aHeight, int aWidth)
    {

        // Abort if map dimensions are not valid
        if(aHeight <= 0 || aWidth <= 0)
            throw new IllegalArgumentException("Cannot create map with 0 or negative dimensions.");

        maxHeight = aHeight;
        maxWidth = aWidth;

        // Create map representation as 2D array of height maxHeight and width maxWidth
        map = new char[maxHeight][maxWidth];

        // Fill with default water tiles.
        for(int y = 0; y < maxHeight; y++)
            {
                for(int x = 0; x < maxWidth; x++)
                    map[y][x] = TILE_WATER;
            }
    }

    // Purpose: Getter methods for private variable maxHeight
    // Parameters: None
    // Returns: Value of maxHeight
    // Side effects: None
    public int getMaxHeight()
    {
        return maxHeight;
    }

    // Purpose: Getter methods for private variable maxWidth
    // Parameters: None
    // Returns: Value of maxWidth
    // Side effects: None
    public int getMaxWidth()
    {
        return maxWidth;
    }

    // Purpose:  Allow quick validation of characters from user input
    // Parameters: c - character to be validates
    // Returns: boolean - true if valid, false if invalid
    // Side effects: None
    public static boolean isCharAValidTile(char c)
    {
        switch(c)
            {
            case 'G': case '~': case '#': // true if among the three valid tiles
                return true;
            default:            // false otherwise
                return false;
            }
    }

    // Purpose: Place a valid tile at column x and row y. Validates its input
    // Parameters: x - column index, y - row index, tile - identity of tile (TILE_WATER, TILE_GRASS, TILE_TREE)
    // Returns: boolean - true if input was valid and tile was edited. False otherwise
    // Side effects: None
    public boolean setTile(int x, int y, char tile)
    {
        // Check if coordinates are within the map
        // Also protect the map from invalid tile chars by validating the char first
        if(x >= 0 && x < maxWidth && y >= 0 && y < maxHeight && isCharAValidTile(tile))
            {
                map[y][x] = tile;
                return true;    // return true when successful
            }
        return false;            // return false when fails
    }

    // Purpose: Checks if map has correct dimension and only contains valid tiles
    // Parameters: None
    // Returns: boolean - true if dimensions and tiles are valid. False otherwise
    // Side effects: None
    public boolean isValid()
    {
        // Check if 2D array dimensions agree with the constructor
        if(map.length != maxHeight || map[0].length != maxWidth)
            return false;
        // Check for invalid characters within the map
        for(int y = 0; y < maxHeight; y++)
            {
                for(int x = 0; x < maxWidth; x++)
                    {
                        if(!isCharAValidTile(map[y][x])) return false;
                    }
            }
        return true;
    }

    // Purpose: Prints an ASCII representation of the entire map
    // Parameters: None
    // Returns: None
    // Side effects: Writes to STDOUT
    public void printMap()
    {
        for(int y = 0; y < maxHeight; y++)
            {
                // Print row y
                for(int x = 0; x < maxWidth; x++)
                    System.out.print(map[y][x]);
                // Print new line at end of row
                System.out.println();
            }
    }
}
