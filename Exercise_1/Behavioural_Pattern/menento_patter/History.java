import java.util.Stack;

public class History {
    // We use a Stack to handle undo functionality (LIFO)
    private final Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        history.push(memento);
    }

    public Memento undo() {
        if (!history.isEmpty()) {
            System.out.println("\nHistory: Performing undo...");
            return history.pop();
        }
        System.out.println("\nHistory: No more states to undo.");
        return null;
    }
}