# Student Task Manager

A command-line Task Manager application written in Java. Built to practice OOP principles, `ArrayList` manipulation, date parsing with `java.time.LocalDate`, and input validation.

## Features

- Add tasks with a title, description, due date, and priority (HIGH / MEDIUM / LOW)
- View all tasks sorted by due date
- Filter and display only pending tasks
- Mark tasks as complete
- Delete tasks by number

## Tech Used

- **Language:** Java
- **Concepts:** Object-Oriented Programming, `ArrayList`, `Comparator`, `LocalDate`, input validation, switch expressions

## How to Run

```bash
cd src
javac *.java
java src.Main
```

## Project Structure

```
java-task-manager/
└── src/
    ├── Main.java         # Entry point
    ├── Task.java         # Task data model
    └── TaskManager.java  # Core logic and menu
```

## What I Learned

Practicing real-world OOP design — separating `Task` (data model) from `TaskManager` (logic/controller), handling user input safely with `try/catch`, and sorting objects with `Comparator.comparing()`.
