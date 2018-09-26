import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Course
{
    // List of students registered in this course.
    private ArrayList<Student> registeredStudents;
    // List of grades associated to each student.
    private HashMap<Student, LinkedList<Integer>> gradeBook;
    // Course identifier
    private String courseName;

    public Course(String aCourseName);

    // Adds the student to them to list of students currently in this class.
    // Meant to be called by Student.registerCourse()
    public void registerStudent(Student student);

    // Adds this course to all registered student's history and assigns them a
    // grade calculated from the gradeBook.
    public void finalizeCourse();
}