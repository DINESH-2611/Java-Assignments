package Collections;


import java.util.PriorityQueue;

public class TaskSchedulerPriorityQueue {
    static class Task implements Comparable<Task> {
        private String name;
        private int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(other.getPriority(), this.getPriority());
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task("Task A", 3));
        taskQueue.add(new Task("Task B", 1));
        taskQueue.add(new Task("Task C", 2));
        taskQueue.add(new Task("Task D", 5));
        taskQueue.add(new Task("Task E", 4));

        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Executing task: " + task.getName() + " (Priority: " + task.getPriority() + ")");
        }
    }
}
