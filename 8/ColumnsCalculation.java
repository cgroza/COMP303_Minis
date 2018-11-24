import java.util.ArrayList;

public interface ColumnsCalculation<T>
{
    public ArrayList<String> getCalculatedColumnNames();
    public ArrayList<String> calculateColumns(T item);
}
