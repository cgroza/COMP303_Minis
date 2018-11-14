import java.util.ArrayList;

// This class allows to keep track of ordered items and their total price.
public class Order implements Printable
{
    // Stores the items in this order.
    private ArrayList<Item> orderedItems = new ArrayList<Item>();

    // Stores order status. Orders are created in an open state.
    // Order is closed when it is payed the costumer.
    private boolean isClosed = false;


    // Purpose: Returns an ItemIterator that allows to traverse the list of
    // items in this order.
    // Returns: ItemIterator to items in this order.
    public ItemIterator getItemIterator()
    {
        return new ItemIterator(orderedItems);
    }

    // Purpose: Adds item to this order.
    // Parameters: item - item to be added to order.
    public void orderItem(Item item)
    {
        orderedItems.add(item);
    }

    // Purpose: Calculates the total price of item in this order.
    // Returns: total price
    public double getTotal()
    {
        // Store total price.
        double total = 0;
        // Traverse items in this order.
        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                // Add the price of this item to the total.
                total = total + itemIt.getItem().getPrice();
                itemIt.nextItem();
            }
        return total;
    }

    // Purpose: Close the order.
    public void close()
    {
        isClosed = true;
    }

    // Purpose: Getter for isClosed field.
    // Returns: true if closed, false if not closed.
    public boolean isClosed()
    {
        return isClosed;
    }

    // Purpose: Implements the Printable composite pattern. The string
    // representation of this order is constructed from the string
    // representations of the items in this order, with additional order data.
    // Returns: String representation of this order.
    public String print()
    {
        // Flag for alcoholic drinks.
        boolean alcohol = false;
        // Will accumulate the string representation.
        String orderText = "";

        // Traverse items.
        ItemIterator itemIt = getItemIterator();
        while(itemIt.moreItems())
            {
                Item item = itemIt.getItem();
                // Check if this Item is an alcoholic drink.
                if(item.getCategory() == "Drink")
                    {
                        if(((ItemDrink) item).getAlcoholized()) alcohol = true;
                    }

                // ItemOfTheDay could also be an alcoholic drink.
                if(item.getCategory() == "ItemOfTheDay")
                    {
                        // Retrieve the original item that was discounted.
                        Item discountedItem = ((ItemOfTheDay) item).getDiscountedItem();
                        // Check if the original item was a drink
                        if(discountedItem.getCategory() == "Drink")
                            {
                                // Check if it was alcoholic.
                                if(((ItemDrink) discountedItem).getAlcoholized()) alcohol = true;
                            }
                    }

                // Add the item string representation to this order string representation.
                orderText = orderText + item.print() + "\n";
                itemIt.nextItem();
            }

        // Warn the user if order contains alcohol.
        if(alcohol)
            orderText = orderText + "Warning: Costumer must be at least 18 years old!\n";
        orderText = orderText + "Total: " + getTotal();

        return orderText;
    }
}
