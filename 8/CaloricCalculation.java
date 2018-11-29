import java.util.ArrayList;

// Implementation of the Strategy pattern for the caloric calculation.
public class CaloricCalculation implements ColumnsCalculation<Food>
{
    // Computes the columns for this entry.
    public String calculateColumns(Food food)
    {
        // Construct fields of the row.
        ArrayList<String> columns = new ArrayList<String>();
        // Name field
        columns.add(food.getName());
        // Calorie field.
        columns.add(Integer.toString(4 * food.getCarbs() + 9 * food.getFat() + 4 * food.getProteins()) + " cal");


        StringBuffer row = new StringBuffer();

        for(int i = 0; i < getCalculatedColumnNames().size(); i++) {
            // Build formatting string for this column.
            String format = "%" + Integer.toString(getCalculatedColumnNames().get(i).length() + 2) + "s";
            // Print this column.
            row.append(String.format(format, columns.get(i)));
        }
        return row.toString();
    }

    public String calculateHeader()
    {
        StringBuffer header = new StringBuffer();
        // Print header column names.
        for(String col : getCalculatedColumnNames()) header.append(" " + col + "  ");
        header.append("\n");
        // Print dash line.
        for(String col : getCalculatedColumnNames())
            {
                header.append("-");
                for(int i = 0; i < col.length(); i++) header.append("-");
                header.append("-");
            }
        return header.toString();
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
