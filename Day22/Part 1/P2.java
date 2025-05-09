import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return String.format("ProductSales{productId='%s', totalRevenue=%.2f}", productId, totalRevenue);
    }
}

class SalesProcessor {
    public static List<ProductSales> analyzeSales(List<Sale> sales) {
        return sales.stream()
                .filter(s -> s.quantity > 10) // Step 1: Filter
                .collect(Collectors.groupingBy(
                        s -> s.productId,
                        Collectors.summingDouble(s -> s.quantity * s.price))) // Step 2: Transform (group & sum)
                .entrySet().stream()
                .map(e -> new ProductSales(e.getKey(), e.getValue()))
                .sorted((a, b) -> Double.compare(b.totalRevenue, a.totalRevenue)) // Step 3: Sort
                .limit(5) // Step 4: Top N
                .collect(Collectors.toList());
    }
}

public class P2 {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 20.0),
                new Sale("P2", 5, 100.0),
                new Sale("P3", 12, 10.0),
                new Sale("P4", 25, 5.0),
                new Sale("P1", 10, 20.0),
                new Sale("P5", 8, 50.0),
                new Sale("P6", 18, 30.0),
                new Sale("P3", 5, 10.0),
                new Sale("P7", 20, 8.0),
                new Sale("P8", 11, 60.0)
        );

        List<ProductSales> topProducts = SalesProcessor.analyzeSales(sales);

        System.out.println("Top 5 Products by Total Revenue (quantity > 10):");
        topProducts.forEach(System.out::println);
    }
}
