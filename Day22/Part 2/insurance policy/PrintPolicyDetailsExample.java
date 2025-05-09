import java.util.*;
public class PrintPolicyDetailsExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        policies.forEach(p -> System.out.println("Policy Number: " + p.policyNumber + ", Holder: " + p.holderName + ", Premium: " + p.premiumAmount));
    }
}

