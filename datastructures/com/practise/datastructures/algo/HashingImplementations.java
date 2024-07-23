package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashingImplementations {
	
	//Find whether an array is subset of another array
	//Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not
	private static void isSubSet(int[] arr1 , int[] arr2){
		// two loops . check whether all elements in arr2 is present in arr1
		//O(length of arr1 * length of arr2)
		
		//binary search
		Arrays.sort(arr1); //O(NlognN)
		int count = 0;
		for (int element : arr2)
			count = (doBinarySearch(arr1, element)) ? ++count:--count; // O(length of arr2 * log(length of arr1))
		System.out.println(count == arr2.length ? " arr2 is subset of arr1 " : "arr2 is not subset of arr1");
		
		//create a hash map on arr1 . search element of arr2 over there 
		// time //O(1) insert . // space increases as per arr1 length
	}
	
	/*
	 * Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists. 
	 * Order of elments in output lists doesn’t matter.

		Example:
		
		Input:
		   List1: 10->15->4->20
		   List2:  8->4->2->10
		Output:
		   Intersection List: 4->10
		   Union List: 2->8->20->4->15->10
	 */
	//lets represent the linked list's by array
	private static void buildIntersectionAndUnion(int[] list1 , int[] list2){
		// create a set from list1
		Set<Integer> hashSet = new HashSet<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		for (int element :  list1)
		            hashSet.add(element);
		for (int element :  list2){
			if (hashSet.contains(element)) resultList.add(element);
		}
		System.out.println(" Intesection List : :" + resultList);
		resultList.clear();
		for (int element : list2)
			hashSet.add(element);
		System.out.println(" Unioned List : : " + hashSet);
		
		
		
	}
	
	/*
	 * Find four elements a, b, c and d in an array such that a+b = c+d
		Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and a, b, c and d are distinct elements. 
		If there are multiple answers, then print any of them.
		
		Example:
		
		Input:   {3, 4, 7, 1, 2, 9, 8}
		Output:  (3, 8) and (4, 7)
		Explanation: 3+8 = 4+7
		
		Input:   {3, 4, 7, 1, 12, 9};
		Output:  (4, 12) and (7, 9)
		Explanation: 4+12 = 7+9
		
		Input:  {65, 30, 7, 90, 1, 9, 8};
		Output:  No pairs found
	 */
	private static void solution(int[] arr){
		Map<Integer,String> resultMap = new HashMap<Integer, String>();
		for (int i = 0 ; i < arr.length ; i++){
			for ( int j = i + 1 ; j < arr.length ; j++){
				int tempSum = arr[i] + arr[j];
				if (!resultMap.containsKey(tempSum))
					   resultMap.put(tempSum, arr[i]+":"+arr[j]);
				else {
					String[] values = resultMap.get(tempSum).split(":");
					System.out.println("[a+b=c+d]=["+values[0]+"+"+values[1]+"]=["+arr[i] +"+"+ arr[j]+"]");
				}
			}
		}
	}
	/*
	 * Find the largest subarray with 0 sum
	   Given an array of integers, find length of the largest subarray with sum equals to 0.
	   Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		Output: 5
		The largest subarray with 0 sum is -2, 2, -8, 1, 7
		
		Input: arr[] = {1, 2, 3}
		Output: 0
		There is no subarray with 0 sum
		
		Input: arr[] = {1, 0, 3}
		Output: 1
	 */
	
	private static void largestSubArrayWithZeroSum(int[] arr){
		//considering all sub arrays
		//O(N2)
		int startIdx = 0 ;
		int endIdx = 0 ;
		int tempSum = 0 ;
		for (int i = 0 ; i < arr.length ; i++){
			tempSum = 0 ;
			for (int j = i ; j  < arr.length - 1 ; j++){
				if ( arr[j] == 0 )
					startIdx = endIdx = j;
				tempSum +=arr[j];
				if (tempSum == 0 )
				{
					if ((endIdx - startIdx) < (j - i)){
					startIdx = i ;
					endIdx = j ;
					}
				}
				
			}
		}
		System.out.println(" largest subarray having sum zero is from index " + startIdx + " to " + endIdx);
		
		//hash map impl
		// Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
 
            if (sum == 0)
                max_len = i+1;
            // Look this sum in hash table
            Integer prev_i = hM.get(sum);
            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
               max_len = Math.max(max_len, i-prev_i);
            else  // Else put this sum in hash table
               hM.put(sum, i);
        }
 
        System.out.println( " largest subarray with zero sum length is " +  max_len );
		
	}
	/*
	 * Count distinct elements in every window of size k
	   Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k.
	 */
	public static void countDistinctElementsInKSizeWindow(int[] arr , int windowSize){
		Map<Integer,Integer> hMap = new HashMap<Integer, Integer>();
		int distinctCount  = 0 ; 
		for ( int i = 0 ; i < windowSize ; i++){
			if (hMap.containsKey(arr[i]))
				 hMap.put(arr[i], hMap.get(arr[i]) + 1);
			else{ 
				 hMap.put(arr[i] , 1);
				 ++distinctCount;
			}
		}
		for ( int i = windowSize ; i < arr.length ; i++){
			
		}
		
		List<Integer> list =  new ArrayList<Integer>();
		int windowStartIndex = 0 ; 
		distinctCount = 0 ;
		for ( int i = 0 ; i < arr.length ; i++){
			list.add(arr[i]);
			if ( i >= windowSize-1){
				 distinctCount = new HashSet(list).size();
				 list.remove(windowStartIndex);
				 System.out.println( " distinct count of elements from index  " + (windowStartIndex ) + " to " + i + " is " + distinctCount);
			}
		}
		
		
	}
	/*
	 * Find smallest range containing elements from k lists
		
		Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.
		
		Example :
		
		Input:
		K = 3
		arr1[] : [4, 7, 9, 12, 15]
		arr2[] : [0, 8, 10, 14, 20]
		arr3[] : [6, 12, 16, 30, 50]
		Output:
		The smallest range is [6 8] 
		Explanation: Smallest range is formed by 
		number 7 from first list, 8 from second
		list and 6 from third list.
		
		
		Input: 
		k = 3
		arr1[] : [4, 7]
		arr2[] : [1, 2]
		arr3[] : [20, 40]
		The smallest range is [2 20] 
	 */
	
	private static boolean doBinarySearch(int[] arr1 , int elementToSearch){
		
		int start = 0 ;
		int end = arr1.length - 1;
		
		while ( start <= end){
			int mid = start + (end - start) / 2;
			if (arr1[mid] == elementToSearch) return true;
			else if ( elementToSearch < arr1[mid] ) end = mid - 1 ;
			else if ( elementToSearch > arr1[mid] ) start = mid + 1 ;	
 		}
		return false;
	}
	private static class CustomComparator<K,V extends Comparable> implements Comparator<K>
	{
		private Map<K,V> map;

		public CustomComparator(Map<K,V> map) {
			this.map = new HashMap<K,V>(map);
		}

		public int compare(K o1, K o2) {
			return map.get(o2).compareTo(map.get(o1));
		}

		
	} 
	public static void KMostFrequentElements(final int[] array , int k)
	{
		Map<Integer,Integer> hMap = new HashMap<Integer, Integer>();
		for (int element : array)
		{
			if (hMap.containsKey(element)) hMap.put(element, hMap.get(element)+1);
			else hMap.put(element, 1);
		}
		CustomComparator customComparator = new HashingImplementations.CustomComparator(hMap);
		Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>(customComparator);
		treeMap.putAll(hMap);
		System.out.println(" print " + k + " most frequent element/s");
		Iterator<Integer> itr = treeMap.keySet().iterator() ;
		while (itr.hasNext() && k !=0)
		{
			System.out.print(" element : " + itr.next());
			--k;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isSubSet(new int[]{5,1,9,3,8}, new int[]{});
		buildIntersectionAndUnion(new int[]{10,15,4,20} , new int[]{8,4,2,10});
		solution(new int[]{3, 4, 7, 1, 2, 9, 8});
		largestSubArrayWithZeroSum(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
		countDistinctElementsInKSizeWindow(new int[]{1, 2, 1, 3, 4, 2, 3} , 4 );
		KMostFrequentElements(new int[]{1,2,3,1,2,1,2,2},2);
	}

}
