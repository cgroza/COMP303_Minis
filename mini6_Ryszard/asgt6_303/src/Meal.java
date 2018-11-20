//Programmer: Ryszard Kubinski
//Date: 13.11.18
//Purpose: The meal class is the composite of many different items

import java.util.ArrayList;

public class Meal implements Item {


    private ArrayList<Item> items=new ArrayList<Item>();

    //adds item object to the Meal
    public Meal(ArrayList<Item> mealItems)
        {this.items=mealItems;}

    //prints meal price with discount if applicable
    public void displayInfo() {
        double mealTotal=0;

        System.out.println("_____MEAL ITEM START____");
        for (Item i : items) {
            mealTotal=mealTotal+i.getPrice();


            i.displayInfo();
            if (i instanceof Dessert && isFullMeal())
            {System.out.println("Discounted Price: "+(.5*i.getPrice()));}

        }

        System.out.println("_____MEAL ITEM END____");
    }



    //Checks if our meal is a full meal so we can offer a dessert discount
    private boolean isFullMeal() {
        int appetizerCounter = 0;
        int mainCourseCounter = 0;
        int dessertCounter = 0;


        for (Item i : items) {
            if (i instanceof Appetizer) {
                appetizerCounter++;
            }
            if (i instanceof Dessert) {
                dessertCounter++;
            }
            if (i instanceof mainCourse) {
                mainCourseCounter++;
            }

        }
        if (appetizerCounter + dessertCounter + mainCourseCounter >= 3) {
            return true;
        } else {
            return false;
        }
    }

    //gets the price of the composite, takes into account if it is a full meal or not
    //applies 50% discount to dessert if meal is full meal.
    public double getPrice() {

        double sum = 0;
        boolean fullMeal=isFullMeal();

        for (Item i : items) {
            if (i instanceof Dessert)
            {if (fullMeal)
                {sum=sum + (.5)*i.getPrice();}
            }
            else{
            sum = sum + i.getPrice();}


        }
        return sum;
    }


}
