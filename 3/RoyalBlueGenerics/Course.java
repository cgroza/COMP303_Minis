import java.util.HashMap;
import java.util.LinkedList;

class Course <S extends Student>
{
    // Index of students registered in this course by their unique student ID.
    private HashMap<String, S> registeredStudents;
    // List of grades associated to each student.
    private HashMap<S, LinkedList<Integer>> gradeBook;
    // Course identifier
    private String courseName;

    public Course(String aCourseName);

    // Adds the student to them to list of students currently in this class.
    // Meant to be called by Student.registerCourse()
    public void registerStudent(S student);

    // Adds this course to all registered student's history and assigns them a
    // grade calculated from the gradeBook.
    public void finalizeCourse();

    // Various getters
    public HashMap<String, S> getRegisteredStudents();
    public HashMap<S, LinkedList<Integer>> getGradeBook();
    public String getCourseName();
}
