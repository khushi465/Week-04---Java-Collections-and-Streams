import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Class representing a Policy
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber +
               ", Holder: " + policyHolderName +
               ", Expiry: " + expiryDate +
               ", Type: " + coverageType +
               ", Premium: " + premiumAmount;
    }
}

// Main class
public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();
    private Set<String> policyNumbers = new HashSet<>(); // to detect duplicates

    // Add a policy to all sets
    public void addPolicy(Policy policy) {
        if (policyNumbers.contains(policy.getPolicyNumber())) {
            System.out.println("Duplicate Policy Detected: " + policy.getPolicyNumber());
            return;
        }
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
        policyNumbers.add(policy.getPolicyNumber());
    }

    // Display all unique policies
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (Policy policy : linkedHashSet) { // use linkedHashSet to maintain insertion order
            System.out.println(policy);
        }
    }

    // Display policies expiring within next 30 days
    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();
        for (Policy policy : treeSet) {
            long daysBetween = ChronoUnit.DAYS.between(today, policy.getExpiryDate());
            if (daysBetween >= 0 && daysBetween <= 30) {
                System.out.println(policy);
            }
        }
    }

    // Display policies based on Coverage Type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Performance Comparison
    public void performanceComparison() {
        System.out.println("\nPerformance Comparison:");
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Policy p = new Policy("PN" + i, "Holder" + i, LocalDate.now().plusDays(i % 365),
                    "Auto", 1000 + i);
            testPolicies.add(p);
        }

        // HashSet
        long start = System.nanoTime();
        Set<Policy> hs = new HashSet<>();
        for (Policy p : testPolicies) {
            hs.add(p);
        }
        long end = System.nanoTime();
        System.out.println("HashSet Insertion Time: " + (end - start) + " ns");

        // LinkedHashSet
        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>();
        for (Policy p : testPolicies) {
            lhs.add(p);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet Insertion Time: " + (end - start) + " ns");

        // TreeSet
        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>();
        for (Policy p : testPolicies) {
            ts.add(p);
        }
        end = System.nanoTime();
        System.out.println("TreeSet Insertion Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 7000));
        system.addPolicy(new Policy("P004", "David", LocalDate.now().plusDays(15), "Auto", 4500));
        system.addPolicy(new Policy("P001", "Eve", LocalDate.now().plusDays(20), "Health", 5500)); // Duplicate

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayPoliciesByCoverage("Auto");

        system.performanceComparison();
    }
}

