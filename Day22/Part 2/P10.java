import java.util.*;
import java.util.stream.*;

public class P10 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 7, 9, 2);

        Optional<Integer> maxNumber = numbers.stream()
                                             .max(Integer::compareTo);

        System.out.println("Max number: " + maxNumber.orElseThrow(() -> new NoSuchElementException("List is empty"))); // Output: Max number: 9

        List<Integer> emptyList = Collections.emptyList();
        Optional<Integer> maxEmpty = emptyList.stream()
                                              .max(Integer::compareTo);

        System.out.println("Max from empty list: " + maxEmpty.orElse(null)); // Output: Max from empty list: null
    }
}
