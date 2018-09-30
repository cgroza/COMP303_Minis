import java.util.ArrayList;
//Programmer: Ryszard Kubinski
//Date: 29.9.2018
//Function: General framework for creating members of institutions. This is the interface for the member
//The interface defines some methods a member must have

public interface Member<E> {
    //Returns the name of the member
    public String getName();

    //Returns the ID number of the member
    public int getId();

    //Returns the products/subscriptions the member has
    public ArrayList<E> getProducts();

    //Returns the values assigned to the products
    public ArrayList<Pair<E, int>> getProductValues();

    //Adds a product to the member's list of products
    public void addProduct(E product);

    //Adds a value to one of the products the member has
    public void addValue(int value, E product);

    //Checks if the member's membership is valid
    public boolean memberValid();


}
