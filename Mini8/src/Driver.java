import java.util.ArrayList;

public class Driver {


    public static void main(String[] args) {
        ArrayList<String> header = new ArrayList<>();
        header.add("Name");
        header.add("Calories");

        System.out.println("Using Strategy Method: ");
        System.out.println();
        //Using Strategy
        Table t = new Table(new ConcreteStrategy(), header);
        t.addToTable(new Food("Banana", 27, 0, 1));
        t.addToTable(new Food("Egg", 0, 5, 6));
        t.addToTable(new Food("Bagel", 56, 2, 11));
        t.print();
        System.out.println();
        System.out.println("Using Template Method: ");
        System.out.println();
        //Using Template Method
        FoodTableTM tm= new FoodTableTM (header);
        tm.addToTable(new Food("Banana", 27, 0, 1));
        tm.addToTable(new Food("Egg", 0, 5, 6));
        tm.addToTable(new Food("Bagel", 56, 2, 11));
        tm.print();

    }

}
