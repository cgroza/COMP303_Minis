import java.util.HashMap;
import java.util.LinkedList;

class ContactsTest
{
    private static HashMap<String, ContactsContact> contactTypes = new HashMap<String, ContactsContact>();
    private static ContactsBook book = new ContactsBook();

    public static void testGetContactType()
    {
        System.out.println("Testing getContactType");
        // Create all instantiable classes of Contacts* and check if the method reports the correct type

        for(String type : contactTypes.keySet())
            {
                String reportedType = contactTypes.get(type).getContactType();
                System.out.printf("Expected contact type: %s, Reported contact type: %s, Valid: %B\n",
                                  type, reportedType, reportedType.equals(type));
            }
    }

    public static void testToHashMap()
    {
        System.out.println("Testing testToHashMap");

        System.out.println("Case: ContactsAcquaintance");

        ContactsContact c = contactTypes.get("Acquaintance");
        ContactsAcquaintance castedA = (ContactsAcquaintance) contactTypes.get("Acquaintance");
        HashMap<String, String> fields = c.toHashMap();
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "name", castedA.getName(), fields.get("name"), castedA.getName().equals(fields.get("name")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "phone", castedA.getPhone(), fields.get("phone"), castedA.getPhone().equals(fields.get("phone")));


        System.out.println("Case: ContactsFriend");
        c = contactTypes.get("Friend");
        ContactsFriend castedF = (ContactsFriend) contactTypes.get("Friend");
        fields = c.toHashMap();

        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "name", castedF.getName(), fields.get("name"), castedF.getName().equals(fields.get("name")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "phone", castedF.getPhone(), fields.get("phone"), castedF.getPhone().equals(fields.get("phone")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "address", castedF.getAddress(), fields.get("address"), castedF.getAddress().equals(fields.get("address")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "birthday", castedF.getBirthday(), fields.get("birthday"), castedF.getBirthday().equals(fields.get("birthday")));

        System.out.println("Case: ContactsBusiness");
        c = contactTypes.get("Business");
        ContactsBusiness castedB = (ContactsBusiness) contactTypes.get("Business");
        fields = c.toHashMap();
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "name", castedB.getName(), fields.get("name"), castedB.getName().equals(fields.get("name")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "phone", castedB.getPhone(), fields.get("phone"), castedB.getPhone().equals(fields.get("phone")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "address", castedB.getAddress(), fields.get("address"), castedB.getAddress().equals(fields.get("address")));
        System.out.printf("Type: %s, Field name: %s, Private field: %s, HashMap field: %s, Valid: %B\n",
                          c.getContactType(), "business", castedB.getBusinessName(), fields.get("business"), castedB.getBusinessName().equals(fields.get("business")));
    }

    public static void testAddContact()
    {
        System.out.println("Testing addContact");
        for(ContactsContact contact : contactTypes.values())
            {
                book.addContact(contact);
                ContactsContact found = book.findContact(contact.getName());
                System.out.printf("Adding %s\t Found: %s \t Valid: %B\n", contact.getName(), found.getName(),
                                  contact.getName().equals(found.getName()));
            }
    }

    public static void testFindContact()
    {
        System.out.println("Testing findContact");
        for(ContactsContact contact : contactTypes.values())
            {
                ContactsContact found = book.findContact(contact.getName());
                System.out.printf("Finding %s \t Valid: %B\n", contact.getName(), found.getName(),
                                  contact.getName().equals(found.getName()));
            }
    }

    public static void testGetAllContacts()
    {
        System.out.println("Testing getAllContacts");
        LinkedList<ContactsContact> allContacts = book.getAllContacts();
        for(ContactsContact contact : contactTypes.values())
                System.out.printf("Contact name: %s\tIn list: %B\n", contact.getName(), allContacts.contains(contact));
    }

    public static void main(String[] args)
    {
        // Initialize test cases
        contactTypes.put("Friend", new ContactsFriend("John Smith", "12345678", "1 Main Street", "25 Dec"));
        contactTypes.put("Business", new ContactsBusiness("John Doe", "22345678", "2 Main Street", "ACME"));
        contactTypes.put("Acquaintance", new ContactsAcquaintance("John Someguy", "52345678"));

        testAddContact();
        testFindContact();
        testGetAllContacts();

        testGetContactType();
        testToHashMap();
    }
}
