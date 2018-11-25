import java.util.ArrayList;

// Demo class.
public class Driver
{
    public static void main(String[] args)
    {
        // Show how to use the Strategy implementation of Table.
        System.out.println("Strategy Implementation:\n");
        CaloricCalculation calc = new CaloricCalculation();
        Table<Food> table1 = new Table<Food>(calc.getCalculatedColumnNames(), calc);
        table1.addItem(new Food("Banana", 27, 0, 1));
        table1.addItem(new Food("Egg", 0, 5, 6));
        table1.addItem(new Food("Bagel", 56, 2, 11));
        table1.addItem(new Food("Cabage", 1, 1, 1));
        table1.addItem(new Food("Cake", 400, 100, 11));
        table1.print();

        System.out.println();

        // Show how to use the Template implementation of Table.
        System.out.println("Template Implementation:\n");
        TableTMFood table2 = new TableTMFood();
        table2.addItem(new Food("Banana", 27, 0, 1));
        table2.addItem(new Food("Egg", 0, 5, 6));
        table2.addItem(new Food("Bagel", 56, 2, 11));
        table2.addItem(new Food("Cabage", 1, 1, 1));
        table2.addItem(new Food("Cake", 400, 100, 11));
        table2.print();
    }
}

