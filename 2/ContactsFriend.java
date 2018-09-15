import java.util.HashMap;

class ContactsFriend extends ContactsWithAddress
{
    // Stores the birthday of the contact
    private String birthday;

    // Purpose: Constructor
    // Parameters: String aName - contact name
    //             String aPhone - contact phone
    //             String anAddress - contact address
    //             String aBirthday - contact birthday
    // Side effects: None
    public ContactsFriend(String aName, String aPhone, String anAddress, String aBirthday)
    {
        super(aName, aPhone, anAddress);
        birthday = aBirthday;
    }

    // Purpose: Access the contact birthday
    // Parameters: None
    // Returns: String - contact's birthday
    // Side effects: None
    public String getBirthday()
    {
        return birthday;
    }

    // Purpose: Set the contact birthday
    // Parameters: String aBirthday - contact's new birthday
    // Returns: None
    // Side effects: None
    public void setBirthday(String aBirthday)
    {
        birthday = aBirthday;
    }


    // Implementation of abstract method from parent class
    public String getContactType()
    {
        return "Friend";
    }

    // Purpose: Adds birthday specific to Friend to the HashMap representation of the contact
    // Parameters: None
    // Returns: HashMap<String, String> - Parent HashMap with birthday included
    // Side effects: None
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> records = super.toHashMap();
        records.put("birthday", birthday);
        return records;
    }
}
