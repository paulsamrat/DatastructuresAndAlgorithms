package com.practise.multithreading.threads;

import java.lang.Thread.UncaughtExceptionHandler;

public class Notifier implements Runnable,UncaughtExceptionHandler {
	 
    private MessagePOJO msg;
     
    public Notifier(MessagePOJO msg) {
        this.msg = msg;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
    }

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("uncaughtException");
		e.printStackTrace();
		
	}
 
}
