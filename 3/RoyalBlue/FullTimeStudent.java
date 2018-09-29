class FullTimeStudent extends Student
{
    // Conditions that full time students need to respect:
    private final int MAX_COURSES = 6;
    private final int MIN_COURSES = 4;

    public FullTimeStudent(String aName, String anID);

    // Implement registeredCourse abstract method specific to FullTimeStudent.
    // Never allow more than 6 courses.
    public void registerCourse(Course course);

    // Returns false if has less than 4 courses or more than 6 courses.
    public bool isInGoodStanding();
}
