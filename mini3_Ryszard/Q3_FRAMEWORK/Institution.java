import java.util.*;
//Programmer: Ryszard Kubinski
//Date: 29.9.2018
//Function: General framework for creating institutions with members & products. This is the interface for the institution
//The interface defines some methods an institution must incorporate to be considered an institution

public interface Institution<T, M> {


    //------------------------------------------------------------------------------------------------//
    //                                         Product Methods                                        //
    //------------------------------------------------------------------------------------------------//
    //Product can be something like a course or membership
    //This method will fetch all of the products offered by an institution
    public ArrayList<T> getOfferedProducts();

    //Creates a new product offered by the institution
    public void newProduct(T t);

    //------------------------------------------------------------------------------------------------//
    //                                         Member Methods                                         //
    //------------------------------------------------------------------------------------------------//
    //Lists the members of an institution
    public ArrayList<M> getMembers();

    //adds a new member to the institution
    public void newMember(M m);

    //Adds details about value of member's product
    public void updateProductValue(int value);

    //gives a member some product offered by institution
    public void giveProduct();

}
