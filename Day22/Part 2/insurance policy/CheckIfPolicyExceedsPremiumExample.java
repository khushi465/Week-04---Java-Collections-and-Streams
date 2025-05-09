import java.util.*;
public class CheckIfPolicyExceedsPremiumExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2500)
        );

        boolean exists = policies.stream()
                                 .anyMatch(p -> p.premiumAmount > 2000);

        System.out.println("Any policy exceeds $2000? " + exists); // Output: true
    }
}
