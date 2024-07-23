package com.algo.stacks.queues;

public class ImplementStackUsingLinkedList {
	private class LinkedListNode{
		private int data;
		private LinkedListNode next;
		
		private LinkedListNode(final int data) {
			this.data = data;
		}
	}
	private LinkedListNode head;
	
	private int pop() {
			if (head  == null)
				return -1;
			int data = head.data;
			head = head.next;
			return data;
	}
	
	private void push(final int data) {
		LinkedListNode node = new LinkedListNode(data);
		if ( null == head) {
			head = node;
		}else {
			node.next = head;
			head = node;
		}
	}
	
	private int peek() {
		if (head == null) return -1;
		else return head.data;
	}
	private void traverse() {
		//traverse
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackUsingLinkedList obj = new ImplementStackUsingLinkedList();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(5);
		System.out.println(obj.pop());
		
	}

}
