import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodTableTM<T> extends TableTM<T> {


    public FoodTableTM(ArrayList<String> head) {
        super(head);
    }

    public void addToTable(T elem) {
        super.addToTable(elem);
    }

    public void removeFromTable(T elem) {
        super.removeFromTable(elem);
    }

    @Override
    protected String calcHeader(ArrayList<String> head) {
        String header = " ";
        for (String s : head) {
            header += " " + s;
        }
        return header;
    }

    @Override
    protected String calcRow(T t, int headersize) {
        Food f = (Food) t;
        String output = "  ";
        String name = f.getName();
        String cals = ((f.getCarbs() * 4) + (f.getFat() * 9) + (f.getProtein() * 4)) + " cal";
        int freespace = headersize - name.length() - cals.length() - 1;

        output += name;
        for (int i = 0; i < freespace; i++) {
            output += " ";
        }

        output += cals;


        return output;
    }

    public void print() {
        String headerString = calcHeader(super.getHeader());
        int headerSize = headerString.length();
        System.out.println(headerString);

        for (int i = 0; i <= headerSize; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (T t : super.getElems()) {
            System.out.println(calcRow(t, headerSize));
        }
    }
}
