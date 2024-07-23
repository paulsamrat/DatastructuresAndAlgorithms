package com.practise.datastructures.sorting;

public class BasicSortingImpl {
	
	public static void bubbleSort(int[] arr){
		System.out.println("performing bubble sort ");
		for (int i = 0 ; i < arr.length -1 ; i++) //no of pass
		{
			for (int j = 0 ; j<arr.length-1-i; j++){
				 if (arr[j] > arr[j+1]){
					 int temp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = temp;
				 }
			}
		}
		traverse(arr);
	}
	//https://www.youtube.com/watch?v=GUDLRan2DWM
	public static void selectionSort(int[] arr){
		System.out.println("performing selection sort");
		for (int i=0 ; i < arr.length - 1 ; i++ ){
			 int smallestIndex = i ;
			 for (int j = i+1 ;j < arr.length ; j++){
				  if (arr[j] < arr[smallestIndex])
					  	smallestIndex = j;
			 }
			 if (i != smallestIndex){
				 int temp = arr[i];
				 arr[i]= arr[smallestIndex];
				 arr[smallestIndex] = temp;
			 }
		}
		traverse(arr);
	}
	public static void insertionSort(int[] arr){
		System.out.println("performing insertion sort");
		for (int i=1; i < arr.length ; i++){
			int k = arr[i];
			int j = i ;
			while (j > 0 && k < arr[j-1]){
				arr[j] = arr[j-1];
				--j;
			}
			arr[j] = k;
		}
		traverse(arr);
	}
	public  static void traverse(int[] arr){
		for (int i : arr)
			System.out.print( i + " -->");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort(new int[]{0,1,2,0,0,1,2,2,1,0});
		//selectionSort(new int[]{4,3,2,1});
		//insertionSort(new int[]{23,1,4,15,17,19});

	}

}
