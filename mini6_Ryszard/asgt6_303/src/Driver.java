//Ryszard Kubinski 260731196
//Nov 15, 2018
//Driver class that calls on different methods from OrderingSystem and Menu classes in order to place an order as if it were a customer


import java.util.ArrayList;

public class Driver {


    public static void main(String[] args) {



        System.out.println("--------Welcome to my Restaurant-----------");
        Menu.getInstance().printMenuItems();
        System.out.println();
        System.out.println("Customer is ordering....");

        System.out.println();
        System.out.println("-----------CUSTOMER ORDER----------");

        OrderingSystem os=OrderingSystem.getInstance();
        os.startOrder();
        //we create a list of items that will constitute our meal
        ArrayList<Item> meal=new ArrayList<>();
        meal.add(new Appetizer("Dumpster Shrimp", 20));
        meal.add(new mainCourse("Old Socks", 35));
        meal.add(new Dessert("Burnt Cake", 5));
        os.orderMeal(meal);
        os.orderItem(new itemOfTheDay(new Side("Fries",3.0),.15));
        os.orderItem(new Drink("Mojito",8.0, true));
        os.listOrder();
        os.Finalize();


    }





}
