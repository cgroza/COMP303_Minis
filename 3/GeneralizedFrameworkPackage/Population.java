import java.util.ArrayList;

class Population<G extends Group, M extends Member>
{
    // List of all groups that exist in this population of entities.
    ArrayList<C> groups;
    // List of all entities in this population>
    ArrayList<S> members;
    // Identifier for the population
    String populationID;

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

    String getPopulationID();
}
