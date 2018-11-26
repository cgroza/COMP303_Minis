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

    public void print() {
        String headerString = calcHeader(header);
        int headerSize = headerString.length();
        System.out.println(headerString);

        for (int i = 0; i <= headerSize; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (T t: elements)
        {System.out.println(calcRow(t,headerSize));}


    }


    protected abstract String calcHeader(ArrayList<String> head);
    protected abstract String calcRow(T t, int headersize);


}
