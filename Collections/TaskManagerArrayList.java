package Collections;

import java.util.ArrayList;

public class TaskManagerArrayList {
    private ArrayList<String> tasks;

    public TaskManagerArrayList() {
        tasks = new ArrayList<>();
    }
    public void addTask(String task) {
        tasks.add(task);
    }
    public void completeTask(int index) {
        tasks.set(index, "[Completed] " + tasks.get(index));
    }
    public void removeTask(int index) {
        tasks.remove(index);
    }
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManagerArrayList manager = new TaskManagerArrayList();
        manager.addTask("Finish report");
        manager.addTask("Call client");
        manager.addTask("Prepare presentation");
        manager.displayTasks();
        manager.completeTask(0);
        manager.removeTask(1);
        manager.displayTasks();
    }
}
