import java.util.*;

//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Allows one to create a new Course. Fields are list of students and coursename.
//Allows one to view currently enrolled students & enroll new students to a course
public class Course {

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//
    private ArrayList<Student> sl;
    private String courseName;

    public Course(String name, ArrayList<Student> sl);

    //---------------------------------------Class Methods--------------------------------------------//

    //Returns arraylist of students enrolled in course
    public ArrayList<Student> getStudents();
    //Adds a student to the student list for this course
    public void registerStudent(Student s);
    //returns name of course as a string
    public String getName();

}
