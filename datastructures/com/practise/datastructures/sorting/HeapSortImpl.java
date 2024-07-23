package com.practise.datastructures.sorting;

public class HeapSortImpl {
	

	public static void main(String args[]){
		//heapify the array
		int array[] = new int[]{12,11,13,5,6,7,25};
		// as the array index starts from "0" we will consider doing heapify from middle of the array -1
		//doing from middle as parent is at n/2 position and ignoring the leaf nodes.
		for (int i = array.length/2 - 1 ; i>=0; i-- ){
			buildMaxHeap(array, array.length, i);
		}
		traverse(array);
		//we will perform heap sort on the max heap formed
		// we will take out the root and place it at the last index of the array ... as the root is the highest in case of max heap
		for (int i = array.length-1;i>=0;i--){
			//swap root with last index
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			// once the array has been altered ..it might happen that the resulting array of size (n-1) does n't
			// lean with the max heap property so doing max heap operation on the altered array  from 0 --> n-2
			// as 0th index as been altered with last index .. so passing 0th index in the below call is the apt one.
			
			buildMaxHeap(array, i,0);
		}
		traverse(array);
	}

	public static void buildMaxHeap(int []array, int arraySize, int rootIndex){
			int largest = rootIndex;
			int leftChildIndex = 2*rootIndex + 1;
			int rightChildIndex = 2*rootIndex + 2 ;
			
			//comparison
			if ( leftChildIndex < arraySize && array[leftChildIndex] > array[largest])
				   largest = leftChildIndex;
			if ( rightChildIndex < arraySize && array[rightChildIndex] > array[largest])
				   largest = rightChildIndex;
			
			if ( largest != rootIndex){
				int temp = array[rootIndex];
				array[rootIndex] = array[largest];
				array[largest] = temp;
				//recursively check whether it breaks lower sub trees or not
				buildMaxHeap(array, arraySize,largest);
			}
			
	}
	
	public static void buildMinHeap(int[] array, int arraySize, int rootIndex){
		int smallest = rootIndex;
		int leftChildIndex = 2 * rootIndex + 1;
		int rightChildIndex = 2 * rootIndex + 2;
		
		//comparison . the root will always be smaller than the child nodes
		if ( leftChildIndex < arraySize &&  array[smallest] > array[leftChildIndex])
			  smallest  = leftChildIndex;
		if ( rightChildIndex < arraySize && array[smallest] > array[rightChildIndex])
			  smallest = rightChildIndex;
		if ( smallest != rootIndex){
			int temp = array[rootIndex];
			array[rootIndex] = array[smallest];
			array[smallest] = temp;
			
			//recursively check the  below sub trees
			buildMinHeap(array, arraySize,smallest);
		}
	}
	
	public static void traverse(int array[]){
		System.out.println("traversing array \n");
		for (int value : array){
			System.out.print("-->" +  value);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
