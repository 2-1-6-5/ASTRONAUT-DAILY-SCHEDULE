public class Car {
    private final String brand;
    private final String model;
    private final String color;
    private final int numberOfDoors;
    
    // Gigantic Constructor (made package-private or private)
    // The Builder will be the only class that calls this.
    Car(String brand, String model, String color, int doors) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberOfDoors = doors;
    }

    // Getters for the Car's properties
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public String toString() {
        return "Car Details:\n" +
               "  Brand: " + brand + "\n" +
               "  Model: " + model + "\n" +
               "  Color: " + color + "\n" +
               "  Doors: " + numberOfDoors;
    }
}