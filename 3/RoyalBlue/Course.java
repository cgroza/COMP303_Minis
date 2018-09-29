import java.util.HashMap;
import java.util.LinkedList;

class Course
{
    // Index of students registered in this course by their unique student ID.
    private HashMap<String, Student> registeredStudents;
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

    // Various getters
    public HashMap<String, Student> getRegisteredStudents();
    public HashMap<Student, LinkedList<Integer>> getGradeBook();
    public String getCourseName();
}
