// FacebookDecorator.java
public class FacebookDecorator extends BaseDecorator {

    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        // 1. Execute the base/wrapped send method
        super.send(message);
        
        // 2. Add new behavior
        sendFacebook(message);
    }

    private void sendFacebook(String message) {
        System.out.println(">>> ADDED DECORATION <<<");
        System.out.println("Sending Facebook message: " + message);
        System.out.println(">>> END DECORATION <<<");
    }
}