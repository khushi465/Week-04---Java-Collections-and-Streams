import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class P5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Avocado", "Grapes");

        Predicate<String> lengthPredicate = word -> word.length() > 5;
        Predicate<String> containsAPredicate = word -> word.contains("a");

        List<String> result = words.stream()
                                   .filter(lengthPredicate.and(containsAPredicate))
                                   .collect(Collectors.toList());

        result.forEach(System.out::println); // Output: Banana, Avocado
    }
}
