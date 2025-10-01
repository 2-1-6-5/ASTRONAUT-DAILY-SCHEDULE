// Demo.java (The Client)
public class Demo {
    public static void main(String[] args) {
        String notificationMessage = "Your order has been shipped!";

        // 1. Create the base component
        INotifier baseNotifier = new Notifier("customer123");

        // 2. Wrap the base component with multiple decorators
        // The structure: FacebookDecorator(WhatsAppDecorator(Notifier))
        INotifier allChannelNotifier = new FacebookDecorator(
                                        new WhatsAppDecorator(baseNotifier)
                                      );

        System.out.println("--- Scenario 1: Email, WhatsApp, and Facebook ---");
        // Calling send() on the outermost decorator triggers the entire chain
        allChannelNotifier.send(notificationMessage);

        System.out.println("\n============================================\n");

        // 3. Create a different combination at runtime (e.g., just Email and WhatsApp)
        INotifier whatsappOnlyNotifier = new WhatsAppDecorator(baseNotifier);

        System.out.println("--- Scenario 2: Email and WhatsApp Only ---");
        whatsappOnlyNotifier.send(notificationMessage);
    }
}