import java.util.HashMap;
import java.util.ArrayList;

// Implementation of table using the strategy pattern.
public class Table <T>
{
    private ArrayList<String> columnNames;
    private ArrayList<T> entries = new ArrayList<T>();
    private ColumnsCalculation<T> columnCalculation;
    public Table(ArrayList<String> colNames, ColumnsCalculation<T> calc){
        // Initialize empty table with the column names.
        columnNames = colNames;
        columnCalculation = calc;
    }

    // Add item to the table.
    public void addItem(T item)
    {
        entries.add(item);
    }

    // Remove the item by its position in the table.
    public T removeByRow(int row)
    {
        return entries.remove(row);
    }

    // Remove the item by searching it in the rows.
    public T removeByItem(T item)
    {
        int row = entries.indexOf(item);
        if  (row > 0)
            return removeByRow(row);
        else return null;
    }

    public void print()
    {
        // Print header column names.
        for(String col : columnNames) System.out.print(" " + col + "  ");
        System.out.println();
        // Print dash line.
        for(String col : columnNames)
            {
                System.out.print("-");
                for(int i = 0; i < col.length(); i++)
                    System.out.print("-");
                System.out.print("-");
            }
        System.out.println();

        for(T entry : entries)
            {
                ArrayList<String> calculatedColumns = columnCalculation.calculateColumns(entry);
                for(int i = 0; i < columnNames.size(); i++) {
                    // Build formatting string for this column.
                    String format = "%" + Integer.toString(columnNames.get(i).length() + 2) + "s";
                    // Print this column.
                    System.out.format(format, calculatedColumns.get(i));
                }
                // End line entry.
                System.out.format("%n");
            }
    }
}
