import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>(); // Candidate -> Votes
    LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>(); // Maintain order of voting

    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Sorted Results (Alphabetical):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in Order of Voting:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");

        system.displayResultsSorted(); 
        System.out.println();
        system.displayVotesInOrder();
    }
}
