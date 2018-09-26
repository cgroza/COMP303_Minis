import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

// Generalization of a collection of entities that join together around a
// central activity that produces "tokes". Ex: A golf club whose players have
// high scores. A class whose students obtain grades. A competition whose
// participants obtain points etc...
class Group <M extends Member>
{
    // List of students registered in this course.
    private ArrayList<M> registeredMembers;
    // List of grades associated to each student.
    private HashMap<S, LinkedList<Integer>> tokenRecord;
    // Group identifier
    private String groupID;

    public Group(String aGroupID);

    // Adds member to the list of members currently in this group.
    // Meant to be called by Member.joinGroup()
    public void addMember(S student);

    // Adds this group to all registered member's history and assigns them
    // their "tokens".
    public void finalizeGroup();
}
