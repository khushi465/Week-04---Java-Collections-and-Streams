import java.util.regex.*;

public class P12 {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }
}
