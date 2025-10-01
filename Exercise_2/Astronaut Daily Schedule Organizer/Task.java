import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    
    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;
    private int difficultyRating; 
    private boolean isCompleted;

    public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority, int difficultyRating) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.difficultyRating = difficultyRating;
        this.isCompleted = false;
    }

    // Getters 
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public Priority getPriority() { return priority; }
    public int getDifficultyRating() { return difficultyRating; } 
    public boolean isCompleted() { return isCompleted; }

    // Setters
    public void setDescription(String description) { this.description = description; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setDifficultyRating(int difficultyRating) { this.difficultyRating = difficultyRating; } 
    public void setCompleted(boolean completed) { this.isCompleted = completed; }

    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String status = isCompleted ? " [Completed]" : "";
        return String.format("%s - %s: %s [%s] (Difficulty: %d)%s",
                             startTime.format(formatter),
                             endTime.format(formatter),
                             description,
                             priority.name(),
                             difficultyRating, 
                             status);
    }
}