import java.util.*;

//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Allows one to create a new Course. Fields are list of students and coursename.
//Allows one to view currently enrolled students & enroll new students to a course
public class Course<E> {

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//
    private ArrayList<E> sl;
    private String courseName;

    public Course(String name, ArrayList<E> sl);

    //---------------------------------------Class Methods--------------------------------------------//

    //Returns arraylist of students enrolled in course
    public ArrayList<E> getStudents();
    //Adds a student to the student list for this course
    public void registerStudent(E s);
    //returns name of course as a string
    public String getName();

}
