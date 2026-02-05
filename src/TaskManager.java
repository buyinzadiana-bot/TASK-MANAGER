import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Custom exception (BONUS)
class InvalidTaskException extends RuntimeException {
    public InvalidTaskException(String message) {
        super(message);
    }
}

public class TaskManager {

    // Using List so we can switch between ArrayList / LinkedList easily
    private List<String> tasks;

    // Constructor
    public TaskManager(boolean useLinkedList) {
        if (useLinkedList) {
            tasks = new LinkedList<>();
        } else {
            tasks = new ArrayList<>();
        }
    }

    // ADD TASK
    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty!");
        }
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // SORT TASKS
    public void sortTasks() {
        Collections.sort(tasks);
        System.out.println("Tasks sorted alphabetically.");
    }

    // SEARCH TASK
    public void searchTask(String task) {
        if (tasks.contains(task)) {
            System.out.println("Task found at index: " + tasks.indexOf(task));
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    // REMOVE TASK
    public void removeTask(String task) {
        if (tasks.remove(task)) {
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found to remove: " + task);
        }
    }

    // GET TASK BY INDEX
    public void getTaskByIndex(int index) {
        try {
            System.out.println("Task at index " + index + ": " + tasks.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
        }
    }

    // FIND LONGEST TASK
    public void findLongestTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        String longest = tasks.get(0);
        for (String task : tasks) {
            if (task.length() > longest.length()) {
                longest = task;
            }
        }
        System.out.println("Longest task: " + longest);
    }

    // DISPLAY ALL TASKS
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Tasks:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
}
