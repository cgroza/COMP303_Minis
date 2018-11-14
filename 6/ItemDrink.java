// Implementation of the Drink category. Contains unique field for alcohol
// content.
public class ItemDrink extends Item
{
    // Marks the drink as alcoholic or not.
    private boolean alcoholized;
    // Purpose: Construct a Drink.
    // Parameters: aName - Drink name
    //             aPrice - Drink price
    //             withAlchool - Alcohol content
    // Returns: Drink object.
    public ItemDrink(String aName, double aPrice, boolean withAlchool)
    {
        super(aName, aPrice, "Drink");
        alcoholized = withAlchool;
    }

    // Purpose: Getter  for alcohol state.
    // Returns: true if alcoholic, false if not.
    public boolean getAlcoholized()
    {
        return alcoholized;
    }
}
