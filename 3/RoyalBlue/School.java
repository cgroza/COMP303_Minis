import java.util.ArrayList;

class School
{
    // List of all courses ever given at this school.
    ArrayList<Course> courses;
    // List of all students in this school.
    ArrayList<Student> students;
    // Identifier for the school
    String schoolName;

    public School(String aSchoolName);

    // Add the course to the approved course list.
    // Used to create a new course in the school.
    public void newCourse(Course course);
    // Add the student to the list of attending students.
    // Used to create a new student in the school.
    public void newStudent(Student student);

    // Getters
    public ArrayList<Student> getStudents();
    public ArrayList<Course> getCourses();

    String getSchoolName();
}