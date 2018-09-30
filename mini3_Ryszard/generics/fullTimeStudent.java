import java.util.*;
//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Implements a full time student. It extends all the parent methods and
//Implements its own course number validity checker to ensure enrollment limits are met.
public class fullTimeStudent extends Student <T>{

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//
    private String name;
    private int Id;
    private ArrayList<T> cl;
    private ArrayList<Pair<T, int>> gradesPerCourse;

    public final int MIN_COURSES=4;
    public final int MAX_COURSES=6;

    public partTimeStudent(String name, int Id, ArrayList<T> c, ArrayList<Pair<T, int>> cg);

    //------------------------------------------------------------------------------------------------//
    //                                          Enrollment verifier                                   //
    //------------------------------------------------------------------------------------------------//

    //Checks if Length of ArrayList of courses is within our MIN_COURSES and MAX_COURSES
    public boolean courseNumberValid();


}
