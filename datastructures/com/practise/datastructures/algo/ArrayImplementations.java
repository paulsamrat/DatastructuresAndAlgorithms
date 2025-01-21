package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.practise.datastructures.dp.DynamicProgramming;

public class ArrayImplementations {
	
	
	//count the  frequencies of elements in O(1) space and O(N) time.
	private static Map<Integer,Integer> getFrequencies(int[] inputArray)
	{
		return null;
		
	}
	
	//find two largest numbers from an unsorted array
	//O(N) TIME : O(1) SPACE
	private static String getTwoLargestNumbers(int[] inputArray)
	{
		int largest = Math.max(inputArray[0], inputArray[1]);
		int secondLargest = Math.min(inputArray[0] , inputArray[1]) ;
		
		for (int i=2  ; i < inputArray.length ; i++)
		{
			if (inputArray[i] > largest) {
				largest = inputArray[i];
				secondLargest = largest;
			}
			else if ( inputArray[i] > secondLargest) secondLargest = inputArray[i];
		}
		return " largest " + largest + " second largest " + secondLargest;
	}
	
	//find union and intersection of two given arrays
	private static String getUnionAndIntersection(int[] firstArray , int[] secondArray)
	{
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		Arrays.asList(firstArray);
		Set<Integer> hashSet = new HashSet<Integer>();
		//after making the set ,, put the elements of the set into a map with value count as 1
		//on traversing the second array , map the elements are present  in the map or not 
		//if yes increment the  corresponding value.
		
		//At last print the map , value greater than one.. are intersected 
		//intersected and remaining elements are unioned.
		return null;
	}
	
	//larger element comes after smaller element 
	//same algo will go for buying and selling stock only once. not multiple times.
	//sorted array
	private static int maximumDifference(int[] inputArray)
	{
		//naive approach
		int maxDiff = -1;
		//O(N2)
		/*for (int i=0 ;i < inputArray.length ; i++)
		{
			for ( int j=i+1 ;j < inputArray.length ; j++)
			{
				maxDiff = inputArray[j] - inputArray[i] > maxDiff ? inputArray[j] - inputArray[i] : maxDiff;
			}
		}*/
		//return maxDiff;
		
		//another
		//logic find the minimum element and subtract from the largest
		/*int minElement = inputArray[0];
		for (int i = 1 ; i < inputArray.length ; i++ )
		{
			maxDiff = inputArray[i] - minElement > maxDiff ?  inputArray[i] - minElement : maxDiff;
			minElement =  inputArray[i] < minElement ? inputArray[i] : minElement;
		}*/
		
		//return maxDiff;
		
		
		//another :larger element appears after smaller element
		//taking the diff between consecutive elements.
		
		//NOT TESTED.
		/*for( int i=0 ; i < inputArray.length -1 ; i++)
		{
			int maxDiffSoFar = inputArray[i+1] - inputArray[i];
			maxDiff = maxDiffSoFar > maxDiff ? maxDiffSoFar : maxDiff;
		}*/
		
		return maxDiff;
	}
	
	
	//Minimum insertions to form shortest palindrome -
	private static void shortestPalindrome(String str){
		// we will perform the LCSubsequence on the string str1 and reverse of the string rev(str1)
		//then deduct -- str1 -  lcs(str1 , rev(str1))
		//input string : ABAB 
		//LCS("ABAB" , "BABA") = ABA or BAB
		//length(ABAB) - length(ABA) = min of of transitions req to convert to shortest palindrome
		//also character to be added to convert to shortest palindrome is prefix or suffix of the second string after the LCS 
		StringBuilder sb = new StringBuilder(str).reverse();
		String temp = DynamicProgramming.longestCommonSubSequence(str,sb.toString());
		System.out.println(" NO. of smallest transitions req to convert " +  str + " to palindrome is " + (str.length() - temp.length()));
		//finding prefix or suffix
		
		System.out.println();
		
	}
		
	//finding the elements of the array are consecutive  or not. ex: 1-->2-->3-->4
	private static void isElementsConsequetive(int[] arrayToCheck)
	{
		//naive approach ... sorting the array using insertion sort . and then checking whether all elements are 1 position apart or not.
		
		//insertion sort
		
		for (int i=0 ;i<arrayToCheck.length-1;i++)
		{
			
			int j =i+1;
			int element = arrayToCheck[j];
			while ( j > 0  && element < arrayToCheck[j-1])
			{
				arrayToCheck[j] = arrayToCheck[j-1];
				j--;
			}
			arrayToCheck[j] = element;
			
		}
		
		System.out.println(" Elements Sorted by Insertion Sort");
		for (int i : arrayToCheck)
				System.out.print( " " + i + " --> " );
				
	  //once the array is sorted.
	}
	
	//Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array.
	//Write a function that returns true if array contains duplicates within k distance.
	
	/*Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
	Output: false
	All duplicates are more than k distance away.

	Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
	Output: true
	1 is repeated at distance 3.

	Input: k = 3, arr[] = {1, 2, 3, 4, 5}
	Output: false

	Input: k = 3, arr[] = {1, 2, 3, 4, 4}
	Output: true*/
	
	private static void isDuplicatesPlacedAtKDistance(int k, int arr[])
	{	
		//base case
		if ( k > arr.length) return;
		//using two loops naive approach . picking each element and running inner loop to match the picked item at the k-distance.
		//hashing.
		
		List<Integer> list = new ArrayList<Integer>();
		boolean isDuplicatesPlacedAtKDistance = false ;
		for (int i=0;i<arr.length;i++)
		{
			if (list.contains(arr[i]))
			{
				if (arr[i] == list.get(i-k)) isDuplicatesPlacedAtKDistance = true;
				else
					isDuplicatesPlacedAtKDistance = false;
			}
			else
				list.add(arr[i]);
		}
		
		if (isDuplicatesPlacedAtKDistance) 
			System.out.println(" \nDuplicates are placed at Kth Distance");
		else
			System.out.println(" \nDuplicates are not placed at Kth Distance");
	}
	
	
	//Given 2 arrays of numbers find if each of the two arrays have the same set of integers
	static void isSameSetOfIntegers(int[] array1 , int[] array2)
	{
		//we will perform xor on the elements of the both array to verify.
		// assuming both the arrays are of equal length.
		int result = 0 ;
		for (int i=0;i< array1.length;i++)
		{
			result += array1[i] ^ array2[i]; 
		}
		if ( result == 0) System.out.println("\n\nAll Elements are Same");
		else
			System.out.println("\n\nElements are diff. in both arrays");
		
		//also we  can use a map to put all elements from the first array into it  along with store their count. O(N)
		//then iterate through next array to c that elements exist in the map if yes decrement the value and at last all the elements should have count as ZERO.
	}
	
	/*
	 *  Find non repeating element in an array

		I have an array consisting of 2n+1 elements. n elements in it are married, i.e they occur twice in the array, 
		however there is one element which only appears once in the array. 
		I need to find that number in a single pass using constant memory. {assume all are positive numbers}
		Eg :- 3 4 1 3 1 7 2 2 4
		Ans:- 7
	 */
	static void findNonrepeatingElement(int[] array)
	{
		//using XOR.
		int element =0;
		for (int i=0;i<array.length;i++)
		{
			System.out.print("\nElement " + element +" after XOR ED with " + array[i] );
			element ^= array[i];
			System.out.println(" Result : " + element + "\n");
		}
		
		System.out.println("Non Repeated Element " + element);
	}

	//Finding intersection point i.e common elements between two SORTED arrays.

	static void findCommonElements(int[] array1, int[] array2)
	{
		int i=0; int j=0;
		System.out.println(" Find Common Elements: ");
		while ( i < array1.length && j < array2.length)
		{   

			//logic is if one element in one array is smaller / greater than another in the same index there is no point in looking at the same position.
			//We will always increment the index of the smaller element's array  so that it looks for some greater element in the larger array. 
			if ( array1[i]  > array2[j]) j++;
			else if ( array1[i] < array2[j]) i++;
			else{
				System.out.println( " Common Element's are  "  + array2[i]);
				i++;
				j++;
			}
		}
	}


	//We have two sorted arrays. 
	//Second array has sufficient space for merging first and second array elements. 
	//Without using additional space (memory) 
	static void mergeTwoArraysWithoutExtraSpace(int[] array1 , int[] array2)
	{
		//second array will have the sorted list fully.
		int i =0 ; int j=0; 
		System.out.println("Merging two arrays into one array ");
		//increasing the size of second array
		while( i < array1.length && j < 3)
		{
			if (array1[i] < array2[j])
			{
				int temp = array2[j];
				array2[j] = array1[i];
				array1[i] = temp;
				i++;j++;
			}
			else 
			{
				j++;
			};
		}
		
		//as there is  enough space currently filled with zero's we will copy values from first array and place it in second.
		for (int m = 0 ; m < array1.length ; m++)
		{
			array2[j] = array1[m];
			j++;
		}

		System.out.println("Merged and Sorted Array");
		for (int m :  array2)
		{
			System.out.print(m + " --> ");
		}
	}
	
	//Given an array containing just 0s and 1s sort it in place in one pass.
	
	static void sortInPlace(int[] arrayToSort)
	{
		System.out.println("\nSorting Starts : ");
		int beginIndex = 0 ; int endIndex = arrayToSort.length-1;
		
		while(beginIndex < endIndex)
		{
			if (arrayToSort[beginIndex] == arrayToSort[endIndex]) endIndex--;
			else if (arrayToSort[beginIndex] > arrayToSort[endIndex])
			{
				int temp = arrayToSort[beginIndex];
				arrayToSort[beginIndex] = arrayToSort[endIndex];
				arrayToSort[endIndex] = temp;
				
				beginIndex ++;
				endIndex --;
			}
			else
			{
				beginIndex++;
			}
		}
		System.out.println("Sorted Array : ");
		for (int i : arrayToSort)
		{
			System.out.print(i + " ---> ");
		}
	}
	public static void arrayReversal(int[] array){
		int beginIndex = 0 ; int endIndex = array.length - 1;
		// reversing in place.
		System.out.println(" \nArray before reversing");
		for ( int element : array){
			System.out.print(element + " -->");
		}
		while ( beginIndex != endIndex){
			int temp = array[beginIndex];
			array[beginIndex] = array[endIndex];
			array[endIndex] = temp;
			beginIndex ++;
			endIndex --;
		}
		System.out.println(" \nArray after reversing");
		for ( int element : array){
			System.out.print(element + " -->");
		}
	}
	
	//Watson gives two integers ( startN and endN) to Sherlock and 
	//asks if he can count the number of square integers between  and  (both inclusive).
	//binary search
	private static void findSqRtBetweenGivenNumbers(){
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for ( int i = 1 ; i <= testCases; i++){
			String str = sc.nextLine();
			String splitArray[] = str.split(" ");
			int startNumber =  Integer.parseInt(splitArray[0]);
			int endNumber = Integer.parseInt(splitArray[1]);
			int count = 0 ; 
			while (startNumber <= endNumber){
				if ( -1 != isSquareRoot(startNumber)) count++;
				startNumber++;
			}
			System.out.println(count);
		}
	}
	
	 public static int isSquareRoot(int inputNumber){
	        if ( inputNumber == 1 || inputNumber == 0 ) return inputNumber;
	        int startIdx = 1 ; int endIdx =  inputNumber / 2 ;
	        while ( startIdx <= endIdx){
	            int middle =   ( startIdx + endIdx ) / 2 ; 
	            if ( middle * middle  == inputNumber ) return middle;
	            if ( middle * middle < inputNumber) startIdx =  middle +1 ;
	            else endIdx = middle -1 ;
	        }
	        return -1;
	    }
		/*
		 * Implement an algorithm to determine if a string has all unique characters. What if
		   you cannot use additional data structures
		 */
		
		private static boolean isStringUnique(String str){
			//considering string as a ascii
			//0(1)     time complexity. // String can have 256 unique characters at max
			if (str.length() > 256) return false;
			boolean char_array[] = new boolean[256];
			for (char c : str.toCharArray()){
				int position = c;
				if (char_array[position]) return false;
				char_array[position] = true;
			}
			return true;
		}
		
		private static boolean isStringUniqueXOR(String str){
			if (str.length() > 256) return false;
			int result = 0;
			char c1[] = str.toCharArray();
			Arrays.sort(c1);
			for (char c : c1){
				 int ascii = c;
				 result ^=  ascii;
				 if (result == 0 )  return false;			 
			}
			return true;
		}
		
		/*
		 * Given two strings, write a method to decide if one is a permutation of the other.
		 * basically we will focus on anagram nature of the string.
		 */
		private static boolean isPermutedStrings(String str1, String str2){
			// Sorting both strings ... making sure strings are anagram.
			if (str1.length() != str2.length()) return false;
			char c1[] = str1.toCharArray();
			char c2[] = str2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			return str1.equals(str2);
			
			//Other way is to count the no. of characters and match between both strings
			/*int [] countarray = new int[256];
			//counting string 1
			for (char c :  str1.toCharArray()){
				countarray[c]++;
			}
			//verifying with string 2 .. if both the count of characters are equivalent
			for (int i=0; i< str2.length();i++){
				int loc =  str2.charAt(i);
				if (--countarray[loc] < 0 )
					return false;
			}
			return true;
			*/
		}
		/*
		 * Write a method to replace all spaces in a string with'%20'. You may assume that
				the string has sufficient space at the end of the string to hold the additional
				characters, and that you are given the "true" length of the string. (Note: if imple-
				menting in Java, please use a character array so that you can perform this opera-
				tion in place.)
				EXAMPLE  Input: "Mr John Smith 	Output: "Mr%20Dohn%20Smith"

		 */
		private static String replaceSpaces(String inputString){
			if (null ==  inputString || inputString.length() == 1 ) return inputString;
			StringBuilder sb = new StringBuilder();
			for (char c : inputString.toCharArray()){
				   if ("".equals(c)) sb.append("%20");
				   sb.append(c);
			}
			return sb.toString();
		}
		
		/*
		 * Implement a method to perform basic string compression using the counts
			of repeated characters. For example, the string aabcccccaaa would become
			a2blc5a3. If the "compressed" string would not become smaller than the orig-
			inal string, your method should return the original string.
		 */
		
		private static String compressString(String inputString){
			// initial checks
			if ( null == inputString) return inputString;
			StringBuilder sb = new StringBuilder();
			int count = 1;
			char last = inputString.charAt(0);
			for (int i=1;i< inputString.length();i++){
				if (last == inputString.charAt(i))
					++count;
				else{
					sb.append(last);
					sb.append(count);
					last = inputString.charAt(i);
					count = 1;
				}				
			}
			return sb.toString();
		}
		/*
		 * Given an image represented by an NxN matrix, where each pixel in the image is 4
		   bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
		 */
		
		 //todo
		
		/*
		 *  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
			column are set to 0.

		 */
		private static void setColumnAndRowToZero(int[][] matrix){
			 //lets assume the matrix is of size 3
			 //keeping track of the 0th element i.e row index and the column index
			 boolean[] rowIndex = new boolean[matrix.length];
			 boolean[] columnIndex = new boolean[matrix[0].length];
			 //scan the matrix and look for 0th element
			 for (int i=0;i<matrix.length;i++){
				 for (int j=0;i<matrix[0].length;j++){
					 if(matrix[i][j] == 0 )
					 {
						 rowIndex[i] = true;
						 columnIndex[j] = true;
					 }
				 }
			 }
			 
			 //setting corresponding row and column to zero
			 
			 for (int i=0;i<matrix.length;i++){
				 for (int j=0;i<matrix[0].length;j++){
					 if ( rowIndex[i] || columnIndex[j])
						 matrix[i][j] = 0 ;
				 }
			 }
		 }
		 
		 /*
		  * Assume you have a method isSubstring which checks if one word is a substring
			of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
			using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").

		  */
		private static boolean isRotationCompatible(String str1, String str2){
			// we first have to determine the rotation point . it cant be rotated at any point
			//example : lets assume xy =  waterbottle and x = wat and we rotate it on x axis ..
			//it can be rotated at any point but the fundamental aspect is if xy + xy ... then the rotated string will obviously be a substring of )xy+xy)
			if ( ( null == str1 || null == str2 ) && (str1.length() != str2.length())) return false;
			String concat =  str1 + str1;
			//return isSubstring(concat,str2);
			return true;
		}
	 //Detect if a subset from a given set of N non-negative integers sums upto a given value S.
	 //Set: {1, 3, 9, 2}, S = 5
	 public void isSubsetSumsUptoGivenNumber(int summation , Set<Integer> set){
		 
	 }
	 //Given an integer array and a number k, print the maximum sum subarray of size k
	 //sliding window technique
	 private static void maxSumSubArray(int arr[] , int subArraySize){
		 int maxSum = Integer.MIN_VALUE;
		 int startIndex = 0 ;
		 int tempSum = 0;
		 //first summing up sub array size array
		 for (int i = 0 ;  i < subArraySize ; i++)
			 		tempSum+=arr[i];
		 if ( tempSum >  maxSum)
		  		 maxSum = tempSum;
		 //sliding windows
		 for (int i =  subArraySize ; i < arr.length ; i++ ){
			  tempSum = tempSum + arr[i] - arr[i-subArraySize];
			  
			  if (tempSum > maxSum){
				   maxSum = tempSum;
				   startIndex = i-subArraySize+1;
			  }
		 }
		 System.out.println(" maximum sum sub array is " + maxSum);
		 System.out.println( " the sub array which corresponds to maximum sum is ");
		 for ( int i = startIndex ; i < startIndex+subArraySize ; i++)
			 	System.out.println(arr[i] + " -->");
	 }
	 //find-the-missing-number-in-the-increasing-sequence
	 // how can you find that missing number without traversing the sequence in linear fashion. 
	 private static void findMissingNoInLogN(int[] arr){
		 //binary search // given array is already sorted
		 int start = 0 ;
		 int end =  arr.length - 1;
		 while (start < end ){
			 if (start > end ) System.out.println(" input array is invalid");
			 int mid = (start + end) / 2;
			 //checking both left and right indexes of the array
			 // there must be n-1 numbers on the left side for a value arr[mid]
			 // we are counting the gaps between consecutive numbers
			 if ( arr[mid]  - arr[0] != mid) 
			 {
				 //then the missing no is on the left side
				 end = mid;
			 }
			 else if ( arr[arr.length-1] -  arr[mid] != mid){
				 //else on right side 
				 start = mid;
			 }
		 }
		 if (start == end ) System.out.println(" missing no.  is " +  (arr[end] - 1) );
	 }
	 
	 //find common elements  accross sorted arrays
	 public static void findCommon(int [] A, int [] B, int [] C){
			int i=0,j=0,k=0;
			while(i<A.length && j<B.length && k<C.length){
				if((A[i]==B[j])&& (B[j]==C[k])){
					System.out.print(A[i] + " ");
					i++;j++;k++;
				}else if((A[i]<=B[j])&& (A[i]<=C[k])){
					i++;
				}else if((B[j]<=A[i])&& (B[j]<=C[k])){
					j++;
				}else{
					k++;
				}
			}
		}
	 //Given an array of size n, find a peak element in the array. Peak element is the element which is greater than or equal to its neighbors.
	 //For example - In Array {1,4,3,6,7,5}, 4 and 7 are peak elements. We need to return any one peak element.
	 
	 public static void findPeakElement(int[] arr){
		 List<Integer> peakElements = new ArrayList<Integer>();
		 for (int i = 1 ; i < arr.length - 1; i++){
			 if (arr[i-1] < arr[i] && arr[i+1] < arr[i])
				 	peakElements.add(arr[i]);
		 }
		 System.out.println(peakElements);
	 }
	 
	 final static int[] offsets = {-1, 0, +1};

	 private static boolean neighborExists(int[][] matrix, int i, int j)
	 {
		 if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length))
		 {
			 if (matrix[i][j] == 1)
			 {
				 return true;
			 }
		 }

		 return false;
	 }

	 private static void doDFS(int[][] matrix, int i, int j, boolean[][] visited)
	 {
		 if (visited[i][j])
		 {
			 return;
		 }

		 // mark this vertex as visited and visit all its neighbors in depth first manner
		 visited[i][j] = true;

		 int xOffset, yOffset;
		 for (int l = 0; l < offsets.length; l++)
		 {
			 xOffset = offsets[l];
			 for (int m = 0; m < offsets.length; m++)
			 {
				 yOffset = offsets[m];

				 // do not consider vertex[i][j] as its own neighbor
				 if (xOffset == 0 && yOffset == 0)
				 {
					 continue;
				 }

				 // check if there exists a vertex at this offset and check if it is '1'
				 if (neighborExists(matrix, i + xOffset, j + yOffset))
				 {
					 doDFS(matrix, i + xOffset, j + yOffset, visited);
				 }
			 }
		 }
	 }


	 public static int findNumberofClusters(int[][] matrix)
	 {
		 // JVM initializes all values to false by default.
		 boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		 int count = 0;
		 for (int i = 0; i < matrix.length; i++)
		 {
			 for (int j = 0; j < matrix[0].length; j++)
			 {
				 if ((matrix[i][j] == 1) && (!visited[i][j]))
				 {
					 // vertex [i][j] marks start of new a cluster. DFS then visits all vertices of this cluster
					 count += 1;
					 doDFS(matrix, i, j, visited);
				 }
			 }
		 }
		 return count;
	 }

	 //Given a binary array, find the index of 0 such that when that 0 is replaced with 1 results in longest continuous sequence of 1's.
	 private static void replaceForLargestSequence(int[] arr){
		 
	 }
	 
	 //print matrix diagonally
	 
	 //Given an array of integers, print the leaders in the array. 
	 //A leader is an element which is larger than all the elements in the array to its right.
	 /*For example:
		 Input Array:
		 { 98, 23, 54, 12, 20, 7, 27 }
		 Output:
		 Leaders- 27 54 98
	 */
	 //Given an array A having positive and negative integers and a number k, 
	 //find the minimum length sub array of A with sum = k.
	 //dp
	 
	 /*
	  *  A sorted array has been rotated so that the elements might appear in the order 3456712. 
	  *  How would you find the minimum element? You may assume that the array has all unique elements.	
	  */
	 
	 // one solution : search for the minimum element but this does not  leverage the sorting advantage.
	 //binary search.
	 
	 public static int findMinimumInSortedRotatedArray(int[] inpArray){
		 int  start =  0;
		 int  end =  inpArray.length - 1 ;
		 
		 while ( start <= end ){
			 
			 int middle =  ( start + end ) / 2 ;
			 if ( inpArray[middle] < inpArray[middle - 1] && inpArray[middle] < inpArray[middle + 1]) return inpArray[middle];
			 else if ( inpArray[middle] >  inpArray[end]) // this means the minimum element is on the left hand side
				 start = middle + 1;
			 else 
				 end =  middle - 1;
		 }
		 return -1;
	 }
	 /*
	 In an array, which consists of N elements, A1, A2, ..., AN, 
	 if a subarray has the total number of distinct elements as that of the original array
	 */
	 
	 //https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/the-normal-type/
	public static void findSubArrayCountHavingUniqueElements(String str) {

		String[] splitA = str.split(" ");
		int totalUniqueElements = 0;
		int countOfDistinctElements = 0;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < splitA.length; i++) {

			for (int j = splitA.length - 1; j >= i; j--) {

				for (int k = i; k <= j; k++) {
					set.add(splitA[k]);
				}
				if (i == 0 && j == splitA.length - 1) {
					totalUniqueElements = set.size();
					++countOfDistinctElements;
				} else if (totalUniqueElements == set.size())
					++countOfDistinctElements;

			}
			set.clear();
		}

		System.out.println(countOfDistinctElements);

	}
	//kadane's algo
	public static void maxSumContiguousArray(int[] inputArray){
		int maxSoFar = 0 ;
		int maxEndingHere = 0 ;
		int startIdx = 0 ;
		int endIdx =  0;
		//valid only if the contiguous segment is positive 
		for ( int i = 0 ; i < inputArray.length ; i++){
			maxEndingHere+= inputArray[i];
			if (maxEndingHere < 0 ){
				maxEndingHere = 0;
				startIdx = i+1;
			}
			if (maxSoFar < maxEndingHere){
				maxSoFar = maxEndingHere;
				endIdx = i;
			}
		}		
		System.out.println(" Max Sum Of Contiguous Array is " + maxSoFar + " taking elements from index " + startIdx + " to "  + endIdx );
		
		//valid even if the contiguous segment is negative or all numbers are negative 
		//DP
		int maxSoFar1 = inputArray[0];
		int maxEndingHere1 = inputArray[0];
		for ( int i = 1 ; i <  inputArray.length; i++){
			maxEndingHere1 = Math.max(inputArray[i], maxEndingHere1 + inputArray[i]);
			maxSoFar1 = Math.max(maxSoFar1, maxEndingHere1);
		}
		
		System.out.println(" Max Sum Of Contiguous Array is Dynamic Programming " + maxSoFar1);
	}
	
	//Given an unsorted array of integers, find a contiguous  subarray which adds to a given number.
	//If there are more than one subarrays with sum as the given number, print any of them.
	
	
	
	 //Write a program to print the  maximum sum subsequence of the given array such that the integers 
	 //in the subsequence are sorted in increasing order.
	
	public static void findMaxSumSubSequence(int[] array){
		
		int maxSumSubSequence = 0 ;
		int tempSum  = 0 ;
		List<Integer> tempList =  new ArrayList<Integer>();
		StringBuffer sb = new StringBuffer();
		//generate all subsequences using bit 
		int noOfSets = (int) Math.pow(2, array.length) 	; // including empty set
		for (int i = 1 ; i <= noOfSets ; i++){
			//check each bit 
//			for (int j = 0 ; j < array.length ; j++){
//				if (BigInteger.valueOf(i).testBit(j) )
//				{
//					if (array[j] > tempArray[])
//						tempArray
//					//sb.append(array[j]).append(",");
//				}
//			}
//			
//			listOfSubSequences.add(sb.toString());
//			sb.setLength(0);
		}	
	}
	
	
	//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
	private static void findMaximumOfAllSubarraysOfSizek(final int[] array , final int k)
	{	
		if ( null == array || array.length == 0) return;
		//sliding window
		int maxOfCurrentSubArray = array[0] ;
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1 ; i < k ; i++)
		{
			if (array[i] > maxOfCurrentSubArray) maxOfCurrentSubArray = array[i];
		}
		list.add(maxOfCurrentSubArray);
		for (int i = k ; i < array.length ; i++)
		{
			maxOfCurrentSubArray =  array[i] > maxOfCurrentSubArray ?  array[i] : maxOfCurrentSubArray;
			list.add(maxOfCurrentSubArray);
		}
		System.out.println("\nfindMaximumOfAllSubarraysOfSizek : " + k + " is : " + list);
	}
	
	
	 /*
	  * A magic index in an arrayA[l...n-l] is defined to be an index such thatA[i] = i. 
	  * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
	  */
	
	/*
	 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. 
	 * For example, if left rotations are performed on array , then the array would become .
	 */
	
	//first non repeating character
	public static void firstNonRepeatingCharacter(String inputString)
	{
		//using count array technique
		int[] countArray =  new int[256];
		for (char c : inputString.toCharArray())
		{
			++countArray[c];
		}
		//iterate and find the first slot with count = 1
		for (int i =  0 ; i < countArray.length ; i++)
		{
			if (countArray[i] == 1) 
			{
				System.out.println( "first non repeating character " + (char)i);
				break;
			}
		}
		//hash map  approach
		// we will store the count of the character as well the index where it occured
		class CountIndex
		{
			private int index;
			private int count;
			
			private CountIndex(int index , int count)
			{
				this.index = index;
				this.count = count;
			}
			private void setCount(int newCount)
			{
				this.count = newCount;
			}
		}
		
		//read the characters and store it in hash map
		Map<Character,CountIndex> hMap = new HashMap<Character, CountIndex>();
		for (int i = 0 ; i < inputString.length() ; i++)
		{	
			char c = inputString.charAt(i);
			if (hMap.containsKey(c))
			{	
				CountIndex ci = hMap.get(c);
				ci.setCount(++ci.count);
				hMap.put(c,ci);
			}
			else
			{
				hMap.put(c, new CountIndex(i, 1));
			}
		}
		
		//iterate
		int firstNonRepeatingCharIdx = Integer.MAX_VALUE;
		char firstNonRepeatingChar = ' ';
		for (Character c1 : hMap.keySet())
		{
			if (hMap.get(c1).count == 1 && hMap.get(c1).index < firstNonRepeatingCharIdx)
			{
				firstNonRepeatingChar = c1;
				firstNonRepeatingCharIdx = hMap.get(c1).index;
			}
		}
		System.out.println("first non repeating character through hash map is : " + firstNonRepeatingChar);
		
		//linked hash map approach maintains the insertion order 
		// so if the unique character is at first half no need to iterate through whole map
		// and no need of maintaining the index as  we are looking for first unique char 
		
		Map<Character,Integer> linkedHMap =  new LinkedHashMap<Character,Integer>();
		for (int i = 0 ; i < inputString.length() ; i++)
		{	
			char c = inputString.charAt(i);
			if (linkedHMap.containsKey(c))
			{	
				linkedHMap.put(c,linkedHMap.get(c)+1);
			}
			else
			{
				linkedHMap.put(c,1);
			}
		}
		char firstNonRepeatingChar1 = ' ';
//		for(Character c  : linkedHMap.keySet())
//		{
//			CountIndex ci = linkedHMap.get(c);
//			if (ci.count == 1)
//		}
		
		
	}
	public static void leftRotateArray(int[] inputArray , int leftRotations){
		int[] rightPart = Arrays.copyOfRange(inputArray, 0, leftRotations);
		for ( int i = leftRotations ; i < inputArray.length ; i++)
		{
			System.out.print(inputArray[i] + " ");
		}
		for(int a : rightPart)
		{
			System.out.print(a + " ");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTwoLargestNumbers(new int[]{5,4,3}));
		System.out.println(" Maximum Difference " + maximumDifference(new int[]{1,5,2,7}));
		
		isElementsConsequetive(new int[]{5,4,3,2,1,8});
		isDuplicatesPlacedAtKDistance(1, new int[]{1, 2, 3, 1, 4, 5});
		isSameSetOfIntegers(new int[]{1,2,3}, new int[]{1,-1,3});
		findNonrepeatingElement(new int[]{1,2,3,4,1,2,3,});
		findCommonElements(new int[]{1,2,3},new int[]{1,2,5,3} );
		mergeTwoArraysWithoutExtraSpace(new int[]{-1,1,2} , new int[]{-2,4,7,0,0,0});
		sortInPlace(new int[]{1,0,1,0,0,1,1,0} );
		arrayReversal(new int[]{1,2,3,4,5});
		findSqRtBetweenGivenNumbers();
		shortestPalindrome("ABAB");
		System.out.println(isStringUniqueXOR("samrats") ? "String is unique" : "String is not unique");
		System.out.println("String Compressed " + compressString("ssaamrat"));
		System.out.println(isPermutedStrings("dog","god"));
		setColumnAndRowToZero(new int[][]{new int[]{1,2,3},new int[]{4,5,6}});
		maxSumSubArray(new int[]{11,-8,16,-7,24,-2,3},3);
		findMissingNoInLogN(new int[]{1,2,4,5,6,7,8});
		findCommon(new int []{1,2,3,4,5,6,7,8,9,10}, new int[]{1,3,5,6,7,8,12},new int[]{2,3,4,5,8,9});
		findPeakElement(new int[]{1,4,3,6,7,5});
		 int[][] matrix = {
                 {1, 0, 1, 0, 1},
                 {1, 1, 0, 0, 0},
                 {0, 1, 0, 1, 1},
              };
		 System.out.println(findNumberofClusters(matrix));
		
		System.out.println("minimum element in sorted rotated array is : " + 
		findMinimumInSortedRotatedArray(new int[]{10,11,12,13,-10,-1,0,1,2,3,4,5,6,7}));
		findSubArrayCountHavingUniqueElements("1 2 2 1 1");
		maxSumContiguousArray(new int[]{1,2,3,-2,5});
		findMaxSumSubSequence(new int[] {1,101,2});
		leftRotateArray(new int[]{1,2,3,4,5,6},6);
		firstNonRepeatingCharacter("geeksforgeeks");
		
		findMaximumOfAllSubarraysOfSizek(new int[]{8 ,5 ,10 ,7 ,9 ,4 ,15 ,12 ,90 ,13} , 4);
		
	}


}
