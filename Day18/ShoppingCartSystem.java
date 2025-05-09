
import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ShoppingCartSystem {
    Map<String, Double> productPrices = new HashMap<>(); // Product Name -> Price
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // Maintain insertion order (Product -> Quantity)

    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }

    public void addToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println(productName + " does not exist in the product list.");
            return;
        }
        cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
    }

    public void displayCartInOrder() {
        System.out.println("Cart Items (In Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println(product + " - Quantity: " + quantity + ", Price: $" + price);
        }
    }

    public void displayCartSortedByPrice() {
        System.out.println("Cart Items (Sorted by Price):");
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            priceMap.putIfAbsent(price, new ArrayList<>());
            priceMap.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : priceMap.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                int quantity = cart.get(product);
                System.out.println(product + " - Quantity: " + quantity + ", Price: $" + price);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem cartSystem = new ShoppingCartSystem();

        // Adding Products
        cartSystem.addProduct("Apple", 1.5);
        cartSystem.addProduct("Banana", 0.8);
        cartSystem.addProduct("Orange", 1.2);
        cartSystem.addProduct("Milk", 2.0);

        // Adding to Cart
        cartSystem.addToCart("Apple", 2);
        cartSystem.addToCart("Milk", 1);
        cartSystem.addToCart("Banana", 5);
        cartSystem.addToCart("Orange", 3);

        System.out.println();
        cartSystem.displayCartInOrder();

        System.out.println();
        cartSystem.displayCartSortedByPrice();
    }
}

