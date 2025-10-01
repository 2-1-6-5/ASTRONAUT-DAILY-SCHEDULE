public interface TaskNotifier {
    void attach(TaskObserver observer);
    void detach(TaskObserver observer);
    void notifyObservers(String message);
}