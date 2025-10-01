import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalTime;
// Removed: import Task.Priority; -> Using fully qualified name Task.Priority

public class ScheduleManager implements TaskNotifier {
    
    // Singleton Pattern fields
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<TaskObserver> observers;

    private ScheduleManager() {
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
        System.out.println("💡 Logging setup complete. (Simplified console log)");
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }
    
    private void log(String message) {
        System.out.println("[LOG " + LocalTime.now().toString() + "]: " + message);
    }

    // Observer Implementation
    @Override
    public void attach(TaskObserver observer) {
        if (!observers.contains(observer)) { observers.add(observer); }
    }
    @Override
    public void detach(TaskObserver observer) { observers.remove(observer); }
    @Override
    public void notifyObservers(String message) {
        for (TaskObserver observer : observers) { observer.update(message); }
    }

    // Mandatory: Conflict Validation
    private Task checkForOverlap(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.getStartTime().isBefore(existingTask.getEndTime()) &&
                newTask.getEndTime().isAfter(existingTask.getStartTime())) {
                return existingTask;
            }
        }
        return null;
    }

    // Mandatory Requirement: 1. Add Task 
    public String addTask(String description, String startTimeStr, String endTimeStr, String priorityStr, String ratingStr) {
        log("Attempting to add task: " + description);
        try {
            Task newTask = TaskFactory.createTask(description, startTimeStr, endTimeStr, priorityStr, ratingStr);
            // ... (conflict check, logging, and return)
            Task conflict = checkForOverlap(newTask);
            if (conflict != null) {
                String message = String.format(
                    "Task conflicts with existing task: '%s'. Task '%s' was NOT added.",
                    conflict.getDescription(), description
                );
                this.notifyObservers(message);
                return "Error: Task conflicts with existing task.";
            }

            tasks.add(newTask);
            Collections.sort(tasks); 
            log("Task added successfully: " + description);
            return "Task added successfully. No conflicts.";

        } catch (IllegalArgumentException e) {
            log("Error adding task: " + e.getMessage());
            return e.getMessage();
        }
    }
    
    // Mandatory Requirement: 2. Remove Task
    public String removeTask(String description) {
        boolean removed = tasks.removeIf(t -> t.getDescription().equalsIgnoreCase(description));
        if (removed) {
            log("Task removed: " + description);
            return "Task removed successfully.";
        } else {
            log("Removal failed: Task not found: " + description);
            return "Error: Task not found.";
        }
    }

    // Mandatory/Optional Requirement: 3. View Tasks
    public List<String> viewTasks(Task.Priority filter) { // <-- Changed to Task.Priority
        if (tasks.isEmpty()) {
            return List.of("No tasks scheduled for the day.");
        }

        List<String> results = new ArrayList<>();
        for (Task t : tasks) {
            if (filter == null || t.getPriority() == filter) {
                results.add(t.toString());
            }
        }
        
        if (results.isEmpty() && filter != null) {
             return List.of("No tasks found with priority: " + filter.name());
        }
        return results;
    }
    
    // Optional Requirement: 1. Edit an existing task
    public String editTask(String oldDesc, String newDesc, String startStr, String endStr, String priorityStr, String ratingStr) {
        Task taskToEdit = tasks.stream()
            .filter(t -> t.getDescription().equalsIgnoreCase(oldDesc))
            .findFirst()
            .orElse(null);

        if (taskToEdit == null) { return "Error: Task not found for editing."; }
        tasks.remove(taskToEdit); 

        try {
            Task tempNewTask = TaskFactory.createTask(newDesc, startStr, endStr, priorityStr, ratingStr);
            
            if (checkForOverlap(tempNewTask) != null) {
                throw new IllegalArgumentException("Task edit creates a time conflict.");
            }
            
            // Apply changes if valid
            taskToEdit.setDescription(newDesc);
            taskToEdit.setStartTime(tempNewTask.getStartTime());
            taskToEdit.setEndTime(tempNewTask.getEndTime());
            taskToEdit.setPriority(tempNewTask.getPriority());
            taskToEdit.setDifficultyRating(tempNewTask.getDifficultyRating());
            
            tasks.add(taskToEdit);
            Collections.sort(tasks);
            log("Task edited: " + oldDesc + " -> " + newDesc);
            return "Task edited successfully.";

        } catch (IllegalArgumentException e) {
            tasks.add(taskToEdit); // Restore the original task on failure
            Collections.sort(tasks);
            this.notifyObservers(String.format("Task edit for '%s' failed: %s", oldDesc, e.getMessage()));
            return "Error during edit: " + e.getMessage();
        }
    }

    // Optional Requirement: 2. Mark tasks as completed
    public String markCompleted(String description) {
        Task task = tasks.stream()
            .filter(t -> t.getDescription().equalsIgnoreCase(description))
            .findFirst()
            .orElse(null);

        if (task != null) {
            task.setCompleted(true);
            log("Task marked completed: " + description);
            return String.format("Task '%s' marked as completed.", description);
        } else {
            return "Error: Task not found.";
        }
    }

    // UNIQUE FEATURE: Workload Analysis
    public String getWorkloadAnalysis() {
        if (tasks.isEmpty()) {
            return "No tasks to analyze.";
        }
        
        int totalRating = tasks.stream().mapToInt(Task::getDifficultyRating).sum();
        double averageRating = (double) totalRating / tasks.size();
        
        return String.format("📊 Workload Analysis: Total daily difficulty score: %d. Average task difficulty: %.2f (based on %d tasks).",
                             totalRating, averageRating, tasks.size());
    }
}