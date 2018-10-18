

import java.util.Scanner;
/**
 *<h1>Program name: MapMain</h1>
 *<h2>Program Function: Gather information and use methods from Map.java to generate ASCII 2D char matrix</h2>
 *@author Ryszard Kubinski 260731196
 *@version 1
 *@since Program Date: Sept 2018
 */


public class MapMain {
    /**
    * Sets up some variables and gathers user input in order to build the 2D char matrix
    * Calls various methods from Map.java to verify if inputs are correct and to add to the matrix
    *
    *
    *
    *
    */
    public static void main(String[] args) {
        //Variable init//
        int maxRow = 0;
        int rowBound;        //will use this once row size is defined
        int maxWidth = 0;
        int widthBound;      //will use this once width is defined
        char[][] matrix;
        int inputRow;        //Scanner inputs
        int inputCol;
        //Preparing more variables that will store the data we get from the user//
        int charRowInput;
        int charColInput;
        int returnStatement;
        char charInput;
        char charConsent;                        //This is the Y/N character the user will enter
        boolean inputConsent = true;                        //checks if user still wants to add new objects
        boolean validInput = true;                        //part of proper char validation
        boolean intValid = true;                        //will use this to check if int entered is valid
        char[] validMapInputs = new char[]{'~', 'G', '#'}; //will use this to check if char input is valid
        char[] validConsentInputs = new char[]{'Y', 'N'};


        //Initializing our Scanner and Data Gathering//
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Map!");

        //Data Gathering Section//
        do {
            System.out.println("Please input the maximum number of rows:");
            inputRow = input.nextInt();

            if (inputRow <= 0)                                                //forcing user to input a number >0 for number of rows
            {
                System.out.println("A row must be greater than 0.");
            } else {
                maxRow = inputRow;
            }
        } while (maxRow <= 0);

        do {
            System.out.println("Please input the maximum number of columns:");
            inputCol = input.nextInt();

            if (inputCol <= 0)                                                //forcing user to input a number >0 for # of cols
            {
                System.out.println("A col must be greater than 0.");
            } else {
                maxWidth = inputCol;
            }
        } while (maxWidth <= 0);

        //Update some variables for our bounds
        rowBound = maxRow - 1;
        widthBound = maxWidth - 1;

        //Initialize Matrix
        matrix = new char[inputRow][inputCol];
        //Defining our Object Using Gathered Data//
        Map mapObject = new Map(maxRow, maxWidth, matrix);    //we create a new Map object using our input
        mapObject.initializer();                            //fills matrix with water
        if (mapObject != null) {
            System.out.println("Map has been initialized.");
        } //checking if we instantiated

        //Modifying the Map//
        //We start the data gathering loop//
        while (inputConsent) {
            do {
                System.out.println("Please add an object to the map (~ for water, G for grass, # for tree");
                charInput = input.next().charAt(0);
                validInput = mapObject.validityChecker(validMapInputs, charInput);
                if (validInput == false) {
                    System.out.println("Invalid Character! Please enter appropriate character!");
                }
            } while (!validInput);

            do {
                System.out.println("Which row would you like to add the object into?");
                charRowInput = input.nextInt();
                if (charRowInput > maxRow - 1 || charRowInput < 0) {
                    intValid = false;
                    System.out.println("Invalid input, please enter number between: 0 and " + rowBound + ".");
                } else {
                    intValid = true;
                }
            } while (!intValid);

            do {
                System.out.println("Which col would you like to add the object into?");
                charColInput = input.nextInt();
                if (charColInput > maxWidth - 1 || charColInput < 0) {
                    intValid = false;
                    System.out.println("Invalid input, please enter number between: 0 and " + widthBound + ".");
                } else {
                    intValid = true;
                }
            } while (!intValid);

            //We will now update the matrix
            returnStatement = mapObject.dataAdder(matrix, charRowInput, charColInput, charInput);
            if (returnStatement != 0)
            //if we use invalid parameters
            {
                System.out.println("invalid call on dataAdder method");
                System.exit(-1);
            }


            //We see if user would like to continue
            do {
                System.out.println("Would you like to add another character? (Y/N)");
                charConsent = input.next().charAt(0);
                validInput = mapObject.validityChecker(validConsentInputs, charConsent);
                if (validInput == false) {
                    System.out.println("Invalid Character! Please enter appropriate character!");
                }
            } while (!validInput);

            if (charConsent == 'N') {
                inputConsent = false;
            }


        }

        input.close();  //we close our scanner

        //Printing the Map//
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (j == maxWidth - 1) {
                    System.out.println(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
        }


    }


}
