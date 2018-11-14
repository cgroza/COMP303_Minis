import java.util.HashMap;
import java.util.ArrayList;

// Only one menu is allowed to exist
public class Menu
{
    private static final Menu menu = new Menu();
    private HashMap<String, Item> items;
    private ItemOfTheDay itemOfTheDay = new ItemOfTheDay(new ItemSide("Oisters", 4.00));
    private Menu()
    {
        items = new HashMap<String, Item>();
        // ItemOfTheDay is always stored at index 0
        addItem(itemOfTheDay);
        addItem(new ItemAppetizer("Guacamole", 3.00));
        addItem(new ItemDessert("Cake", 11.00));
        addItem(new ItemDrink("Beer", 6.00, true));
        addItem(new ItemMainCourse("Giant Lobster", 30.00));
    }

    public void addItem(Item item)
    {
        items.put(item.getName(),item);
    }

    public Item getItemByName(String name)
    {
        return items.get(name);
    }

    public void setItemOfTheDay(ItemOfTheDay item)
    {
        itemOfTheDay = item;
        items.put("ItemOfTheDay", item);
    }

    public ItemOfTheDay getItemOfTheDay()
    {
        return itemOfTheDay;
    }

    public ItemIterator getItemIterator()
    {
        return new ItemIterator(new ArrayList<Item>(items.values()));
    }

    public static Menu getMenu()
    {
        return menu;
    }

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
