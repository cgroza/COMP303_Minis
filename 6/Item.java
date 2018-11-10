public abstract class Item implements Printable
{
    private double price;
    private String name;
    private String category;

    Item(String aName, double aPrice, String aCategory)
    {
        price = aPrice;
        name = aName;
        category = aCategory;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String printPrice()
    {
        return Double.toString(price);
    }

    public String print()
    {
        return category + ", " + name + ", " + printPrice();
    }

    public String getCategory()
    {
        return category;
    }
}
