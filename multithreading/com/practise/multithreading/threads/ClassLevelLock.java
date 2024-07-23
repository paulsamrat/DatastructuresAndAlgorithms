package com.practise.multithreading.threads;

public class ClassLevelLock implements Runnable{
	
	private int counter = 0 ;
	public static void main(String args[])
	{	
		ClassLevelLock object1 = new ClassLevelLock();
		new Thread(object1 , "thread1").start();
		//new Thread(object1 , "thread2").start();
		
		//ClassLevelLock object2 = new ClassLevelLock();
		new Thread(object1 , "thread3").start();
		//new ClassLevelLock().start();
		/*
		 *Calling static and noon static method  
		 */
		/*
		Case 1: If t1 has DemoClass.foo1() and t2 has DemoClass.foo1() 
		then the string �class level� is printed twice in 10 seconds because foo1() 
		is locked at the class level that means the object DemoClass.class is locked. In other words one thread has 
		to wait for another thread to return from the function foo1().

		Case 2: If t1 has dc1.foo1() and t2 has dc2.foo1() then the result and explanation of case 1 holds here as well.

		Case 3: If t1 has dc1.foo2() and t2 has dc1.foo2() then the string �instance level� is printed twice in 10 seconds 
		because foo2() is locked at the instance level that means the instance dc1 is locked. 

		Case 4: if t1 has dc1.foo2() and t2 has dc2.foo2() then the string �instance level� is printed twice in 5 seconds because foo2() 
		is being called on 2 different instances of DemoClass which are dc1 and dc2 so they don�t interfere with each other. 
		*/
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		/*
		 * having class level lock will generate the o/p in the same sequence of thread coming to this point 
		 * they will not interleave .
		 * However having lock on the current object will interleave there executions and also its not predictable.
		 */
		synchronized (this) { 
			System.out.println("synchronized block " + Thread.currentThread().getName());
            System.out.println("synchronized block " + Thread.currentThread().getName() + " end");
            
		}
	}
	
	public void start(){
		System.out.println(Thread.currentThread().getName() + " in overridden start method");run();
	}
	
	public static synchronized void foo1(){
		  try {
		   Thread.sleep(5000); // 5 seconds
		  } catch (InterruptedException e) {
		   e.printStackTrace();
		  } 
		  System.out.println("class level");
		 }
    public synchronized void foo2(){
		  try {
		   Thread.sleep(5000); // 5 seconds
		  } catch (InterruptedException e) {
		   e.printStackTrace();
		  }
		  System.out.println("instance level");
		 }
 
}
