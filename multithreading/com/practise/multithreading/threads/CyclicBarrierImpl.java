package com.practise.multithreading.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Party implements Runnable{
	
	private final CyclicBarrier cb;
	
	public Party(CyclicBarrier cb){
		this.cb = cb;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		try{
            System.out.println(Thread.currentThread().getName() + " is calling await()");
			Thread.sleep(2000);
			cb.await();
            System.out.println(Thread.currentThread().getName() + " has started running again");

		}catch(InterruptedException ie){
			ie.printStackTrace();
		}catch(BrokenBarrierException e){
			e.printStackTrace();
		}
			
		}
}
public class CyclicBarrierImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cb = new CyclicBarrier(3); // three parties 
		Thread p1 = new Thread(new Party(cb),"party-1");
		Thread p2 = new Thread(new Party(cb),"party-2");
		Thread p3 = new Thread(new Party(cb),"party-3");
		
		//staring the parties
		p1.start();
		p2.start();
		p3.start();
        System.out.println(Thread.currentThread().getName() + " has finished");

	}

}
