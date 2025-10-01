public class Demo {
    public static void main(String[] args) {
        
        // 1. Get the first instance. This will call the private constructor.
        Singleton firstInstance = Singleton.getInstance("Configuration Settings Loaded");
        
        System.out.println("First Instance Data: " + firstInstance.getData());
        
        // 2. Try to get a second instance with different data.
        // The pattern ensures the *existing* instance is returned, ignoring the new data.
        Singleton secondInstance = Singleton.getInstance("New Attempted Configuration");
        
        System.out.println("Second Instance Data: " + secondInstance.getData());

        // Verification: Check if both variables reference the exact same object in memory.
        System.out.println("\nDo both references point to the same object? " + 
                           (firstInstance == secondInstance)); // Output: true
    }
}