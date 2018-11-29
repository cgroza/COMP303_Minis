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
        System.out.println(columnCalculation.calculateHeader());
        for(T entry : entries)
            {
                System.out.println(columnCalculation.calculateColumns(entry));
            }
    }
}
