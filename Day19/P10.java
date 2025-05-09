import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class P10 {

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Replace with your file path

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Normalize and split the line into words
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort entries by frequency (descending)
            List<Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
            sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
                Entry<String, Integer> entry = sortedEntries.get(i);
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
