package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AmazonHashingQuestions {
	
	/*
	 * Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.

		Note: Expected time complexity is O(N log(N)).
		
		Input:
		First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.
		
		Output:
		Print the relatively sorted array.
		
		Constraints:
		1 ≤ T ≤ 100
		1 ≤ N,M  ≤ 106
		1 ≤ A1[], A2[] <= 106
		
		Example:
		Input:
		1
		11 4
		2 1 2 5 7 1 9 3 6 8 8
		2 1 8 3
		
		Output:
		2 2 1 1 8 8 3 5 6 7 9
	 */
	
	private void relative_sorting(final int[] arr1 , final int[] arr2)
	{	
		System.out.println( " -- relative sorting -- ");
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int element : arr2) map.put(element, 0);
		for (int element : arr1)
		{
			if (map.containsKey(element))
				map.put(element, map.get(element)+1);
			else
				map.put(element, 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{	
			int key = entry.getKey();
			int value = entry.getValue();
			while(value != 0)
			{
				System.out.print(key + " ");
				--value;
			}
		}
		System.out.println();
	}
	/*
	 * Given an array A[] of integers, sort the array according to frequency of elements.
	 * That is elements that have higher frequency come first. 
	 * If frequencies of two elements are same, then smaller number comes first.
	 * Input:
			
		5
		5 5 4 6 4
		5
		9 9 9 2 5
		
		Output:
		4 4 5 5 6
		9 9 9 2 5				
	 */
	private void sorting_elements_by_frequency(final int[] arr)
	{
		System.out.println(" -- sorting_elements_by_frequency -- ");
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int element : arr)
		{
			map.put(element, map.getOrDefault(element, 0) + 1);
		}
		// Sort the map
		List<Map.Entry<Integer,Integer>> entryList = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer,Integer>>(){
			
			// elements that have higher frequency come first. 
			//If frequencies of two elements are same, then smaller number comes first.
			@Override
			public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
				 if ( entry1.getValue() != entry2.getValue())
					 return entry2.getValue() - entry1.getValue();
				 else
					 return entry1.getKey() - entry2.getKey();
			}
			
		});
		
		for (Map.Entry<Integer,Integer> entry : entryList)
		{
			int key = entry.getKey();
			int value = entry.getValue();
			while(value != 0)
			{
				System.out.print(key + " ");
				--value;
			}
		}
		System.out.println();
	}
	
	private void largest_subarray_0_sum(final int[] arr)
	{
		System.out.println( " -- largest_subarray_0_sum -- " );
		Map<Integer,Integer>  map = new HashMap<Integer,Integer>();
		int sum = 0 ;
		int largestSubArrayLength = Integer.MIN_VALUE;
		map.put(0,-1); //**[-1,0,1] .this should print '3'
		for (int i = 0 ; i < arr.length ; i++)
		{	
			//if (arr[i]==0 && largestSubArrayLength==0) 
				//largestSubArrayLength = 1; 
			sum+=arr[i];
			if (map.containsKey(sum))
			{
				largestSubArrayLength = Math.max(largestSubArrayLength,i - map.get(sum));
			}
			else
				map.put(sum, i);
		}
		System.out.println(largestSubArrayLength==Integer.MIN_VALUE ? 0 : largestSubArrayLength);
	}
	
	private void print_common_elements(final int[] arr1 , final int[] arr2 , final int[] arr3)
	{
		System.out.println(" -- print_common_elements -- ");
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int element :  arr1)
			 map.put(element, map.getOrDefault(element, 0)+1);
		for (int element :  arr2)
			 map.put(element, map.getOrDefault(element, 0)+1);
		for (int element :  arr3)
			 map.put(element, map.getOrDefault(element, 0)+1);
		//print element whose count is 3
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if (entry.getValue() == 3) System.out.print(entry.getKey() + " ");
		}
		System.out.println();
	}
	//https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers/0
	private void find_all_4_numbers_which_sums_to_the_given_number(final int[] arr , final int sumToFind)
	{
		System.out.println(" -- find_all_4_numbers -- ");
		//store sums in pairs and look for the difference in map
		Map<Integer,String> map = new HashMap<Integer, String>();
		int sum = 0 ;
		for (int i=0 ; i < arr.length ; i++ )
		{
			for (int j = i+1; j < arr.length ; j++)
			{
				sum = arr[i] +arr[j];
				if (map.containsKey(sumToFind-sum))
				{
					String[] indices = map.get(sumToFind-sum).split(",");
					int idx1 = Integer.parseInt(indices[0]);
					int idx2 = Integer.parseInt(indices[1]);
					if (idx1 != i && idx1 != j && idx2 != i && idx2 != j)
					{
						System.out.print( arr[i] + " " + arr[j] + " " + arr[idx1] + " " + arr[idx2]);
						System.out.print("$");
					}
					
				}
				else
				{
					 map.put(sum, i+"," + j);
				}
			}
		}
		
		System.out.println();
	}
	//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
	private void count_distinct_elements_in_every_window(final int[] arr , final int windowSize)
	{
		int[] count =  new int[100];
		int countOfDistinctElements = 0 ;
		System.out.println( " -- count_distinct_elements_in_every_window -- ");
		for (int i = 0 ; i < windowSize ; i++)
		{
			count[arr[i]]++;
			if (count[arr[i]] == 1 )countOfDistinctElements++;
		}
		System.out.print(countOfDistinctElements + " ");
		for (int i = windowSize ; i < arr.length ; i++)
		{
			count[arr[i]]++;
			if (count[arr[i]]  == 1 ) ++countOfDistinctElements; // did we add an unique element
			count[arr[i-windowSize]]--;
			if (count[arr[i-windowSize]]  == 0 ) --countOfDistinctElements; // did we removed an unique element
			System.out.print(countOfDistinctElements + " ");
		}
		
	}
	
	//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0
	//Given an array of integers and a number k, write a function that returns true if 
	//given array can be divided into pairs such that sum of every pair is divisible by k.
	private void Array_Pair_Sum_Divisibility_Problem(int[] arr ,  int k)
	{	
		System.out.println( " -- Array_Pair_Sum_Divisibility_Problem --  ");
		 Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		 int n = arr.length;
		 if(n%2==1)
	     {
	         System.out.println("False");
	         //continue st;
	     }
	     for(int i=0;i<n;i++)
	     {
	         if(hmap.containsKey(arr[i]%k))
	        	 hmap.put(arr[i]%k,hmap.get(arr[i]%k)+1);
	        else
	        	hmap.put(arr[i]%k,1);
	     }
	     for(int i=0;i<n;i++)
	     {
	    	 int rem=arr[i]%k;
	    	 if(rem==0 || 2*rem==k)
	    	 { 
	    		 if(hmap.get(rem)%2==1)
	    	 	{
	    		 System.out.println("False");
	    		 //continue st;
	    	 	}	
	    	 }
	    	 else if(hmap.get(rem)!=hmap.get(k-rem))
	    	 {
	    		 System.out.println("False");
	    		 //continue st;
	    	 }
	     }
	  System.out.println("True");
	
	}
	//https://www.youtube.com/watch?v=bgx1eAgBgaQ
	//Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. T
	//he converted array should be in form a < b > c < d > e < f. 
	//The relative order of elements is same in the output i.e you have to iterate on the original array only.
	private void convert_an_array_into_zig_zag_array(int[] arr)
	{	
		System.out.println( " -- convert_an_array_into_zig_zag_array --  " );
		boolean flag = false; //where false is <
		boolean toSwap = false;
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (!flag && arr[i-1] > arr[i])
				toSwap = true;
			else if (flag && arr[i-1] < arr[i])
				toSwap = true;
			if (toSwap)
			{
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				toSwap = false;
			}
			flag = !flag;
		}
		System.out.println(Arrays.toString(arr));
	}
	private void longest_consecutive_subsequence(final int[] arr)
	{
		
		Arrays.sort(arr);
		//all elements are sorted by now
		// iterate through sorted array and look for  longest_consecutive_subsequence 
		int prevElement = arr[0];
		int  longestLength = Integer.MIN_VALUE;
		int tempLongest = 1 ;
		for (int i =  1 ; i < arr.length ; i++)
		{
			//is the current element the very next element of the prev element
			if ((prevElement + 1 ) == arr[i]) 
				++tempLongest;
			else
			{
				longestLength = Math.max(tempLongest, longestLength);
				tempLongest = 1;
			}
			prevElement = arr[i];
		}
		longestLength = Math.max(tempLongest, longestLength); // if after considering last element . we get the longest length
		System.out.println();
		System.out.println( " -- longest_consecutive_subsequence -- " );
		System.out.println(longestLength);
		longest_consecutive_subsequence_hashing(arr);
	}
	
	private void longest_consecutive_subsequence_hashing(final int[] arr)
	{
		
		//put all elements to hashset
		Set<Integer> set = new HashSet<Integer>();
		for (int element : arr) set.add(element);
		int  longestLength = Integer.MIN_VALUE;
		// check each possible sequence from the start 
        // then update optimal length 
        for (int i=0; i<arr.length; ++i) 
        { 
            // if current element is the starting 
            // element of a sequence 
            if (!set.contains(arr[i]-1)) 
            { 
                // Then check for next elements in the 
                // sequence 
                int j = arr[i]; 
                while (set.contains(j)) 
                    j++; 
  
                // update  optimal length if this length 
                // is more 
                if (longestLength<j-arr[i]) 
                	longestLength = j-arr[i]; 
            } 
        } 
		System.out.println( " -- longest_consecutive_subsequence_hashing -- " );
		System.out.println(longestLength);
	}
	//https://practice.geeksforgeeks.org/problems/find-first-repeated-character/0
	//Given a string S. The task is to find the first repeated character in it. 
	//We need to find the character that occurs more than once and whose index of first occurrence is smallest. S contains only lowercase letters.
	private void find_first_repeated_character(final String str)
	{	
		System.out.println(" -- find_first_repeated_character -- ");
		int[] count = new int[26];
		for (char c : str.toCharArray())
		{
			count[c-'a']++;
			if (count[c-'a'] > 1) {System.out.println(c); break;}
		}
		
	}
	//Find a pair of elements swapping which makes sum of two arrays same
	private void pair_after_swapping_makes_two_arrays_same_sum(final int[] arr1 , final int[] arr2)
	{	
		System.out.println(" -- pair_after_swapping_makes_two_arrays_same_sum -- ");
		//calculate sum of both arrays
		int sum1=0,sum2=0;
		Set<Integer> set = new HashSet<Integer>();
		for (int element : arr1) sum1+=element;
		for (int element : arr2) sum2+=element;
		int diff = Math.abs(sum1-sum2)/2; // so both arrays will have to make up this diff. by swapping 
		//iterate through larger sum array . not necessarily
		//keep all elements of larger array in hash set
		if (sum1 > sum2)
		{
			for (int element : arr1) set.add(element);
		}
		else
		{
		for (int element : arr2) set.add(element);
		int[] smallerArr = sum1 > sum2 ? arr2:arr1;
		for (int element : smallerArr)
		{
			if (set.contains(element+diff))
			{
				System.out.print(element + "," + (element+diff) + " ");
				break;
			}
		}
		
		}
	}
	//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0
	//You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0
	private void total_count_of_subarrays_having_zero_sum(final int[] arr)
	{
		int sum  = 0 ;
		Map<Integer,Integer> hs = new HashMap<Integer,Integer>();
		hs.put(0,1) ; // in case whole array adds up to zero sum
		int res = 0;
		    for(int i = 0; i < arr.length; i++) {
		        sum += arr[i];
		        if(hs.containsKey(sum)) {
		            res += hs.get(sum);
		            hs.put(sum,hs.get(sum) + 1);
		        }
		        else {
		            hs.put(sum,1);
		        }
		    }
		
		System.out.println();
		System.out.println(" -- total_count_of_subarrays_having_zero_sum -- ");
		System.out.println(res);
	}
	//https://practice.geeksforgeeks.org/problems/check-frequencies/0
	//Given a string s which contains lower alphabetic characters, the task is to check if its possible to remove at most one character 
	//from this string in such a way that frequency of each distinct character becomes same in the string.
//	Input:
//		2
//		xyyz
//		xxxxyyzz
//
//		Output:
//		1
//		0
	private void check_if_frequencies_can_be_equal(final String str)
	{	
		System.out.println( " -- check_if_frequencies_can_be_equal -- ");
		int highestFreqTillNow = 0 ;
		char charHavingHighestFreq = ' ';
		int[] freqCount = new int[26];
		for (char c : str.toCharArray())
		{
			freqCount[c-'a']++;
			if (freqCount[c-'a'] > highestFreqTillNow)
			{
				highestFreqTillNow = freqCount[c-'a'];
				charHavingHighestFreq = c;
			}
		}
		// as we are allowed to remove at most one character // lets remove it from highest freq char
		freqCount[charHavingHighestFreq-'a']--;
		highestFreqTillNow--;
		//iterate through freq count array . all elements should have same freq if not error
		boolean flag = Boolean.TRUE;
		for (int i = 0 ; i < 26 ; i++)
		{
			if (freqCount[i] != 0 && (freqCount[i] != highestFreqTillNow)) { flag = Boolean.FALSE ; break;}
		}
		System.out.println( flag ? "Possible" : " Not Possible");
	}
	
	//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
	private void count_the_triplets(int[] arr)
	{
		Map<Integer,String> map = new HashMap<Integer, String>();
		// consider all double's - ON2
		//search for double addition in hashmap
		
		//also
		//sort the array
		//consider  all double's (addition) and use binary search to find the corresponding element 
	}
	//University Career Fair
	// like train station problem
	private void maxEvents(List<Integer> arrival, List<Integer> duration)
	{
		//sort all arrivals w.hMapr.t to duration
//		Map<Integer,StringBuilder>  linkedHMap= new LinkedHashMap<Integer, StringBuilder>();
//		for (int i = 0 ; i < arrival.size() ; i++)
//		{
//			if (linkedHMap.containsKey(arrival.get(i)))
//				linkedHMap.put(arrival.get(i), linkedHMap.get(arrival.get(i)).append(duration.get(i)));
//			else
//				linkedHMap.put(arrival.get(i), new StringBuilder().append(duration.get(i)));
//		}
//		//sort the arrival times w.r.t duration of stay
//		for (Map.Entry<Integer,StringBuilder> entry : linkedHMap.entrySet() )
//		{
//			entry.getValue();
//		}
		
		for(int i = 0 ; i < arrival.size();)
		{
			//Queue<>
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonHashingQuestions obj = new AmazonHashingQuestions();
		
		obj.relative_sorting(new int[]{2,1,2,5,7,1,9,3,6,8,8}, new int[]{2,1,8,3});
		obj.sorting_elements_by_frequency(new int[]{9,9,9,2,5});
		obj.largest_subarray_0_sum(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
		obj.print_common_elements(new int[]{1,5,10,20,40,80},new int[]{6,7,20,80,100} , new int[]{3,4,15,20,30,70,80,120});
		obj.find_all_4_numbers_which_sums_to_the_given_number(new int[]{ 2, 7, 4, 0, 9, 5,1, 3},20);
		obj.count_distinct_elements_in_every_window(new int[]{4,1,1},2);
		obj.longest_consecutive_subsequence(new int[]{1, 9, 3, 10, 4, 20, 2});
		obj.find_first_repeated_character("hellogeeks");
		obj.pair_after_swapping_makes_two_arrays_same_sum(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
		obj.total_count_of_subarrays_having_zero_sum(new int[]{6  ,-1 ,-3 ,4 ,-2 ,2 ,4 ,6 ,-12 ,-7});
		obj.check_if_frequencies_can_be_equal("xxxxyyzz");
		obj.Array_Pair_Sum_Divisibility_Problem(new int[]{9,7,5,3}, 6);
		obj.convert_an_array_into_zig_zag_array(new int[]{4,3,7,8,6,2,1});
	}

}
