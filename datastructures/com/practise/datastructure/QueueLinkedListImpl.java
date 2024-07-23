package com.practise.datastructure;

import java.util.NoSuchElementException;


/** Queue node data structure */
class Node<T> {
	Node<T> next;
	T element;

	public Node( T element, Node<T> next ) {
		this.element = element;
		this.next = next;
	}
}

public class QueueLinkedListImpl<T> {

	/**
	 * @param args
	 */
	
	/** Head of the queue */
	private Node<T> front = null;
	/** Tail of the queue */
	private Node<T> rear = null;
	
	/** Enques a new node at the tail (end) of the queue */
	public void enqueue( T t ) {
		Node<T> newNode = new Node<T>( t, null );
		if( isEmpty( ) ) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	/** Deques the node from the head (top) of the queue */
	public T dequeue( ) throws NoSuchElementException {
		if( isEmpty( ) ) throw new NoSuchElementException( );
		
		T element = front.element;
		front = front.next;
		return element;
	}
	
	
	
	/** Checks if the queue is empty */
	public boolean isEmpty( ) {
		return front == null;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueLinkedListImpl<Integer> queue = new QueueLinkedListImpl<Integer>( );
		queue.enqueue( 1 );
		queue.enqueue( 2 );
		queue.enqueue( 3 );
 
		while( ! queue.isEmpty( ) ) {
			System.out.println( queue.dequeue( ) );
		}

	}

}
