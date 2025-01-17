package GeneralGroups;          // part of generalized framework package

import java.util.HashMap;
import java.util.LinkedList;

// Generalization of a collection of entities that join together around a
// central activity that produces "tokes". Ex: A golf club whose players have
// high scores. A class whose students obtain grades. A competition whose
// participants obtain points etc...
public class Group <M extends Member>
{
    // Index of members registered in this group by their unique memberID.
    private HashMap<String, M> registeredMembers;
    // List of tokens associated to each member in this group.
    private HashMap<M, LinkedList<Integer>> tokenRecord;
    // Group identifier
    private String groupID;

    public Group(String aGroupID);

    // Adds member to the list of members currently in this group.
    // Meant to be called by Member.joinGroup()
    public void addMember(M member);

    // Adds this group to all registered member's history and assigns them
    // their "tokens".
    public void finalizeGroup();

    // Various getters
    public HashMap<String, M> getRegisteredMembers();
    public HashMap<M, LinkedList<Integer>> getTokenRecord();
    public String getGroupID();
}
