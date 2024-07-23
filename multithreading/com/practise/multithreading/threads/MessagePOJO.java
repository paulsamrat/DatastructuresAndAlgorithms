package com.practise.multithreading.threads;

public class MessagePOJO {
	
	private String msg;
    
    public MessagePOJO(String str){
        this.msg=str;
    }
 
    public String getMsg() {
        synchronized (this) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return msg;
		}
    	
    }
 
    public void setMsg(String str) {
        this.msg=str;
    }
   
    
}
