package com.practise.multithreading.threads;

class SharedResource {
    // Static method with class-level lock
    public static void printNumbers() {
        synchronized (SharedResource.class) { // Class-level lock
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                try {
                    Thread.sleep(500); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// Thread class that calls printNumbers()
class MyThread extends Thread {
    public void run() {
        SharedResource.printNumbers();
    }
}

public class ClassLevelLock01 {
    public static void main(String[] args) {
        // Creating two threads that will access the static method
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}

