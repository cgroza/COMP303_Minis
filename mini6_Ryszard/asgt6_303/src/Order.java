//Ryszard Kubinski 260731196
//Nov 15 2018
//Order class allows different operations to be done on a list of items

import java.util.ArrayList;

public class Order {
    //Stores all the items in the order
    private ArrayList<Item> order=new ArrayList<Item>();

    //adds an item to the order list. The item can be an Object of type meal or of type Item.
    public void orderItem(Item i) {

        this.order.add(i);
    }
    //removes an item from the item list
    public void removeItem(Item i) {
        this.order.remove(i);
    }

    //Prints out the details about all the Items in an Order by calling the individual item's displayInfo method
    public void listOrder()
    {double sum=0;
    for (Item i: order)
    {
        sum=sum+i.getPrice();
        if (i instanceof Drink)
        {if (((Drink) i).isAlcoholized())
        {
            i.displayInfo();
            System.out.println("WARNING: Customer should be at least 18.");}
        }

        else{i.displayInfo();}


    }
    System.out.println("Total Price: "+sum);
     }


}
