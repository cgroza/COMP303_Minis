//Ryszard Kubinski
//Nov 15 2018
//Item Object Drink , implements Item interface
//Has extra boolean field uesd to determine if it is alcoholized or not
public class Drink implements Item{


    private String name;
    private double price;
    private boolean alcoholized;

    public Drink(String name, double price, boolean alcohol) {
        this.name = name;
        this.price = price;
        this.alcoholized = alcohol;
    }

    public void displayInfo() {

        if (alcoholized) {
            System.out.println("Alcoholic Drink: " + this.name + "   Price: " + this.price);
        } else {
            System.out.println("Non-alcoholic Drink: " + this.name + "   Price: " + this.price);
        }

    }

    public boolean isAlcoholized() {
        return alcoholized;
    }

    public double getPrice()

    {return this.price;}
}
