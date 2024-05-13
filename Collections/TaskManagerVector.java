package Collections;

import java.util.Vector;

public class TaskManagerVector {
    private Vector<String> tasks;

    public TaskManagerVector() {
        tasks = new Vector<>();
    }

    public synchronized void addTask(String task) {
        tasks.add(task);
    }

    public synchronized void removeTask(int index) {
        tasks.remove(index);
    }

    public synchronized void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManagerVector manager = new TaskManagerVector();

        for (int i = 0; i < 5; i++) {
            final int threadIndex = i;
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    manager.addTask("Task from Thread " + threadIndex);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        manager.displayTasks();
    }
}
