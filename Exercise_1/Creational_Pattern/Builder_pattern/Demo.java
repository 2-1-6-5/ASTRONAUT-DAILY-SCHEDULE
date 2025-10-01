public class Demo {
    public static void main(String[] args) {
        
        // --- 1. Use the Builder Directly (Ad-Hoc Construction) ---
        System.out.println("--- Ad-Hoc Construction ---");
        Car customCar = new CarBuilder()
            .setBrand("Tesla")
            .setModel("Model 3")
            .setDoors(4)
            // Optional: color is skipped
            .build();
            
        System.out.println(customCar);
        
        // --- 2. Use the Director (Predefined Construction) ---
        System.out.println("\n--- Director Construction ---");
        
        // Create the Builder instance
        CarBuilder builder = new CarBuilder();
        
        // Create the Director instance
        Director director = new Director();

        // Pass the builder to the director to execute a routine
        director.constructSportsCar(builder);

        // Get the final product from the builder
        Car sportsCar = builder.build();
        
        System.out.println(sportsCar);
    }
}