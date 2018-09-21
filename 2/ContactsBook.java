import java.util.HashMap;
import java.util.LinkedList;

public class ContactsBook
{
    // This HashMap allows us to index contacts by name. Contacts with the same
    // name are stored in a LinkedList indexed by their common name.
    private HashMap<String, LinkedList<ContactsContact>> contactBook;

    public ContactsBook()
    {
        contactBook = new HashMap<String, LinkedList<ContactsContact>>();
    }

    // Purpose: Accumulates and returns a list with all known contacts
    // Parameters: None
    // Returns: LinkedList of all known contacts
    // Side effects: None
    public LinkedList<ContactsContact> getAllContacts()
    {
        // Accumulate contacts from the HashMap into a LinkedList
        LinkedList<ContactsContact> allContacts = new LinkedList<ContactsContact>();
        // for all contacts of the same name
        for(LinkedList<ContactsContact> c : contactBook.values())
            allContacts.addAll(c);
        return allContacts;
    }

    // Purpose: Adds the contact to the record of contacts
    // Parameters: contact - contact to be added
    // Returns: None
    // Side effects: None
    public void addContact(ContactsContact contact)
    {
        // Don't add null references
        if(contact == null) return;
        // Check if we already have entries of the same name
        LinkedList<ContactsContact> priorContacts = contactBook.get(contact.getName());
        if(priorContacts != null)
            priorContacts.add(contact);
        // If not, create a new list entry for the contact and add it to the HashMap index
        else
            {
                LinkedList<ContactsContact> newEntry = new LinkedList<ContactsContact>();
                newEntry.add(contact);
                contactBook.put(contact.getName(), newEntry);
            }
    }

    // Purpose: Finds a contact by name in the record of contacts
    // Parameters: name - Name of contact to be searched
    // Returns: ContactsContact if found, null if not found
    // Side effects: None
    public ContactsContact findContact(String name)
    {
        // Check if an entry list exists
        LinkedList<ContactsContact> contacts = contactBook.get(name);
        if(contacts != null)
            // Then return the first contact in the entry list
            return contacts.getFirst();
        // Return null if nothing is found
        else return null;
    }

}
