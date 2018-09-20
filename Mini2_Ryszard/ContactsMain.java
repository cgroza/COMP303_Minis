//Program Name: ContactsMain
//Programmer: Ryszard Kubinski 260731196
//Purpose: Build a contact book with different types of contacts and data using arraylist data struct.
//Date: 19.9.18


import java.util.Scanner;
import java.util.ArrayList;


public class ContactsMain {

    //Function: Maintains the main menu loop until user exits via input=4
    //Function calls: 1. calls menuLoop, which prints our options.
    //2. Calls menuExec which manipulates array List of objects based on input

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int mainChoice = 0;
        ArrayList<contactsBase> arr = new ArrayList<contactsBase>();

        while (mainChoice < 4) {
            menuLoop();
            mainChoice = Integer.parseInt(sc.nextLine());
            menuExec(arr, mainChoice);

        }
    }


    //Function: Prints Menu Options
    public static void menuLoop() {
        System.out.println("1 -> New Contact");
        System.out.println("2 -> Find Contact");
        System.out.println("3 -> List All");
        System.out.println("4 -> Quit");
    }

    //Function: based on input from main, calls methods which manipulate arraylist arr
    //if the number 4 is inputted, program terminates
    public static void menuExec(ArrayList<contactsBase> arr, int Choice) {
        switch (Choice) {
            case 1:
                dataGather(arr);
                break;
            case 2:
                searcher(arr);
                break;
            case 3:
                listPrint(arr);
                break;
            case 4:
                System.exit(0);
        }
    }

    //Function: Gathers data from user and adds new objects to arr.

    public static void dataGather(ArrayList<contactsBase> arr) {
        System.out.println("Type in A for New Acquaintance, B for New Business or F for New Friend.");
        Scanner sc = new Scanner(System.in);
        String contactType = sc.nextLine();
        //Gathering new contact info, will fill the constructor instead of using setter method
        switch (contactType) {
            case "A":
                acquaintanceInput(arr);
                break;
            case "B":
                businessInput(arr);
                break;
            case "F":
                friendInput(arr);
        }
    }

    //Function: adds a new Acquaintance type object to the arr
    public static void acquaintanceInput(ArrayList<contactsBase> arr) {
        String contactName;
        String contactPhoneNumber;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Contact Name: ");
        contactName = sc.nextLine();
        System.out.println("Enter Phone Number:");
        contactPhoneNumber = sc.nextLine();
        arr.add(new contactsAcquaintance("Acquaintance", contactName, contactPhoneNumber));
    }

    //Function: adds a new business type object to arr
    public static void businessInput(ArrayList<contactsBase> arr) {
        String contactName;
        String contactPhoneNumber;
        String contactAddress;
        String contactBizName;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Contact Name:");
        contactName = sc.nextLine();
        System.out.println("Enter Phone Number:");
        contactPhoneNumber = sc.nextLine();
        System.out.println("Enter Address:");
        contactAddress = sc.nextLine();
        System.out.println("Enter business name:");
        contactBizName = sc.nextLine();
        arr.add(new contactsBusiness("Business", contactName, contactPhoneNumber, contactAddress, contactBizName));
    }

    //Function: adds a new Friend type object to the arraylist
    public static void friendInput(ArrayList<contactsBase> arr) {
        String contactName;
        String contactPhoneNumber;
        String contactAddress;
        String contactBirthday;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Contact Name: ");
        contactName = sc.nextLine();
        System.out.println("Enter Phone Number:");
        contactPhoneNumber = sc.nextLine();
        System.out.println("Enter Address:");
        contactAddress = sc.nextLine();
        System.out.println("Enter birthday:");
        contactBirthday = sc.nextLine();
        arr.add(new contactsFriend("Friend", contactName, contactPhoneNumber, contactAddress, contactBirthday));
    }


    //Function: Searches through an arrayList for objects with a certain string
    public static void searcher(ArrayList<contactsBase> arr) {
        Scanner sc = new Scanner(System.in);
        Boolean found = false;
        String searchTerm;
        System.out.println("Please enter contact name that you will be searching for:");
        searchTerm = sc.nextLine();


        //Loops through the .name of each object in arraylist, looking for our userinputted search term
        //If found, it calls the toString method of our object which prints out the properties of
        //that object.
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(searchTerm)) {
                System.out.println(arr.get(i).toString());
                found = true;

            }

        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

    //Function: Prints the properties of the objects of the arraylist
    public static void listPrint(ArrayList<contactsBase> arr) {
        System.out.println("TYPE                NAME                PHONE               " +
                "ADDRESS             BUSINESSNAME        BIRTHDATE");

        for (int i = 0; i < arr.size(); i++) {

            System.out.println(arr.get(i).toString());
        }
    }


}
