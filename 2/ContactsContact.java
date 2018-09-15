import java.util.HashMap;

public abstract class ContactsContact
{
    // Fields common to all contacts
    private String name;
    private String phone;

    protected ContactsContact(String aName, String aPhone)
    {
        name = aName;
        phone = aPhone;
    }

    // Purpose: Access the contact name
    // Parameters: None
    // Returns: String - contact's name
    // Side effects: None
    public String getName()
    {
        return name;
    }

    // Purpose: Set the contact name
    // Parameters: String aName - contact's new name
    // Returns: None
    // Side effects: None
    public void setName(String aName)
    {
        name = aName;
    }

    // Purpose: Access the contact phone number
    // Parameters: None
    // Returns: String - contact's phone number
    // Side effects: None
    public String getPhone()
    {
        return phone;
    }

    // Purpose: Set the contact phone number
    // Parameters: String aPhone - contact's new phone number
    // Returns: None
    // Side effects: None
    public void setPhone(String aPhone)
    {
        phone = aPhone;
    }

    // Purpose: Return the type of contact the object represents
    // Parameters: None
    // Returns: String - the name of the contact type
    // Side effects: None
    public abstract String getContactType();

    // Purpose: Return a HashMap representation of this object
    // Parameters: None
    // Returns: HashMap<String, String> - contains the fields and values of this object
    // Side effects: None
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> records = new HashMap<String, String>();
        records.put("name", name);
        records.put("phone", phone);
        return records;
    };
}
