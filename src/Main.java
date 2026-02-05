public class Main {

    public static void main(String[] args) {

        // true = LinkedList, false = ArrayList
        TaskManager manager = new TaskManager(false);

        System.out.println("---- ADDING TASKS ----");

        try {
            manager.addTask("Do homework");
            manager.addTask("Clean room");
            manager.addTask("Buy groceries");
            manager.addTask(""); // invalid
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Task adding attempt finished.");
        }

        System.out.println("\n---- DISPLAY TASKS ----");
        manager.displayTasks();

        System.out.println("\n---- SORT TASKS ----");
        manager.sortTasks();
        manager.displayTasks();

        System.out.println("\n---- SEARCH TASKS ----");
        manager.searchTask("Clean room");
        manager.searchTask("Go jogging");

        System.out.println("\n---- REMOVE TASK ----");
        manager.removeTask("Buy groceries");
        manager.removeTask("Go jogging");

        System.out.println("\n---- GET TASK BY INDEX ----");
        manager.getTaskByIndex(0);
        manager.getTaskByIndex(10); // invalid index

        System.out.println("\n---- LONGEST TASK ----");
        manager.findLongestTask();
    }
}
