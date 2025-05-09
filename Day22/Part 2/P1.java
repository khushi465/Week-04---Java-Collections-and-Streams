@FunctionalInterface
interface Sum {
    int add(int a, int b);
}

public class P1 {
    public static void main(String[] args) {
        Sum sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.add(10, 20)); // Output: Sum: 30
    }
}
