

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1> Junit testing for Map application</h1>
 * @author Ryszard Kubinski 260731196
 *  @version 1
 *  @since Program Date: Oct 2018
 */

public class MapTest {

    private char[][] matrix = new char[100][100];
    private Map testMap = new Map(100, 100, matrix);

    /**
     * Makes sure a map object is properly created by the constructor
     */
    @Test
    public void constructorTest() {
        assertNotNull(testMap);
    }

    /**
     * Checks if the initializer method in Map creates a matrix full of water characters
     */
    @Test
    public void initializer() {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                matrix[i][j] = '~';
            }
        }
        assertArrayEquals(testMap.initializer(), matrix);
    }
    /**
     * Uses known valid inputs and inserts them into different spots in the 2D matrix.
     * Inputs are inserted within the matrix, at its boundaries and on the outside.
     * This verifies if proper exceptions are thrown when insertion is attempted in illegal location.
     */

    @Test
    public void dataAdder() {
        char[] testSet = new char[]{'G', '~', '#'};   //testing all the possible valid char inputs
        int[] testCases = new int[]{-1, 0, 1, 49, 50, 51, 99, 100, 101};   //Here are our valid, invalid and boundary cases

        for (int i = 0; i < testSet.length - 1; i++) {
            for (int j = 0; j < testCases.length - 1; j++) {
                for (int n = 0; n < 100; n++) {

                    //Testing if our out of bounds cases raise Errors
                    if ((testCases[j] == -1 || testCases[j] == 100 || testCases[j] == 101)) {
                        assertEquals(-1, Map.dataAdder(matrix, n, testCases[j], testSet[i]));
                        assertEquals(-1, Map.dataAdder(matrix, testCases[j], n, testSet[i]));
                    }

                    //Testing if our proper boundary/within bounds cases do not raise errors
                    if ((testCases[j] == 0 || testCases[j] == 1 || testCases[j] == 49 || testCases[j] == 50 || testCases[j] == 51 || testCases[j] == 99)) {
                        assertEquals(0, Map.dataAdder(matrix, n, testCases[j], testSet[i]));
                        assertEquals(0, Map.dataAdder(matrix, testCases[j], n, testSet[i]));
                    }


                }
            }
        }

    }
    /**
     * Validates the input validation method.
     * Checks if the method that validates user input based on provided datasets is detecting improper inputs
     */

    @Test
    public void validityChecker() {

        char[] testSet1 = new char[]{'~', 'G', '#'};
        char[] testSet2 = new char[]{'N', 'Y'};
        char testChar;

        for (int i = 32; i < 127; i++) {
            testChar = (char) i;
            if (testChar == 'G' || testChar == '~' || testChar == '#') {
                assertTrue(Map.validityChecker(testSet1, testChar));
            } else if (testChar == 'Y' || testChar == 'N') {
                assertTrue(Map.validityChecker(testSet2, testChar));
            }
        }
    }

}