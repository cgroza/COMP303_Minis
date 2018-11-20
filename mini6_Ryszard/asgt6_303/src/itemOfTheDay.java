//Ryszard Kubinski 260731196
//Nov 15 2018
//ItemOfTheDay class is an Item Object and has the displayInfo method, the getPrice method
//It uses the Decorator pattern
public class itemOfTheDay implements Item{

    private Item item;
    private double discount;

    public itemOfTheDay(Item i, double discount)
    {this.item=i;
    this.discount=discount;}

    public void displayInfo()
    {
        this.item.displayInfo();
        System.out.println("Discounted Price: "+getPrice());

    }

    public double getPrice()

    {return (1-this.discount)*this.item.getPrice();}


}
