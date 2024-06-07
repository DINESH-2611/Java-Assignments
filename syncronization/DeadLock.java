package syncronization;

public class DeadLock {
    public static void main(String[] args) {
        final ResourceA resourceA = new ResourceA();
        final ResourceB resourceB = new ResourceB();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                resourceA.methodA(resourceB);
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                resourceB.methodB(resourceA);
            }
        };

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
class ResourceA {
    public synchronized void methodA(ResourceB resourceB) {
        System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceA");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " attempting to acquire lock on ResourceB");
        synchronized (resourceB) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceB");
//            System.out.println(123);
        }
    }
}
class ResourceB {
    public synchronized void methodB(ResourceA resourceA) {
        System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceB");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " attempting to acquire lock on ResourceA");
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceA");
//            System.out.println(123);
        }
    }
}

