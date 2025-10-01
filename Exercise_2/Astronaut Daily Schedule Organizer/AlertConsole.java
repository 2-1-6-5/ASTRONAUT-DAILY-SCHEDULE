public class AlertConsole implements TaskObserver {
    @Override
    public void update(String message) {
        System.out.println("\n📢 **ALERT**: " + message);
    }
}