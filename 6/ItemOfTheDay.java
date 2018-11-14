public class ItemOfTheDay extends ItemDiscount
{
    public ItemOfTheDay(Item item)
    {
        super(item, "ItemOfTheDay", 0.20);
    }
    @Override
    public String print()
    {
        return super.print() + " (" + getDiscountedItem().getCategory() + ")";
    }
}
