// Box.java (The Composite)
import java.util.ArrayList;
import java.util.List;

public class Box implements BoxComponent {
    private List<BoxComponent> children = new ArrayList<>();
    private double packagingCost = 2.0; // Extra cost, as mentioned in the video

    public void add(BoxComponent component) {
        children.add(component);
    }

    public void remove(BoxComponent component) {
        children.remove(component);
    }

    @Override
    public double calculatePrice() {
        double total = 0;
        System.out.println("\n== Starting calculation for a Box ==");
        
        // Sum the price of all components recursively
        for (BoxComponent component : children) {
            total += component.calculatePrice();
        }

        // Add the box's own cost
        total += packagingCost;
        
        System.out.println("== Total price for this Box (including $" + packagingCost + " packaging) is: $" + total + " ==");
        return total;
    }
}