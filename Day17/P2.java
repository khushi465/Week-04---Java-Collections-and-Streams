
import java.util.*;

interface ProductCategory {

    String getCategoryName();
}

class BookCategory implements ProductCategory {

    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements ProductCategory {

    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {

    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends ProductCategory> {

    private String name;
    private double price;
    private T category;
    // object of the category classes

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percent) {
        this.price -= price * percent / 100;
    }

    public String getDetails() {
        return String.format("%s Category: %s, Price: INR %.2f", name, category.getCategoryName(), price);
    }
}

class DiscountUtil {

    public static <T extends Product<?>> void applyDiscount(T product, double percent) {
        // means t must be a type that is a product with some unknown category type not necessarily a subclass
        product.applyDiscount(percent);
        System.out.println("Discount applied: " + product.getDetails());
    }
}

public class P2 {

    public static void main(String[] args) {
        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

        // Add various products
        catalog.add(new Product<>("The Alchemist", 15.99, new BookCategory()));
        catalog.add(new Product<>("T-Shirt", 25.00, new ClothingCategory()));
        catalog.add(new Product<>("Smartphone", 599.99, new GadgetCategory()));

        // Display and apply discounts
        for (Product<? extends ProductCategory> product : catalog) {
            System.out.println(product.getDetails());
            DiscountUtil.applyDiscount(product, 10); // 10% off
        }
    }
}
