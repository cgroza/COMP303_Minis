import java.util.ArrayList;

public class Table<T> {

    private ArrayList<T> elements;
    private ArrayList<String> header;


    private Strategy Strat;

    public Table(Strategy s, ArrayList<String> cols) {
        this.Strat = s;

        this.header = cols;
        this.elements=new ArrayList<>();

    }

    public void addToTable(T elem) {
        elements.add(elem);
    }

    public void removeFromTable(T elem) {
        elements.remove(elem);
    }

    public void print() {
        String headerString = Strat.calculateHeader(header);
        int headerSize = headerString.length();
        System.out.println(headerString);

        for (int i = 0; i <= headerSize; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (T t: elements)
        {System.out.println(Strat.calculateRow(t,headerSize));}


    }


}
