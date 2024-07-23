package com.practise.multithreading.threads;

public class ThreadSynchronization implements Runnable{
	
	
	   private String threadName;

	   ThreadSynchronization( String name){
	       threadName = name;
	   }
	   public void run() {
	     printCount();
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   public void printCount(){
		   synchronized(ThreadSynchronization.class){ 
			   try {
			         for(int i = 5; i > 0; i--) {
			            System.out.println("Counter   ---   "  + i );
			         }
			     } catch (Exception e) {
			         System.out.println("Thread  interrupted.");
			     }
		   }
	   }
	   
	   public static void main(String args[]) {

		  //ThreadSynchronization PD = new ThreadSynchronization();

		   ThreadSynchronization T1 = new ThreadSynchronization( "Thread - 1 ");
		   ThreadSynchronization T2 = new ThreadSynchronization( "Thread - 2 ");
           new Thread(T1).start();
           new Thread(T2).start();

	      //T1.start();
	      //T2.start();

	      // wait for threads to end ..if not then when thread 1 finishes and prints o/p by that time thread 2 enters
          //and prints counter variable.
	      try {
	    	  new Thread(T1).join();
	    	  new Thread(T2).join();
	      } catch( Exception e) {
	         System.out.println("Interrupted");
	      }
	   }
}
