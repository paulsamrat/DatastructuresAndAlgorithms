package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AmazonHeapQuestions {
	
	//https://www.youtube.com/watch?v=6bvnZzwiKzs
	//Merge K - sorted arrays  
	//1. Diff. size Arrays . {1,2,3}  , {7,8,9} , {4,5,6}
	// combine all - { 1,2,3,7,8,9,4,5,6} and then apply merge sort of any sorting algo
	// time complexity - NLOG(N) - here K*NLog(K*N)
	//2.
	// Also  we can compare one element from each array and like wise addit to the final list 
	// comparing 1 element with K such element . 1st pass - k comparisons 
	// there are N*K elements considering all K arrays
	// K* (N*K)
	
	// complexity more than step 1 
	
	// we can take the adv of sorted arrays and use a min heap of K size 
	
	// design container to be put in priority queue
	
	private class QueueEntry implements Comparable<QueueEntry>
	{
		private int arrayNumber;
		private int arrayElementIdx;
		private int arrayElementVal;
		
		private QueueEntry(final int arrayNumber , final int arrayElementIdx , final int arrayElementVal )
		{
			this.arrayNumber = arrayNumber;
			this.arrayElementIdx = arrayElementIdx;
			this.arrayElementVal = arrayElementVal;
		}

		/**
		 * @return the arrayNumber
		 */
		public int getArrayNumber() {
			return arrayNumber;
		}

		/**
		 * @return the arrayElementIdx
		 */
		public int getArrayElementIdx() {
			return arrayElementIdx;
		}

		/**
		 * @return the arrayElementVal
		 */
		public int getArrayElementVal() {
			return arrayElementVal;
		}

		public int compareTo(QueueEntry entry) {
			// TODO Auto-generated method stub
			return this.arrayElementVal > entry.arrayElementVal ? 1
					: this.arrayElementVal < entry.arrayElementVal ? -1 : 0;
		}
		
		
	}
	
	
	private void mergeKSortedArrays(int[][] array)
	{
		Queue<QueueEntry> pq = new PriorityQueue<AmazonHeapQuestions.QueueEntry>(array.length);
		// add first element from all arrays
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0 ; i < array.length ; i++)
		{	
			if (array[i].length > 0 )
				pq.offer(new QueueEntry(i,0,array[i][0]));
		}
		
		while (!pq.isEmpty())
		{
			QueueEntry entry = pq.poll();
			result.add(entry.getArrayElementVal());
			int newArrayIndex = entry.getArrayElementIdx() + 1 ;
			if ( newArrayIndex < array[entry.getArrayNumber()].length)
			{
				pq.offer(new QueueEntry(entry.getArrayNumber(),newArrayIndex,array[entry.getArrayNumber()][newArrayIndex]));
			}
		}
		System.out.println( " merge k sorted arrays k = " + array.length + " merged array " + result);
		
	}
	
//	Arthur and Alena are playing a game with an array containing some integers. Arthur can take any integer and remove it from the array and he has to add half of that number (rounded up) back to the array.
//
//	 
//	Alena allots Arthur a fixed number of moves and challenges him to minimize the sum of the final array.
//
//	 
//	As an example of how moves work, start with the array nums = [10, 20, 7] and perform k = 4 moves. Pick any element to perform a move on, for example the 7. Perform the division: 7/2 = 3.5, and round up to 4. Replace the 7 with the new value 4. At this point, the array is nums = [10, 20, 4].  All 4 moves are performed as follows:
//
//	 
//
//	Pick    Pick/2    Rounded        Result
//
//	 Initial array                            [10, 20, 7]
//
//	7           3.5             4             [ 10, 20, 4]
//
//	10        5                 5               [5, 20, 4]
//
//	20        10            10               [5, 10, 4]
//
//	10        5                5                [5, 5, 4]
//
//	 
//
//	The sum of the final array is 5 + 5 + 4 = 14, and that sum is minimal.
//
//	 
//	Function Description
//
//	Complete the function minSum in the editor below. The function must return an integer denoting the minimum sum of the array after k steps.
	
	
	public void minSum(final int[] array , int KMoves)
	{
		if ( null ==  array || array.length == 0 || KMoves <= 0) return;
		int minSum = 0;
		Queue<Integer> pq =  new PriorityQueue<Integer>(array.length,new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			} // max heap
		});
		//put all array values into priority queue
		for (int element : array)
		{
			pq.offer(element);
		}
		while (KMoves != 0 )
		{
			int peekElement = pq.poll();
			// correct
			//peekElement = peekElement%2 != 0 ? ( ( peekElement / 2 ) + 1 ) : peekElement / 2 ;
			// 
			peekElement = (int)Math.ceil((double)peekElement/(double)2);
			pq.offer(peekElement);
			--KMoves;
		}
		while (!pq.isEmpty())
		{
			minSum+=pq.poll();
		}
		System.out.println("Min Sum after performing operations = " + minSum);
	}
	//https://algorithmsandme.com/find-kth-smallest-element-in-array/
	private void find_kth_smallest_element(final int[] array , final int Kth)
	{
		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		// form a max heap with size k 
		for (int i = 0 ; i < Kth ; i++)
			pq.offer(array[i]);
		//so now the queue has the kth smallest element .i.e out of k elements the largest at root 
		for (int i =Kth ; i < array.length ; i++)
		{
			// if the incoming element is lesser than root element 
			// that means the root element can't be no longer the kth smallest , some other will be 
			// so replace the root 
			// and heapify
			if (pq.peek() > array[i]) 
			{
				pq.poll();
				pq.offer(array[i]);
			}
			
		}
		
		//once done .
		// the kth smallest is at root
		System.out.println( " --  find_kth_smallest_element -- " + pq.peek());
	}
	/*
	 * For example, given array arr=[8, 2, 4], the subarrays of size x = 2 would be [8, 2] and [2, 4]. The minimum values of the two subarrays are [2, 2]. The maximum of those two minimum values is 2. This is the value you want to determine.
		Function Description 
		
		Complete the function segment in the editor below. 
		Your function must find the minimum value for each subarray of size x in array arr and return an integer denoting the maximum of these minima.
		
		 
		
		segment has the following parameter(s):
		
		    x:  an integer, the segment length
		
		    arr[arr[0],...arr[n-1]]:  an array of integers
	 */
	private class Entry
	{
		private int index;
		private int value;
		
		private Entry(final int index, final int value)
		{
			this.index = index;
			this.value = value;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Entry))
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (index != other.index)
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		private AmazonHeapQuestions getOuterType() {
			return AmazonHeapQuestions.this;
		}
	}
	private void segment(int x, int[] arr)
	{
		Queue<Entry> smallest = new PriorityQueue<AmazonHeapQuestions.Entry>(x,new Comparator<AmazonHeapQuestions.Entry>() {

			@Override
			public int compare(Entry e1, Entry e2) {
				// TODO Auto-generated method stub
				return e1.value - e2.value;
			}
		});
		
		
		Queue<Entry> highestAmongAll = new PriorityQueue<AmazonHeapQuestions.Entry>(new Comparator<AmazonHeapQuestions.Entry>() {

			@Override
			public int compare(Entry e1, Entry e2) {
				// TODO Auto-generated method stub
				return e2.value - e1.value;
			}
		});
		
		
		//pre process
		for ( int i = 0 ; i < x ; i++)
			smallest.offer(new Entry(i,arr[i]));
		
		
		for ( int i = x ; i <  arr.length ; i++)
		{
			//take a note of the least one . and add it to the highest among all slot
			Entry entry = smallest.peek();
			highestAmongAll.offer(entry);
			smallest.remove(new Entry(i-x,arr[i-x]));
			smallest.offer(new Entry(i,arr[i]));
		}
		System.out.println( " highest element among all smaller sub segments is " + highestAmongAll.peek().value );
	}
	/*
	 * Arthur and Alena are playing a game with an array containing some integers. Arthur can take any integer and remove it from the array and he has to add half of that number (rounded up) back to the array.

 
		Alena allots Arthur a fixed number of moves and challenges him to minimize the sum of the final array.
		
		 
		As an example of how moves work, start with the array nums = [10, 20, 7] and perform k = 4 moves. Pick any element to perform a move on, for example the 7. Perform the division: 7/2 = 3.5, and round up to 4. Replace the 7 with the new value 4. At this point, the array is nums = [10, 20, 4].  All 4 moves are performed as follows:
		
		 
		
		Pick    Pick/2    Rounded        Result
		
		 Initial array                            [10, 20, 7]
		
		7           3.5             4             [ 10, 20, 4]
		
		10        5                 5               [5, 20, 4]
		
		20        10            10               [5, 10, 4]
		
		10        5                5                [5, 5, 4]
		
		 
		
		The sum of the final array is 5 + 5 + 4 = 14, and that sum is minimal.
	 */
	public static void main(String[] args)
	{
		AmazonHeapQuestions obj = new AmazonHeapQuestions();
		obj.mergeKSortedArrays(new int[][]{{1,3,5},{2,4}});
		obj.minSum(new int[]{2,3}, 1);
		obj.find_kth_smallest_element(new int[]{4, 2, 1, 7, 5, 3, 8, 10, 9},4);
		obj.segment(2, new int[]{1, 1, 1});
	}
}
