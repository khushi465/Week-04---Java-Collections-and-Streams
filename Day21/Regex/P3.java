
public class P3 {
    public static void main(String[] args) {
        String color = "#FFA500";
        String regex = "^#[A-Fa-f0-9]{6}$";
        
        if (color.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
