import java.util.*;

//Programmer: Ryszard Kubinski
//Date: 29.9.2018
//Function: General framework for creating products/subscriptions for institutions.
public interface Product<E> {
    //Gets a list of all the members using this product
    public ArrayList<E> getMembers();

    //adds a member who is using the product
    public void addMember(E member);

    //Returns the name of the product
    public String getName();


}
