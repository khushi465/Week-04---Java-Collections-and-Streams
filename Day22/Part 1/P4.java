import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    Date claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaimStats {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    public PolicyClaimStats(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return String.format("PolicyClaimStats{policyNumber='%s', totalAmount=%.2f, averageAmount=%.2f}",
                policyNumber, totalAmount, averageAmount);
    }
}

class ClaimsProcessor {
    public static List<PolicyClaimStats> analyzeClaims(List<Claim> claims) {
        // Step 1: Filter
        Map<String, List<Claim>> grouped = claims.stream()
                .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        // Step 2–4: Aggregate total and average claim amounts
        return grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
                    double average = policyClaims.stream().mapToDouble(c -> c.claimAmount).average().orElse(0);
                    return new PolicyClaimStats(policy, total, average);
                })
                .sorted((a, b) -> Double.compare(b.totalAmount, a.totalAmount)) // Top N: Sort by totalAmount
                .limit(3)
                .collect(Collectors.toList());
    }
}

public class P4 {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P001", 7000, new Date(), "Approved"),
                new Claim("C002", "P002", 12000, new Date(), "Approved"),
                new Claim("C003", "P001", 8000, new Date(), "Approved"),
                new Claim("C004", "P003", 4000, new Date(), "Rejected"),
                new Claim("C005", "P002", 15000, new Date(), "Approved"),
                new Claim("C006", "P004", 6000, new Date(), "Approved"),
                new Claim("C007", "P003", 10000, new Date(), "Approved"),
                new Claim("C008", "P005", 3000, new Date(), "Approved"),
                new Claim("C009", "P002", 9000, new Date(), "Approved")
        );

        List<PolicyClaimStats> topPolicies = ClaimsProcessor.analyzeClaims(claims);
        System.out.println("Top 3 Policies with Highest Total Claim Amounts:");
        topPolicies.forEach(System.out::println);
    }
}
