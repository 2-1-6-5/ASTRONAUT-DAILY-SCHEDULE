import java.util.Scanner;
import java.util.List;
// Removed: import Task.Priority; -> Using fully qualified name Task.Priority

public class ConsoleApp {
    public static void main(String[] args) {
        // Singleton and Observer setup
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.attach(new AlertConsole());

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n🚀 Astronaut Daily Schedule Organizer 🚀");
        // ... (menu printing)
        System.out.println("-------------------------------------------------");
        System.out.println("Available Commands:");
        System.out.println("  ADD <desc> <start> <end> <priority> <difficulty_1-5>");
        System.out.println("  REMOVE <desc>");
        System.out.println("  VIEW (or VIEW HIGH/MEDIUM/LOW)");
        System.out.println("  EDIT <old_desc> <new_desc> <start> <end> <priority> <difficulty_1-5>");
        System.out.println("  COMPLETE <desc>");
        System.out.println("  ANALYZE"); 
        System.out.println("  EXIT");
        System.out.println("-------------------------------------------------");


        while (true) {
            System.out.print("\nEnter command: ");
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) continue;

            String[] parts = inputLine.split(" ", 7);
            String command = parts[0].toUpperCase();
            
            try {
                switch (command) {
                    case "EXIT":
                        System.out.println("Logging out. Have a productive day!");
                        scanner.close();
                        return;

                    case "ADD":
                        if (parts.length == 6) {
                            String output = manager.addTask(parts[1], parts[2], parts[3], parts[4], parts[5]);
                            System.out.println("\nResponse: " + output);
                        } else {
                            System.out.println("Error: ADD requires 5 arguments.");
                        }
                        break;
                    
                    case "REMOVE":
                        if (parts.length == 2) {
                            String output = manager.removeTask(parts[1]);
                            System.out.println("\nResponse: " + output);
                        } else {
                            System.out.println("Error: REMOVE requires 1 argument.");
                        }
                        break;
                    
                    case "VIEW":
                        Task.Priority filter = null; // <-- Changed to Task.Priority
                        if (parts.length == 2) {
                            filter = Task.Priority.valueOf(parts[1].toUpperCase()); // <-- Changed to Task.Priority.valueOf
                        } else if (parts.length > 2) {
                             System.out.println("Error: VIEW takes 0 or 1 argument.");
                             break;
                        }
                        
                        List<String> tasks = manager.viewTasks(filter);
                        System.out.println("\nScheduled Tasks:");
                        tasks.forEach(task -> System.out.println("  - " + task));
                        break;

                    case "EDIT":
                        if (parts.length == 7) {
                            String output = manager.editTask(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                            System.out.println("\nResponse: " + output);
                        } else {
                            System.out.println("Error: EDIT requires 6 arguments.");
                        }
                        break;
                        
                    case "COMPLETE":
                        if (parts.length == 2) {
                            String output = manager.markCompleted(parts[1]);
                            System.out.println("\nResponse: " + output);
                        } else {
                            System.out.println("Error: COMPLETE requires 1 argument.");
                        }
                        break;

                    case "ANALYZE":
                         if (parts.length == 1) {
                            String output = manager.getWorkloadAnalysis();
                            System.out.println("\nResponse: " + output);
                        } else {
                            System.out.println("Error: ANALYZE takes no arguments.");
                        }
                        break;

                    default:
                        System.out.println("Error: Unknown command '" + command + "'");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n🚨 Critical System Error: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}