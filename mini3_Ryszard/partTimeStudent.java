import java.util.*;

//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Implements a part time student. It extends all the parent methods and
//Implements its own course number validity checker to ensure enrollment limits are met.

public class partTimeStudent extends Student {

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//
    private String name;
    private int Id;
    private ArrayList<Course> cl;
    private ArrayList<Pair<Course, int>> gradesPerCourse;

    public final int MIN_COURSES=1;
    public final int MAX_COURSES=3;

    //Constructor passes all the info to the super
    public partTimeStudent(String name, int Id, ArrayList<Course> c, ArrayList<Pair<Course, int>> cg);

    //------------------------------------------------------------------------------------------------//
    //                                          Enrollment verifier                                   //
    //------------------------------------------------------------------------------------------------//

    //Checks if Length of the student's ArrayList of courses is within our MIN_COURSES and MAX_COURSES
    public boolean courseNumberValid();




}
