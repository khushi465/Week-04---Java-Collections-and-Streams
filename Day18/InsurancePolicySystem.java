
import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", " + premiumAmount + "]";
    }
}

public class InsurancePolicySystem {
    Map<String, Policy> policyMap = new HashMap<>(); // For quick lookup
    Map<String, Policy> linkedPolicyMap = new LinkedHashMap<>(); // To maintain insertion order
    TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>(); // Sorted by Expiry Date

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        linkedPolicyMap.put(policy.policyNumber, policy);

        expiryDateMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        expiryDateMap.get(policy.expiryDate).add(policy);
    }

    public Policy getPolicyByNumber(String number) {
        return policyMap.get(number);
    }

    public List<Policy> listExpiringIn30Days() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate in30Days = now.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : expiryDateMap.subMap(now, true, in30Days, true).entrySet()) {
            expiringSoon.addAll(entry.getValue());
        }
        return expiringSoon;
    }

    public List<Policy> listPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : policyMap.values()) {
            if (p.policyholderName.equalsIgnoreCase(holderName)) {
                result.add(p);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = policyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().expiryDate.isBefore(today)) {
                linkedPolicyMap.remove(entry.getKey());
                expiryDateMap.get(entry.getValue().expiryDate).remove(entry.getValue());
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        
        system.addPolicy(new Policy("P100", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P101", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P102", "Alice", LocalDate.now().plusDays(5), "Home", 8000));
        system.addPolicy(new Policy("P103", "Charlie", LocalDate.now().minusDays(5), "Health", 6000));

        System.out.println("Policy by Number P100: " + system.getPolicyByNumber("P100"));
        System.out.println("Policies expiring in next 30 days: " + system.listExpiringIn30Days());
        System.out.println("Policies for Alice: " + system.listPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("All policies after removing expired:");
        for (Policy p : system.policyMap.values()) {
            System.out.println(p);
        }
    }
}




