import java.util.*;
public class HighestPremiumExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        Policy highestPremiumPolicy = policies.stream()
                                              .max(Comparator.comparingDouble(p -> p.premiumAmount))
                                              .orElseThrow(() -> new NoSuchElementException("No policies found"));

        System.out.println("Policy with Highest Premium: " + highestPremiumPolicy);
    }
}
