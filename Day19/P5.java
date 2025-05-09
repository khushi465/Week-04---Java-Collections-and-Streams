import java.io.*;
import java.util.Arrays;

public class P5 {

    public static void main(String[] args) {
        String originalImagePath = "original.jpg";       // Use a valid image path
        String newImagePath = "copied.jpg";

        try {
            // Step 1: Read image into byte array
            byte[] imageBytes = imageToByteArray(originalImagePath);

            // Step 2: Write byte array back to new image file
            byteArrayToImage(imageBytes, newImagePath);

            // Step 3: Verify files are identical (optional)
            if (verifyImages(originalImagePath, newImagePath)) {
                System.out.println("Image copied successfully and is identical.");
            } else {
                System.out.println("Image copy completed, but files differ.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Convert image to byte array using ByteArrayOutputStream
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Convert byte array back to image using ByteArrayInputStream
    public static void byteArrayToImage(byte[] data, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Optional: Compare two image files byte-by-byte
    public static boolean verifyImages(String path1, String path2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(path1);
             FileInputStream fis2 = new FileInputStream(path2)) {

            byte[] file1 = fis1.readAllBytes();
            byte[] file2 = fis2.readAllBytes();

            return Arrays.equals(file1, file2);
        }
    }
}
