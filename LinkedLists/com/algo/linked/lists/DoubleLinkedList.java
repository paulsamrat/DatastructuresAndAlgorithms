package com.algo.linked.lists;

public class DoubleLinkedList {
	
	private class DLLNode{
		private int val;
		private DLLNode prev;
		private DLLNode next;
		
		private DLLNode(final int val) {
			this.val = val;
		}
	}
	
	private DLLNode head;
	private DLLNode tail;
	
	//creating a double linked list 
	private void create(final int[] values) {
		head = new DLLNode(values[0]);
		DLLNode currNode = head;
		for (int i =1 ; i < values.length ; i++) {
			final DLLNode temp = new DLLNode(values[i]);
			currNode.next = temp;
			temp.prev = currNode;
			currNode=temp;
		}
		tail = currNode;
	}
	
	//traverse forward
	private void traverse() {
		DLLNode currNode = head; 
		while (currNode!= null) {
			System.out.println(currNode.val);
			currNode = currNode.next;
		}
	}
	// traverse backward
	private void traverseBackward() {
		DLLNode currNode = tail;
		while(currNode!=null) {
			System.out.println(currNode.val);
			currNode = currNode.prev;
		}
	}
	
	// insertion at the beginning
	
	private void insertAtBeginning(final int data) {
		final DLLNode temp = new DLLNode(data);
		temp.next = head;
		head.prev = temp;
		head = temp;
	}
	
	//insertion at the end
	
	private void insertAtTheEnd(final int data) {
		final DLLNode temp = new DLLNode(data);
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
		
	}
	
	//insertion at a specific point
	
	private void insertAtASpecificPoint(final int dataToSearch , final int dataToInsert) {
		DLLNode currNode = head;
		while(currNode != null) {
			if (currNode.val == dataToSearch) {
				final DLLNode temp = new DLLNode(dataToInsert);
				final DLLNode temp1 = currNode.next;
				currNode.next = temp;
				temp.prev = currNode;
				temp.next = temp1;
				temp1.prev = temp;
			}
			
			currNode = currNode.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	
}
