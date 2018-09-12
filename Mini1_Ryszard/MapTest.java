//Program name: MapTest
//Programmer: Ryszard Kubinski 260731196
//Program Date: Sept 2018
//Program Function: Test the methods in file Map.java

public class MapTest {


public static void main(String[]args)
    {char [] testSet1=new char[]{'~','G','#'};
     char [] testSet2=new char[]{'N','Y'};
     int testSetID1=1;  // will tell our tester which testset its working with
     int testSetID2=2;
    validityCheckerTester(testSet1,testSetID1);
    try
        {Thread.sleep(5000);}
    catch(InterruptedException ex)
        {Thread.currentThread().interrupt();}    //giving time to user to read output

    validityCheckerTester(testSet2,testSetID2);
    try
        {Thread.sleep(5000);}
    catch(InterruptedException ex)
        {Thread.currentThread().interrupt();}    //giving time to user to read output
    dataAdderTester();

    }

public static void dataAdderTester()
    {//defining some test variables that we will use in our dataAdder function
     int testCounter=0;
     int passedTests=0;
     float  passedQuot;
     int    returnCode;    //we will store the return code of our function here

     char                [][] test_matrix=new char[100][100];   //test matrix of 100 x 100 for exhaustiveness
     char                 [] testSet=new char[]{'G','~','#'};   //testing all the possible valid char inputs
     int [] testCases= new int[]{-1,0,1,49,50,51,99,100,101};   //Here are our valid, invalid and boundary cases

    //We fill our test matrix//
    for (int i=0;i<100;i++)
        {for (int j=0;j<100;j++)
            {test_matrix[i][j]='~';}
        }
    System.out.println("Testing method dataAdder, using a sample matrix full of water:");

    //Here is test for each character at the boundary cases as input for both rows and columns
    for(int i=0;i<testSet.length-1;i++)
        {for (int j=0;j<testCases.length-1;j++)
            {for (int n=0;n<100;n++)
                {testCounter=testCounter+2;                         //we do two tests within this for loop
                 System.out.println("Test case for method dataAdder:");
                 System.out.println("Arguments are-> Row: "+n+" Col: "+testCases[j]+" character: "+testSet[i]);
                 returnCode=Map.dataAdder(test_matrix,n,testCases[j],testSet[i]);

                //Testing if our out of bounds cases raise Errors
                if(returnCode!=0 && (testCases[j]==-1||testCases[j]==100||testCases[j]==101))
                    {System.out.println("Result: Test Passed");
                    passedTests++;}
                else if(returnCode==0 && (testCases[j]==-1||testCases[j]==100||testCases[j]==101))
                {System.out.println("Result: Test Failed"); }

                //Testing if our proper boundary/within bounds cases do not raise errors
                if(returnCode==0 && (testCases[j]==0||testCases[j]==1||testCases[j]==49||testCases[j]==50||testCases[j]==51||testCases[j]==99))
                    {System.out.println("Result: Test Passed");
                        passedTests++;}
                else if(returnCode!=0 && (testCases[j]==0||testCases[j]==1||testCases[j]==49||testCases[j]==50||testCases[j]==51||testCases[j]==99))
                    {System.out.println("Result: Test Failed"); }

                //Repeating the above but this time with our test inputs being in the row instead of the column//
                System.out.println("Test case for method dataAdder:");
                System.out.println("Arguments are-> Row: "+n+" Col: "+testCases[j]+" character: "+testSet[i]);
                returnCode=Map.dataAdder(test_matrix,testCases[j],n,testSet[i]);

                //Testing if our out of bounds cases raise Errors
                if(returnCode!=0 && (testCases[j]==-1||testCases[j]==100||testCases[j]==101))
                    {System.out.println("Result: Test Passed");
                    passedTests++;}
                else if(returnCode==0 && (testCases[j]==-1||testCases[j]==100||testCases[j]==101))
                    {System.out.println("Result: Test Failed"); }

                //Testing if our proper boundary/within bounds cases do not raise errors
                if(returnCode==0 && (testCases[j]==0||testCases[j]==1||testCases[j]==49||testCases[j]==50||testCases[j]==51||testCases[j]==99))
                    {System.out.println("Result: Test Passed");
                     passedTests++;}
                else if(returnCode!=0 && (testCases[j]==0||testCases[j]==1||testCases[j]==49||testCases[j]==50||testCases[j]==51||testCases[j]==99))
                    {System.out.println("Result: Test Failed"); }

                }
            }
        }
    passedQuot=passedTests/testCounter*100;
    System.out.println(passedTests+"/"+testCounter+"("+passedQuot+"%)"+" tests passed for dataAdder method.");
    }

//Method responsible for seeing if our character input is good during user loop
public static void validityCheckerTester(char [] testSet,int testSetID)
    {
    char     testChar;                      //temporarily stores each letter/symbol of ASCII table to use as test
    boolean    tester;
    int passCounter=0;                   //these will count the number of tests done and how many were passed
    int testCounter=0;
    float   countQuot;

    //Now we will test some characters from the ASCII table that are available on the standard keyboard//
    for (int i=32;i<127;i++)
        {testChar=(char)i;
        tester=Map.validityChecker(testSet,testChar);
        System.out.println("Test case for method validityChecker:");
        System.out.print("Argument: "+testChar);

        if(testSetID==1)
            {if ((testChar=='G'||testChar=='~'||testChar=='#')&&!tester)
                {System.out.println(" Result: Error");}
             else{System.out.println(" Result: Test passed");
                passCounter++;}
            }

        else if(testSetID==2)
            {if ((testChar=='Y'||testChar=='N')&&!tester)
                {System.out.println(" Result: Error");}
            else{System.out.println(" Result: Test Passed");
                passCounter++;}
            }

        System.out.println();
        testCounter++;
        }
    countQuot=passCounter/testCounter*100;
    System.out.println(passCounter+"/"+testCounter+"("+countQuot+"%)"+" tests passed for validityChecker method using test set: "+testSetID);

    }











}
