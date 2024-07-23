package com.practise.datastructures.sorting;

public class MergeSort {
	
	private void merge_sort(int[] arr , int startIdx , int endIdx)
	{
		if (startIdx >= endIdx) return ; // stop when there is only 1 element . as that element is already sorted
		int mid = ( startIdx + endIdx ) / 2 ;
		//split it
		merge_sort(arr , startIdx , mid);
		merge_sort(arr, mid+1 , endIdx);
		//merge routine
		merge(arr,startIdx,endIdx);
	}
	
	//once this routine executes - original array will be sorted starting from startIdx to endIdx
	private void merge(int[] arr, int startIdx, int endIdx) {
		
		System.out.println( " entering merge routine with startIdx= " + startIdx + " endIdx = "  + endIdx);
		// TODO Auto-generated method stub
		//create a temp array to store the sorted result
		int[] tempArr = new int[endIdx-startIdx+1];
		int mid = ( startIdx + endIdx ) / 2 ; 
		int k = mid + 1 ; 
		int m  = 0 ; // counter to fill the temp Array
		int n = startIdx;
		while (startIdx <= mid && k <= endIdx)
		{
			if (arr[startIdx] < arr[k])
			{
				tempArr[m++] = arr[startIdx++];
			}
			else
			{
				tempArr[m++] = arr[k++];
			}
		}
		
		// check whether we have exhausted the input array // or its already sorted
		if ( startIdx > mid) 
		{
			// there's still some element left from mid+1 to end 
			// add all in the end of the temp array
			for(; k<= endIdx ; k++) tempArr[m++] = arr[k];
		}
		
		else if ( k > endIdx)
		{
			// there's still some element left from startIdx to mid
			// add all in the end of the temp array
			for(; startIdx<= mid ; startIdx++) tempArr[m++] = arr[startIdx];
		}
		
		// copy temp array . which contains all elements sorted in increasing order 
		// from startidx to endidx - which corresponds to original array
		
		for (int i = n,j=0 ; i <= endIdx ; i++)
			 arr[i] = tempArr[j++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort obj = new MergeSort();
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		obj.merge_sort(arr, 0, arr.length-1); 
		System.out.println( " array after being sorted -- " + arr);
	}

}
