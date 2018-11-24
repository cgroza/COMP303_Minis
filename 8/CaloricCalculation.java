import java.util.ArrayList;

public class CaloricCalculation implements ColumnsCalculation<Food>
{
    // Computes the columns for this entry.
    public ArrayList<String> calculateColumns(Food food)
    {
        // Construct fields of the row.
        ArrayList<String> columns = new ArrayList<String>();
        // Name field
        columns.add(food.getName());
        // Calorie field.
        columns.add(Integer.toString(4 * food.getCarbs() + 9 * food.getFat() + 4 * food.getProteins()) + " cal");
        return columns;
    }

    // Outputs the column names that are calculated by this strategy.
    public ArrayList<String> getCalculatedColumnNames()
    {
        ArrayList<String> colNames = new ArrayList<String>();
        colNames.add("Name");
        colNames.add("Calories");
        return colNames;
    }
}
