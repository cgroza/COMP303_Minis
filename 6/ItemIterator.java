import java.util.ArrayList;

// Implements the Iterator pattern that is used to traverse collection of Items.
public class ItemIterator
{
    // Track the current item.
    private int currentItem = 0;
    // Collection of items to be iterated over.
    private ArrayList<Item> itemList;
    public ItemIterator(ArrayList<Item> items)
    {
        itemList = items;
    }

    // Purpose: Check if there are more items to be iterator over.
    // Returns: true if there is a next item, false if not.
    public boolean moreItems()
    {
        return currentItem < itemList.size();
    }
    // Purpose: Increments the iterator to the next item.
    // Side effects: Iterator is incremented.
    public void nextItem()
    {
        currentItem++;
    }
    // Purpose: Retrieve the item pointed by the iterator.
    // Returns: Item at current point.
    public Item getItem()
    {
        return itemList.get(currentItem);
    }
}
