import java.util.*;
import java.util.stream.*;

public class SecondMostFrequentWordExample {
    public static void main(String[] args) {
        // Sample list of words
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "banana", "cherry");

        // Count frequency of each word
        Map<String, Long> wordCount = words.stream()
                                           .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Sort words by frequency and get the second most frequent word
        wordCount.entrySet().stream()
                 .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                 .skip(1)  // Skip the most frequent word
                 .findFirst()  // Get the second most frequent word
                 .ifPresent(entry -> System.out.println("Second most frequent word: " + entry.getKey() + " with count: " + entry.getValue()));
    }
}
