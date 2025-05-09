import java.io.*;

public class P1 {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to ");

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } 
        }
    }

