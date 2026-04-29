package src;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a new task
    public void addTask() {
        System.out.print("Task title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Description: ");
        String desc = scanner.nextLine().trim();

        LocalDate dueDate = null;
        while (dueDate == null) {
            System.out.print("Due date (YYYY-MM-DD): ");
            try {
                dueDate = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("  Invalid format. Try again.");
            }
        }

        String priority = "";
        while (!priority.equals("HIGH") && !priority.equals("MEDIUM") && !priority.equals("LOW")) {
            System.out.print("Priority (HIGH / MEDIUM / LOW): ");
            priority = scanner.nextLine().trim().toUpperCase();
        }

        tasks.add(new Task(title, desc, dueDate, priority));
        System.out.println("  Task added!\n");
    }

    // View all tasks sorted by due date
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("  No tasks found.\n");
            return;
        }
        ArrayList<Task> sorted = new ArrayList<>(tasks);
        sorted.sort(Comparator.comparing(Task::getDueDate));
        System.out.println("\n--- All Tasks (sorted by due date) ---");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
        System.out.println();
    }

    // Mark a task as complete
    public void markTaskComplete() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to mark complete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            ArrayList<Task> sorted = new ArrayList<>(tasks);
            sorted.sort(Comparator.comparing(Task::getDueDate));
            if (index >= 0 && index < sorted.size()) {
                sorted.get(index).markComplete();
                System.out.println("  Marked as complete!\n");
            } else {
                System.out.println("  Invalid number.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("  Please enter a valid number.\n");
        }
    }

    // Delete a task
    public void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            ArrayList<Task> sorted = new ArrayList<>(tasks);
            sorted.sort(Comparator.comparing(Task::getDueDate));
            if (index >= 0 && index < sorted.size()) {
                Task removed = sorted.get(index);
                tasks.remove(removed);
                System.out.println("  Deleted: " + removed.getTitle() + "\n");
            } else {
                System.out.println("  Invalid number.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("  Please enter a valid number.\n");
        }
    }

    // Filter and show only pending tasks
    public void viewPending() {
        System.out.println("\n--- Pending Tasks ---");
        boolean found = false;
        ArrayList<Task> sorted = new ArrayList<>(tasks);
        sorted.sort(Comparator.comparing(Task::getDueDate));
        for (Task t : sorted) {
            if (!t.isCompleted()) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("  No pending tasks!");
        System.out.println();
    }

    // Main menu
    public void run() {
        System.out.println("==============================");
        System.out.println("   Student Task Manager v1.0  ");
        System.out.println("==============================");
        String choice = "";
        while (!choice.equals("5")) {
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. Mark Task Complete");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addTask();
                case "2" -> viewTasks();
                case "3" -> viewPending();
                case "4" -> markTaskComplete();
                case "5" -> deleteTask();
                case "6" -> { System.out.println("Goodbye!"); return; }
                default  -> System.out.println("  Invalid option.\n");
            }
        }
    }
}
