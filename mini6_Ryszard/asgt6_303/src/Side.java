//Ryszard Kubinski
//Nov 15 2018
//Item Object Side , implements Item interface
public class Side implements Item{


    private String name;
    private double price;

    public Side(String name, double price)
    {this.name=name;
        this.price=price;}

    public void displayInfo()
    {
        System.out.println("Side: "+this.name+"   Price: "+this.price);

    }

    public double getPrice()

    {return this.price;}
}
