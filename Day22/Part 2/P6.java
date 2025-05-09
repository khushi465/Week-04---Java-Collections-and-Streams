import java.util.*;
import java.util.function.*;

public class P6 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        
        Consumer<String> printUpperCase = word -> System.out.println(word.toUpperCase());
        
        words.forEach(printUpperCase);  // Output: APPLE, BANANA, CHERRY
    }
}
