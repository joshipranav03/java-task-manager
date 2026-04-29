# Student Task Manager

A console-based task management app built in Java to help students track assignments, deadlines, and priorities.

## Features
- Add tasks with title, description, due date, and priority (HIGH / MEDIUM / LOW)
- View all tasks sorted by due date
- Filter pending tasks
- Mark tasks as complete
- Delete tasks

## Tech Used
- Java 17+
- `ArrayList`, `Comparator`, `LocalDate`
- OOP: encapsulation, classes, methods

## How to Run

```bash
# From the project root
javac src/*.java
java src.Main
```

## Project Structure
```
java-task-manager/
├── src/
│   ├── Main.java         # Entry point
│   ├── Task.java         # Task model (fields, getters, markComplete)
│   └── TaskManager.java  # Menu logic, ArrayList operations, sorting
└── README.md
```

## Example Output
```
==============================
   Student Task Manager v1.0  
==============================
1. Add Task
2. View All Tasks
3. View Pending Tasks
4. Mark Task Complete
5. Delete Task
6. Exit
Choose:
```

## Concepts Practiced
- Object-Oriented Programming
- Collections (`ArrayList`)
- Sorting with `Comparator`
- Input validation and exception handling
- Boolean flags for state management
