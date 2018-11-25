import java.util.ArrayList;

// Strategy interface to be implemented by classes that calculate columns from
// Table entries.
public interface ColumnsCalculation<T>
{
    // Returns the column names for which calculations are returned.
    public ArrayList<String> getCalculatedColumnNames();
    // Returns the calculated columns in the same order as the column names.
    public ArrayList<String> calculateColumns(T item);
}
