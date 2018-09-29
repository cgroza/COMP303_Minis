import java.util.ArrayList;

// Generalization of a collection of entities that can form groups between them
// within a population. Ex: A school with students in courses.  A league with players in teams.
class Population<G extends Group, M extends Member>
{
    // List of all groups that exist in this population of entities.
    private ArrayList<C> groups;
    // List of all entities in this population>
    private ArrayList<S> members;
    // Identifier for the population
    private String populationID;

    public Population(String aPopulationID);

    // Add the course to the approved group list.
    // Used to create a new group in this population.
    public void newGrup(G group);
    // Add the student to the list of attending students.
    // Used to create a new member in this population.
    public void newMember(M member);

    // Getters
    public ArrayList<M> getMembers();
    public ArrayList<G> getGroups();

    public String getPopulationID();
}
