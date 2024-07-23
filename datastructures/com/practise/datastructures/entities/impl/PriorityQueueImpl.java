package com.practise.datastructures.entities.impl;

import java.util.Comparator;
import java.util.PriorityQueue;
//http://algorithms.tutorialhorizon.com/priority-queue-implementation/

class  IntegerComparator implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
	
}
public class PriorityQueueImpl {
	PriorityQueue<Integer> pq;
	//default the Pri­or­ity Queue works as min-Heap.
	public PriorityQueueImpl() {
		pq = new PriorityQueue<Integer>();
	}
	//MAX HEAP PQ
	public PriorityQueueImpl(String maxHeap) {
		pq = new PriorityQueue<Integer>(10, new IntegerComparator());
	}
	public void insert(int[] x) {
		for (int i = 0; i < x.length; i++) {
			pq.offer(x[i]);
		}
	}

	public int peek() {
		return pq.peek();
	}

	public int extractMin() {
		return pq.poll();
	}
	
	public int extractMax() {
		return pq.poll();
	}

	public int getSize() {
		return pq.size();
	}

	public void print() {
		System.out.println(pq);
	}
	public static void main(String[] args) {
		int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
		PriorityQueueImpl i = new PriorityQueueImpl();
		i.insert(arrA);
		i.print();
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Priority Queue Size: " + i.getSize());
		
		int[] arrA1 = { 1, 6, 2, 9, 4, 3, 8 };
		PriorityQueueImpl i1 = new PriorityQueueImpl("maxheap");
		i1.insert(arrA1);
		i1.print();
		System.out.println("Max Element in the Priority Queue: "
				+ i1.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i1.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i1.extractMax());
		System.out.println("Priority Queue Size: " + i1.getSize());
	}

}
