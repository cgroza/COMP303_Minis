class PartTimeStudent <C extends Course> extends Student<C>
{
    // Conditions that part time students need to respect.
    private final int MAX_COURSES = 3;
    private final int MIN_COURSES = 1;

    public FullTimeStudent(String aName, String anID);
    // Implement registeredCourse abstract method specific to FullTimeStudent.
    // Never allow more than 1 courses.
    public void registerCourse(C course);
    // Returns false if has less than 1 courses or more than 3 courses.
    public bool isInGoodStanding();
}
