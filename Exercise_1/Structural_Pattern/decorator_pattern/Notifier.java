// Notifier.java (The Concrete Component)
public class Notifier implements INotifier {
    private String username;

    public Notifier(String username) {
        this.username = username;
    }

    @Override
    public void send(String message) {
        // This simulates retrieving the email from the database
        String email = username + "@example.com";
        
        System.out.println("--- BASE NOTIFIER ---");
        System.out.println("Sending EMAIL to " + email + ": " + message);
        System.out.println("---------------------");
    }
}