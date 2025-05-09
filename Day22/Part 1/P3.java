import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("BookRecommendation{title='%s', rating=%.1f}", title, rating);
    }
}

class BookProcessor {
    public static List<BookRecommendation> recommendBooks(List<Book> books, int page, int pageSize) {
        return books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0) // Step 1
                .sorted((a, b) -> Double.compare(b.rating, a.rating)) // Step 3
                .map(b -> new BookRecommendation(b.title, b.rating)) // Step 2
                .skip((page - 1) * pageSize) // Step 4 (Pagination)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}

public class P3 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.3),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.0),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
                new Book("Contact", "Carl Sagan", "Science Fiction", 4.4),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.2),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.1),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("2001: A Space Odyssey", "Arthur C. Clarke", "Science Fiction", 4.0),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.1)
        );

        int page = 1;
        int pageSize = 5;
        System.out.println("Page " + page + " of Top Science Fiction Book Recommendations:");
        BookProcessor.recommendBooks(books, page, pageSize).forEach(System.out::println);

        System.out.println("\nPage 2 of Top Science Fiction Book Recommendations:");
        BookProcessor.recommendBooks(books, 2, pageSize).forEach(System.out::println);
    }
}
