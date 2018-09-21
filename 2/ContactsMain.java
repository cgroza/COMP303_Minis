import java.util.Scanner;
import java.util.HashMap;

class ContactsMain
{

    private static ContactsBook contacts = new ContactsBook();
    // Purpose: Read a single number from the prompt
    // Parameters: None
    // Returns: User input integer, negative integers as error values
    // Side effects: Reads STDIN
    public static int getMenuNumber(int minEntry, int maxEntry)
    {
        try {
            Scanner in = new Scanner(System.in);
            int entry = in.nextInt();
            if(entry > maxEntry || entry < minEntry) return -1;
            return entry;
        }
        catch(Exception e) {
            // Negative values are used as error values and will make the
            // program ask the question again
            return -1;
        }
    }

    // Purpose: Read a string from the prompt
    // Parameters: None
    // Returns: User input string, empty string as error value
    // Side effects: Reads STDIN, writes to STDOUT
    public static String getString(String question)
    {
        System.out.println(question);
        try{
            Scanner in = new Scanner(System.in);
            return in.nextLine();
        }
        catch(Exception e)
            {
                return "";
            }
    }

    // Purpose: Read input and create Acquaintance contact
    // Parameters: None
    // Returns: Fully initialized ContactAcquaintance object
    // Side effects: Reads STDIN, writes to STDOUT
    public static ContactsAcquaintance gatherAcquaintance() {
        String name = getString("Enter acquaintance name: ");
        String phone = getString("Enter acquaintance phone: ");
        return new ContactsAcquaintance(name, phone);
    }

    // Purpose: Read input and create Business contact
    // Parameters: None
    // Returns: Fully initialized ContactBusiness object
    // Side effects: Reads STDIN, writes to STDOUT
    public static ContactsBusiness gatherBusiness() {
        String personName = getString("Enter person name: ");
        String phone = getString("Enter business phone: ");
        String address = getString("Enter business address: ");
        String businessName = getString("Enter business name: ");
        return new ContactsBusiness(personName, phone, address, businessName);
    }

    // Purpose: Read input and create Friend contact
    // Parameters: None
    // Returns: Fully initialized ContactFriend object
    // Side effects: Reads STDIN, writes to STDOUT
    public static ContactsFriend gatherFriend() {
        String name = getString("Enter friend name: ");
        String phone = getString("Enter friend phone: ");
        String address = getString("Enter friend address: ");
        String birthday = getString("Enter friend birthday: ");
        return new ContactsFriend(name, phone, address, birthday);
    }

    // Purpose: Shows and handles the menu for creating new contact
    // Parameters: None
    // Returns: None
    // Side effects: Reads STDIN, writes to STDOUT
    public static void menuNewContact() {
        final int maxEntry = 4;
        final int minEntry = 1;
        int menuEntry;
        ContactsContact contact = null;
        while(true)
            {
                // Show contact options to user
                System.out.println("1. New Acquaintance");
                System.out.println("2. New Business");
                System.out.println("3. New Friend");
                System.out.println("4. Back");

                // Read user choice
                menuEntry = getMenuNumber(minEntry, maxEntry);

                // Restart if menu selection is invalid
                if(menuEntry < minEntry)
                    {
                        System.out.println("Invalid selection. Try again.");
                        continue;
                    }
                // Create the appropriate user
                switch(menuEntry)
                    {
                    case 1:
                        contact = gatherAcquaintance(); break;
                    case 2:
                        contact = gatherBusiness(); break;
                    case 3:
                        contact = gatherFriend(); break;
                    case 4: return;
                    }
                // Add contact to the contact book
                contacts.addContact(contact);
                return;
            }
    }

    // Purpose: Shows and handles the menu for finding a contact and listing it
    // Parameters: None
    // Returns: None
    // Side effects: Reads STDIN, writes to STDOUT
    public static void menuFindContact() {
        // Get query
        String name = getString("Contact name to search: ");
        // Search query in database
        ContactsContact contact = contacts.findContact(name);
        // If found, then display the information
        if(contact != null)
            {
                // Output
                HashMap<String, String> records = contact.toHashMap();
                System.out.printf("Contact type: %s\n", contact.getContactType());
                // Print all the key, values of all fields
                for(String key : records.keySet())
                        System.out.printf("%s : %s\n", key, records.get(key));
            }
        else System.out.println("Not found.");
    }

    // Purpose: Converts null references to string to empty strings
    // Parameters: String s - String reference to be converted
    // Returns: s if reference is not null, empty string if it is null
    // Side effects: None
    public static String nullToEmptyString(String s)
    {
        if(s == null) return "";
        return s;
    }

    // Purpose: Prints information about all the contacts in the database
    // Parameters: None
    // Returns: None
    // Side effects: Reads STDIN, writes to STDOUT
    public static void menuListAll() {
        // Print header
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
                          "TYPE", "NAME", "PHONE", "ADDRESS", "BIRTHDATE", "BUSINESS NAME\n");
        for(ContactsContact contact : contacts.getAllContacts())
            {
                // Print each contact according to the template
                HashMap<String, String> record = contact.toHashMap();
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
                                  contact.getContactType(),
                                  record.get("name"),
                                  record.get("phone"),
                                  nullToEmptyString(record.get("address")),
                                  nullToEmptyString(record.get("birthday")),
                                  nullToEmptyString(record.get("business")));

            }
    }

    // Purpose: Shows and handles the inputs for the main menu
    // Parameters: None
    // Returns: None
    // Side effects: Reads STDIN, writes to STDOUT
    public static void menuMain()
    {
        final int maxEntry = 4;
        final int minEntry = 1;
        int menuEntry;
        while(true)
            {
                // Show the user the main menu
                System.out.println("1. New Contact");
                System.out.println("2. Find Contact");
                System.out.println("3. List All");
                System.out.println("4. Quit");

                // Read user choice
                menuEntry = getMenuNumber(minEntry, maxEntry);

                // Try again if selection is invalid
                if(menuEntry  < minEntry)
                    {
                        System.out.println("Invalid selection. Try again.");
                        continue;
                    }
                // Send user to the appropriate sub-menu
                switch(menuEntry)
                    {
                    case 1:
                        menuNewContact(); break;
                    case 2:
                        menuFindContact(); break;
                    case 3:
                        menuListAll(); break;
                    case 4:
                        return;
                    }
            }
    }

    public static void main(String[] args) {
        menuMain();
    }
}
