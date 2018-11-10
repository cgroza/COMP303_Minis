public class ItemDrink extends Item
{
    private boolean alcoholized;
    public ItemDrink(String aName, double aPrice, boolean withAlchool)
    {
        super(aName, aPrice, "Drink");
        alcoholized = withAlchool;
    }

    public boolean getAlcoholized()
    {
        return alcoholized;
    }
}
