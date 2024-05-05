package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProducerConsumer {
    private static final int BUFFER_SIZE=5 ;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter no of items to be added by the Producer");
//        int n=scanner.nextInt();
//        BUFFER_SIZE=n;
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    private static void produce(int item) {
        synchronized (buffer) {
            while (buffer.size() == BUFFER_SIZE) {
                try {
                    System.out.println("Buffer full, waiting for consumer to consume...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.add(item);
            System.out.println("Produced: " + item);
            buffer.notify();
        }
    }

    private static void consume() {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                try {
                    System.out.println("Buffer empty, waiting for producer to produce...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int item = buffer.poll();
            System.out.println("Consumed: " + item);
            buffer.notify();
        }
    }
}


