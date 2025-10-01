// BaseDecorator.java (The Base Decorator)
public abstract class BaseDecorator implements INotifier {
    // The wrapped component reference
    private INotifier wrapped;

    public BaseDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
    }

    // Delegates the call to the wrapped object
    @Override
    public void send(String message) {
        wrapped.send(message);
    }
}
