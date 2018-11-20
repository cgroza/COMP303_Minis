//Ryszard Kubinski
//OrderingSystem class contains an arraylist of all the orders that have been made.
//It also contains a current Order object to which the Driver/Customer class can add to.
//The OrderingSystem class uses singleton Design Pattern.
//Nov 15, 2018

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderingSystem {

    //only one OrderingSystem is needed because we can have many orders in the Ordering System
    //our current order is represented by the Order field
    private static OrderingSystem os = new OrderingSystem();
    private ArrayList<Order> orders= new ArrayList<Order>();
    //we initilalize our Current Order as null
    private Order o = null;

    //getInstance allows other classes to retrieve the instance of OrderingSystem
    public static OrderingSystem getInstance() {
        return os;
    }

    //This initializes our Order field and it is ready to be filled with items
    public void startOrder() {
    this.o= new Order();
    }
    //order is added to our Master list of orders and the current order field becomes null again
    public void Finalize()
    {orders.add(this.o);
    this.o=null; }
    //Prints out all the items in the order
    public void listOrder()
    {o.listOrder();}

    //Allows external classes to order a meal but they must pass an appetizer, main course and dessert
    //This is then added to the current order
    public void orderMeal(ArrayList<Item> mealItems) {



        this.o.orderItem(new Meal(mealItems));
    }

    //Adds an item to the current order Object
    public void orderItem(Item i) {



        this.o.orderItem(i);

    }


}
