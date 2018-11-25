import java.util.ArrayList;

// Implementation of Table for Food items.
public class TableTMFood extends TableTM<Food>
{
    public TableTMFood()
    {
        super(getColumnList());
    }

    // Factory method for column name list to pass to template constructor.
    private static ArrayList<String> getColumnList()
    {
        ArrayList<String> cols = new ArrayList<String>();
        cols.add("Name");
        cols.add("Calories");
        return cols;
    }

    // Implementation of the abstract template method that calculates the value
    // of columns.
    public ArrayList<String> entryToRowFields(Food food)
    {
        // Construct fields of the row.
        ArrayList<String> columns = new ArrayList<String>();
        // Name field
        columns.add(food.getName());
        // Calorie field.
        columns.add(Integer.toString(4 * food.getCarbs() + 9 * food.getFat() + 4 * food.getProteins()) + " cal");
        return columns;
    }
}
