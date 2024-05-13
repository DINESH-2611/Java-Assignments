package Collections;


import java.util.ArrayDeque;

public class TastPipeLineArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> taskPipeline = new ArrayDeque<>();

        taskPipeline.addLast("Task 1");
        taskPipeline.addLast("Task 2");
        taskPipeline.addLast("Task 3");

        taskPipeline.addFirst("High-Priority Task");

        while (!taskPipeline.isEmpty()) {
            String task = taskPipeline.removeFirst();
            System.out.println("Processing task: " + task);
        }
    }
}
