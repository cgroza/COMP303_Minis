//Program Name: ContactsBase
//Programmer: Ryszard Kubinski 260731196
//Purpose: Instantiates an base Contact object which is then extended by different types of contact Objects
//Date: 19.9.18

public abstract class contactsBase {

    private String name;
    private String phoneNumber;


    protected contactsBase(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public abstract String toString();

    protected String getName() {
        return this.name;
    }

    protected String getPhoneNumber() {
        return this.phoneNumber;
    }

    //Helps toString print out table cells for our contact book
    //a table cell may have no more than 20 characters in order for the format to remain nice.
    //anything a string does not fill with characters, this function fills with whitespace up until 20 characters
    protected String tablePadder(String input) {
        String output = "";
        int length = input.length();

        for (int i = 0; i < 20 - length; i++) {
            output = output + " ";
        }
        return output;
    }

}
