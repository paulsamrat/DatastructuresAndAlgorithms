package com.practise.multithreading.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ProducerBQ implements Runnable{
	private  BlockingQueue<Integer> bq ;
	
	public ProducerBQ(BlockingQueue<Integer> blockingQ){
		this.bq = blockingQ;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			for ( int i=0 ; i <10 ;i++){
				System.out.println(Thread.currentThread().getName() + " Produced " + i);
				bq.put(i);
                Thread.sleep(2000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
}
class ConsumerBQ implements Runnable{
	private  BlockingQueue<Integer> bq ;
	
	public ConsumerBQ(BlockingQueue<Integer> blockingQ){
		this.bq = blockingQ;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			for ( int i1=0 ; i1 <10 ;i1++){
				Integer i = bq.take();
				System.out.println(Thread.currentThread().getName() + " consumed " + i);

			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
public class ProducerConsumerBlockingQueueImpl {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(10);//capacity 10

		Thread producer = new Thread(new ProducerBQ(bq),"Producer");
		Thread consumer = new Thread(new ConsumerBQ(bq),"Consumer");
		producer.start();
		consumer.start();
	}

}
