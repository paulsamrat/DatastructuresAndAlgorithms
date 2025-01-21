package com.practise.datastructures.algo.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class AmazonArrayQuestions {
	
	   //sliding window O(N)
	   //https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k/
		static void track_the_maximum_of_each_subarray_size_k(int[] array , int k)
		{		
			Deque<Integer> dQueue = new LinkedList<Integer>();
			Queue<Integer> pQueue = new PriorityQueue<Integer>( new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return o2 - o1 ;
				}
				
			});
 			// construct the window
			for (int i = 0 ; i < k ; i++)
			{
				dQueue.offer(array[i]);
				pQueue.offer(array[i]);
			}
			System.out.println(" subarray : " + dQueue + " maximum value : " + pQueue.peek());
			
			for ( int i = k ; i < array.length ; i++)
			{
				//dQueue.removeFirst();
				pQueue.remove(dQueue.removeFirst());
				dQueue.offer(array[i]);
				pQueue.offer(array[i]);
				System.out.println(" subarray : " + dQueue + " maximum value : " + pQueue.peek());
			}
			
		}
	//https://www.youtube.com/watch?v=GeHOlt_QYz8&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj&index=48
	//Array of integers - where each value = 1<= x <= length(array)
	// final all duplicates in the array
	private static void findAllDuplicates(int[] array)
	{	
		//as the boundary condition is given . we can negate the values at that specific index and look for already negated value
		Set<Integer> result = new HashSet<Integer>();
		for (int i=0 ; i < array.length ; i++)
		{
			int value = array[i] < 0 ? Math.abs(array[i]) : array[i] ;
			if (array[value - 1 ] < 0)
			{
				result.add(array[i]);
			}
			else
			{
				array[array[i]-1] = - array[array[i]-1];
			}
			
		}
		System.out.println("findAllDuplicates -->" + result);
	}
	
	//stack sort
	//Given a stack of element's . sort the input stack w/ just using 1 temp stack
	
	private static void stackSort(Stack<Integer> stack)
	{
		if (  null ==  stack || stack.isEmpty()) return ;
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!stack.isEmpty())
		{
			int element = stack.pop();
			while (!tempStack.isEmpty() && element > tempStack.peek()) {
				stack.push(tempStack.pop());
			}
			tempStack.push(element);
		}
		System.out.println( "stackSort --> after sorting in descending order: " + tempStack );
	}
	
	//Find next greater number with same set of digits
	private static void next_greater_number_with_same_set_of_digits(final String number)
	{
		// every descending subsets is itself the largest --> next greater element can't be obtained 
		//lets first find a point where the pattern breaks
		for (int i=number.length() - 1 ; i >= 1 ; i--)
		{
			// move right till we find a digit lesser than the previous one
			if (number.charAt(i-1) < number.charAt(i))
			{
				//exchange rightmost digit with the previous current digit  
				int temp = number.charAt(number.length()-1);
				//number
			}
		}
	}
	

	
	//sliding window
	//https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
	private static void longest_subarray_sum_elements_atmost_k(final int[] array , final int k)
	{	
		//prerequisites check
		int start = 0 ,end = 0,current_sum = 0 ;
		int longestSubArrayLength = Integer.MIN_VALUE;
		
		while (end < array.length)
		{
			current_sum+=array[end];
			while(current_sum > k )
			{
				current_sum-=array[start];
				++start;
			}
			++end;
			longestSubArrayLength = Math.max(longestSubArrayLength, end-start);
		}
		System.out.println("longest_subarray_sum_elements_atmost_k  = " + longestSubArrayLength);
	}
	
//	Subarray whose sum is closest to K
//	Given an array of positive and negative integers and an integer K. The task is to find the subarray which has its sum closest to k. In case of multiple answers, print any one.
//	Note: Closest here means abs(sum-k) should be minimal.
//
//	Examples:
//
//	Input: a[] = { -5, 12, -3, 4, -15, 6, 1 }, K = 2
//	Output: 1
//	The subarray {-3, 4} or {1} has sum = 1 which is the closest to K.
//
//	Input: a[] = { 2, 2, -1, 5, -3, -2 }, K = 7
//	Output: 6
//	Here the output can be 6 or 8
//	The subarray {2, 2, -1, 5} gives sum as 8 which has abs(8-7) = 1 which is same as that of the subarray {2, -1, 5} which has abs(6-7) = 1.
	private static void longest_subarray_sum_elements_closest_to_k(int[] array)
	{
		int start = 0 , end = 0 , curr_sum = 0 ;
		int longestSubArrayLength = Integer.MIN_VALUE;
	}
	

	//Dutch National Flag Problem
	//Given an array with 0s,1s and 2s, sort array in increasing order. 
	//Another way to phrase this problem is sort balls with three different colors : red, blue and white, 
	//where balls of each color are placed together. This is typically know as Dutch national flag problem and algorithm to solve it is called Dutch national flag problem. Example:
	//A = [0,1,0,1,1,2,0,2,0,1]
	//Output = [0,0,0,0,1,1,1,1,2,2]
	
	private static void sort_array_0_1_2(int [] array)
	{
		int start = 0 , end = array.length - 1, reader = 0 ;
		while (reader <= end)
		{
			if (array[reader] == 0)
			{
				swap(array,start,reader);
				++reader;
				++start;
			}
			else if (array[reader] == 1) ++reader;
			else if (array[reader] == 2) 
			{
				swap(array,reader,end);
				--end;
				
			}
		}
		System.out.println("sort_array_0_1_2 " +Arrays.toString(array) );
	}
	
	private static void swap(int[] array , int idx1 , int idx2)
	{
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	//Equilibrium index of an array 
	//is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

	public static void findEquilibriumPoint(int[] array){

		//O(N)
		int leftSum = 0 ;
		int totalSum = 0 ;

		//calculate total sum first
		for (int i : array) totalSum += i;
		for (int j = 0 ; j < array.length ; j++){
			totalSum -=array[j]; // this is the right sum now 
			if (leftSum == totalSum){
				System.out.println(" equilibrium is at point " + ++j);
				break;
			}
			leftSum+=array[j];
		}
	}
	private static void next_greater_number_with_same_set_of_digits(int[] ar)
	{
		int i; 
        
        // I) Start from the right most digit  
        // and find the first digit that is smaller  
        // than the digit next to it. 
        for (i = ar.length - 1; i > 0; i--)  
        { 
            if (ar[i] > ar[i - 1]) { 
                break; 
            } 
        } 
          
        // If no such digit is found, then all  
        // digits are in descending order means  
        // there cannot be a greater number with  
        // same set of digits 
        if (i == 0)  
        { 
            System.out.println("Not possible"); 
        }  
        else 
        { 
            int x = ar[i - 1], min = i; 
              
            // II) Find the smallest digit on right  
            // side of (i-1)'th digit that is greater  
            // than number[i-1] 
            for (int j = i + 1; j < ar.length; j++)  
            { 
                if (ar[j] > x && ar[j] < ar[min])  
                { 
                    min = j; 
                } 
            } 
  
            // III) Swap the above found smallest  
            // digit with number[i-1] 
            swap(ar, i - 1, min); 
  
            // IV) Sort the digits after (i-1)  
            // in ascending order 
            Arrays.sort(ar, i, ar.length); 
            System.out.print("next_greater_number_with_same_set_of_digits" + Arrays.toString(ar)); 
            
        } 
		
	}
	
	private static void kth_largest_element_in_a_stream()
	{
		
	}
	
	//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
	private static void median_in_a_stream() throws NumberFormatException, IOException
	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0 ; i < 10 ; i++)
		{	
			//assuming null is not passed
			int input = Integer.parseInt(bf.readLine());
			findMedian(input,pq);
		}
	}
	private static void findMedian(int input , Queue<Integer> pq)
	{
		pq.offer(input);
		
	}
	
	//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0
	//Given two unsorted arrays A of size N and B of size M of distinct elements, 
	//the task is to find all pairs from both arrays whose sum is equal to X.
	private static void find_all_pairs_with_a_given_sum(int[] unsortedArr1 , int[] unsortedArr2 , int reqSum)
	{	
		//pre checks here
		Map<Integer,Integer> mapUnsortedArr2 = new HashMap<Integer, Integer>();
		for (int element : unsortedArr2)
		{
			if (mapUnsortedArr2.containsKey(element))
			{
				mapUnsortedArr2.put(element, mapUnsortedArr2.get(element)+1);
			}
			else
			{
				mapUnsortedArr2.put(element,1);
			}
		}
		System.out.println("\nfind_all_pairs_with_a_given_sum ...");
		for (int element : unsortedArr1)
		{	
			int elementToFind = Math.abs(element-reqSum);
			if (mapUnsortedArr2.containsKey(elementToFind) && mapUnsortedArr2.get(elementToFind) > 0 )
			{
				System.out.print(element + " " + elementToFind + ",");
				mapUnsortedArr2.put(elementToFind, mapUnsortedArr2.get(elementToFind)-1);
			}
		}
	}
	
	//For example, the string a3c9b2c1 has two instances where 'c' is followed by a count: once
	//with 9 occurrences, and again with 1. It should be compressed to a3b2c10
	private static void better_compression(final String str)
	{
		int[] count = new int[26];
		int lastCharIdx = 0;
		int j ,tempFreq;
		Set<Character> sorted = new TreeSet<Character>();
		for (int i = 0 ; i < str.length();i++)
		{
			int index = str.charAt(i)-'a';
			if (index >= 0 && index <= 26)
			{
					lastCharIdx =  index;
					sorted.add(str.charAt(i));
			}
			else
			{
				j = i;
				tempFreq = 0;
				while ( j < str.length() )
				{	
					index = str.charAt(j)-'0';
					if (index >= 0 && index <=9)
					{
						//keep on forming the count
						tempFreq = tempFreq*10+str.charAt(j)-'0';
						++j;
					}
					else
					{
						break;
					}
					
				}
				count[lastCharIdx]+=tempFreq;
				i = j-1;
			}

		}
		StringBuilder sb = new StringBuilder(26);
//		for (int i = 0 ; i < str.length() - 1 ; i++)
//		{	
//			int index = str.charAt(i)-'a';
//			if (index >= 0 && index <= 26 && count[index] != 0 )
//			{
//				sb.append(str.charAt(i)).append(count[index]);
//				count[index] =  0;
//			}
//		}
		//alternative
//		for (Iterator<Character> itr = sorted.iterator() ; itr.hasNext();)
//		{
//			char c = itr.next();
//			sb.append(c).append(count[c-'a']);
//		}
		
		for (int i = 0 ; i < count.length ; i++)
		{

			char c  = (char) ((int)'a' + i) ;
			if (count[c-'a'] != 0 )
				sb.append(c).append(count[c-'a']);
			
		}
		System.out.println("\nbetter_compression " + sb.toString());
		
	}
	//["a","a","b","b","c","c","c"] compressed  a2b2c3
	private static void string_compression_in_place(String[] str)
	{	
		int count = 1 ;
		int ptr1 = 0 ,ptr2 = ptr1+1;
		String result = StringUtils.EMPTY;
		while ( ptr2 < str.length)
		{
			if (str[ptr1] == str[ptr2]) ++count;
			else
			{
				result = result + str[ptr1] + count;
				count = 1 ;
			}
			++ptr1;++ptr2;
		}
		if (str[ptr1] == str[ptr2-1]) {
			result = result + str[ptr1] + count;
		}
		System.out.println( "string_compression_in_place "  + result);
	}
	//Write a program to print all the LEADERS in the array. 
	//An element is leader if it is greater than all the elements to its right side. The rightmost element is always a leader. 
	//https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
	public static void findAllLeaders(int[] array){
		if( null == array || array.length ==0 ) return;
		int leaderTillNow = array[array.length - 1] ;
		System.out.print("findAllLeaders  :" + leaderTillNow + " -- ");
		for (int i = array.length - 2 ; i >= 0 ; i--)
		{
			if( array[i] >= leaderTillNow ) 
			{	
				leaderTillNow = array[i];
				System.out.print(leaderTillNow + " -- ");
			}
		}
		System.out.println();
		findAllLeaders_stack(array);
	}
	public static void findAllLeaders_stack(int[] array){
		Stack<Integer> stack = new Stack<Integer>();
		//start from end of the array
		stack.push(array[array.length - 1]); //rightmost element is the leader as always
		for ( int i = array.length - 2 ; i >= 0 ; i--)
		{
			// if the current element is greater than top element present  in stack
			// then current element is the leader
			// else don't add the current element into stack as this is not the leader
			
			if (array[i] >= stack.peek()) stack.push(array[i]);
			
		}
		//all leaders are present in stack
		while (!stack.isEmpty())
		{
			System.out.print( stack.pop() + " , ");
		}
	}
	
	private static void findMinNumberOfPlatFormsReq(final int[] arrival , final int[] departure)
	{	
		if (null == arrival || arrival.length == 0 ) return;
		int platformsReqTillNow = 1;
		int minNoOfPlatformReq = 1;
		//int arrivalLength = arrival.length;
		//int departureLength = departure.length;
		//sort both Arrays
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int j = 0 ;
		int i = 1;
		while( i < arrival.length)
		{
			++platformsReqTillNow;
			while(departure[j] < arrival[i] && j < departure.length)
			{
				--platformsReqTillNow;
				++j;
			}
			++i;
			minNoOfPlatformReq = Math.max(platformsReqTillNow, minNoOfPlatformReq);
		}
		System.out.println( "\nminimum number of platforms required for railway station = " + minNoOfPlatformReq);
	}
	//https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
	private static void reverseArrayInGroups(final int[] array , final int groupSize)
	{	
		System.out.println( " reverseArrayInGroups of : " + groupSize + "  : Before Reversing : " + Arrays.toString(array));
		if (null == array || array.length == 0 ||   groupSize <= 0 ) return;
		if (array.length == 1 ) System.out.println(array[0]);
		if (groupSize == 1) System.out.println(array);
		if (array.length == 2) System.out.println( array[1] + "," + array[0]);
		int startIdx = 0 ;
		int endIdx = groupSize-1;
		while(startIdx < array.length)
		{	
			int startIdxTmp = startIdx;
			int endIdxTmp = endIdx;
			while (startIdxTmp < endIdxTmp)
			{
				int temp = array[startIdxTmp];
				array[startIdxTmp] = array[endIdxTmp];
				array[endIdxTmp] = temp;
				++startIdxTmp;
				--endIdxTmp;
			}
			startIdx+=groupSize;
			endIdx = ( endIdx + groupSize)  >= array.length ? array.length - 1 : endIdx + groupSize  ;
		}
		System.out.println(" reverseArrayInGroups : After Reversing : " + Arrays.toString(array));
	}
	//Given an unsorted array of integers, find a contiguous  subarray which adds to a given number.
		//If there are more than one subarrays with sum as the given number, print any of them.
	private static void subarray_with_given_sum(final int[] arr)
	{
		//Map<Integer,>
	}
	//https://www.youtube.com/watch?v=86YAPbZmsRI
	//https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
	private static void findPythagoreanTriplet(final int[] array)
	{
		//assuming all elements are distinct
		Set<Integer> set = new HashSet<Integer>();
		for ( int i : array) set.add(i);
		for (int i : array)
		{	
			if ( i % 2  == 0 )
				//is the current number even ? 
			{
				int temp = i / 2 ;
				temp = (int) Math.pow(temp, 2);
				if ( set.contains(temp -1 ))
					if (set.contains(temp+1))
					{
						System.out.println( "\n PythagoreanTriplet : " + i + " -- " + (temp -1) + " -- " + (temp+1 ));
						break;
					}
			}
			//is the current number odd ? 
			else
			{
				int temp =(int) Math.pow(i, 2);
				temp  = temp / 2;
				if ( set.contains(temp)) 
					if (set.contains(temp + 1))
					{
						System.out.println( "\n PythagoreanTriplet : " + i + " -- " + (temp) + " -- " + (temp+1 ));
						break;
					}
			}
		}
	}
	//https://www.geeksforgeeks.org/chocolate-distribution-problem/
	private static void chocolateDistributionProblem(int[] array , final int noOfStudents)
	{
		if ( null == array || array.length < noOfStudents || array.length == 0 || noOfStudents == 0) return;
		Arrays.sort(array);
		int minDiff = Integer.MAX_VALUE ;
		int startIdx =  0 ;
		int endIdx = noOfStudents - 1 ;  /** slidding window **/
		while(endIdx <= array.length - 1)
		{
			int tempDiff = array[endIdx] - array[startIdx];
			minDiff = Math.min(tempDiff, minDiff);
			++startIdx;
			++endIdx;
		}
		System.out.println(" chocolateDistributionProblem :  Minimum-Difference : " + minDiff);
	}
	
	@SuppressWarnings("unchecked")
	private static void form_largest_number_from_given_set_of_numbers(final int[] arr)
	{
		//logic
//		Given two numbers X and Y, how should myCompare() decide which number to put first – 
//		we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). 
//		If XY is larger, then X should come before Y in output, else Y should come before. 
//		For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260,
		//List<int[]> list = Arrays.asList(arr);
		//convert int to wrapper
//		Integer[] arr1 = new Integer[arr.length];
//		for (int i = 0 ; i < arr.length ; i++)
//		{
//			arr1[i] = Integer.valueOf(arr[i]);
//		}
//		List<Integer> list = Arrays.asList(arr1);
		List<String> strList = new ArrayList<String>(arr.length);
		for (int element : arr)
		{
			strList.add(String.valueOf(element));
		}
		Collections.sort(strList, new Comparator<String>(){

			@Override
			public int compare(String X, String Y) {
		        return X.concat(Y).compareTo(Y.concat(X)) > 0 ? -1:1; 
			}
			
		});
		System.out.println(strList);
	}
	/*
	 * Find the element before which all the elements are smaller than it, and after which all are greater
		Given an array, find an element before which all elements are smaller than it, and after which all are greater than it. Return the index of the element if there is such an element, otherwise, return -1.
		Examples:
		
		Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		Output: 4
		Explanation: All elements on left of arr[4] are smaller than it
		and all elements on right are greater.
		
		Input: arr[] = {5, 1, 4, 4};
		Output: -1
		Explanation : No such index exits.


	 */
	//to check
	//{5, 1, 4, 3, 6, 8, 10, 7, 9} index - 4 ans
	private void find_element_all_smaller_towards_left_and_all_higer_towards_right(final int[] arr)
	{
		//create left array  having largest element till ith location
		//create right array having lowest element till ith location
		
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		left[0] = arr[0];
		right[arr.length-1] = arr[arr.length-1];
		for (int i = 1 ; i < arr.length ; i++) 
		{
			left[i] = arr[i] > arr[i-1] ? arr[i] : left[i-1];
		}
		for (int i = arr.length-2 ; i >= 0 ; i--)
		{
			right[i] = arr[i] < arr[i+1] ? arr[i] : right[i+1];
		}
		for(int i= 0 ; i < arr.length ; i++)
		{
			if (arr[i] > left[i-1] && arr[i] < right[i+1])
			{
				System.out.println( " element = " + arr[i]);
				break;
			}
		}
	}

	
	
	//https://www.youtube.com/watch?v=76-CYD0jn7s
	//buy and sell only once - maximize profit
	private static void stock_buy_and_sell(final int[] stockPrices)
	{	
		System.out.println( " -- stock_buy_and_sell -- only once");
		// as we have to maximize profit .
		// so we will look for lowest buying price 
		
		int maxProfit = Integer.MIN_VALUE ;
		int lowestBuyingPrice = Integer.MAX_VALUE;
		int lowestBuyingPriceIdx = 0;
		int tempBuyingIdx = 0 ;
		int sellingPriceIdx = 0 ;
		
		for (int i = 0 ; i < stockPrices.length ; i++)
		{
			if (stockPrices[i] < lowestBuyingPrice)
			{
				lowestBuyingPrice = stockPrices[i] ;
				tempBuyingIdx = i;
			}
			//profit earned buy selling at the ith price 
			// we always have to buy it and then sell it 
			// so if we found a new buying index . selling starts from that index 
			if ( (stockPrices[i] - lowestBuyingPrice )  > maxProfit)
			{
				sellingPriceIdx=i;
				lowestBuyingPriceIdx = tempBuyingIdx;
				maxProfit = (stockPrices[i] - lowestBuyingPrice );
			}
		}
		
		System.out.println( "Max Profit Earned = " + maxProfit + " Brought at price " + stockPrices[lowestBuyingPriceIdx] + " sold at price " + stockPrices[sellingPriceIdx] );
	}
	
	//https://www.youtube.com/watch?v=Taq95cvRom8
	//buy and sell multiple times   - maximize profit
	// so we have to find all increasing pairs
	
	private static void stock_buy_and_sell_multiple_times(final int[] stockPrices)
	{	
		System.out.println( " -- stock_buy_and_sell_multiple_times -- ");
		// as we have to maximize profit .
		// so we will look for lowest buying price 
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		int maxProfit = 0 ;
		int buyingIdx = -1;
		int sellingIdx = 0 ;
		
		for (int i = 1 ; i < stockPrices.length ; i++)
		{
			if (stockPrices[i] > stockPrices[i-1])
			{	
				maxProfit+= stockPrices[i] - stockPrices[i-1];
				if (buyingIdx == -1) buyingIdx = i-1;
				sellingIdx = i;
			}
			else
			{
				sellingIdx = i-1;
				buyingIdx = -1;
			}
			if (buyingIdx >= 0 )
				result.put(buyingIdx, sellingIdx);
		}
		System.out.println(result + " Max Profit Earned = " + maxProfit);
	}
	private class PetrolPumpData
	{
		private int petrol;
		private int distToTravel;
		
		private PetrolPumpData(final int petrol , final int distToTravel)
		{
			this.petrol = petrol;
			this.distToTravel =distToTravel;
		}
	}
	//function returns start point of tour
	private static void circular_tour(PetrolPumpData array[])
	{	
		System.out.println( " -- circular_tour --  ");
	    //Initialize start as first petrol bunk
	    int start_point = 0;
	    int end_point =  1;

	    int curr_petrol = array[start_point].petrol - array[start_point].distToTravel;
	    while1:
	    while (end_point != start_point || curr_petrol < 0)
	    {
	        //If current petrol is negitive
	        //remove first petrol pump and update start
	        while (curr_petrol < 0 && start_point != end_point)
	        {
	            curr_petrol = curr_petrol - (array[start_point].petrol - array[start_point].distToTravel);
	            start_point = (start_point + 1)%array.length;
	            //if zero is coming again as start point.
	            //No solution
	            //loop starting again
	            if (start_point == 0)
	               //return -1;
	            	System.out.println( " No Circular Paths Exist");
	            	break while1;
	        }
	        //update current_petrol and end point
	        //adding next petrol pump to Queue
	        curr_petrol = curr_petrol + array[end_point].petrol - array[end_point].distToTravel;
	        end_point = (end_point + 1)%array.length;
	    }
	    //final start point
	    System.out.println( " circular_tour starting from pretrol pump " + start_point);
	}
	//idea
	/*
	 *  Select a pivot and partition the array with pivot at correct position j
		If position of pivot, j, is equal to k, return A[j].
		If j is less than k, discard array from start to j, and look for (k-j)th smallest element in right sub array, go to step 1.
		If j is greater than k, discard array from j to end and look for kth element in left subarray, go to step 1
	 */
	
	//not tested
	private static int find_kth_smallest_element_quick_sort(final int[] array , int kThSmallest , int start , int end)
	{
		int pivotElement = array[start+(end-start)/2];
		int i = start,j=end;
		while (i <= j)
		{
			while (array[i] < pivotElement) ++i;
			while (array[j] > pivotElement) --j;
			
			if ( i <= j )
			{
				 int temp = array[i];
			     array[i] = array[j];
			     array[j] = temp;
			     
			     ++i;
			     --j;
			}
		}
		//at this point pivot element is at right place
		//so basically pivot element is the ith smallest element 
		
		if ( j == kThSmallest) return array[j];
		if (kThSmallest > j) 
		{
			find_kth_smallest_element_quick_sort(array,kThSmallest,j+1,end);
		}
		else
		{
			find_kth_smallest_element_quick_sort(array,kThSmallest,start,j-1);
		}
		return -1;
	}
	
	private static void find_kth_smallest_element_quick_select(final int[] array , int kThSmallest , int start , int end)
	{
		
	}
	
	//private int find_the_partition_index()
	//Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. 
	//The task is to find the index of the given element K in the array A.
	private static void search_in_a_rotated_array(int[] array, int elementToSearch)
	{	
		System.out.println( " -- search_in_a_rotated_array -- " );
		//as the array is sorted and rotated 
		// find the rotation point
		int rotationIdx = 0;
		int elementToSearchIdx = Integer.MIN_VALUE;
		// do binary search to find the rotation index
		for ( int i = 0 ; i< array.length-1 ;i++)
		{
			if (array[i+1] < array[i]) {rotationIdx = i ; break;}
		}
		//do binary search on both parts
		if (elementToSearch > array[rotationIdx])
			elementToSearchIdx = do_binary_search(array,0,rotationIdx,elementToSearch);
		else 
			elementToSearchIdx = do_binary_search(array,rotationIdx+1,array.length-1, elementToSearch);
			
		System.out.println(elementToSearchIdx == -1  ? " Element Not Found" : elementToSearchIdx);
		
	}
	private static int do_binary_search(final int[] array , int startIdx , int endIdx , int elementToSearch)
	{
		while(startIdx <= endIdx)
		{
			int midElementIdx = startIdx + (endIdx-startIdx)/2;
			if (array[midElementIdx] == elementToSearch) return midElementIdx;
			if (elementToSearch < array[midElementIdx] )
				 endIdx = midElementIdx-1;
			if (elementToSearch > array[midElementIdx] )
				 startIdx = midElementIdx + 1 ;
		}
		return -1;
	}
	
	private static void merge_two_sorted_arrays_in_place(final int[] X , final int[] Y)
	{
		int m = X.length;
		int n = Y.length;

		// consider each element X[i] of array X and ignore the element
		// if it is already in correct order else swap it with next smaller
		// element which happens to be first element of Y
		for (int i = 0; i < m; i++)
		{
			// compare current element of X[] with first element of Y[]
			if (X[i] > Y[0])
			{
				// swap (X[i], Y[0])
				int temp = X[i];
				X[i] = Y[0];
				Y[0] = temp;

				int first = Y[0];

				// move Y[0] to its correct position to maintain sorted
				// order of Y[]. Note: Y[1..n-1] is already sorted
				int k;
				for (k = 1; k < n ; k++) {
					if (Y[k] < first)
							Y[k - 1] = Y[k];
				}

				Y[k - 1] = first;
			}
		}
		System.out.println("X: " + Arrays.toString(X));
		System.out.println("Y: " + Arrays.toString(Y));
	}
	//to modify
	private static void median_two_sorted_arrays(final int[] sorted1 , final int[] sorted2)
	{	
		System.out.println("  -- median_two_sorted_arrays -- ");
		int totalLength = sorted1.length + sorted2.length;
		List<Integer> mediansIdx = new ArrayList<Integer>(2);
		if (totalLength % 2 == 0)
		{
			mediansIdx.add(totalLength/2);
			mediansIdx.add(totalLength/2-1);
		}
		else
			mediansIdx.add(totalLength/2);
		int result = 0;
		
		for (int i=0,j=0 ; i < sorted1.length && j < sorted2.length;)
		{	
			if (sorted1[i] < sorted2[j]) ++i;
			else ++j;
			if (mediansIdx.contains(i))
			{
				result+=sorted1[i];
				mediansIdx.remove((Integer)i);
			}
			else if(mediansIdx.contains(j))
			{
				result +=sorted2[j];
				mediansIdx.remove((Integer)j);
			}
			if (mediansIdx.isEmpty())break;
		}
		System.out.println( ( totalLength % 2 == 0 )  ? result/2 : result);
		//handle cases when 1 of the sorted array is empty
	}
	
	private static void sort_array_0_1(final int[] array)
	{	
		System.out.println( " --  sort_array_0_1 -- ");
		int start = 0 ;
		int end  = array.length - 1 ;
		//two ways 
		while (start < end)
		{
			while (array[start] == 0 && start < end)
				++start;
			while(array[end] == 1 && end > start )
				--end;
			if(start < end )
			{
				array[start] = 0;  
	            array[end] = 1; 
	            ++start;
	            --end;
			}
		}
		
//	    while(start < end) 
//	    { 
//	        if(array[start] == 1) 
//	        { 
//	        	array[start] = array[end];  
//	            array[end] = 1;  
//	            --end; 
//	        } 
//	        else
//	        	++start; 
//	    } 
		System.out.println( Arrays.toString(array));
	}
	//Sprint Training
	public static void getMostVisited(int n, int[] sprints) 
	{
	    // Write your code here
	    int [] blocksVisited = new int[n+1];
	    int mostVisited = 0 ;  
	    int mostVisitedBlockId = 0 ; 
	    for (int i = 0 ; i < sprints.length - 1; i++)
	    {
	      int startPoint = Math.min(sprints[i] , sprints[i+1]);
	      int endPoint = Math.max(sprints[i] , sprints[i+1]);
	      for (int j = startPoint ; j <= endPoint ; j++)
	      {
	        blocksVisited[j]++;
	        if (blocksVisited[j] >= mostVisited)
	        {
	        	mostVisited = blocksVisited[j];
	        	mostVisitedBlockId = j < mostVisitedBlockId ? j : mostVisitedBlockId;
	        }
	      }
	    }
	    System.out.println( " most visited block id -   = " + mostVisitedBlockId ) ;
	}
	
	public static List<String> doesCircleExist(List<String> commands) {
	    // Write your code here
	   
	    List<String> result = new ArrayList<String>();
	    for (String command : commands)
	    {
	    	char direction = 'N';
	 	    int x = 0;
	 	    int y = 0;
	    	for (char c : command.toCharArray())
	    	{
	    		if (c == 'G')
	    		{
	    	            if (direction == 'N') {
	    	                y++;
	    	            } else if (direction == 'S') {
	    	                y--;
	    	            } else if (direction == 'W') {
	    	                x--;
	    	            } else {
	    	                x++;
	    	            }
	    	     } 
	    		else if (c == 'L') 
	    		{
	    	            if (direction == 'N') {
	    	                direction = 'W';
	    	            } else if (direction == 'S') {
	    	                direction = 'E';
	    	            } else if (direction == 'W') {
	    	                direction = 'S';
	    	            } else {
	    	                direction = 'N';
	    	            }            
	    	        } 
	    		else 
	    		{
	    	            if (direction == 'N') {
	    	                direction = 'E';
	    	            } else if (direction == 'S') {
	    	                direction = 'W';
	    	            } else if (direction == 'W') {
	    	                direction = 'N';
	    	            } else {
	    	                direction = 'S';
	    	            }            
	    	     }
	    		
	    		
	    	}
	    	if ( (x == 0 && y == 0) || (direction != 'N'))
    		{
    			result.add("YES");
    		}
    		else
    		{
    			result.add("NO");
    		}
	    }
	    return result;
	}
	
    public static void finalPrice(List<Integer> prices) {
    // Write your code here
    //List<Integer> itemsIdx =  new ArrayList<Integer>();
    StringBuilder sb = new StringBuilder();
    long totalCost = 0 ; 
    int lowestCostTillNow = prices.get(prices.size()-1);
    //itemsIdx.add(prices.size()-1);
    sb.append(prices.size()-1).append(" ");
    totalCost = lowestCostTillNow;
    for (int i = prices.size() -  2 ; i >= 0 ; i--)
    {
      if ( lowestCostTillNow < prices.get(i) )
      {
        totalCost+= prices.get(i) - lowestCostTillNow ;
      }
      else
      {
        totalCost+=prices.get(i);
        lowestCostTillNow = prices.get(i);
        //itemsIdx.add(i);
        sb.append(i).append(" ");
      }
    }
    System.out.println(totalCost);
    //Collections.reverse(itemsIdx);
    System.out.println(sb.reverse());
    }
    
    /*
     * A beautiful subarray is defined as an array of any length having a specific number of odd elements.  Given an array of integers and a number of odd elements that constitutes beauty, create as many distinct beautiful subarrays as possible.  Distinct means the arrays don't share identical starting and ending indices, though they may share one of the two.

 
		
		For example, given the array [1, 2, 3, 4, 5] and a beautiful number of 2, the following beautiful subarrays can be formed:
		
		 
		
		[1, 2, 3]
		
		[1, 2, 3, 4]
		
		[2, 3, 4, 5] 
		
		[3, 4, 5]
     */
    
    public static void beautiful_subarray(int[] array , final int kOddElements)
    {

        // Write your code here
            int start =0;
            int end =0;
            int cnt =0;
            long total=0;
            while(end<array.length){
                if(array[end++]%2!=0) cnt++;
                //++end;
                while( cnt>kOddElements){
                    if(array[start++]%2!=0) cnt--;
                    //++start;
                }
                if(cnt==kOddElements){
                    total +=beautifulSubarraysHelper(array,start, end, kOddElements);
                }
            }
            //return total;
            System.out.println( " total number of subarrays = " + total);
        }
        public static long beautifulSubarraysHelper(int[] a, int start, int end, int m){
            long total_so_far = m==0 ? 0: 1;
             while(start<end && a[start]%2==0) {
                total_so_far++;
                start++;
                
            }
            return total_so_far;
    }
    
    /*
     * Your music player allows you to choose songs to play, but only in pairs and only pairs of songs with durations that add up to whole minutes. Given a list of song durations, calculate the total number of different pairs of songs that can be chosen.
	For example, given song lengths [40, 20, 60], one pair of songs can be chosen: [40, 20]. While the third song is a whole minute long, songs must be chosen in pairs.
	Function Description 
	Complete the function playlist in the editor below. The function must return a single integer that is the number of ways to choose two songs such that the total duration is a multiple of a whole minute.
     */
    public static void noOfWaysToChoosePairSongs(int[] array)
    {
    	int[] count =  new int[61];
    	int result = 0 ; 
    	for (int i = 0 ; i < array.length ;i++)
    	{
    		count[array[i]%60]++;
    	}
    	for (int i = 1 ; i < count.length ; i++)
    	{
    		if (array[i] > 0  && array[60-i] > 0 )
    		{
    			++result;
    			array[i]--;
    			array[60-i]--;
    		}
    	}
    }
    
    
//    A hotel manager has to process N bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
//    Inputs:
//    - First list for arrival time of booking
//    - Second list for departure time of booking
//    - Third is K which denotes the count of rooms
//    Output:
//    - A boolean which tells whether its possible to make a booking
//    false means there are not enough rooms for N booking
//    true means there are enough rooms for N booking
//    Example:
//    Inputs:
//    - arrivals = [1, 3, 5]
//    - departures = [2, 6, 10]
//    - K = 1
//
//    Output: false. At day = 5, there are 2 guests in the hotel. But we have only one room.
    
    public static void is_booking_possible(final int[] arrivals , final int[] departures , final int roomsAvailable)
    {
    	// take an solution array . max size is departure value
    	// iterate through arrivals 
    	//populate soln array
    	
    	//iterate trough departures
    	//populate soln array
    	
    	// for days staying increment loc by 1 and for departure days decrement by 1 
    	
    	//finally iterate through soln array . check for any loc where the rooms needed is greater than available rooms 
    	// return false else true
    	
    	//using map.
    	
    	//using abv approach some data are irrelevant like from day 6 to day 10 . there is no activity
    	
    	// using map.
    	Map<Integer,Integer> count = new HashMap<Integer, Integer>();
    	for ( int i  = 0 ; i < arrivals.length ; i++)
    	{
    		int arrivalDay = arrivals[i];
    		int departureDay = departures[i];
    		
    		if (count.containsKey(arrivalDay))
    			 count.put(arrivalDay, count.get(arrivalDay)+1);
    		else count.put(arrivalDay, 1);
    		
    		
    		if (count.containsKey(departureDay))
    				count.put(departureDay, count.get(departureDay)-1);
    		else count.put(arrivalDay, -1);
    		
    		//sort the whole map
    		
    		Map<Integer,Integer> sorted = new TreeMap<Integer, Integer>(count);
    		int result = 0;
    		for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
    		    result += entry.getValue();

    		    // If the current count exceeds the maximum number of rooms
    		    if (result > roomsAvailable) {
    		      
    		    		System.out.println( " booking not possible");
    		    		break;
    		    }
    		  }
    		
    		
    	// w/o - hashmap	
    		
    		// Sort both collections
    		  Arrays.sort(arrivals);
    		  Arrays.sort(departures);

    		  // Number of rooms
    		  int n = arrivals.length;

    		  int count1 = 0;
    		  int indexArrival = 0;
    		  int indexDeparture = 0;

    		  while (indexArrival < n && indexDeparture < n) {
    		    // Check the min
    		    if (arrivals[indexArrival] < departures[indexDeparture]) {
    		      indexArrival++;
    		      count1++;

    		      // If the current count exceeds the maximum number of rooms
    		      if (count1 > roomsAvailable) {
    		        //return false;
    		    	System.out.println( " booking not possible");
  		    		break; 
    		      }
    		    } else {
    		      indexDeparture++;
    		      count1--;
    		    }
    		  }

    	}
    }
    //find square root 
	public int sqrt(int a) {
	  long low = 1, high = a;
	
	  while (low <= high) {
	    long mid = (high + low) / 2;
	    long current = mid * mid;
	
	    if (current == a) {
	      return (int) mid;
	    } else if (current < a) {
	      low = mid + 1;
	    } else {
	      high = mid - 1;
	    }
	  }
	
	  return (int) high;
	}
	
	//find starting index of the given element 
	//given a array which can contain duplicates - find starting index of the given element
	public static int find_starting_index(final int[] arr , final int elementToFind)
	{	
		System.out.println( "find starting index of element = " + elementToFind );
		System.out.println( "-1 denotes element not found ");

		//using binary search
		int start = 0 ;
		int end = arr.length-1;
		
		while (start <= end)
		{
			int mid = start + (end-start)/2;
			if (arr[mid] == elementToFind && ( mid == 0 || elementToFind > arr[mid-1])) return mid;
			else if (elementToFind > arr[mid]) start = mid+1;
			else end = mid-1;
		}
		return -1;
	}
	
	//find ending index of the given element 
	//given a array which can contain duplicates - find starting index of the given element
	public static int find_ending_index(final int[] arr , final int elementToFind)
	{	
		System.out.println( "find ending index of element = " + elementToFind );
		System.out.println( "-1 denotes element not found ");

		//using binary search
		int start = 0 ;
		int end = arr.length-1;

		while (start <= end)
		{
			int mid = start + (end-start)/2;
			if (arr[mid] == elementToFind && ( mid == arr.length-1 || elementToFind < arr[mid+1])) return mid;
			else if (elementToFind < arr[mid]) end = mid-1;
			else start = mid+1;
		}
		return -1;
	}
	
	//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
	//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
	
	public void find_maximum(final int[] array)
	{
		int[] solution = new int[array.length];
		//using LIS approach
		//solution[0] = 
	}
	
	//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	/*
	 * Given an array of positive numbers, 
	 * find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. 
	 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
	 */
	
	public static void find_maximum_subsequence_sum(final int[] array)
	{
		//using dp approach
		int[] solution =  new int[array.length];
		solution[0] = array[0];
		solution[1] = array[0] > array[1] ? array[0] : array[1] ;
		for (int i = 2 ; i < array.length ; i++)
		{
			solution[i] = solution[i-2] + array[i] > solution[i-1] ? solution[i-2] + array[i] : solution[i-1];
		}
		System.out.println( "  -- find_maximum_subsequence_sum -- " +solution[array.length-1] );
	}
	
	//pigeon hole principle
	//A good subarray is an subarray where (ai+ai+1,ai+2...ai+n)/N 
	public static void divisible_subarrays(final int[] arr , final int n)
	{
		// as the sum needs to be divisible by N
		// so each element must have a remainder between 0 --> N-1
		
		// as per pigeon hole principle . at-least 1 hole / 1 bucket must have 2 or more values 
		
		//building the prefix array 
		
		int[] pigeonHole =  new int[n-1];
		// go through all array elements and put it into right pegion hole
		for (int element : arr)
		{
			pigeonHole[element%n] = element;
		}
		
	}
//	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//	Example:
//	Input: [0,1,0,3,12]
//	Output: [1,3,12,0,0]
//	You must do this in-place without making a copy of the array.
//	Minimize the total number of operations.
	
	public static void move_all_zeros_maintain_relative_order(final int[] array)
	{
		int lastZeroIdx = Integer.MIN_VALUE;
		for (int i = 0 ; i < array.length ; i++)
		{
			if (array[i] == 0 && lastZeroIdx == Integer.MIN_VALUE)
				lastZeroIdx = i ;
			else if (array[i] != 0 && lastZeroIdx != Integer.MIN_VALUE)
			{
				array[lastZeroIdx]= array[i];
				array[i] = 0;
				++lastZeroIdx;
			}
		}
		
		//print
		System.out.println( " --  move_all_zeros_maintain_relative_order -- " + Arrays.toString(array));
	}
	
	//There are n people lined up, and each have a height represented as an integer. 
	//A murder has happened right in front of them, and only people who are taller than everyone 
	//in front of them are able to see what has happened. How many witnesses are there?

//	Example:
//	Input: [3, 6, 3, 4, 1]  
//	Output: 3
//	Explanation: Only [6, 4, 1] were able to see in front of them.
	
	public static void find_no_of_witnesses(final int[] array)
	{
	  int largestElementTillNow = array[array.length-1];
	  int noOfWitnesses = 1 ;
	  for (int i = array.length-2 ; i >= 0 ; i--)
	  {
		  if (array[i] > largestElementTillNow){++noOfWitnesses;largestElementTillNow=array[i];}
	  }
	  //print
	  System.out.println( " -- find_no_of_witnesses -- " + noOfWitnesses);
	}
	//Given an array of n positive integers and a positive integer s, 
	//find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

	public static void minimum_size_subarray_sum(final int[] arr , final int s)
	{
		int start = 0 ;
		int end = 0 ;
		int currSum = 0 ;
		int minSubArrLength = Integer.MAX_VALUE;
		while (end < arr.length)
		{
				currSum+=arr[end];
				++end;
				while(currSum >= s)
				{
					minSubArrLength = Math.min(minSubArrLength, (end-start));
					currSum -= arr[start];
					++start;
				}
		}
		
		System.out.println(" -- minimum_size_subarray_sum -- " + minSubArrLength);
	}
	
	//Non-decreasing Array with Single Modification
//	You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.
//	We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
//
//	Example:
//
//	[13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.
//
//	[13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.
//	O(N)
	public static void non_decreasing_arr_single_modification(final int[] arr)
	{	
		int noOfModifications = 0 ;
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (arr[i] < arr[i-1])
			{
				//swap
				++noOfModifications;
			}
			if (noOfModifications > 1) { System.out.println( " -- not possible -- ");break; }
		}
	}
	
	//Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
	
	//Example 1:
	//Input: [3, 3, 2, 1, 3, 2, 1]
	//Output: [1, 1, 2, 2, 3, 3, 3]
	public static void sort_3_given_numbers(final int[] arr)
	{	
		System.out.println( " -- sort_3_given_numbers --  ");
		int start = 0 ;
		int end = arr.length-1;
		int runner = 0 ;
		
		while (runner < end)
		{
			if (arr[runner] == 1 )
			{	
				if (arr[runner] != arr[start]) swap(arr,start,runner);
				++start;
				++runner;
			}
			else if (arr[runner] == 3)
			{
				if (arr[runner] != arr[end]) swap(arr, runner, end);
				--end;
			}
			else if (arr[runner] == 2)
			{
				++runner;
			}
		}
		
		System.out.println(" -- sort_3_given_numbers -- "  + Arrays.toString(arr));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		track_the_maximum_of_each_subarray_size_k(new int[]{ 1, 2, 3, 2, 4, 1, 5, 6,1} , 3);
		findAllDuplicates(new int[]{1,2,3,4,5});
		Stack<Integer> input = new Stack<Integer>();
		input.push(5);
		input.push(4);
		input.push(11);
		input.push(2);
		input.push(1);
		stackSort(input);
		longest_subarray_sum_elements_atmost_k(new int[]{1, 2, 1, 0, 1, 1, 0},4);
		sort_array_0_1_2(new int[]{0,1,0,1,1,2,0,2,0,1});
		next_greater_number_with_same_set_of_digits(new int[]{5,3,4,9,7,6});
		find_all_pairs_with_a_given_sum(new int[]{1,2,4,5,7}, new int[] {5,6,3,4,8},9);
		better_compression("a12c56a12c5a2b4a7");
		string_compression_in_place(new String[]{"a","a","b","b","c","c","d"});
		findEquilibriumPoint(new int[]{-7, 1, 5, 2, -4, 3, 0});
		findAllLeaders(new int[]{16 ,17 ,4 ,3 ,5 ,2});
		findMinNumberOfPlatFormsReq(new int[]{900,940,950,1100, 1500, 1800}, new int[]{910,1200,1120,1130,1900,2000});
		reverseArrayInGroups(new int[]{1,2,3,4,5,6},3);
		findPythagoreanTriplet(new int[]{17,2,8,6,15});
		chocolateDistributionProblem(new int[]{3 ,4 ,1 ,9 ,56 ,7 ,9 ,12} , 5);
		form_largest_number_from_given_set_of_numbers(new int[]{54, 546, 548, 60});
		
		stock_buy_and_sell(new int[]{100,80,120,130,70,60,100,25});
		stock_buy_and_sell_multiple_times(new int[]{100,80,120,130,70,60,100,125});
		PetrolPumpData[] arr = {new AmazonArrayQuestions().new PetrolPumpData(4, 6), new AmazonArrayQuestions().new PetrolPumpData(6, 5), new AmazonArrayQuestions().new PetrolPumpData(7, 3) , new AmazonArrayQuestions().new PetrolPumpData(4, 5)}; 
		//circular_tour(arr);
		//find_kth_smallest_element_quick_sort(new int[]{3,5,1,2,6,9,7},4,0,6);
		search_in_a_rotated_array(new int[]{5 ,6 ,7 ,8 ,9 ,10 ,1 ,2 ,3},2);
		merge_two_sorted_arrays_in_place(new int[]{ 1, 4, 7, 8, 10 }, new int[]{ 2, 3, 9 });
		median_two_sorted_arrays(new int[]{1,4,5,6,8},new int[]{2,3,7});
		sort_array_0_1(new int[]{0,0,0});
		getMostVisited(10, new int[]{1,5,10,3});
		List<String> cmd =  new ArrayList<String>();
		cmd.add("GGGGR");
		cmd.add("RGL");
		System.out.println(doesCircleExist(cmd));
		List<Integer> prices = new ArrayList<Integer>();
		prices.add(5);
		prices.add(1);
				prices.add(3);
						prices.add(4);
								prices.add(6);
										prices.add(2);
		finalPrice(prices) ;
		beautiful_subarray(new int[]{2, 5, 4, 9},1);
		System.out.println( find_starting_index(new int[]{1,1,2,2,2,3,3,4} , 1));
		System.out.println( find_ending_index(new int[]{1,1,2,2,2,3,3,4} , 5      ));
		find_maximum_subsequence_sum(new int[]{1, 20, 3});
		move_all_zeros_maintain_relative_order(new int[]{0,1,0,3,12});
		find_no_of_witnesses(new int[]{3, 6, 3, 4, 1});
		minimum_size_subarray_sum(new int[]{7,7,7,7},7);
		non_decreasing_arr_single_modification(new int[]{13, 4, 1});
		sort_3_given_numbers(new int[]{3, 3, 2, 1, 3, 2, 1});
	}

}
