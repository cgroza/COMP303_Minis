package GeneralGroups;          // part of generalized framework package

import java.util.HashMap;

// Generalization of a collection of entities that can form groups between them
// within a population. Ex: A school with students in courses.  A league with players in teams.
public class Population<G extends Group, M extends Member>
{
    // An index of groups by their unique ID
    private HashMap<String, C> groups;
    // An index of all members by their unique memberID>
    private HashMap<String, S> members;
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
    public HashMap<String, M> getMembers();
    public HashMap<String, G> getGroups();

    public String getPopulationID();
}
