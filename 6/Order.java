import java.util.ArrayList;

public class Order implements Printable
{
    private ArrayList<Item> orderedItems = new ArrayList<Item>();
    private boolean isClosed = false;

    public ItemIterator getItemIterator()
    {
        return new ItemIterator(orderedItems);
    }

    public void orderItem(Item item)
    {
        orderedItems.add(item);
    }

    public double getTotal()
    {
        double total = 0;
        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                total = total + itemIt.getItem().getPrice();
                itemIt.nextItem();
            }
        return total;
    }

    public void close()
    {
        isClosed = true;
    }

    public boolean isClosed()
    {
        return isClosed;
    }

    public String print()
    {
        boolean alcohol = false;
        String orderText = "";

        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                Item item = itemIt.getItem();
                // Check if this is an alcoholic drink.
                if(item.getCategory() == "Drink")
                    {
                        if(((ItemDrink) item).getAlcoholized()) alcohol = true;
                    }

                // ItemOfTheDay could also be an alcoholic drink
                if(item.getCategory() == "ItemOfTheDay")
                    {
                        // Retrieve the original item that was discounted
                        Item discountedItem = ((ItemOfTheDay) item).getDiscountedItem();
                        // Check if the original item was a drink
                        if(discountedItem.getCategory() == "Drink")
                            {
                                // Check if it was alcoholic
                                if(((ItemDrink) discountedItem).getAlcoholized()) alcohol = true;
                            }
                    }

                // print the item
                orderText = orderText + item.print() + "\n";
                itemIt.nextItem();
            }

        // Warn the user if order contains alcohol
        if(alcohol)
            orderText = orderText + "Warning: Costumer must be at least 18 years old!\n";
        orderText = orderText + "Total: " + getTotal();

        return orderText;
    }
}
