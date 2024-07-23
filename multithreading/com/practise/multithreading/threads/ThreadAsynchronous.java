package com.practise.multithreading.threads;

import java.util.List;

public class ThreadAsynchronous extends Thread{

	/**
	 * @param args
	 */
	private String name;
	private long mTimeInterval;
	
	
	
	public ThreadAsynchronous (String _name, int i) {
        name = _name;
        mTimeInterval = i;
    }
	@Override
	public void run()
	{
		try
		{
			while( !isInterrupted())
			{
				System.out.println("NAME " + name);
				sleep(mTimeInterval);
			}
		}
		catch (InterruptedException INTEX) {
			INTEX.printStackTrace();
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new ThreadAsynchronous ( "thread 1" , 1000 );
		ThreadAsynchronous thread2  = new ThreadAsynchronous ( "thread 2" , 2000 );
		ThreadAsynchronous thread3  = new ThreadAsynchronous ( "thread 3" , 1500 );
        thread1.start ();
        thread2.start ();
        thread3.start ();
        thread1.interrupt();
        thread2.interrupt ();
        thread3.interrupt ();
        List a =null;
        

	}

}
