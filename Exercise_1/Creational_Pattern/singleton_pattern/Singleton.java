public class Singleton {

    // 1. Private static field to hold the single instance, marked 'volatile'.
    // 'volatile' ensures visibility across threads and prevents partial initialization issues.
    private static volatile Singleton instance = null;

    // A simple data field for demonstration
    private String data; 

    // 2. Private constructor to prevent instantiation from outside the class.
    private Singleton(String data) {
        this.data = data;
        // Initialization code (e.g., loading config or connecting to a resource) goes here.
        System.out.println("Singleton instance is being created with data: " + data);
    }

    // 3. Public static method to get the instance (Global Access Point).
    // This uses Double-Checked Locking for efficient, thread-safe lazy initialization.
    public static Singleton getInstance(String data) {
        // Use a local variable to reduce repeated reads of the volatile field (performance optimization).
        Singleton result = instance;
        
        // First check: If an instance exists, return it immediately without locking.
        if (result == null) {
            // Synchronized block to ensure only one thread enters the creation logic.
            synchronized (Singleton.class) {
                // Second check: After acquiring the lock, check again.
                // This prevents multiple threads from creating new instances.
                if (instance == null) {
                    instance = new Singleton(data);
                    result = instance; 
                } else {
                    result = instance;
                }
            }
        }
        return result;
    }

    // Example method to show the instance is working
    public String getData() {
        return data;
    }
}