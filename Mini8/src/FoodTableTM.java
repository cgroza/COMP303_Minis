//Ryszard Kubinski 260731196
//November 25, 2018
//Based on the Table Template, the FoodTableTM is specific to Food items
import java.util.ArrayList;

public class FoodTableTM extends TableTM<Food> {

    //constructor passes the header arraylist to the super class
    public FoodTableTM(ArrayList<String> head) {
        super(head);
    }
    //adding to the item list
    public void addToTable(Food elem) {
        super.addToTable(elem);
    }
    //removing from item list
    public void removeFromTable(Food elem) {
        super.removeFromTable(elem);
    }

    //Turns the arraylist of strings that is the header into a printable string with a length
    @Override
    protected String calcHeader(ArrayList<String> head) {
        String header = " ";
        for (String s : head) {
            header += " " + s;
        }
        return header;
    }

    //Based on header length, we create a string with different number of white space for the row
    @Override
    protected String calcRow(Food f, int headersize) {

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
        super.print();
        }
    
}
