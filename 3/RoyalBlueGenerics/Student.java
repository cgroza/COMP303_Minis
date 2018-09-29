import java.util.ArrayList;

abstract class Student <C extends Course>
{
    private String name;        // Student name
    private String ID;          // Student ID

    // History of courses taken in past semesters.
    private ArrayList<C> courseHistory;
    // Final grades of already completed courses.
    private ArrayList<Pair<C, int>> courseGrades;
    // List of courses in the current semesters.
    private ArrayList<C> registeredCourses;

    public Student(String aStudentName, String anID);

    // Adds a course to the list of registered courses. Returns true if
    //  successful and false otherwise. This class is abstract since each type
    //  of student is expected to validate whether the student is eligible to
    //  register.
    public abstract bool registerCourse(C course);

    // Adds the course to the grades list and assigns them a final grade. Moves
    // a course from the list of registered courses list to the history of
    // courses since the student has graduated from the course.
    public void completeCourse(C course, int finalGrade);

    // Evaluates the student according to their type to see if they respect all
    // the conditions of their type.
    public abstract bool isInGoodStanding();

    // Various getters
    public String getName(C course);
    public String getID(C course);

    // Course related helper methods
    public int getCourseGrade(C course);
    public bool isRegistered(C course);
    public ArrayList<C> getCourseHistory();
    public ArrayList<C> getRegisteredCourses();
    public int countRegisteredCourses();

}
