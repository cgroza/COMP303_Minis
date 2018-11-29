import java.util.ArrayList;

// Strategy interface to be implemented by classes that calculate columns from
// Table entries.
public interface ColumnsCalculation<T>
{
    // Returns the column names for which calculations are returned.
    public ArrayList<String> getCalculatedColumnNames();
    // Return the String representation of the header of this calculation.
    public String calculateHeader();
    // Returns the calculated columns in the same order as the column names.
    public String calculateColumns(T item);
}
