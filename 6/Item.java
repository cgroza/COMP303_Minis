// This class is a contract for Items that can be ordered from the Menu. It
// keeps track of name, category and price. It provides a common implementation
// for the Printable composite pattern.
public abstract class Item implements Printable
{
    // Stores the price of this item.
    private double price;
    // Stores the name of this item.
    private String name;
    // Stores the category of this item.
    private String category;

    // Purpose: Item constructor.
    // Parameters: aName - name of this item
    //             aPrice - price of this item
    //             aCategory - category of this item
    // Returns: Item object.
    Item(String aName, double aPrice, String aCategory)
    {
        price = aPrice;
        name = aName;
        category = aCategory;
    }

    // Gutters for name and price and category.
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getCategory()
    {
        return category;
    }

    // Purpose: Returns a string representation of the item price. Useful to
    // implement Printable composite patters.
    // Returns: String representation of price.
    public String printPrice()
    {
        return Double.toString(price);
    }

    // Purpose: Implementation of the Printable composite pattern. Prints the
    // item category, name and price separated by commas.
    // Returns: String representation of the item.
    public String print()
    {
        return category + ", " + name + ", " + printPrice();
    }
}
