//Program name: Map
//Programmer: Ryszard Kubinski 260731196
//Program Date: Sept 2018
//Program Function: Contains methods used by MapMain that are used to modify the Map character table

import java.util.Scanner;

public class Map {

    //Private variable declaration//
    private int      maxRow;
    private int    maxWidth;
    private char[][] matrix;

    //Constructor//
    public Map(int height, int width, char [][] map)
        {maxRow=height;
        maxWidth=width;
        matrix=map;}

    //Initializer for the matrix//
    //This method is not static and needs an object to be instantiated to work//
    public char[][] initializer()
        {for (int i=0; i<maxRow; i++)
            {for (int j=0; j<maxWidth; j++)
                {matrix[i][j]='~';}
            }
        return matrix;}
    //Matrix is now full of water characters

    //Function for data input, used to change the Map from the MapMain class//
    //Returns -1 if theres an error in the input
    public static int dataAdder(char [][] map,int rowInput,int colInput, char mod)
        {boolean inputTester;
         int      mapHeight=   map.length;      //computing the dimensions of our inputted map
         int       mapWidth=map[0].length;
        //We must then test if input to dataAdder is valid//
        char []validInput=new char[]{'G','~','#'};  //defining our valid inputs
        //here we test our input char against the allowed characters
        inputTester=validityChecker(validInput, mod);
        //we return an error if our dimensions dont match
        if (!inputTester||0>rowInput||(rowInput>mapHeight)||colInput>mapWidth||colInput<0)
            {return -1;}
        //Now we perform actual modification//
        try{
        map[rowInput][colInput]=mod;}
        catch(Exception e)
        {return -1;}
        return 0;}

    //This function checks validity of input character based on an array//
    public static boolean validityChecker(char[] array,char input)
        {boolean validFlag=false;                               //function will flag if char input is invalid
            for (int i = 0; i < array.length; i++)
                {if (array[i] == input)
                    {validFlag=true;
                    break;}
                }

        return validFlag;}










}
