package com.practise.multithreading.threads;

public class ObjectLevelLock extends Thread{
	private static MessagePOJO obj = null;
	public static void main(String args[]){
		//creating two threads but passing the same object
		obj = new MessagePOJO("hello this is a object level synchronization test ");
		//new ObjectLevelLock().start();
		//new ObjectLevelLock().start();
		new ObjectLevelLock().start();
		new ObjectLevelLock().start();

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(obj.getMsg());
	}
	
	
}
