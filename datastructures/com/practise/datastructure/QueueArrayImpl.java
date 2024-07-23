package com.practise.datastructure;


class Queue {
		int q[];
		int front,rear, temp , max ;
		
		public Queue(int n) {
			// TODO Auto-generated constructor stub
			max = n;
			q = new int[max];
			front =0;
			rear =-1;
			
		}
		
		public void push(int element){
			if (rear >= max-1) System.out.println("Queue is Overflowed :");
			else {
				rear++;
				q[rear] = element ;
			}
		}
		
		public void pop(){
			if (front > rear ) System.out.println("Queue is underflowed");
			else {
				System.out.println(""+q[front]+"is deleted\n"); 
				front ++;
			}
		}
		
		public void display(){
			System.out.println("\n\t\tElements are:"); 
			for(int i=front;i<=rear;i++) { 
			System.out.println(""+"\t\t"+q[i]); 
			}
		}
		
		
}
public class QueueArrayImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(5);
		queue.push(5);
		queue.push(1);
		queue.display();

	}

}
