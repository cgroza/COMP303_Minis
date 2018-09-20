//Program Name: ContactsTest
//Programmer: Ryszard Kubinski 260731196
//Purpose: Tests the creation of different contact type objects
//Date: 19.9.18

public class ContactsTest {
    private static String placeHolder = " ";

    public static void main(String[] args) {
        //we will count how many tests were successful and provide an output to the user.
        int test_count = 0;
        int passed_count = 0;
        int percentage;

        if (acqTest()) {
            passed_count++;
            test_count++;

        } else {
            test_count++;
        }

        if (bizTest()) {
            passed_count++;
            test_count++;
        } else {
            test_count++;
        }

        if (friendTest()) {
            passed_count++;
            test_count++;
        } else {
            test_count++;
        }

        percentage = 100 * passed_count / test_count;

        if (percentage == 100) {
            System.out.println(passed_count + "/" + test_count + " -> " + percentage + "% tests passed. ");
        } else {
            System.out.println(passed_count + "/" + test_count + "-" + percentage + "% tests passed. Testing Failed.");
        }

    }


    //The following functions will test if we instantiated our objects correctly and if their function works correctly//
    //We cannot instantiate contactsBase but we do test all of its methods
    //methods tested: getName, toString, tablePadder
    // getName should return the input used for name during instantiation
    //toString should return a string of length greater than the sum of the lengths of the inputs
    //tablePadder should return a string of a certain length and no longer


    public static boolean acqTest() {
        contactsAcquaintance a = new contactsAcquaintance(placeHolder, placeHolder, placeHolder);
        System.out.print("Testing contactsAcquaintance.java and its methods");

        if (a != null && a.toString().length() > 3 && a.getName().equals(" ") && a.getPhoneNumber().equals(" ") && a.tablePadder(placeHolder).length() == 19) {
            System.out.println("---Test passed.");
            return true;
        } else {
            System.out.println("---Test failed.");
            return false;
        }
    }

    public static boolean bizTest() {
        System.out.print("Testing contactsBusiness.java and its methods");
        contactsBusiness b = new contactsBusiness(placeHolder, placeHolder, placeHolder, placeHolder, placeHolder);

        if (b != null && b.toString().length() >3 && b.getName().equals(" ") && b.getPhoneNumber().equals(" ") && b.tablePadder(placeHolder).length() == 19) {
            System.out.println("---Test passed.");
            return true;

        } else {
            System.out.println("---Test failed.");
            return false;
        }
    }

    public static boolean friendTest() {
        System.out.print("Testing contactsFriend.java and its methods");
        contactsFriend f = new contactsFriend(placeHolder, placeHolder, placeHolder, placeHolder, placeHolder);

        if (f != null && f.toString().length() >3 && f.getName().equals(" ") && f.getPhoneNumber().equals(" ") && f.tablePadder(placeHolder).length() == 19) {
            System.out.println("---Test passed.");
            return true;
        } else {
            System.out.println("---Test failed.");
            return false;
        }
    }


}
