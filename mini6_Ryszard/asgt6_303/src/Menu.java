//Programmer: Ryszard Kubinski 260731196
//Nov 15 2018
//Menu Class is a singleton that acts the database of our items.

import java.util.ArrayList;

public class Menu {

    //creating our singleton, there can be only one Menu object
    private static Menu menu = new Menu();

    //we intialize a list of our items and our item of the day
    private ArrayList<Item> menuItems;


    //Hardcoded menu constructor with our different items
    private Menu() {
        menuItems = new ArrayList<>();
        menuItems.add(new Drink("Mojito", 8, true));
        menuItems.add(new Drink("Day Old Coffee", 3, false));
        menuItems.add(new Appetizer("Dumpster Shrimp", 20));
        menuItems.add(new Appetizer("Stinky Fish", 10));
        menuItems.add(new mainCourse("Old Socks", 35));
        menuItems.add(new mainCourse("Boiled Chicken", 65));
        menuItems.add(new Side("Moldy Salad", 7));
        menuItems.add(new Side("Blue Cheese", 12));
        menuItems.add(new Dessert("Burnt Cake", 5));
        menuItems.add(new Dessert("5 Peanuts", 2));
        menuItems.add(new itemOfTheDay(new Side("Fries", 3.0), .15));


    }
    //returns menu instance so that external classes can access the items of the instance
    public static Menu getInstance() {
        return menu;
    }

    //Using the menu instance, external classes can print the items in the menu
    public void printMenuItems() {
        for(Item i: menuItems)
            {
            if (i instanceof itemOfTheDay)
                {System.out.print("Item of the day: ");}
            i.displayInfo();
            }
    }


}
