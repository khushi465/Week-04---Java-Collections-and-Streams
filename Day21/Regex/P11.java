
public class P11 {
    public static void main(String[] args) {
        String cardNumber = "4111111111111111"; // Example for Visa
        String regex = "^(4\\d{15}|5[1-5]\\d{15})$";
        
        if (cardNumber.matches(regex)) {
            System.out.println("Valid Card Number");
        } else {
            System.out.println("Invalid Card Number");
        }
    }
}
