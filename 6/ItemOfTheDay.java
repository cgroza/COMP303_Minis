// This class represents the ItemOfTheDay. Items of the day get a 20% discount.
public class ItemOfTheDay extends ItemDiscount
{
    // Purpose: Construct an ItemOfTheDay by applying a 20% discount to an item.
    // Parameters: item - Item to be promoted as ItemOfTheDay.
    // Returns: ItemOfTheDay object.
    public ItemOfTheDay(Item item)
    {
        super(item, "ItemOfTheDay", 0.20);
    }
    // Purpose: Specialized implementation of Printable interface that marks
    // this item with the ItemOfTheDay and the category.
    // Returns: String representation of ItemOfTheDay.
    @Override
    public String print()
    {
        return super.print() + " (" + getDiscountedItem().getCategory() + ")";
    }
}
