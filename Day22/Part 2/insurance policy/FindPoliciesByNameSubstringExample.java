import java.util.*;
public class FindPoliciesByNameSubstringExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob Smith", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        policies.stream()
                .filter(p -> p.holderName.contains("Smith"))
                .forEach(System.out::println);
    }
}
