import java.util.*;
//Programmer: Ryszard Kubinski
//Date: 29.9.18
//Function: Contains Main Menu which calls different methods that manipulate Students and Courses based on user I/O.


public class School<C,S> {

    //------------------------------------------------------------------------------------------------//
    //                                          Fields & Constructor                                  //
    //------------------------------------------------------------------------------------------------//
    private ArrayList<C> cl;
    private ArrayList<S> sl;

    //Constructor to initalize the fields of School
    public School(ArrayList<C> cl, ArrayList<S> sl);

    //------------------------------------------------------------------------------------------------//
    //                                          Course Methods                                        //
    //------------------------------------------------------------------------------------------------//

    //Returns the names of the Course objects in the Course Object list using toString method from Course Class
    public ArrayList<C> getCourses();

    //adds a Course to the arraylist
    public void newCourse(C c);

    //------------------------------------------------------------------------------------------------//
    //                                          Student Methods                                       //
    //------------------------------------------------------------------------------------------------//

    //Returns the names of the Student objects in the Student Object list using toString method from Student Class
    public ArrayList<Student> getStudents();

    //Adds a Student object to the student arraylist
    public void newStudent(S s);

    //------------------------------------------------------------------------------------------------//
    //                                          Other Methods                                         //
    //------------------------------------------------------------------------------------------------//

    //This method retrieves a student from the student list and then calls the addGrade method in Student class
    //Calls student's getCourses to retrieve course and then call's the Student Class' method using the Course and grade as parameter.
    public void addGrade(int grade);

    //Retrieves a student from student list, retrieves a course from course list fields
    // Method then calls registerStudent() in Student class using the course as a parameter
    // Method also calls registerStudent in Course class, using student as a parameter
    public void registerStudent();

    //Exits the program
    public void exit();

    //Will Contain our I/O prompts and will call different methods based on these inputs
    public static void main(String[] args);


}
