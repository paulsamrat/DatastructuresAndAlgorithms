package com.practise.datastructures.algo;

public class DoubleLinkedListImpl {
		
	private static Node rootNode;
	
	class Node{
		private int data;
		private Node previous;
		private Node next;
		
		Node(int value){
			this.data = value;
		}
	}
	
	public void createDoubleLinkedList(int values[]){
		for (int value : values){
			//creating a node to insert
			Node nodeToInsert = new Node(value);
			if ( null == rootNode){
				rootNode = nodeToInsert;
			}else{
				Node currNode = rootNode;
				while ( null !=  currNode.next)
					currNode = currNode.next;

				currNode.next = nodeToInsert;
				nodeToInsert.previous = currNode;

			}
		}
	}
	public void reverse(Node head){
		Node currNode = head;
		Node prevPtr = null;
		while ( null != currNode){
			Node temp = currNode.next;
			currNode.next = prevPtr;
			if ( null != prevPtr) prevPtr.previous = currNode;
			prevPtr = currNode;
			currNode = temp;
		}
		prevPtr.previous = null;
		head = prevPtr;
		System.out.println("traversing dll in reverse order ");
		traverse(head);
	}
	
	public void traverse(Node rootNode){
		Node currNode = rootNode;
		System.out.println("traversing double linked list");
		while ( null != currNode){
			System.out.println(" --- > " + currNode.data);
			currNode = currNode.next;
		}
	}
	public static void main(String args[]){
		DoubleLinkedListImpl obj = new DoubleLinkedListImpl();
		obj.createDoubleLinkedList(new int[]{1,2,3,4,5});
		obj.traverse(rootNode);
		obj.reverse(rootNode);
	}
}
	
	

