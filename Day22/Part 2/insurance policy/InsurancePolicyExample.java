import java.util.*;
import java.util.stream.*;

class Policy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + holderName + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyExample {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
            new Policy("P123", "Alice", 1500),
            new Policy("P124", "Bob", 1000),
            new Policy("P125", "Charlie", 2000)
        );

        List<Policy> filteredPolicies = policies.stream()
                                                 .filter(p -> p.premiumAmount > 1200)
                                                 .collect(Collectors.toList());

        filteredPolicies.forEach(System.out::println);
    }
}
