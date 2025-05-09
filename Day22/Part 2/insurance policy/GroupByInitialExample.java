import java.util.*;
import java.util.stream.Collectors;
public class GroupByInitialExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        Map<Character, List<Policy>> groupedPolicies = policies.stream()
                                                                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));

        groupedPolicies.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });
    }
}
