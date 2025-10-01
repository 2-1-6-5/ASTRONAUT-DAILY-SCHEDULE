public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // 1. Initial State
        editor.type("Hello, ");
        System.out.println("Current Text: " + editor.getCurrentText());
        history.save(editor.save()); // SAVE 1: "Hello, "

        // 2. State After First Change
        editor.type("Memento Pattern!");
        System.out.println("Current Text: " + editor.getCurrentText());
        history.save(editor.save()); // SAVE 2: "Hello, Memento Pattern!"

        // 3. State After Second Change
        editor.type(" Design Pattern.");
        System.out.println("Current Text: " + editor.getCurrentText());

        // 4. UNDO Operation (Go back to SAVE 2)
        Memento previousState = history.undo();
        if (previousState != null) {
            editor.restore(previousState);
        }
        System.out.println("Final Text after Undo: " + editor.getCurrentText());
        // Output will be: "Hello, Memento Pattern!"
    }
}