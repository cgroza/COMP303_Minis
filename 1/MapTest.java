public class MapTest
{
    // Test the constructor itself
    public static void mapTest()
    {
        // The constructor should throw an exception when illegal arguments are provided
        // (width < 1 and height < 1)

        for(int w = -1; w <= 3; w++)
            {
                for(int h = -1; h <= 3; h++)
                    {
                        try{
                            Map map = new Map(h, w);
                            if(map.isValid())
                                System.out.printf("Map constructor arguments: %d %d Result: valid object\n", h, w);
                            else
                                System.out.printf("Map constructor arguments: %d %d Result: invalid object\n", h, w);
                        }
                        catch(IllegalArgumentException e)
                            {
                                System.out.printf("Map constructor arguments: %d %d Result: IllegalArgumentException\n", h, w);
                            }
                    }
            }
    }

    public static void isCharAValidTileTest()
    {
        System.out.println("Test case for method isCharAValidTile:");
        // Test all possible chars. Only ~, G, # should return true.
        for(char c = 0; c <= 255; c++)
            {
                boolean result = Map.isCharAValidTile(c);
                System.out.printf("Arguments: %c Result: %B\n", c, result);
                c++;
            }

    }

    public static void setTileTest()
    {
        System.out.println("Test case for method setTile: ");
        // Create a 3 by 3 map.
        Map map = new Map(3, 3);
        // Attempt to insert all tiles in a 5x5 region beyond the map
        for(int y = -1; y < 4; y++)
            {
                for(int x = -1; x < 4; x++)
                    {
                        char[] tiles = new char[]{Map.TILE_WATER, Map.TILE_GRASS, Map.TILE_TREE};
                        for(char tile : tiles)
                            {
                                boolean result = map.setTile(x, y, tile);
                                System.out.printf("Arguments: %d %d %c Result: %B\n", x, y, tile, result);
                            }
                    }
            }
    }

    public static void getMaxHeightTest()
    {
        System.out.println("Test case for method getMaxHeight: ");
        // Create maps of height 1 to 100 and test getMaxHeight
        for(int h = 1; h < 4; h++)
            {
                Map map = new Map(h, 1);
                System.out.printf("Map constructor arguments: %d %d Result: %d Expected result %d\n", h, 1, map.getMaxHeight(), h);
            }
    }

    public static void getMaxWidthTest()
    {

        System.out.println("Test case for method getMaxWidth: ");
        // Create maps of width 1 to 100 and test getMaxHeight
        for(int w = 1; w < 4; w++)
            {
                Map map = new Map(1, w);
                System.out.printf("Map constructor arguments: %d %d Result: %d Expected result: %d\n", 1, w, map.getMaxWidth() , w);
            }
    }

    public static void isValidTest()
    {

        System.out.println("Test case for method isValid: ");
        // Create maps between height and widths 0 to 3 
        for(int w = 1; w <= 3; w++)
            {
                for(int h = 1; h <= 3; h++)
                    {
                        Map map = new Map(h, w);
                        System.out.printf("Map constructor arguments: %d %d Result: %B\n", h, w, map.isValid());
                    }
            }
    }

    public static void main(String[] args)
    {
        mapTest();
        isCharAValidTileTest();
        setTileTest();
        getMaxHeightTest();
        getMaxWidthTest();
        isValidTest();
    }
}
