



import java.util.Scanner;
/**
 *<h1>Program name: Map</h1>
 *<h2>Program Function: Contains methods used by MapMain that are used to modify the Map character table</h2>
 *@author Ryszard Kubinski 260731196
 *@since Sept 2018
 */

public class Map {


    private int maxRow;
    private int maxWidth;
    private char[][] matrix;

    /**Constructor
     * @throws IllegalArgumentException if input is invalid
     */


    public Map(int height, int width, char[][] map) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Cannot use 0 for input here.");
        }
        maxRow = height;
        maxWidth = width;
        matrix = map;

    }

    /**
     * Initializer for the matrix
     * @return matrix full of '~' characters
     */

    public char[][] initializer() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxWidth; j++) {
                matrix[i][j] = '~';
            }
        }
        return matrix;
    }




    /**
     * dataAdder verifies if input is valid using validityChecker method then validates that insertion is within boundaries of the 2D matrix. Only then does it
     * add a character to the 2D matrix.
     * @param map - 2D matrix of characters
     * @param rowInput - x coordinate for where we want to add a new character in the 2D matrix
     * @param colInput - y coordinate for where we want to add a new character in the 2D matrix
     * @param mod - the character that we will be adding to the 2D matrix
     * @return - returns 0 if operation successful, -1 if operation failed due to illegal insertion location or illegal character
     */
    public static int dataAdder(char[][] map, int rowInput, int colInput, char mod) {
        boolean inputTester;
        int mapHeight = map.length;      //computing the dimensions of our inputted map
        int mapWidth = map[0].length;
        //We must then test if input to dataAdder is valid//
        char[] validInput = new char[]{'G', '~', '#'};  //defining our valid inputs

        //here we test our input char against the allowed characters
        inputTester = validityChecker(validInput, mod);

        //we return an error if our dimensions dont match
        if (!inputTester || 0 > rowInput || (rowInput > mapHeight) || colInput > mapWidth || colInput < 0) {
            return -1;
        }
        //Now we perform actual modification//
        try {
            map[rowInput][colInput] = mod;
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    /**
     * Called by dataAdder method to see if user inputted char is within a list of allowed chars
     * @param array list consisting of permitted characters
     * @param input character we get from user input in dataAdder
     * @return return false if character not in permitted list, true if in permitted list
     */
    public static boolean validityChecker(char[] array, char input) {
        boolean validFlag = false;                               //function will flag if char input is invalid
        for (int i = 0; i < array.length; i++) {
            if (array[i] == input) {
                validFlag = true;
                break;
            }
        }

        return validFlag;
    }


}
