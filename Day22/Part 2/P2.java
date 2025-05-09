import java.util.*;
import java.util.stream.*;

public class P2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Almond");
        List<String> filtered = words.stream()
                                     .filter(word -> !word.startsWith("A"))
                                     .collect(Collectors.toList());
        filtered.forEach(System.out::println); // Output: Banana, Cherry
    }
}
