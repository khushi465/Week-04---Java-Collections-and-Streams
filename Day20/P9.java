import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            int[] arr = {1, 2, 3, 4, 5};
            try {
                int value = arr[index];
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a valid number");
        } finally {
            scanner.close();
        }
    }
}
