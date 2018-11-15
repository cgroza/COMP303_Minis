//Ryszard Kubinski
//Nov 15 2018
//Item Object Dessert , implements Item interface
public class Dessert implements Item {

    private String name;
    private double price;

    public Dessert(String name, double price)
    {this.name=name;
        this.price=price;}

    public void displayInfo()
    {
        System.out.println("Dessert: "+this.name+"   Price: "+this.price);

    }

    public double getPrice()

    {return this.price;}


}
