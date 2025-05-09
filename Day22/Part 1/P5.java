import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return String.format("RiskAssessment{holderId='%s', name='%s', riskScore=%.3f}", holderId, name, riskScore);
    }
}

class RiskAssessor {
    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        return holders.stream()
                .filter(h -> h.policyType.equalsIgnoreCase("Life") && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore)) // Sort by descending risk score
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));
    }
}

public class P5 {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 70, "Health", 35000),
                new PolicyHolder("H003", "Carol", 68, "Life", 25000),
                new PolicyHolder("H004", "David", 75, "Life", 42000),
                new PolicyHolder("H005", "Eve", 80, "Life", 30000),
                new PolicyHolder("H006", "Frank", 62, "Life", 18000),
                new PolicyHolder("H007", "Grace", 59, "Life", 20000)
        );

        Map<String, List<RiskAssessment>> categorized = RiskAssessor.assessRisk(holders);

        System.out.println("High Risk Policy Holders:");
        categorized.getOrDefault("High Risk", Collections.emptyList()).forEach(System.out::println);

        System.out.println("\nLow Risk Policy Holders:");
        categorized.getOrDefault("Low Risk", Collections.emptyList()).forEach(System.out::println);
    }
}
