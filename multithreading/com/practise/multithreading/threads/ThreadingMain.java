package com.practise.multithreading.threads;
import java.util.concurrent.locks.ReentrantLock;

class ClassLvlLock{
	public static void printHello() {
		//so now any different threads coming to execute this static sync method
		//need to execute sequentially
		synchronized (ClassLvlLock.class) {
			for (int i = 0 ; i < 10 ; i++) {
				System.out.println(Thread.currentThread().getName() + " ::" + "hello");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ObjLvlLock{
	public synchronized void printHello() {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(Thread.currentThread().getName() + " ::" + "hello");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//verbose code prior lambda

//class ClassLevelThread implements Runnable{
//	private ObjLvlLock obj;
//	
//	public ClassLevelThread(final ObjLvlLock objLvlLock) {
//		this.obj = objLvlLock;
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		obj.printHello();
//	}
//	
//}

/**
A ReentrantLock is a more advanced, flexible alternative to Java’s built-in synchronized keyword. 
It belongs to the java.util.concurrent.locks package and allows a thread to reacquire the same lock it already holds, 
preventing self-deadlocks.


A reentrant lock allows a thread to lock multiple times without blocking itself. Each lock() call must be matched with an unlock()

**/


//this is basically alternative to synchronized keyword
class ReentrantClass {
    private final ReentrantLock lock = new ReentrantLock(); // Reentrant Lock

    public void printNumbers() {
        lock.lock(); // First lock
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                Thread.sleep(500);
            }
            nestedLock(); // Calls another synchronized method
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Unlock once after method execution
        }
    }

    public void nestedLock() {
        lock.lock(); // Reacquiring the same lock
        try {
            System.out.println(Thread.currentThread().getName() + " - Nested Method");
        } finally {
            lock.unlock(); // Unlock the nested call separately
        }
    }
}


public class ThreadingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating two threads that will access the static method
        Thread t1 = new Thread(() -> ClassLvlLock.printHello(), "Class Level Thread-1");
        Thread t2 = new Thread(() -> ClassLvlLock.printHello(), "Class Level Thread-2");
        //class level locks sequential execution
        //t1.start();
        //t2.start();
        
        //lets test class level locks
        //implementing through lambda
        final ObjLvlLock obj = new ObjLvlLock();
        //sequential execution as locked on single object
        //to make parallel execution have multiple objects created and then execute 
        Thread t11 = new Thread(()->obj.printHello(),"obj level thread - 1");
        Thread t12 = new Thread(()->obj.printHello(),"obj level thread - 2");
        //t11.start();
        //t12.start();
        
        //reentrant nature testing
        final ReentrantClass objShared01 = new ReentrantClass();
        final ReentrantClass objShared02 = new ReentrantClass();
        Thread t13 = new Thread(()->objShared01.printNumbers());
        Thread t14 = new Thread(()->objShared02.printNumbers());
        t13.start();
        t14.start();
        
        
	}

}
/**

Before Java 8, you had to define a Runnable using an anonymous class:

Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        SharedResource.printNumbers();
    }
}, "Thread-1");

Thread t2 = new Thread(new Runnable() {
    @Override
    public void run() {
        SharedResource.printNumbers();
    }
}, "Thread-2");
This is longer and more verbose.

✅ Using Lambda Expression (Java 8+)
With Java 8, the lambda expression simplifies the Runnable implementation:

Thread t1 = new Thread(() -> SharedResource.printNumbers(), "Thread-1");
Thread t2 = new Thread(() -> SharedResource.printNumbers(), "Thread-2");
Here, ()-> SharedResource.printNumbers() replaces the Runnable implementation.
**/
