//Program Name: ContactsFriend
//Programmer: Ryszard Kubinski 260731196
//Purpose: Instantiates a Friend object which extends the basic contacts object
//Date: 19.9.18

public class contactsFriend extends contactsBase {
    private String birthday;
    private String address;
    private String type;

    //Function: takes in all the necessary parameters and fills super constructor
    public contactsFriend(String type, String name, String number, String address, String birthday) {
        super(name, number);
        this.type         = type;
        this.birthday = birthday;
        this.address   = address;
    }

    //Spits out the parameters of the object without letting user access them or change them
    public String toString() {
        return this.type + tablePadder(this.type) + getName() + tablePadder(getName())
        + getPhoneNumber() + tablePadder(getPhoneNumber())+
        this.address + tablePadder(this.address)
        +tablePadder("")+ this.birthday;
    }

}
