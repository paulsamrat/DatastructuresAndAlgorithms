package com.practise.multithreading.threads;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable{
	private final CountDownLatch cdl;
	private final String name;
	
	public Service(String name,CountDownLatch cdl){
		this.cdl = cdl;
		this.name = name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.println(Thread.currentThread().getName() + "starting operation");
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "started operation decrementing the countdown");
		cdl.countDown();
		System.out.println(Thread.currentThread().getName() + " doing some useful work");
	}
	
}

public class CountDownLatchImpl {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cdl = new CountDownLatch(3) ; // creating a countdown of 3 units
		//creating services
		Thread cacheService = new Thread(new Service("CacheService", cdl));
		Thread alertService = new Thread(new Service("AlertService", cdl));
		Thread validationService = new Thread(new Service("ValidationService", cdl));
		
		//starting services.
		cacheService.start();
		alertService.start();
		validationService.start();
		
		try {
			cdl.await();
            System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
