import java.time.LocalTime;
import java.time.format.DateTimeParseException;
// Removed: import Task.Priority; -> Using fully qualified name Task.Priority

public class TaskFactory {

    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr, String ratingStr) throws IllegalArgumentException {
        LocalTime startTime;
        LocalTime endTime;
        Task.Priority priority; // <-- Changed to Task.Priority
        int difficultyRating;

        // 1. Validate Time Format
        try {
            startTime = LocalTime.parse(startTimeStr);
            endTime = LocalTime.parse(endTimeStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format. Please use HH:mm (e.g., 07:00).");
        }

        // 2. Validate Time Logic (Start < End)
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("Error: Start time must be before end time.");
        }

        // 3. Validate Priority
        try {
            priority = Task.Priority.valueOf(priorityStr.toUpperCase()); // <-- Changed to Task.Priority.valueOf
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: Invalid priority: " + priorityStr + ". Must be HIGH, MEDIUM, or LOW.");
        }
        
        // 4. Validate Difficulty Rating
        try {
            difficultyRating = Integer.parseInt(ratingStr);
            if (difficultyRating < 1 || difficultyRating > 5) {
                throw new IllegalArgumentException("Error: Difficulty rating must be an integer between 1 and 5.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Difficulty rating must be a valid number (1-5).");
        }

        return new Task(description, startTime, endTime, priority, difficultyRating);
    }
}