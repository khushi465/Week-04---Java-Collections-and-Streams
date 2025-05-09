import java.util.regex.*;

public class P7 {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[a-zA-Z0-9.-]+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }
}
