import java.util.HashMap;

public abstract class ContactsWithAddress extends ContactsContact
{
    // Field common to all contacts with an address
    private String address;

    // Purpose: Constructor. Only callable by child classes
    // Parameters: String aName - contact name
    //             String aPhone - contact phone
    //             String anAddress - contact address
    // Side effects: None
    protected ContactsWithAddress(String aName, String aPhone, String anAddress)
    {
        super(aName, aPhone);
        address = anAddress;
    }

    // Purpose: Access the contact address
    // Parameters: None
    // Returns: String - contact's address
    // Side effects: None
    public String getAddress()
    {
        return address;
    }

    // Purpose: Set the contact address
    // Parameters: String aBirthday - contact's new address
    // Returns: None
    // Side effects: None
    public void setAddress(String anAddress)
    {
        address = anAddress;
    }

    // Purpose: Adds address field specific to WithAddress to the HashMap representation of the contact
    // Parameters: None
    // Returns: HashMap<String, String> - Parent HashMap with address included
    // Side effects: None
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> records = super.toHashMap();
        records.put("address", address);
        return records;
    }
}
