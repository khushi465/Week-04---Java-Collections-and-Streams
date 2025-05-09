public class P9 {
    public static void main(String[] args) {
        String badWordsRegex = "(damn|stupid)";
        String sentence = "This is a damn bad example with some stupid words.";
        String censoredSentence = sentence.replaceAll(badWordsRegex, "****");
        
        System.out.println(censoredSentence);
    }
}
