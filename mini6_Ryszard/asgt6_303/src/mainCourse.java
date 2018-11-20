//Ryszard Kubinski 260731196
//Nov 15 2018
//mainCourse class is an Item Object and has the displayInfo and getPrice methods
public class mainCourse implements Item {

    private String name;
    private double price;

    public mainCourse(String name, double price)
    {this.name=name;
        this.price=price;}

    //prints out the info contained in the fields
    public void displayInfo()
    {
        System.out.println("Main Course: "+this.name+"   Price: "+this.price);

    }
    //returns the price field of the item
    public double getPrice()

    {return this.price;}


}
