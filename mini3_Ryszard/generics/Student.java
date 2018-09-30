import java.util.*;

//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Contains methods which allow us to modify the student parent object. We can modify the student's grades for courses,
//register the student for courses, access the student's Id, their name and view their course history.

public abstract class Student <C>{

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//

    private String name;
    private int Id;
    private ArrayList<C> c;
    private ArrayList<Pair<C, int>> gradesPerCourse;
    //we store grades paired to courses, a custom class called Pair needs to be created for this


    public Student(String name, int Id, ArrayList<C> cl, ArrayList<Pair<C, int>> cg);

    //------------------------------------------------------------------------------------------------//
    //                                          Getter Methods                                        //
    //------------------------------------------------------------------------------------------------//
    //Goal for these methods is to return details about a student
    //returns student name field
    public String getName();

    //returns student Id field
    public int getId();

    //returns student course history
    public ArrayList<Course> getCourses();

    //prints student course history as a string by calling the getName method from the Course class
    public void printCourses();

    //returns student grades for select courses
    public ArrayList<Pair<C, int>> getCourseGrades();

    //------------------------------------------------------------------------------------------------//
    //                                          Field Modifiers                                       //
    //------------------------------------------------------------------------------------------------//

    //This will use the arraylist add function to add a course to the ArrayList of type course
    public void registerForCourse(C c);

    //Adds grade to the course/grade pair specified
    public void addGrade(int grade, C c);

    //returns Name of student in case a course wants to list all of its students
    public String toString();

    public abstract boolean courseNumberValid();


}
