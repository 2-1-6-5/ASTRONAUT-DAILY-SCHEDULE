// WhatsAppDecorator.java
public class WhatsAppDecorator extends BaseDecorator {

    public WhatsAppDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        // 1. Execute the base/wrapped send method
        super.send(message);
        
        // 2. Add new behavior
        sendWhatsApp(message);
    }

    private void sendWhatsApp(String message) {
        System.out.println(">>> ADDED DECORATION <<<");
        System.out.println("Sending WhatsApp message: " + message);
        System.out.println(">>> END DECORATION <<<");
    }
}