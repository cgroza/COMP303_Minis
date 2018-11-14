import java.util.HashMap;
import java.util.ArrayList;

// This class represents the Menu, the set of all possible items that can be
// ordered. It implements the Singleton design pattern.
public class Menu
{
    // Stores the only instance of this class.
    private static final Menu menu = new Menu();
    // Database of items indexed by name.
    private HashMap<String, Item> items;
    // Current selection for the item of the day.
    private ItemOfTheDay itemOfTheDay = new ItemOfTheDay(new ItemSide("Oisters", 4.00));

    // Purpose: Construct a Menu. Private since it is a singleton.
    // Returns: Menu object.
    private Menu()
    {
        items = new HashMap<String, Item>();
        // Add default items in this menu.
        setItemOfTheDay(itemOfTheDay);
        addItem(new ItemAppetizer("Guacamole", 3.00));
        addItem(new ItemDessert("Cake", 11.00));
        addItem(new ItemDrink("Beer", 6.00, true));
        addItem(new ItemMainCourse("Giant Lobster", 30.00));
    }

    // Purpose: Add a new item to the Menu.
    // Parameters: item - Item to be added to the database.
    public void addItem(Item item)
    {
        items.put(item.getName(),item);
    }

    // Purpose: Lookup item in database.
    // Parameters: name - Name of item to be looked up.
    // Returns: null if not found, the item otherwise.
    public Item getItemByName(String name)
    {
        return items.get(name);
    }

    // Purpose: Set the ItemOfTheDay in the database.
    // Parameters: item - Item to be promoted to ItemOfTheDay
    public void setItemOfTheDay(ItemOfTheDay item)
    {
        // ItemOfTheDay is always stored at key "ItemOfTheDay"
        itemOfTheDay = item;
        items.put("ItemOfTheDay", item);
    }

    // Purpose: Getter for the item of the day.
    // Returns: ItemOfTheDay object if set, null otherwise.
    public ItemOfTheDay getItemOfTheDay()
    {
        return itemOfTheDay;
    }

    // Purpose: Returns an ItemIterator that allows to traverse the list of
    // items in this menu.
    // Returns: ItemIterator to items in this menu.
    public ItemIterator getItemIterator()
    {
        return new ItemIterator(new ArrayList<Item>(items.values()));
    }

    // Purpose: Returns a reference to the only instance of the Menu.
    // Returns: Unique menu instance.
    public static Menu getMenu()
    {
        return menu;
    }

    // Purpose: Implements the Printable composite pattern. The string
    // representation of this menu is constructed from the string
    // representations of the items in this menu.
    // Returns: String representation of this menu.
    public String print()
    {
        String menuText = "Menu:\n";
        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                menuText = menuText + itemIt.getItem().print() + "\n";
                itemIt.nextItem();
            }
        return menuText;
    }
}
