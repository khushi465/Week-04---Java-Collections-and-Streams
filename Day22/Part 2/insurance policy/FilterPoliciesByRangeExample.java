import java.util.*;
import java.util.stream.Collectors;
public class FilterPoliciesByRangeExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        List<Policy> filteredPolicies = policies.stream()
                                                 .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                                                 .collect(Collectors.toList());

        filteredPolicies.forEach(System.out::println);
    }
}

