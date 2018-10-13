/**
 * This class represents a tile Map. It also provides constants and methods
 * relating to the identity of the tile characters and their validation.
 * @author Cristian Groza
 */
public class Map
{
    /**
     * 2d array representing the tile map.
     */
    private char[][] map;

    /**
     * Stores the maximum height of the map.
     */
    private int maxHeight;         // stores map height
    /**
     * Stores the maximum width of the map.
     */
    private int maxWidth;          // stores map width

    /**
     * Constant is ASCII representation of the WATER tile.
     */
    public static final char TILE_WATER = '~';
    /**
     * Constant is ASCII representation of the GRASS tile.
     */
    public static final char TILE_GRASS = 'G';
    /**
     * Constant is ASCII representation of the TREE tile.
     */
    public static final char TILE_TREE  = '#';

    /**
     * Constructs a Map with valid height and width
     * <p>
     * Side effects: Allocates memory 2D array, may throw exceptions if requested map is too big
     * @param aHeight  maximum height of the map (positive, non-zero)
     * @param aWidth   maximum width of the map (positive, non-zero)
     * @exception IllegalArgumentException when arguments are zero or negative
     */
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

    /**
     * Getter method for private variable maxHeight.
     * @return Maximum height of map.
     */
    public int getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * Getter method for private variable maxWidth.
     * <p>
     * No side effects.
     * @return Maximum height of map.
     */
    public int getMaxWidth()
    {
        return maxWidth;
    }

    /**
     * Validates characters to be good tile characters.
     * @param c character to be validated
     * @return true if valid, false if invalid.
     */
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

    /**
     * Place a valid tile at column x and row y. Validates the input beforehand.
     * @param x map column index
     * @param y map row index
     * @param tile identity of tile (TILE_WATER, TILE_GRASS, TILE_TREE)
     * @return true if input was valid and tile was edited and false otherwise.
     */
    public boolean setTile(int x, int y, char tile)
    {
        // Check if coordinates are within the map
        // Also protect the map from invalid tile chars by validating the char first
        if(x >= 0 && x < maxWidth && y >= 0 && y < maxHeight && isCharAValidTile(tile))
            {
                map[y][x] = tile;
                return true;       // return true when successful
            }
        return false;              // return false when fails
    }

    /**
     *  Check if map has correct dimension and only contains valid tiles.
     *  @return true if dimensions and tiles are valid and false otherwise.
     */
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

    /** Print an ASCII representation of the entire map.
     * <p>
     * Side effects: Writes to STDOUT
     */
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
