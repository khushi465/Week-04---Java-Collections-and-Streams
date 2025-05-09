
public class P2 {
    public static void main(String[] args) {
        String plate = "AB1234";
        String regex = "^[A-Z]{2}\\d{4}$";
        
        if (plate.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
