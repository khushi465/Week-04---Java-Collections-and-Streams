import java.util.function.*;

public class P7 {
    public static void main(String[] args) {
        Function<Double, Double> areaOfCircle = radius -> Math.PI * radius * radius;

        System.out.println("Area of circle with radius 5: " + areaOfCircle.apply(5.0));  // Output: 78.53981633974483
    }
}
