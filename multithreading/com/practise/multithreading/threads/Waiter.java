package com.practise.multithreading.threads;

public class Waiter implements Runnable{

	private MessagePOJO msg;
    
    public Waiter(MessagePOJO m){
        this.msg=m;
    }
 
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		synchronized (msg) {
				
			System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
            try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
	            //process the message now
	         System.out.println(name+" processed: "+msg.getMsg());
		}
	}

}
