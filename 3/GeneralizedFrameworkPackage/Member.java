import java.util.ArrayList;

// Generalization of an entity that can be part of Groups and can accumulate
// tokens associated with those groups. Ex: students in a course, players in a
// competition.
abstract class Member <G extends Group>
{
    private String memberID;        // Member identification

    // History of groups associations from the past.
    private ArrayList<G> groupHistory;

    // Tokens earned in past groups.
    private ArrayList<Pair<G, int>> groupTokens;
    // List of current groups.
    private ArrayList<C> currentGroups;

    public Member(String aMemberID);

    // Adds a group to the list of registered groups. Returns true if
    //  successful and false otherwise. This class is abstract since each type
    //  of member is expected to validate whether the student is eligible to
    //  join the group.
    public abstract bool joinGroup(G group);

    // Adds the group to the list and assigns them their final tokens. Moves
    // a group from the list of registered groups list to the history of
    // groups since the member has completed the group.
    public void completeGroup(G group, int finalTokens);

    // Evaluates the member according to their type to see if they respect all
    // the conditions to remain in the group.
    public abstract bool isValid();

    // Various getters
    public String getMemberID(G group);

    // Course related helper methods
    public int getGroupTokens(G group);
    public bool isJoined(G group);
    public ArrayList<G> getGroupHistory();
    public ArrayList<G> getJoinedGroups();
    public int countJoinedGroups();

}
