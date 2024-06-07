package syncronization;

import java.util.Random;

public class Buffer {
    private int data;
    private boolean empty = true;

    public synchronized void put(int value) throws InterruptedException {
        while (!empty) {
            wait();
        }
        data = value;
        empty = false;
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (empty) {
            wait();
        }
        int value = data;
        empty = true;
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int value = random.nextInt(100);
                buffer.put(value);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int value = buffer.get();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class BufferMain {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
        Thread producer2 = new Thread(new Producer(buffer), "Producer-2");
        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(buffer), "Consumer-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
