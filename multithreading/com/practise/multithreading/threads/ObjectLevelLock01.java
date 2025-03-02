package com.practise.multithreading.threads;

class SharedResource01 {
    public void printNumbers() {
        synchronized (this) { // Object-level lock
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                try {
                    Thread.sleep(500); // Simulating processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread01 extends Thread {
    private SharedResource01 resource;

    public MyThread01(SharedResource01 resource) {
        this.resource = resource;
    }

    public void run() {
        resource.printNumbers();
    }
}

public class ObjectLevelLock01 {
    public static void main(String[] args) {
        SharedResource01 obj1 = new SharedResource01();
        SharedResource01 obj2 = new SharedResource01();

        Thread t1 = new MyThread01(obj1); // Lock will be on obj1
        Thread t2 = new MyThread01(obj2); // Lock will be on obj2

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}

