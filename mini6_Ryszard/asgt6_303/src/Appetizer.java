//Ryszard Kubinski
//Nov 15 2018
//Item Object Appetizer , implements Item interface
public class Appetizer implements Item {

    private String name;
    private double price;

    public Appetizer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Appetizer: " + this.name + "   Price: " + this.price);

    }

    public double getPrice() {
        return this.price;
    }


}
