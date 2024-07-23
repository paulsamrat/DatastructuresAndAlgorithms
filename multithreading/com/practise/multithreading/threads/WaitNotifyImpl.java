package com.practise.multithreading.threads;

public class WaitNotifyImpl {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadNonRunnable object = new ThreadNonRunnable();
		object.start();
		synchronized (object) {
			    String currentThreadName = Thread.currentThread().getName();
			    System.out.println("Current Thread Name " + currentThreadName);
				System.out.println(Thread.holdsLock(object) ? "true" : "false");
				System.out.println("Waiting for Thread Non Runnable to complete " );
				object.wait();
				System.out.println(Thread.holdsLock(object) ? "true" : "false");


		}
		System.out.println("Total is: " + object.total); 
		
		
		MessagePOJO msg = new MessagePOJO("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();
         
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
         
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
	}

}
