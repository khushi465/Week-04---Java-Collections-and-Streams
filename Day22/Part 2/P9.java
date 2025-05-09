@FunctionalInterface
interface Square {
    int calculate(int a);

    default void printMessage(int a) {
        System.out.println("The square of " + a + " is: " + calculate(a));
    }
}

public class P9 {
    public static void main(String[] args) {
        Square square = a -> a * a;

        square.printMessage(4); // Output: The square of 4 is: 16
    }
}
