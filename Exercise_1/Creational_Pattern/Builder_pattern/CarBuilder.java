public class CarBuilder implements CarBuilderInterface {
    
    // The builder holds copies of the product's fields
    private String brand;
    private String model;
    private String color;
    private int doors;

    // The setter methods configure the builder's fields and return the builder itself.
    @Override
    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    // The build method uses the stored data to instantiate the final Car object.
    @Override
    public Car build() {
        // Validation logic can be placed here before creation
        if (brand == null || model == null) {
            throw new IllegalStateException("Brand and Model are mandatory.");
        }
        
        // Calls the package-private constructor of the Car class
        return new Car(brand, model, color, doors);
    }
}