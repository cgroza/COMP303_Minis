// This class implements the Decorator pattern that allows to discount items.
public class ItemDiscount extends Item
{
    // Stores the item to be discounted.
    private Item discountedItem;
    public ItemDiscount(Item item, String category, double discount)
    {
        // Apply discount
        super(item.getName(), item.getPrice() * (1 - discount), category);
        discountedItem = item;
    }

    // Purpose: Specialized implementation of Printable interface Returns:
    // String representation of discounted item that shows original price and
    // discounted price.
    @Override
    public String printPrice()
    {
        return discountedItem.printPrice() + " -> " + Double.toString(getPrice());
    }

    // Getter for discounted item field.
    public Item getDiscountedItem()
    {
        return discountedItem;
    }
}
