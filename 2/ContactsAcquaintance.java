class ContactsAcquaintance extends ContactsContact
{
    // Purpose: Constructor
    // Parameters: String aName - contact name
    //             String aPhone - contact phone
    // Side effects: None
    public ContactsAcquaintance(String aName, String aPhone)
    {
        super(aName, aPhone);
    }

    // Implementation of abstract method from parent class
    public String getContactType()
    {
        return "Acquaintance";
    }
}
