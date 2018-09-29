import java.util.ArrayList;

class School<C extends Course, S extends Student>
{
    // Index of all courses ever given at this school by unique course name
    private HashMap<C> courses;
    // Index of all students in this school by unique student id
    private HashMap<S> students;
    // Identifier for the school
    private String schoolName;

    public School(String aSchoolName);

    // Add the course to the approved course list.
    // Used to create a new course in the school.
    public void newCourse(C course);
    // Add the student to the list of attending students.
    // Used to create a new student in the school.
    public void newStudent(S student);

    // Getters
    public ArrayList<S> getStudents();
    public ArrayList<C> getCourses();

    public String getSchoolName();
}
