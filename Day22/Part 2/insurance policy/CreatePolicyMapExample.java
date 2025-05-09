import java.util.*;
import java.util.stream.Collectors;
public class CreatePolicyMapExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000)
        );

        Map<String, Double> policyMap = policies.stream()
                                                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));

        policyMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
