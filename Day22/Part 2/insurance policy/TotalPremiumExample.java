import java.util.*;
public class TotalPremiumExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        double totalPremium = policies.stream()
                                      .mapToDouble(p -> p.premiumAmount)
                                      .sum();

        System.out.println("Total Premium: " + totalPremium); // Output: 4500.0
    }
}


