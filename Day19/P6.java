import java.io.*;

public class P6 {

    public static void main(String[] args) {
        String inputFile = "input.txt";      // Provide your input file name
        String outputFile = "output.txt";    // Output file name

        // Specify character encoding (UTF-8)
        try (BufferedReader reader = new BufferedReader(
                 new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(
                 new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine();
            }
            System.out.println("File converted successfully: Uppercase → Lowercase");

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
