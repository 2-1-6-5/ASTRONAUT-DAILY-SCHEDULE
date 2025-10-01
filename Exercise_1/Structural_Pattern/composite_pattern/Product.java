// Product.java (The Leaf)
public class Product implements BoxComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        System.out.println("  - Calculating price for " + name + ": $" + price);
        return price;
    }
}