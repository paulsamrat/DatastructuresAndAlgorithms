package com.practise.multithreading.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerImpl {
	
	public static void main(String args[]) {
		List sharedQueue = new ArrayList();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();
    }
}

class Producer implements Runnable {

    private final List sharedQueue;
    private final int SIZE;

    public Producer(List sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
            	//wait if queue is full
                while (sharedQueue.size() == SIZE) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is full " + Thread.currentThread().getName()
                                            + " is waiting , size: " + sharedQueue.size());

                        sharedQueue.wait();
                    }
                }

                //producing element and notify consumers
                synchronized (sharedQueue) {
                    sharedQueue.add(i);
                    sharedQueue.notifyAll();
                }
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
class Consumer implements Runnable {

    private final List sharedQueue;

    public Consumer(List sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }

}
