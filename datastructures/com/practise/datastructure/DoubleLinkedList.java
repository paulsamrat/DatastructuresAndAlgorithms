package com.practise.datastructure;

public class DoubleLinkedList {

	private int data;
	private DoubleLinkedList next;
	private DoubleLinkedList prev;

	public DoubleLinkedList()
	{
		data = 0;
		next = null;
		prev = null;
	}

	public DoubleLinkedList(int value)
	{
		data = value;
		next = null;
		prev = null;
	}

	public DoubleLinkedList InsertNext(int value)
	{
		DoubleLinkedList node = new DoubleLinkedList(value);
		if(this.next == null)
		{	
			// Easy to handle
			node.prev = this;
			node.next = null; // already set in constructor
			this.next = node;
		}
		else
		{
			// Insert in the middle
			DoubleLinkedList temp = this.next;
			node.prev = this;
			node.next = temp;
			this.next = node;
			temp.prev = node;
			// temp.next does not have to be changed
		}
		return node;
	}

	public DoubleLinkedList InsertPrev(int value)
	{
		DoubleLinkedList node = new DoubleLinkedList(value);
		if(this.prev == null)
		{
			node.prev = null; // already set on constructor
			node.next = this;
			this.prev = node;
		}
		else
		{

			// Insert in the middle
			DoubleLinkedList temp = this.prev;
			node.prev = temp;
			node.next = this;
			this.prev = node;
			temp.next = node;
			// temp.prev does not have to be changed
		}
		return node;
	}

	public void TraverseFront()
	{
		TraverseFront(this);
	}

	public void TraverseFront(DoubleLinkedList node)
	{
		if(node == null)
			node = this;
		System.out.println("\n\nTraversing in Forward Direction\n\n");

		while(node != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
	}

	public void TraverseBack()
	{
		TraverseBack(this);
	}

	public void TraverseBack(DoubleLinkedList node)
	{
		if(node == null)
			node = this;
		System.out.println("\n\nTraversing in Backward Direction\n\n");
		while(node != null)
		{
			System.out.println(node.data);
			node = node.prev;
		}
	}

	public static void main(String[] args)
	{

		DoubleLinkedList node1 = new DoubleLinkedList(1);
		DoubleLinkedList node3 = node1.InsertNext(3);
		DoubleLinkedList node2 = node3.InsertPrev(2);
		DoubleLinkedList node5 = node3.InsertNext(5);
		DoubleLinkedList node4 = node5.InsertPrev(4);

		node1.TraverseFront();
		node5.TraverseBack();
	}

}
