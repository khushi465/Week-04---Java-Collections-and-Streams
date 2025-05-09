import java.util.*;
public class AveragePremiumExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        double averagePremium = policies.stream()
                                        .mapToDouble(p -> p.premiumAmount)
                                        .average()
                                        .orElse(0.0);

        System.out.println("Average Premium: " + averagePremium); // Output: 1500.0
    }
}
