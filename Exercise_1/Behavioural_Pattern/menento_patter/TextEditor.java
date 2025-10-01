public class TextEditor {
    private String text = "";

    public void type(String words) {
        this.text = this.text.concat(words);
    }

    public String getCurrentText() {
        return this.text;
    }

    // Method to create a Memento (save state)
    public Memento save() {
        System.out.println("\nTextEditor: Saving state...");
        return new Memento(this.text);
    }

    // Method to restore state from a Memento
    public void restore(Memento memento) {
        this.text = memento.getSavedText();
        System.out.println("TextEditor: Restored state: " + this.text);
    }
}