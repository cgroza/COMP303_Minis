import java.util.HashMap;

class School
{
    // Index of all courses ever given at this school by unique course name
    private HashMap<String, Course> courses;
    // Index of all students in this school by unique student id
    private HashMap<String, Student> students;
    // Identifier for the school
    private String schoolName;

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

    public String getSchoolName();
}
