//Program Name: ContactsAcquaintance
//Programmer: Ryszard Kubinski 260731196
//Purpose: Instantiates an Acquaintance object which extends the basic contacts object
//Date: 19.9.18

public class contactsAcquaintance extends contactsBase {
    private String contactType = "";


    //Function: takes in all the necessary parameters and fills super constructor
    public contactsAcquaintance(String type, String Name, String phoneNumber) {
        super(Name,phoneNumber);
        this.contactType = type;


    }

    //Spits out the parameters of the object without letting user access them or change them
    public String toString() {
        return this.contactType + tablePadder(this.contactType) + getName() + tablePadder(getName())
         + getPhoneNumber() + tablePadder(getPhoneNumber());
    }

    //Allowing strings of maximum 20 chars in Length
    //Pads with spaces for all chars not filled with string

}

