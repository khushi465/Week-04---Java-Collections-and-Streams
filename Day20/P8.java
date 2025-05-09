public class P8 {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method1() throws ArithmeticException {
        int result = 10 / 0;
    }

    public static void method2() throws ArithmeticException {
        method1();
    }
}
