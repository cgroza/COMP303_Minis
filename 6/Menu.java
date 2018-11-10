import java.util.ArrayList;

// Only one menu is allowed to exist
public class Menu
{
    private static final Menu menu = new Menu();
    private ArrayList<Item> items;
    private ItemOfTheDay itemOfTheDay = new ItemOfTheDay(new ItemAppetizer("Oisters", 4.00));
    private Menu()
    {
        items = new ArrayList<Item>();
        // ItemOfTheDay is always stored at index 0
        addItem(itemOfTheDay);
        addItem(new ItemDessert("Cake", 11.00));
        addItem(new ItemDrink("Beer", 6.00, true));
        addItem(new ItemMainCourse("Giant Lobster", 30.00));
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void setItemOfTheDay(ItemOfTheDay item)
    {
        itemOfTheDay = item;
        items.set(0, item);
    }

    public ItemOfTheDay getItemOfTheDay()
    {
        return itemOfTheDay;
    }

    public ItemIterator getItemIterator()
    {
        return new ItemIterator(items);
    }

    public static Menu getMenu()
    {
        return menu;
    }

    public String print()
    {
        String menuText = "";
        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                menuText = menuText + itemIt.getItem().print() + "\n";
                itemIt.nextItem();
            }
        return menuText;
    }
}
