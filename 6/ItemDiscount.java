public class ItemDiscount extends Item
{
    private Item discountedItem;
    public ItemDiscount(Item item, String category, double discount)
    {
        super(item.getName(), item.getPrice() * (1 - discount), category);
        discountedItem = item;
    }

    @Override
    public String printPrice()
    {
        return discountedItem.printPrice() + " -> " + Double.toString(getPrice());
    }

    public Item getDiscountedItem()
    {
        return discountedItem;
    }
}
