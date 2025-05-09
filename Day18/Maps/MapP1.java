
import java.util.*;

public class MapP1 {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> freqMap = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z\\s]", ""); // Ignore punctuation
        String[] words = text.split("\\s+");

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> result = countWords(text);
        System.out.println(result); // Output: {hello=2, world=1, java=1}
    }
}

