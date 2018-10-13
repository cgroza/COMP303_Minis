import org.junit.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
  *This is a JUnit tester class for the Map class. It tests all its methods.
  * @author Cristian Groza
*/
public class JUnitMapTest extends TestCase
{
    // Test the constructor itself
    /**
     * Tests the Map constructor.
     */
    @Test
    public void testMap()
    {
        // The constructor should throw an exception when illegal arguments are provided
        // (width < 1 and height < 1)
        this.setName("testMap");
        System.out.println("Test case name: " + this.getName());
        for(int w = -1; w <= 3; w++)
            {
                for(int h = -1; h <= 3; h++)
                    {
                        try{
                            Map map = new Map(h, w);
                            assertTrue(map.isValid());
                        }
                        catch(IllegalArgumentException e)
                            {
                                assertTrue(w <= 0 || h <= 0);
                            }
                    }
            }
    }

    /**
     * Tests the Map.isCharAValidTile().
     */
    @Test
    public void testIsCharAValidTile()
    {
        this.setName("testIsCharAValidTile");
        System.out.println("Test case name: " + this.getName());
        // Test all possible chars. Only ~, G, # should return true.
        for(char c = 0; c <= 255; c++)
            {
                boolean result = Map.isCharAValidTile(c);
                boolean goodResult = c == Map.TILE_WATER || c == Map.TILE_TREE || c == Map.TILE_GRASS;
                assertEquals(goodResult, result);
                c++;
            }
    }

    /**
     * Tests the Map.setTile().
     */
    @Test
    public void testSetTile()
    {

        this.setName("testSetTile");
        System.out.println("Test case name: " + this.getName());
        // Create a 3 by 3 map.
        Map map = new Map(3, 3);
        // Attempt to insert all tiles in a 7x7 region beyond the map
        for(int y = -1; y < 6; y++)
            {
                for(int x = -1; x < 6; x++)
                    {
                        char[] tiles = new char[]{Map.TILE_WATER, Map.TILE_GRASS, Map.TILE_TREE};
                        for(char tile : tiles)
                            {
                                boolean result = map.setTile(x, y, tile);
                                if(y < 0 || y > 2 || x < 0 || x > 2)
                                    assertTrue(!result);
                                else
                                    assertTrue(result);
                            }
                    }
            }
    }

    /**
     * Tests the Map.getMaxHeight().
     */
    @Test
    public void testGetMaxHeight()
    {
        this.setName("testGetMaxHeight");
        System.out.println("Test case name: " + this.getName());
        // Create maps of height -10 to 10 and test getMaxHeight
        for(int h = -10; h < 10; h++)
            {
                try {
                    Map map = new Map(1, h);
                    assertEquals(h, map.getMaxWidth());
                } catch(IllegalArgumentException e)
                    {
                        assertTrue(h <= 0);
                    }
            }
    }

    /**
     * Tests the Map.getMaxWidth().
     */
    @Test
    public void testGetMaxWidth()
    {
        this.setName("testGetMaxWidth");
        System.out.println("Test case name: " + this.getName());
        // Create maps of width -10 to 10 and test getMaxHeight
        for(int w = -10; w < 10; w++)
            {
                try {
                    Map map = new Map(1, w);
                    assertEquals(w, map.getMaxWidth());
                } catch(IllegalArgumentException e)
                    {
                        assertTrue(w <= 0);
                    }
            }
    }

    /**
     * Tests the Map.isValid().
     */
    @Test
    public void testIsValid()
    {
        this.setName("testIsValid");
        System.out.println("Test case name: " + this.getName());
        // Create maps between height and widths -10 to 10
        for(int w = -10; w <= 10; w++)
            {
                for(int h = -10; h <= 10; h++)
                    {
                        try{
                            Map map = new Map(h, w);
                            assertTrue(map.isValid());
                        } catch(IllegalArgumentException e)
                            {
                                assertTrue(w <= 0 || h <= 0);
                            }

                    }
            }
    }
}
