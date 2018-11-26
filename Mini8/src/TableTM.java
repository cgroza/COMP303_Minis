import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class TableTM <T>{


    private ArrayList<T> elements;
    private ArrayList<String> header;


    public TableTM( ArrayList<String> cols) {

        this.header = cols;
        this.elements = new ArrayList<>();

    }

    public void addToTable(T elem) {
        elements.add(elem);
    }

    public void removeFromTable(T elem) {
        elements.remove(elem);
    }

    public ArrayList<T> getElems()
        {return elements;}

      public ArrayList<String> getHeader()
      {return header;}

    protected abstract void print();


    protected abstract String calcHeader(ArrayList<String> head);
    protected abstract String calcRow(T t, int headersize);


}
