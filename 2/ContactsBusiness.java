import java.util.HashMap;

class ContactsBusiness extends ContactsWithAddress
{
    // Stores the business name of the contact
    private String businessName;

    // Purpose: Constructor
    // Parameters: String aName - contact name
    //             String aPhone - contact phone
    //             String anAddress - contact address
    //             String aBusinessName - contact business name
    // Side effects: None
    public ContactsBusiness(String aName, String aPhone, String anAddress, String aBusinessName)
    {
        super(aName, aPhone, anAddress);
        businessName = aBusinessName;
    }


    // Purpose: Access the contact business name
    // Parameters: None
    // Returns: String - contact's business name
    // Side effects: None
    public String getBusinessName()
    {
        return businessName;
    }


    // Purpose: Set the contact business name
    // Parameters: String aBusinessName - contact's new business name
    // Returns: None
    // Side effects: None
    public void setBusinessName(String aBusinessName)
    {
        businessName = aBusinessName;
    }

    // Implementation of abstract method from parent class
    public String getContactType()
    {
        return "Business";
    }

    // Purpose: Adds business name specific to Friend to the HashMap representation of the contact
    // Parameters: None
    // Returns: HashMap<String, String> - Parent HashMap with business name included
    // Side effects: None
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> records = super.toHashMap();
        records.put("business", businessName);
        return records;
    }
}
