package src;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority; // HIGH, MEDIUM, LOW
    private boolean completed;

    public Task(String title, String description, LocalDate dueDate, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority.toUpperCase();
        this.completed = false;
    }

    // Getters
    public String getTitle()       { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate()  { return dueDate; }
    public String getPriority()    { return priority; }
    public boolean isCompleted()   { return completed; }

    // Mark task complete
    public void markComplete() { this.completed = true; }

    @Override
    public String toString() {
        String status = completed ? "[DONE]" : "[PENDING]";
        return String.format("%s %-25s | Due: %s | Priority: %-6s | %s",
                status, title, dueDate, priority, description);
    }
}
