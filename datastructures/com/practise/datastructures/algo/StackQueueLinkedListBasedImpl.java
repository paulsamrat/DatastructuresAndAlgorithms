package com.practise.datastructures.algo;

class SingleLinkedListNode{
	public int data;
	public SingleLinkedListNode next;
	
	public SingleLinkedListNode(int data){
		this.data = data;
	}
}
public class StackQueueLinkedListBasedImpl {
	
	private static SingleLinkedListNode rootNode;

	//always add to first in case of stack
	public void addFirst(SingleLinkedListNode nodeToInsert){
		nodeToInsert.next  = rootNode;
		rootNode = nodeToInsert;
	}
	
	public void removeFirst(){
		System.out.println(" popping  out elements from stack");
		while( null != rootNode ){
			System.out.println(" popping : popped node : " + rootNode.data);
			rootNode = rootNode.next;
		}
	}
	
	//stack push operation
	public void push(int[] values){
		for (int value : values){
			SingleLinkedListNode node = new SingleLinkedListNode(value);
			if ( null == rootNode)
				 rootNode = node;
			else{
				addFirst(node);
			}
		}
	}
	
	//peek
	public void peek(){
		if ( null != rootNode)
			System.out.println( " peek element " +  rootNode.data);
		else
			System.out.println(" root element is empty");
	}
	
	//enqueue operation
	public void enqueue(int[] values){
		for (int value : values){
			SingleLinkedListNode node = new SingleLinkedListNode(value);
			if ( null == rootNode)
					rootNode=  node;
			else{
				SingleLinkedListNode currNode = rootNode;
				while ( null != currNode.next){
					currNode = currNode.next;
				}
				currNode.next = node;
			}
			
		}
	}
	
	//dequeue operation
	public void dequeue(){
		while ( null != rootNode){
			//dequeue  first node
			System.out.println(" dequeue : popped node " +  rootNode.data);
			rootNode = rootNode.next;
		}
	}
	//stack pop operation
	public void pop(){
		removeFirst();
	}
	
	//traverse
	public void traverse(){
		System.out.println(" traversing single linked list");
		SingleLinkedListNode currNode = rootNode;
		while ( null != currNode){
			System.out.println(" --->" + currNode.data);
			currNode = currNode.next;
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackQueueLinkedListBasedImpl obj = new StackQueueLinkedListBasedImpl();
		System.out.println( " creating a stack with array of elements { 5,4,3,2,1}" );
		obj.push(new int[]{5,4,3,2,1});
		System.out.println( " traversing the stack ");
		obj.traverse();
		obj.peek();
		obj.pop();
		obj.peek();
		System.out.println(" creating a queue with  array of elements { 5,4,3,2,1}");
		obj.enqueue(new int[]{5,4,3,2,1});
		obj.traverse();
		obj.peek();
		obj.dequeue();
		obj.peek();
	}

}
