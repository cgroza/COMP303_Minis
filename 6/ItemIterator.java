import java.util.ArrayList;

public class ItemIterator
{
    private int currentItem = 0;
    private ArrayList<Item> itemList;
    public ItemIterator(ArrayList<Item> items)
    {
        itemList = items;
    }

    public boolean moreItems()
    {
        return currentItem < itemList.size();
    }
    public void nextItem()
    {
        currentItem++;
    }
    public Item getItem()
    {
        return itemList.get(currentItem);
    }
}
