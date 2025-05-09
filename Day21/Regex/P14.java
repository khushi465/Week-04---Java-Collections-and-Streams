import java.util.*;
import java.util.regex.*;

public class P14 {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatedWords = new HashSet<>();
        
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        
        System.out.println(repeatedWords);
    }
}
