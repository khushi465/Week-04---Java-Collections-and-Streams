import java.io.*;

public class P2 {
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";              // Path to your 100MB+ test file
        String destUnbuffered = "copy_unbuffered.dat";
        String destBuffered = "copy_buffered.dat";

        // Copy with unbuffered streams
        long timeUnbuffered = copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Time taken with unbuffered streams: " + timeUnbuffered + " ns");

        // Copy with buffered streams
        long timeBuffered = copyWithBufferedStreams(sourceFile, destBuffered);
        System.out.println("Time taken with buffered streams:   " + timeBuffered + " ns");

        System.out.println("\nBuffered copy was " +
                ((double) timeUnbuffered / timeBuffered) + "x faster.");
    }

    public static long copyWithUnbufferedStreams(String src, String dest) {
        long start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }

    public static long copyWithBufferedStreams(String src, String dest) {
        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }
}
