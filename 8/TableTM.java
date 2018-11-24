import java.util.ArrayList;

public abstract class TableTM <T> {
    protected ArrayList<String> columnNames;
    protected ArrayList<T> entries = new ArrayList<T>();

    public TableTM(ArrayList<String> colNames){
        // Initialize empty table with the column names.
        columnNames = colNames;
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

    // The variable procedure is the way the fields are calculated. This method
    // should be overridden by the user to specify how to calculate the fields.
    public abstract ArrayList<String> entryToRowFields(T entry);

    // This method prints the table to the console.
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

        // Now print entries.
        for(T entry: entries)
            {
                // Fields are always calculated differently depending on entry.
                ArrayList<String> fields = entryToRowFields(entry);
                // But are always printed in the same way.
                for(int i = 0; i < columnNames.size(); i++) {
                    // Build formatting string for this column.
                    String format = "%" + Integer.toString(columnNames.get(i).length() + 2) + "s";
                    // Print this column.
                    System.out.format(format, fields.get(i));
                }
                // End line entry.
                System.out.format("%n");
            }
    }
}
