import java.util.*;
import java.util.stream.Collectors;
public class CountPoliciesByPremiumRangeExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000),
            new Policy("P126", "David", 2500)
        );

        Map<String, Long> premiumRangeCount = policies.stream()
                                                     .collect(Collectors.groupingBy(
                                                         p -> {
                                                             if (p.premiumAmount <= 1000) return "$0-$1,000";
                                                             else if (p.premiumAmount <= 2000) return "$1,001-$2,000";
                                                             else return ">$2,000";
                                                         }, Collectors.counting()));

        premiumRangeCount.forEach((range, count) -> System.out.println(range + ": " + count));
    }
}
