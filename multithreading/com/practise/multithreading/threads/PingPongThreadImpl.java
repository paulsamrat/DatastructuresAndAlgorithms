package com.practise.multithreading.threads;

class Ping implements Runnable{
	Object lock;
	
	public Ping(Object lock){
		this.lock = lock;
	}
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			try {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
					lock.notifyAll();
					lock.wait();
				}

			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}
class Pong implements Runnable{
	Object lock;
	
	public Pong(Object lock){
		this.lock = lock;
	}
	public void run() {
		while (true) {
			try {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
					lock.notifyAll();
					lock.wait();
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
class OddPrinter implements Runnable{
	Object lock;
	public OddPrinter(Object lock){
		this.lock = lock;
	}
	public void run() {
		// TODO Auto-generated method stub
		int i = 2;
		while (i < Integer.MAX_VALUE){
			synchronized (lock) {
				try { 
					System.out.println(Thread.currentThread().getName() + " " + i);
					Thread.sleep(2000);
					i+=2;
					lock.notifyAll();
					lock.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}			
		}
	}
	
}
class EvenPrinter implements Runnable{
	Object lock;
	public EvenPrinter(Object lock){
		this.lock  = lock;
	}
	public void run() {
		// TODO Auto-generated method stub
		int i = 1 ;
		while (i < Integer.MAX_VALUE){
			synchronized (lock) {
				try { 
					System.out.println(Thread.currentThread().getName() + " " +  i);
					Thread.sleep(2000);
					i+=2;
					lock.notifyAll();
					lock.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
}
public class PingPongThreadImpl {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object lock = new Object();
		//creating ping and pong threads
		Thread ping = new Thread(new Ping(lock),"Ping");
		Thread pong = new Thread(new Pong(lock),"Pong");
		//ping.start();
		//pong.start();
		Thread evenPrinter = new Thread(new EvenPrinter(lock),"EvenPrinter");
		Thread oddPrinter = new Thread(new OddPrinter(lock),"OddPrinter");
		evenPrinter.start();
		oddPrinter.start();


	}

}
