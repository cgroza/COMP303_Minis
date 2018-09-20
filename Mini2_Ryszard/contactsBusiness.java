//Program Name: ContactsBusiness
//Programmer: Ryszard Kubinski 260731196
//Purpose: Instantiates a Business contact object which extends the basic contacts object
//Date: 19.9.18

public class contactsBusiness extends contactsBase {
    private String businessName;
    private String      address;
    private String         type;

    //Function: takes in all the necessary parameters and fills super constructor
    public contactsBusiness(String type, String name, String number, String address, String bizName) {
        super(name, number);
        this.type=type;
        this.businessName = bizName;
        this.address = address;


    }
    //Spits out the parameters of the object without letting user access them or change them
    public String toString() {
        return this.type + tablePadder(this.type) + getName() + tablePadder(getName())
                + getPhoneNumber() + tablePadder(getPhoneNumber())
                +this.address + tablePadder(this.address) + this.businessName;
    }


}
