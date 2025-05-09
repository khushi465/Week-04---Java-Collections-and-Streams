
public class P1 {
    public static void main(String[] args) {
        String username = "user_123";
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        
        if (username.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
