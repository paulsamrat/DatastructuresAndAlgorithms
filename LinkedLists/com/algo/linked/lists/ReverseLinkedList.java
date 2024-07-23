package com.algo.linked.lists;

public class ReverseLinkedList {
	private class LinkedListNode {
		private int data;
		private LinkedListNode next;
		private LinkedListNode(final int data) {
			this.data = data;
		}
	}
	private LinkedListNode head;
	private LinkedListNode curr;
	//git test
	private void buildSingleLinkedList(final int[] arr) {
		for (int data : arr) {
			final LinkedListNode node = new LinkedListNode(data);
			if (null  == head)
			{
				head = node;
				curr = head;
			}
			else
			{
				curr.next = node;
				curr = curr.next;
			}
				
		}
	}
	private void traverse(final LinkedListNode head) {
		LinkedListNode curr = head;
		while(curr != null) {
			System.out.print("::" + curr.data);
			curr = curr.next;
		}
	}
	private LinkedListNode reverse;
	private LinkedListNode temp;
	private void reverse(final LinkedListNode head) {
		LinkedListNode curr = head;
		while( curr !=  null) {
			if (null == reverse) {
				reverse = curr;
				reverse.next = temp;
			}else {
				reverse = curr;
				reverse.next = temp;
				
			}
			temp = reverse;
			curr = curr.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList obj = new ReverseLinkedList();
		obj.buildSingleLinkedList(new int[] {1,2,3,4,5});
		obj.traverse(obj.head);
		obj.reverse(obj.head);
		obj.traverse(obj.reverse);
	}

}
