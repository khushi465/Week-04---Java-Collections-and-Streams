import java.io.*;

public class P8 {

    public static void main(String[] args) {
        try {
            // Connect the input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create and start writer and reader threads
            Thread writer = new Thread(new WriterThread(pos));
            Thread reader = new Thread(new ReaderThread(pis));

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Error connecting piped streams: " + e.getMessage());
        }
    }
}

// Writer thread: sends data
class WriterThread implements Runnable {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
            String[] messages = {
                "Hello from writer thread!",
                "Java Piped Streams are useful.",
                "End of message."
            };

            for (String msg : messages) {
                writer.write(msg);
                writer.newLine(); // write newline so reader knows when line ends
                writer.flush();   // ensure data is sent
                Thread.sleep(500); // simulate processing time
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

// Reader thread: receives data
class ReaderThread implements Runnable {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}
