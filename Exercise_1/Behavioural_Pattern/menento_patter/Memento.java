public class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    // Only the Originator (TextEditor) should need to access this.
    public String getSavedText() {
        return text;
    }
}