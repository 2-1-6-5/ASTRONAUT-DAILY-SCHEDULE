public interface CarBuilderInterface {
    
    // Methods to set the parts of the product, often returning 'this' 
    // to allow for method chaining.
    CarBuilderInterface setBrand(String brand);
    CarBuilderInterface setModel(String model);
    CarBuilderInterface setColor(String color);
    CarBuilderInterface setDoors(int doors);
    
    // Method to finalize and return the constructed product.
    Car build();
}