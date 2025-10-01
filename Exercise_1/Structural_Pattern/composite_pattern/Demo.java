// Demo.java (The Client)
public class Demo {
    public static void main(String[] args) {
        // 1. Create Leaf Products
        Product book1 = new Product("Java Programming Book", 49.99);
        Product game1 = new Product("Video Game: Composite", 59.99);

        // 2. Create Box A (Small Box)
        Box smallBoxA = new Box();
        smallBoxA.add(book1);
        smallBoxA.add(new Product("Headphones", 35.00));
        
        // 3. Create Box B (Another Small Box)
        Box smallBoxB = new Box();
        smallBoxB.add(game1);
        
        // 4. Create the Mother Box (Root of the tree)
        Box motherBox = new Box();
        
        // Add a product and the smaller boxes to the Mother Box
        motherBox.add(new Product("Gift Card", 20.00));
        motherBox.add(smallBoxA); // Box A is a component
        motherBox.add(smallBoxB); // Box B is a component

        // 5. Client calculates the price on the root (Mother Box).
        // The Composite Pattern ensures this call recursively calculates all prices.
        double finalPrice = motherBox.calculatePrice();

        System.out.println("\n------------------------------------");
        System.out.println("FINAL DELIVERY PRICE: $" + finalPrice);
        System.out.println("------------------------------------");
    }
}