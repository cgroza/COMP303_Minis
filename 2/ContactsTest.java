import java.util.HashMap;

class ContactsTest
{
    private static HashMap<String, ContactsContact> contactTypes = new HashMap<String, ContactsContact>();

    public static void testSetName()
    {
        System.out.println("Testing setName and the getter");
        String testName = "Bugs Bunny";
        // Test setName in all child classes of ContactsContact
        for(String type : contactTypes.keySet())
            {
                ContactsContact c = contactTypes.get(type);
                String reportedType = c.getContactType();
                c.setName(testName);
                System.out.printf("Contact type: %s, Field name: %s, set: %s, get: %s, Valid: %B\n",
                                  reportedType, "name", testName, c.getName(), c.getName().equals(testName));
            }
    }

    public static void testSetPhone()
    {
        System.out.println("Testing setPhone and the getter");
        String testPhone = "1 800 1234";
        // Test setPhone in all child classes of ContactsContact
        for(String type : contactTypes.keySet())
            {
                ContactsContact c = contactTypes.get(type);
                String reportedType = c.getContactType();
                c.setPhone(testPhone);
                System.out.printf("Contact type: %s, Field name: %s, set: %s, get: %s, Valid: %B\n",
                                  reportedType, "phone", testPhone, c.getPhone(), c.getPhone().equals(testPhone));
            }
    }

    public static void testSetAddress()
    {
        System.out.println("Testing setAddress and the getter");
        String testAddress = "325 S. Santa Claus Lane, North Pole";
        // Test setAddress in all child classes of ContactsWithAddress
        for(String type : new String[]{"Business", "Friend"})
            {
                ContactsWithAddress c = (ContactsWithAddress) contactTypes.get(type);
                String reportedType = c.getContactType();
                c.setAddress(testAddress);
                System.out.printf("Contact type: %s, Field name: %s, set: %s, get: %s, Valid: %B\n",
                                  reportedType, "address", testAddress, c.getAddress(), c.getAddress().equals(testAddress));
            }
    }

    public static void testSetBirthday()
    {
        // Test setBirthday in ContactsFriend class
        System.out.println("Testing setBirthday and the getter");
        String testBirthday = "4th July";
        ContactsFriend c = (ContactsFriend) contactTypes.get("Friend");
        String reportedType = c.getContactType();
        c.setBirthday(testBirthday);
        System.out.printf("Contact type: %s, Field name: %s, set: %s, get: %s, Valid: %B\n",
                          reportedType, "birthday", testBirthday, c.getBirthday(), c.getBirthday().equals(testBirthday));
    }

    public static void testSetBusinesName()
    {
        // Test setBusinessName in ContactsBusiness class
        System.out.println("Testing setBusinessName and the getter");
        String testBusiness = "Funny Business Incorporated";
        ContactsBusiness c = (ContactsBusiness) contactTypes.get("Business");
        String reportedType = c.getContactType();
        c.setBusinessName(testBusiness);
        System.out.printf("Contact type: %s, Field name: %s, set: %s, get: %s, Valid: %B\n",
                          reportedType, "business", testBusiness, c.getBusinessName(), c.getBusinessName().equals(testBusiness));
    }

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

    public static void main(String[] args)
    {
        // Initialize test cases
        contactTypes.put("Friend", new ContactsFriend("John Smith", "12345678", "1 Main Street", "25 Dec"));
        contactTypes.put("Business", new ContactsBusiness("John Doe", "22345678", "2 Main Street", "ACME"));
        contactTypes.put("Acquaintance", new ContactsAcquaintance("John Someguy", "52345678"));

        testGetContactType();
        testToHashMap();
        testSetName();
        testSetPhone();
        testSetAddress();
        testSetBirthday();
        testSetBusinesName();

    }
}
