import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.*;

public class MostFrequentWordsExample {
    public static void main(String[] args) throws IOException {
        // Read text file as a String
        String text = new String(Files.readAllBytes(Paths.get("text_corpus.txt")));

        // Tokenize text into words, remove punctuation, convert to lowercase
        List<String> words = Arrays.stream(text.split("\\W+"))
                                   .map(String::toLowerCase)
                                   .collect(Collectors.toList());

        // Count frequency of each word
        Map<String, Long> wordCount = words.stream()
                                           .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Find top N frequent words
        int N = 10; // Get top 10 frequent words
        wordCount.entrySet().stream()
                 .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                 .limit(N)
                 .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
