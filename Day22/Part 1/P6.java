import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    Date transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class Alert {
    String policyNumber;
    int fraudCount;
    double totalAmount;

    public Alert(String policyNumber, int fraudCount, double totalAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format("Alert{policyNumber='%s', fraudCount=%d, totalAmount=%.2f}", 
                              policyNumber, fraudCount, totalAmount);
    }
}

class FraudDetector {
    public static List<Alert> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> grouped = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(t -> t.policyNumber));

        return grouped.entrySet().stream()
                .map(e -> {
                    int count = e.getValue().size();
                    double total = e.getValue().stream().mapToDouble(t -> t.amount).sum();
                    return new Alert(e.getKey(), count, total);
                })
                .filter(a -> a.fraudCount > 5 || a.totalAmount > 50000)
                .collect(Collectors.toList());
    }
}

public class P6 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 12000, new Date(), true),
                new Transaction("T002", "P001", 18000, new Date(), true),
                new Transaction("T003", "P001", 16000, new Date(), true),
                new Transaction("T004", "P001", 14000, new Date(), true),
                new Transaction("T005", "P001", 11000, new Date(), true),
                new Transaction("T006", "P001", 13000, new Date(), true), // 6 frauds over 10k
                new Transaction("T007", "P002", 25000, new Date(), true), // 1 fraud
                new Transaction("T008", "P003", 9000, new Date(), true),   // below 10k, ignored
                new Transaction("T009", "P003", 55000, new Date(), true), // 1 fraud over 50k
                new Transaction("T010", "P004", 8000, new Date(), false)  // not fraudulent
        );

        List<Alert> alerts = FraudDetector.detectFraud(transactions);

        System.out.println("Fraud Alerts:");
        alerts.forEach(System.out::println);
    }
}
