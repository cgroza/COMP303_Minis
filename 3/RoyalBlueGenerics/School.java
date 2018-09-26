import java.util.ArrayList;

class School<C extends Course, S extends Student>
{
    // List of all courses ever given at this school.
    ArrayList<C> courses;
    // List of all students in this school.
    ArrayList<S> students;
    // Identifier for the school
    String schoolName;

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

    String getSchoolName();
}
