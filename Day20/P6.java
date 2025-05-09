public class P6 {
    public static void main(String[] args) {
        try {
            System.out.println(calculateInterest(-1000, 5, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return amount * rate * years / 100;
    }
}
