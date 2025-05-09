import java.util.*;
public class ExtractUniqueHolderNamesExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Alice", 2000)
        );

        policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .forEach(System.out::println);
    }
}
