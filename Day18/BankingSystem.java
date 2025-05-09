
import java.util.*;

class Customer {
    String accountNumber;
    double balance;

    Customer(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: $" + balance;
    }
}

public class BankingSystem {
    Map<String, Double> accounts = new HashMap<>();              // AccountNumber -> Balance
    Queue<String> withdrawalRequests = new LinkedList<>();       // Queue for withdrawal processing

    // Add a new account
    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Request a withdrawal (enqueue account number)
    public void requestWithdrawal(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist!");
            return;
        }
        withdrawalRequests.add(accountNumber);
        System.out.println("Withdrawal request queued for account: " + accountNumber);
    }

    // Process all withdrawal requests
    public void processWithdrawals(double amount) {
        System.out.println("\nProcessing Withdrawals...");
        while (!withdrawalRequests.isEmpty()) {
            String acc = withdrawalRequests.poll();
            double currentBalance = accounts.get(acc);
            if (currentBalance >= amount) {
                accounts.put(acc, currentBalance - amount);
                System.out.println("Withdrawal of $" + amount + " successful for " + acc);
            } else {
                System.out.println("Withdrawal failed for " + acc + " (Insufficient balance)");
            }
        }
    }

    // Display all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            String accNum = entry.getKey();
            double balance = entry.getValue();
            sortedAccounts.putIfAbsent(balance, new ArrayList<>());
            sortedAccounts.get(balance).add(accNum);
        }

        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            double balance = entry.getKey();
            for (String accNum : entry.getValue()) {
                System.out.println("Account: " + accNum + ", Balance: $" + balance);
            }
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 3000);
        bank.addAccount("A103", 7000);
        bank.addAccount("A104", 2000);

        bank.displayAllAccounts();

        // Request some withdrawals
        bank.requestWithdrawal("A101");
        bank.requestWithdrawal("A103");
        bank.requestWithdrawal("A104");

        // Process withdrawals (say withdraw $1000 from each)
        bank.processWithdrawals(1000);

        // Display updated account balances
        bank.displayAllAccounts();

        // Display accounts sorted by balance
        bank.displayAccountsSortedByBalance();
    }
}

