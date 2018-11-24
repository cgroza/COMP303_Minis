import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args)
    {
        System.out.println("Strategy Implementation:\n");
        CaloricCalculation calc = new CaloricCalculation();
        Table<Food> table = new Table<Food>(calc.getCalculatedColumnNames(), calc);
        table.addItem(new Food("Banana", 27, 0, 1));
        table.addItem(new Food("Egg", 0, 5, 6));
        table.addItem(new Food("Bagel", 56, 2, 11));
        table.addItem(new Food("Cabage", 1, 1, 1));
        table.addItem(new Food("Cake", 400, 100, 11));
        table.print();

        System.out.println();
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

