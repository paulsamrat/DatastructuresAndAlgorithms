package com.practise.datastructures.dp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class DynamicProgramming {
	/*
	 * Objec­tive: Given a rod of length n inches and a table of prices pi, i=1,2,…,n,
	 * write an algo­rithm to find the max­i­mum rev­enue  obtain­able by cut­ting up the rod and sell­ing the pieces.
	 * Given: Rod lengths are inte­gers and For i=1,2,…,n we know the price pi of a rod of length i inches

		Exam­ple:
		
		Length	1	2	3	4	5	6	7	8	9	10
		Price	1	5	8	9	10	17	17	20	24	30
	 */
	//https://www.youtube.com/watch?v=ElFrskby_7M
	private static int maximumRevRodCutting(int[]price,int length){
		int[] solution = new int[length+1];
		solution[0] = 0 ;
		for (int i = 1 ; i <= length ; i++){
			  //possible cuts
		      //int maxTillNow = Integer.MIN_VALUE;
			  for (int k = 1 ; k <= i ; k++){
				  //maxTillNow = Math.max(maxTillNow,price[k]+solution[i-k]);
				  solution[i] = Math.max(solution[i], solution[i-k]+price[k]);
			  }
			  //solution[i] = maxTillNow;

		}
		return solution[length];
	}
	
	/*
	 * Given a rope of length n meters, write an algo­rithm to cut the rope in such a way
	 * 	that prod­uct of dif­fer­ent lengths of rope is max­i­mum. At least one cut has to be made.
	 */
	private static int cutRopeToObtainMaximumProduct(int ropeLength){
		int solution[] = new int[ropeLength+1];
		solution[0] = 1 ;
		//we will start cutting the rope from  length ---  1 -->ropelength
		// will figure  out the optimal revenue in each cut
		for (int i = 1 ; i <= ropeLength ; i++){
		    int maxTillNow = Integer.MIN_VALUE;
			for (int k=1; k<=i; k++){
				maxTillNow = Math.max(maxTillNow,k * solution[i-k]);
			 }
			solution[i] = maxTillNow;
		}
		return solution[ropeLength];
	}
	
	private static int cutRopeToObtainMaximumProduct_1(int ropeCutLength)
	{
		int solution[] = new int[ropeCutLength+1];
		solution[0] = 0 ;
		solution[1] = 1 ;
		solution[2] = 2 ;
		solution[3] = 3 ;
		
		for ( int i = 4 ; i <= ropeCutLength ; i++)
		{
			 int maxTillNow = Integer.MIN_VALUE;
			 for (int k=1; k<i; k++){
					maxTillNow = Math.max(maxTillNow,(i-k) * solution[k]);
			  }
			 solution[i] = maxTillNow;
		}
		return solution[ropeCutLength];
	}
	//http://www.ideserve.co.in/learn/set-partition-problem-dynamic-programming
	private boolean partitionPossible(int requiredSum, int[] set)
	{
		boolean[][] solution = new boolean[requiredSum + 1][set.length + 1];
		int numRows = requiredSum + 1, numCols = set.length + 1;
	    //All elements in 0th row are initialized to 'true' because for any given set, we can always find an empty subset with sum = '0'
		for (int j = 0; j < numCols; j++)
		{
			solution[0][j] = true;
		}
		//All elements in 0th column except the element in the 0th row are initialized to 'false' since no sum except 0 could be obtained by any subset of the empty set({}).
		for (int i = 1; i < numRows; i++)		
			solution[i][0] = false;
		/*Rules for filling up solution[i][j]:
			1. If solution[i][j-1] is 'true' then solution[i][j] is also 'true'. 
			This is because if there exists a subset(with sum = 'i') of set formed by first 'j-1' elements(of given set) 
			then that same subset will also be a subset for the set formed by first 'j' elements.

			2. If solution[i][j-1] is 'true' then solution[(i + set[j-1])][j] is also 'true'. 
			This is because if there exists a subset(with sum = 'i') of set formed by first 'j-1' elements(of given set) 
			then inserting 'j'th element into that subset results in a new subset which will have sum = 'i' + value of 'j'th element.
			 This sum is represented by the row = 'i + set[j-1]'. 
			 Remember indexing scheme used here is 0 based and therefore value of 'j'th element is represented by set[j-1].

			3. If solution[i][j] is not set to 'true' using above two rules then set solution[i][j] to 'false'. 
			Because there is no other case other than above two cases in which solution[i][j] would be 'true'.*/


		for (int j = 1; j < numCols; j++)
		{
			for (int i = 0; i < numRows; i++)
			{
				if (solution[i][j-1] == true)
				{
					solution[i][j] = true;
					if (((i + set[j-1]) < numRows))
					{
						solution[(i + set[j-1])][j] = true;
					}
				}
				else if (solution[i][j] != true)
				{
					solution[i][j] = false;
				}

			}
		}
		return solution[numRows-1][numCols-1];
	}

	public boolean partitionExists(int[] set)
	{
		int sum = 0;
		for (int i = 0; i < set.length; i++)
				sum += set[i];
		if ((sum % 2) != 0)
			return false;
		return partitionPossible(sum/2, set);
	}
	
	
	//Given an infinite supply of coins of values: {C1, C2, ..., Cn} and a sum. 
	//Find minimum number of coins that can represent the sum.
	public static int getMinCoinsDP(int[] values, int sum) {
		int min = 0;
		int[] minCoins = new int[sum+1];        
		minCoins[0] = 0;
		for(int i = 1; i <= sum; i++) {
			min = Integer.MAX_VALUE;
			for(int j = 0; j < values.length; j++) {
				if(i >= values[j])
					min = Math.min(min, minCoins[i - values[j]]);
			}
			if(min != Integer.MAX_VALUE)
				minCoins[i] = min + 1;
			else
				minCoins[i] = Integer.MAX_VALUE;
		}
		return minCoins[sum];
	} 
	//find minimum number of jumps to reach end.k
	//https://www.youtube.com/watch?v=cETfFsSTGJI
	private static int findMinimumNoOfJumpsToReachEnd( boolean isRecursive , int[] inputArray, int result[])
	{
		//Dynamic Approach.
		int[]jump = new int[inputArray.length];
		int[]jumpPos = new int[inputArray.length]; 
        jump[0] = 0;
        for(int i=1; i < inputArray.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        
        for(int i=1; i < inputArray.length; i++){
            for(int j=0; j < i; j++){
                if(inputArray[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        //result[i] = j;
                        jump[i] = jump[j] + 1;
                        jumpPos[i] = j; //at last just see the indicess for back tracking  -- here 0,1,4,5,9
                    }
                	//Math.min(jump[i], jump[j]+1)
                }
            }
        }
        
        return jump[jump.length-1];
        
       }
	
	//shortest path from source to destination. //Minimum cost path from source to destination.
	//cordinates to reach
	private static int minCostPath( boolean isRecursive, int[][] pathGraph , int xCoordinates, int yCoordinates)
	{
		if (isRecursive){
			//Recursive.
			if ( xCoordinates == 0 && yCoordinates==0) return pathGraph[xCoordinates][yCoordinates];
			else if (xCoordinates < 0 || yCoordinates < 0 ) return Integer.MAX_VALUE;
			else
				return pathGraph[xCoordinates][yCoordinates] +
						minimum(minCostPath(true,pathGraph,xCoordinates-1,yCoordinates-1), 
								minCostPath(true,pathGraph,xCoordinates,yCoordinates-1),
								minCostPath(true,pathGraph,xCoordinates-1,yCoordinates));
		}
		else
		{
			//Dynamic Programming
			//http://algorithms.tutorialhorizon.com/dynamic-programming-minimum-cost-path-problem/
			//Taking a cost array .. the desired location of which will yield the lowest path.
			//At every cell, we have two options (go right or down) and we will choose the minimum of these two.
			int[][] solution = new int[pathGraph.length][pathGraph.length];

			solution[0][0] = pathGraph[0][0];
			// fill the first row
			for (int i = 1; i < pathGraph.length; i++) {
				solution[0][i] = pathGraph[0][i] + solution[0][i - 1];
			}

			// fill the first column
			for (int i = 1; i < pathGraph.length; i++) {
				solution[i][0] = pathGraph[i][0] + solution[i - 1][0];
			}

			// path will be either from top or left, choose which ever is minimum
			for (int i = 1; i < pathGraph.length; i++) {
				for (int j = 1; j < pathGraph.length; j++) {
					solution[i][j] = pathGraph[i][j]
							+ Math.min(solution[i - 1][j], solution[i][j - 1]);
				}
			}
			return solution[pathGraph.length - 1][pathGraph.length - 1];


		}
	}
	//count-ways-reach-nth-stair
	//There are n stairs, a person standing at the bottom wants to reach the top.
	//The person can climb either 1 stair or 2 stairs at a time. 
	//Count the number of ways, the person can reach the top.
	//Bottom UP
	private static int countWaysToReachNthStair(int stair, int maxjump){
		int[] result = new int[stair];
		result[0] = 1;// similar to n-1 ways  + 1;
		result[1] = 1;
		for ( int i = 2 ; i <stair ; i++){
			for(int j = 1 ; j <= maxjump && j <= i ; j++)
					result[i] += result[i-j];
		}
		return result[stair-1];
	}
	private static int minimum(int x, int y , int z)
	{
		if ( x > y ) return y < z ? y :z;
		else
			return x < z ? x : z;
	}
	//allowed jumps 1 or 2
	private static int noOfWaysToReachNthStairRecursion(final int nthStair)
	{	
		if ( nthStair == 1 || nthStair == 2 || nthStair == 3 ) return nthStair;
		return noOfWaysToReachNthStairRecursion(nthStair-1) + noOfWaysToReachNthStairRecursion(nthStair-2);
	}
	//Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
	//https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
	private static void number_of_ways_to_cover_a_distance(int distance)
	{
		//its a fibbonacci series once the steps are counted
		//max ways to cover distance[i]
		int[] maxWays = new int[distance+1];
		maxWays[0] = 1 ; //ways to reach ground level
		maxWays[1] = 1; 
		maxWays[2] = 2;
		
		for(int i = 3 ; i <= distance ; i++)
		{
			maxWays[i] = maxWays[i-1] + maxWays[i-2] + maxWays[i-3];
			// if atmost 2 steps allowed
			// maxWays[i-1] + maxWays[i-2] // at max a distance of (d-2) can be go backwards
		}
		System.out.println("number_of_ways_to_cover_a_distance " + maxWays[distance]);
	}
	//find the longest common subsequence among two sequences.
	//Dynamic Programming
	/*
	 * Example:
		Input:
		2
		6 6
		ABCDGH
		AEDFHR
		3 2
		ABC
		AC
		
		Output:
		3
		2
		
		Explanation
		LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
		
		LCS of "ABC" and "AC" is "AC" of length 2
	 */
	public static String longestCommonSubSequence(String str1 , String str2)
		{
			int[][] arrayToStore = new int[str1.length()+1][str2.length()+1];
			//capturing the sub sequence
			StringBuilder sb = new StringBuilder();
			for (int i=1 ; i<= str1.length() ; i++)
			{
				for (int j=1;j<= str2.length();j++)
				{
					if (str1.charAt(i-1) == str2.charAt(j-1)){
						arrayToStore[i][j] = 1 + arrayToStore[i-1][j-1];
					}
					else
						arrayToStore[i][j] = Math.max(arrayToStore[i-1][j],arrayToStore[i][j-1]);
				}
			}
			
			//print sequence
			// we will start of the end and move upwards // whenever its a diagonal element we will consider that character in the  common sequence
			//not tested
			int i = str1.length();
			int j = str2.length();
			while( i > 0 && j>0 ){
				//starting from corner index
				int value = 0 ;
				int xIndex = Integer.MIN_VALUE;
				int yIndex = Integer.MIN_VALUE;
				if ( arrayToStore[i][j-1] >  arrayToStore[i-1][j]){
					value = arrayToStore[i][j-1];
					xIndex = i;
					yIndex = j-1;
				}else if ( arrayToStore[i][j-1] ==  arrayToStore[i-1][j]){
					value = arrayToStore[i-1][j];
					xIndex = i-1;
					yIndex = j;
				}
				if ( arrayToStore[i][j] > value)
				{	
					sb.append(str1.charAt(i-1));
					--i;
					--j;
				}else if (arrayToStore[i][j]  == value || arrayToStore[i][j] < value ){
					j = yIndex;
					i = xIndex;
				}
			}
			System.out.println(" Length of longest common subsequence is " + arrayToStore[str1.length()][str2.length()]);
			System.out.println( " longest common subsequence " + sb.toString());
			return sb.toString();
		}
	//https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/
	private static void length_shortest_common_supersequence(final String str1 , final String str2 , int str1Length , int str2Length)
	{	
		System.out.println( " length_shortest_common_supersequence " );
		int solution[][] = new int[str1Length+1][str2Length+1];
		
		// initialize first column of the lookup table
				for (int i = 0; i <= str1Length; i++) {
					solution[i][0] = i;
				}

				// initialize first row of the lookup table
				for (int j = 0; j <= str2Length; j++) {
					solution[0][j] = j;
				}
				
		for (int i = 1 ; i <= str1.length() ; i++)
		{
			for (int j = 1 ; j <= str2.length() ; j++)
			{
				if (str1.charAt(i-1) == str2.charAt(j-1))
						solution[i][j] = 1 + solution[i-1][j-1];
				else
					solution[i][j] = Math.min(solution[i-1][j]+1, solution[i][j-1]+1);
			}
		}
		System.out.println(solution[str1Length][str2Length]) ;
	}
	private static int length_shortest_common_supersequence_recursive(final String str1 , final String str2 , int str1Length , int str2Length)
	{	
		if (str1Length == 0 || str2Length == 0) return str1Length+str2Length; // supersequence should contain all characters
		
		if (str1.charAt(str1Length-1) == str2.charAt(str2Length))
			return 1 + length_shortest_common_supersequence_recursive(str1,str2,str1Length-1,str2Length-1);
		//if characters dont match
		//Math.min -- as we have to find the shortest of left and right half
		// include character from str1 to supersequence
		return Math.min(1+length_shortest_common_supersequence_recursive(str1,str2,str1Length,str2Length-1) ,
				// include character from str2 to supersequence
				1+length_shortest_common_supersequence_recursive(str1,str2,str1Length-1,str2Length)  ) ;
	} 
	//find the longest palindromic subsequence.
	//Recursive.
	//http://techieme.in/longest-palindromic-subsequence/
	private static int longestPalindromicSubsequence(boolean isRecursive, String inputString)
	{

		if (isRecursive) 
		{
			int tempLength =  inputString.length();
			if ( tempLength == 1 ) return 1;
			else if ( tempLength == 2  && inputString.charAt(0) == inputString.charAt(1))  return 2;
			else if (inputString.charAt(0) == inputString.charAt(tempLength-1))
				return 2 + longestPalindromicSubsequence(true , inputString.substring(1, tempLength-1));
			else
				return  Math.max( longestPalindromicSubsequence(true, inputString.substring(0,tempLength-1)) , longestPalindromicSubsequence(true, inputString.substring(1, tempLength)));
		}
		//Dynamic Approach.
		else
		{
			int length =  inputString.length();
			int[][] calculateArray = new int[length][length];
			int j;
			//all characters of length one are being stored diagonally . also they are implicitly palindromic
			for ( int i = 0 ; i < inputString.length() ; i++)
			{
				calculateArray[i][i] = 1;
			}

			// Build the table. Note that the lower diagonal values of table are
			// useless and not filled in the process. The values are filled in a
			// manner similar to Matrix Chain Multiplication DP solution (See
			// http://www.geeksforgeeks.org/archives/15553). cl is length of
			// substring
			//starting with 2 characters and moving up  to N characters at a time.
			for (int cl=2; cl<=length; cl++)
			{
				for (int i=0; i<=length-cl; i++)
				{
					j = i+cl-1; //  iterates based on no of characters .. 2 at a time or 3 ,or 4
					if (inputString.charAt(i) == inputString.charAt(j) && cl == 2)
						calculateArray[i][j] = 2;
					else if (inputString.charAt(i) == inputString.charAt(j))
						calculateArray[i][j] = calculateArray[i+1][j-1] + 2;
					else
						calculateArray[i][j] = Math.max(calculateArray[i][j-1], calculateArray[i+1][j]);
				}
			}

			return calculateArray[0][length-1];
		}

	}
	
	//https://www.youtube.com/watch?v=obBdxeCx_Qs
	private void longest_palindromic_substring(final String str )
	{
		boolean[][] solution = new boolean[str.length()][str.length()];

		int currPalindromeLength = 0 ;
		int maxPalindromeLength = Integer.MIN_VALUE;
		String longestPalindrome = StringUtils.EMPTY;
		//all characters of length 1 is palindrome by itself
		maxPalindromeLength = 1 ;
		longestPalindrome = String.valueOf(str.charAt(0));
		for (int i = 0 ; i < str.length() ; i++)
		{
			solution[i][i] = Boolean.TRUE;
		}
		//start considering substring of length - starting from 2 to input string length

	}
    //Given a set of distinct integers, S, return all possible subsets.
	/*This problem is a good candidate for the Base Case and Build approach. Imagine that
		wearetryingtofindallsubsetsofasetlikeS = {alt the Base Case.
		BaseCase:n = 0.
		There is just one subset of the empty set: {}.
		Case:r\ 1.
		Thereare twosubsetsoftheset{a j: {}, {a j.
		a2, ..., an}.Wecanstartwith
		Case:n = 2.
		Therearefoursubsetsoftheset{a^ a2}:{},{aj,{a2},{aaJ a2}.
		Case:n = 3.
		Now here's where things get interesting. We want to find a way of generating the solu-
		tion for n = 3 based on the prior solutions.
		What isthe difference between the solution for n = Sand the solution for n = 2?Let's look at this more deeply:
		P(2) - {}, {aj, {a2}, {aaJ a2}
		P(3) = {}, (aj, {aj, {a3}, {aa, a2}, {a^ a3}, {a2, a3},
		{aj, a2, a3}
		ThedifferencebetweenthesesolutionsisthatP(2) ismissingallthesubsetscontaining ar
		P(3) -P(2)={aj,{3lJ a,},{a2J a3},{a,,a2,a3}
		How can we use P ( 2 ) to create P( 3)? We can simply clone the subsets in P ( 2 ) and add a3 to them:
		P(2) ={} , {aj, {aj, {9lJ a2}
		P(2) + a3 = {a3}, {at, a j, {a2, a3}, {aaJ a2, a3}
		When merged together, the lines above make P(3).
		Case:n > 0
		Generating P(n) for the general case isjust a simple generalization of the abovesteps. 
		We compute P (n -l), clone the results,and then add an to each of these <b>cloned sets.</b>
	 	*/
		
	//iterative //O(2 power N)
	public static List<List<Integer>> findSubsetsOfGivenSet(int[] setValues){
		
		//result : subsets
		List<List<Integer>> result =  new ArrayList<List<Integer>>(); 
		for (int value :  setValues){
			
			//creating a list temp sets to  copy values from result sets.
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			
			//create a fresh copy of  all the sets from result set to temp set
			for (List<Integer> resultSet : result)
				    temp.add(new ArrayList<Integer>(resultSet));
			
			//adding the current set element to all cloned sets from result set
			for (List<Integer> tempSet : temp )
				    tempSet.add(value);
			
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(value);
			temp.add(single);
			
			//now union  temp sets(which is having the current element in all sets) with result set (which does not have 
			//the current element)
			result.addAll(temp);
		}
		//adding a empty set at the end by default 
		result.add(new ArrayList<Integer>());
		return result;
	}
	
	// given a number from an unsorted positive array 
	// find the subset that adds up to the given number 
	//this is not a dp approach
	public static void find_subset_that_adds_to_the_input_number(int[] array , int inputNumber)
	{
		//if number is zero. it corresponds to empty set
		if ( 0 == inputNumber) System.out.println("{}");
		//find power set of the given array 
		StringBuffer sb = new StringBuffer();
		int currentCount = 0 ;
		for (int i = 1 ; i <=Math.pow(2, array.length)-1  ; i++)
		{	
			for (int i1 = 0 ; i1 < array.length ; i1++)
			{
				if (BigInteger.valueOf(i).testBit(i1))
				{
					sb.append(array[i1]);
					currentCount = currentCount+array[i1];
				}
			}
			// is the sub set adds up ot the given number
			if (currentCount == inputNumber)
			{
				System.out.println(" sub set that adds up to the  input number is : [" + sb + "]");
				break;
			}
			currentCount = 0;
			sb.setLength(0);
		}
	}
	//back tracking 
	//recursive // 0(2N)
	private static void find_subset_that_adds_to_the_input_number(int[] A, int currSum, int index, int sum,
	          int[] solution)
	{
		if (currSum == sum) {
	          System.out.println("\nSum found");
	          for (int i = 0; i < solution.length; i++) {
	            if (solution[i] == 1) {
	              System.out.print("  " + A[i]);
	            }
	          }

	        } else if (index == A.length || currSum > sum) {
	          return;
	        } else {
	          solution[index] = 1;// select the element
	          currSum += A[index];
	          find_subset_that_adds_to_the_input_number(A, currSum, index + 1, sum, solution);
	          currSum -= A[index];	
	          solution[index] = 0;// do not select the element
	          find_subset_that_adds_to_the_input_number(A, currSum, index + 1, sum, solution);
	        }
	        return;
		
	}
	//https://www.ideserve.co.in/learn/set-partition-problem-recursion
	//given a set of numbers - can it be partitioned into dis joint sets of equal sum
	private static void set_partition_with_equal_sum(int[] array)
	{
		//total sum
		int sum = 0 ;
		for (int element : array) sum+=element;
		if (sum % 2 != 0) return ; // not possible
		boolean result = find_subset_with_the_given_sum(array,sum/2,0);
		System.out.println( "set_partition_with_equal_sum possible  ? "  + result);
	}
	//back tracking
	private static boolean find_subset_with_the_given_sum(int[] array , int reqSum , int currIdx)
	{
		if (reqSum == 0 ) return true;
		if (currIdx == array.length || reqSum < 0 ) return false; // bounding function
		return find_subset_with_the_given_sum(array, reqSum - array[currIdx], currIdx + 1)
				|| find_subset_with_the_given_sum(array, reqSum, currIdx + 1);
		
	}
	
	//https://www.youtube.com/watch?v=K20Tx8cdwYY
	private static void find_subset_with_the_given_sum_dp(int[] array , int reqSum)
	{	
		System.out.println();
		System.out.println( " -- find_subset_with_the_given_sum_dp -- " );
		if ( reqSum == 0) return;
		boolean solution [][] =  new boolean[array.length+1][reqSum+1];
		//if the req sum is 0 
		//we can make it with an empty set 
		// so first column will have true values
		for (int i = 0 ; i < array.length ; i++)
			 solution[i][0] = Boolean.TRUE;
		
		// if sum is zero.
		solution[0][0] = Boolean.TRUE;
		
		
		// for every other sum - which corresponds to column values
		// check whether the sum can be reached by considering the sub set values present in rows 
		
		for ( int i = 1 ; i < solution.length ; i++)
		{
			for ( int j = 1 ; j < solution[0].length ; j++)
			{
				// if the sum at jth position (denoted by j value) can be reached considering the subset till ith value
				// if element i.e j is greater than current subset element .
				// then there is no way current subset element can be part of solution so copy the solution till [i-1][j] loc
				
				if (array[i-1]  > j) solution[i][j] = solution[i-1][j];
				else solution[i][j] = solution[i - 1][j] || solution[i - 1][j - array[i - 1]];
					
			}
		}
		System.out.println(solution[array.length][reqSum]);
		
	}
	/*  Dynamic Programming – Egg Dropping Problem

		Objec­tive:  There are n number of eggs and building which has k floors. Write an algorithm to find the minimum number of drops
		is required to know the floor from which if egg is dropped, it will break.
	
		Note:
	
		One trial is – dropping an egg once from the particular floor.
		If egg does not break after dropping, will be used again.
		If egg breaks when dropped from some floor then it will break if dropped from any higher floor.
		If egg does not break when dropped from some floor then it will not break if dropped from any lower floor.
	*/
	//Time Complexity: 2powerk - k (no of floors) 
	private static int egg_dropping_problem_recursive(int eggs , int floors)
	{
		//base case
        //if floors = 0 then no drops are required OR floors = 1 then 1 drop is required
		if (floors == 0 || floors == 1) return floors;
		//base case 2:
        //if only one egg is there then drops = floors // at worst case we will drop from each floor to check
        if(eggs==1)
            return floors;
        int minimumDrops=Integer.MAX_VALUE, tempResult;
        //check dropping from all the floors 1 to floors and pick the minimum among those.
        //for every drop there are 2 scenarios - a) either egg will break b) egg will not break
        for (int i = 1; i <=floors ; i++) {
            //for the worst case pick the maximum among a) and b)
            tempResult = Math.max(egg_dropping_problem_recursive(eggs-1,i-1), egg_dropping_problem_recursive(eggs, floors-i));
            minimumDrops = Math.min(tempResult,minimumDrops);
        }
        return minimumDrops + 1;
	}
	
	
	
	private static void egg_dropping_problem(int eggs , int floors)
	{
		int [][] eggDrops = new int [eggs+1][floors+1];
        //base case 1:
        //if floors = 0 then no drops are required // OR floors = 1 then 1 drop is required
        for (int i = 1; i <=eggs ; i++) {
            eggDrops[i][0] = 0;
            eggDrops[i][1] = 1;
        }
        //base case 2:
        //if only one egg is there then drops = floors
        for (int i = 1; i <=floors ; i++) {
            eggDrops[1][i] = i;
        }

        for (int i = 2; i <=eggs ; i++) {
            for (int j = 2; j <=floors ; j++) {
                eggDrops[i][j] = Integer.MAX_VALUE;
                int tempResult;
                for (int k = 1; k <=j ; k++) {
                    tempResult = 1 + Math.max(eggDrops[i-1][k-1], eggDrops[i][j-k]);
                    eggDrops[i][j] = Math.min(tempResult,eggDrops[i][j]);
                }
            }
        }
        // eggDrops[eggs][floors] will have the result : minimum number of drops required in worst case
        System.out.println("egg_dropping_problem " +  eggDrops[eggs][floors]);
		
	}
	class Box{
		private int length;
		private int width;
		private int height;
		
		private Box( final int height , final int width , final int length  )
		{
			this.height	= height;
			this.width = width;
			this.length = length;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Box [length=").append(length).append(", width=").append(width).append(", height=")
					.append(height).append("]");
			return builder.toString();
		}
		
		
	}
	//https://www.youtube.com/watch?v=9mod_xRB-O0
	//https://algorithms.tutorialhorizon.com/dynamic-programming-box-stacking-problem/
	
	//to test - 
	private static void box_stacking_problem(final int[][] boxDimensions)
	{	
		List<Box> listOfBoxes = new ArrayList<DynamicProgramming.Box>(boxDimensions.length);
		// form list of boxes with all dimensions.
		for ( int i = 0 ; i < boxDimensions.length ; i++)
		{
			int height = boxDimensions[i][0];
			int width = boxDimensions[i][1];
			int length = boxDimensions[i][2];
			
			// each box can have 3 rotations possible
			// length * height * width
			// height * length * width
			// width * height * length
			//adding all 3 rotations into list 
			listOfBoxes.add(new DynamicProgramming().new Box(height,width,length));
			listOfBoxes.add(new DynamicProgramming().new Box(width,height,length));
			listOfBoxes.add(new DynamicProgramming().new Box(length,width,height));
			
			//sort all boxes in decreasing order of their base area
			// as we cant start a box of higher base area on top of a lesser base area
			
			Collections.sort(listOfBoxes, new Comparator<Box>(){

				@Override
				public int compare(Box box1, Box box2) {
					int box1BaseArea = box1.length * box1.width;
					int box2BaseArea = box2.length * box2.width;
					
					return box2BaseArea - box1BaseArea;
				}
				
			});
			
			// all boxes are sorted - higher base area to lower base area
			// now it boils down to longest subsequence dp problem
			//to display all the possible boxes.
	        System.out.println("All possible combination of boxes after rotation");
	        for (Box box : listOfBoxes) {
	            System.out.println(box.height + " " + box.width + " " + box.length);
	        }
	        
		}
	        int maxHeight[] = new int[listOfBoxes.size()];
	        int result[] = new int[listOfBoxes.size()];
	        
	        //if the boxes were by themselves i.e if we would have considered single box 
	        //then max height with that box at that index would be the height of the box itself.
	        
	        //fill the max height array
	        for (int i = 0 ; i < maxHeight.length ; i++)
	        {
	        	maxHeight[i] = listOfBoxes.get(i).height;
	        }
	        
	        //similar result will store the boxes indices which goes on top of which
	       // fill all boxes with the initial indices
	        
	        for (int i = 0 ; i < result.length ; i++)
	        {
	        	result[i] = i;
	        }
			
	        // start with the 2nd box and go till end 
	        
	        for (int i =  1 ; i < maxHeight.length ; i++)
	        {
	        	int j = 0 ;
	        	
	        	while ( j < i )
	        	{	
	        		// as the boxes are sorted in decreasing order 
	        		// we are checking if the ith box can go on top of jth box 
	        		Box ithBox = listOfBoxes.get(i);
	        		Box jthBox = listOfBoxes.get(j);
	        		if (ithBox.width < jthBox.width && ithBox.length < jthBox.length)
	        		{
	        			// then max height at ith position will be the height gained at jth position + ith box height
	        			maxHeight[i] = maxHeight[j] + ithBox.height;
	        			//also the ith box was placed on top of jth box 
	        			result[i] = j; // index
	        			//later with index we can find the actual box through listofboxes
	        		}
	        		
	        		++j;
	        	}
	        }
	        
	        // go through entire height array and get the max height
	        int maximumHeight = Integer.MIN_VALUE;
	        int smallestBoxIdx = 0 ;
	        for (int i = 0 ; i < maxHeight.length ; i++)
	        {
	        	if (maxHeight[i] > maximumHeight)
	        	{
	        		maximumHeight = maxHeight[i] ;
	        		smallestBoxIdx = i;
	        	}
	        }
	        // go through result array . start from smallestBoxIdx and trace back wards to largest box
        	System.out.print( " box_stacking_problem : box details -  smallest to largest" );
	        while ( smallestBoxIdx != 0 )
	        {
	        	System.out.print( " box " + listOfBoxes.get(smallestBoxIdx));
	        	smallestBoxIdx = result[smallestBoxIdx];
	        }
	}
	//https://algorithms.tutorialhorizon.com/dynamic-programming-remove-boxes-problem/
	/*
	 * Objec­tive:  Given a number of boxes with different colors represented by different positive numbers. 
	 * You need to remove all the boxes in several rounds, each time you can choose continuous boxes with the same color (means with same numbers, 
	 * composed of k boxes, k >= 1), remove them and get k*k points.
	   Write an algorithm to get the maximum points by removing all the boxes.
	    
	    1233211

	    Remove 33 – Profit = 2*2 = 4, Remaining = 12211
		Remove 22 – Profit = 4 + 2*2 = 8, Remaining = 111
		Remove 11 - Profit = 3*3 + 8 = 17				
	 */
	static int box_remove_to_gain_maximum_points_recursion(String input)
	{
		if (1 == input.length() ) return 1;
		if ( null == input || input.length() == 0) return 0;
		
		int startIdx = 0 ;
		int endIdx = 0 ;
		int profit = 0 ;
		
		while (startIdx <= input.length() )
		{
			
		}
		return 0;
	}
	//https://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
	public static void maximum_product_subarray(int[] array) {
		if ( null == array || array.length == 0 ) return;

		int maxProductTillNow = array[0];
		int minProductTillNow = array[0];
		int maxProductTillNow1 = array[0]; // added as maxProductTillNow gets updated interim & same value can't be re-used
		int minProductTillNow2 = array[0];
		int overallMaxProduct = array[0];
		
		for (int i = 1 ; i < array.length ; i++)
		{	
			if (array[i] > 0 )
			{
				maxProductTillNow1 = Math.max(array[i], maxProductTillNow*array[i]);
				minProductTillNow2 = Math.min(array[i], minProductTillNow*array[i]);
			}
			else
			{
				maxProductTillNow1 = Math.max(array[i], minProductTillNow*array[i]);
				minProductTillNow2 = Math.min(array[i], maxProductTillNow*array[i]);
			}
			maxProductTillNow=maxProductTillNow1;
			minProductTillNow=minProductTillNow2;
			
			overallMaxProduct = Math.max(overallMaxProduct, maxProductTillNow);
		}

		
		System.out.println("maximum_product_subarray = " + overallMaxProduct);
	}
	
	//https://www.programcreek.com/2014/02/leetcode-subarray-sum-equals-k-java/
	//max subarray-sum-equals-k-java/
	
	private static void max_subarray_sum_equals_k(final int[] array , final int k)
	{
		if (null == array || array.length == 0 ) return;
		//redundant if the following login is applied
		//if (array.length == 1 && array[0] == k) System.out.println( "subarray_sum_equals_k  = " + array[0]);
		Map<Integer,Integer> hMap = new HashMap<Integer, Integer>(array.length);
		hMap.put(0, -1); // if subarray starts from beginning
		int sum = 0 ;
		int maxSubArrayLength = 0 ;
		int subarraystartingpos = 0 ;
		for (int i = 0 ; i < array.length ; i++)
		{	
			sum+=array[i];
			if (hMap.containsKey(sum-k))
			{
				//maxSubArrayLength = Math.max(maxSubArrayLength,i - hMap.get(sum-k));
				if ( (i - hMap.get(sum-k)) > maxSubArrayLength ) 
				{
					subarraystartingpos = hMap.get(sum-k) + 1;
					maxSubArrayLength = i - hMap.get(sum-k);
				}
			}
			hMap.putIfAbsent(sum, i);
		}
		
		System.out.println("max_subarray_sum_equals_k = " + maxSubArrayLength);
		System.out.println( " subarray - which have the above sum is ");
		for (int i = subarraystartingpos ; i<subarraystartingpos+maxSubArrayLength ; i++)
		{	
			System.out.print(",");
			System.out.print(array[i]);
		}
	}
	//https://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/
	//find the maximum sum of subarray close to k but not larger than k.

	public static int getLargestSubArraySumCloseToK(int[] arr, int k){
		int sum=0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		int result=Integer.MIN_VALUE;
		set.add(0);
		for(int i=0; i<arr.length; i++)
		{
		sum=sum+arr[i];
		Integer ceiling = set.ceiling(sum-k);
			if(ceiling!=null){
			result = Math.max(result, sum-ceiling);
			}
		set.add(sum);
		}
		return result;
	}
	//https://www.youtube.com/watch?v=CE2b_-XfVDk
	private static void longest_increasing_subsequence(final int[] array)
	{
		//dp
		int[] result = new int[array.length];
		Arrays.fill(result, 1); // all individual elements are itself increasing sub sequence
		
		for (int i = 1 ; i < array.length ; i++)
		{
			for ( int j = 0 ; j < i ; j++)
			{
				if (array[j] < array[i])
					result[i] = Math.max(result[i], result[j]+1);
			}
		}
		System.out.println("longest_increasing_subsequence is of length " + result[array.length-1]);
	}
	
	//https://www.techiedelight.com/longest-common-substring-problem/
	private static void longest_common_substring(final String str1 , final String str2)
	{
		if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2) ) return; // 0
		int[][] dpArray = new int[str1.length()+1][str2.length()+1];
		int lengthOfLongestCommonSubString = 0;
		int endingIndxOfLongestCommonSubString = 0 ; 
		for (int i = 1 ; i < str1.length() ; i++ )
		{
			for (int j = 1 ; j < str2.length() ; j++)
			{
				if (str1.charAt(i-1) == str2.charAt(j-1))
					 dpArray[i][j] = 1 + dpArray[i-1][j-1];
				if ( dpArray[i][j] > lengthOfLongestCommonSubString)
				{
					lengthOfLongestCommonSubString = dpArray[i][j] ;
					endingIndxOfLongestCommonSubString = i ;
				}
			}
		}
		
		System.out.println("longest_common_substring" + str1.substring(endingIndxOfLongestCommonSubString-lengthOfLongestCommonSubString,endingIndxOfLongestCommonSubString) + " length " + lengthOfLongestCommonSubString);
	}
	
	//https://algorithms.tutorialhorizon.com/dynamic-programming-edit-distance-problem/
	public static void edit_Distance(String s1, String s2) {
	        int [][] solution = new int[s1.length()+1][s2.length()+1];
	        
	        //base case
	        //If any of the string is empty then number of operations
	        //needed would be equal to the length of other string
	        //(Either all characters will be removed or inserted)
	        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
	            solution[0][i] =i;
	        }

	        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
	            solution[i][0] =i;
	        }

	        //solving it bottom-up manner
	        int m = s1.length();
	        int n = s2.length();
	        for (int i = 1; i <=m ; i++) {
	            for (int j = 1; j <=n ; j++) {
	                //If last characters are matching, ignore the last character
	                // then the solution will be same as without the last character.
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                    solution[i][j] = solution[i-1][j-1];
	                else
	                    solution[i][j] = 1 +    Math.min(solution[i][j-1], //Insert
	                                            Math.min(solution[i-1][j], // Remove
	                                            solution[i-1][j-1])); //Replace
	            }
	        }
	        System.out.println("editDistanceDP = " + solution[s1.length()][s2.length()]);
	    }
	//Given a string, find the minimum number of characters to be inserted to convert it to palindrome
	//recursive
	public static int min_insertion_to_form_palindromic_string(final String str , int startIdx , int endIdx)
	{
		//base cases
		if (startIdx > endIdx ) return Integer.MAX_VALUE;
		if (startIdx == endIdx) return 0;
		if (startIdx == endIdx - 1) return str.charAt(startIdx) == str.charAt(endIdx) ? 0 : 1 ; //ab insertion either bab || aba 
																								//bb || aa zero insertion
		if (str.charAt(startIdx) == str.charAt(endIdx)) return min_insertion_to_form_palindromic_string(str,startIdx+1 , endIdx-1);
		return 1 + Math.min(min_insertion_to_form_palindromic_string(str,startIdx+1 , endIdx), min_insertion_to_form_palindromic_string(str ,startIdx , endIdx-1)) ; 
	}
	
	/*
	 * https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
	 * You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

		Double the number
		Add one to the number
		Input:
		2
		8
		7
		Input:
		4
		5
		
		Explanation:
		Testcase1:
		Input  : N = 8
		Output : 4
		0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
		Testcase2:
		Input  : N = 7
		Output : 5
		0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
	 */
	
	public static void min_operations(final int number)
	{
		
	}
//	You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.
//
//	In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
//
//	You need to determine the maximum possible amouint of money you can win if you go first.
	public static void  pots_of_gold_optimal_strategy()
	{
		
	}
	
	//0/1 KnapSack Problem
	public static void KnapSack_0_1(final int[] weights , final int[] profits , final int knapSackVol)
	{	
		System.out.println( " ... KnapSack_0_1 .." );
		//create a 2D array 
		// columns will point to knap sack weight
		// rows will point to weights
		
		// at every step we will take a decision whether to include the curr item in the knap sack
		// if included . whats the curr profit 
		// if not included whats the curr profit
		// pick max profit at that curr decision 
		
		int[][] solution  =  new int[weights.length+1][knapSackVol+1];
		
		// if the knap sack vol is 0 .
		// the max profit that can be achieved by considering all weights is 0
		
		// fill 1st col'n as zero
		//for (int i = 0 ; i < solution.length ; i++)
			 //solution[i][0] = 0 ;
		
		// if there are no weights 
		//max profit that can be achieved by filling whole knapsack is )
		//can be ommited ..
		//for (int i = 0 ; i < solution[0].length ; i++)
			 //solution[0][i] = 0 ;
		
		
		for ( int i  = 1 ; i < solution.length ; i++)
		{
			for (int j = 1 ; j < solution[0].length ; j++)
			{
				// curr weight is greater than kanpsack vol. 
				//get the previous max profit
				if (weights[i-1] > j)
				  solution[i][j] = solution[i-1][j];
				else
				{
					//calculate the profit gained by including it 
					int profitGainedByIncludingCurrWeight = profits[i-1]+solution[i-1][j-weights[i-1]];
					//profit by not including it
					int profitGainedByNotIncludingCurrWeight = solution[i-1][j];
					solution[i][j] = Math.max(profitGainedByIncludingCurrWeight, profitGainedByNotIncludingCurrWeight);
				}
			}
		}
		
		
		//items picked up 
		StringBuilder sb = new StringBuilder();
		
		System.out.println( " maximum weight - gained from the knap sack = " + solution[solution.length-1][solution[0].length-1]);
	}
	
	/** Dynamic Programming - Problems involving Grids **/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value = {0,1   ,5   ,8   ,9  ,10  ,17  ,17  ,20};
		int len = 8;
		System.out.println(" Max profit for length S " + len + ":"
				+ maximumRevRodCutting(value, len));
		
		System.out.println(" Maximum product cutting in "
				+ 5 + " is " + cutRopeToObtainMaximumProduct(5));
		System.out.println(" Maximum product cutting in "
				+ 5 + " is " + cutRopeToObtainMaximumProduct_1(10));
		getMinCoinsDP(new int[]{2,5,3},7);
		System.out.println(" Minimum Number of Jumps to Reach from START to END " + findMinimumNoOfJumpsToReachEnd(false, new  int[]{2, 3, 1, 1, 2, 4, 2, 0,1,1}, new int[16]));
		int[][] pathGraph = new int[][]{{1,2,3} , {4,8,2} ,{1,5,3} };
		System.out.println( " Minimum cost path from Source to Destination is " +  minCostPath(false, pathGraph, 2,2));
		countWaysToReachNthStair(4 , 2);
		longestCommonSubSequence("ABCD","DCBA");
		System.out.println(" Length of Maximum Palindromic Subsequence " + longestPalindromicSubsequence(false , "ACECCBA"));
	    System.out.println(" find all subsets of a given set ");
	    System.out.println(" result " + findSubsetsOfGivenSet(new int[]{1,2,3}));
	    find_subset_that_adds_to_the_input_number(new int[]{1,2,3},5);
	    maximum_product_subarray(new int[]{40,0,-20,-10});//new int[]{-6,4,-5,8,-10,0,8}
	    max_subarray_sum_equals_k(new int[]{ 5, 6, -5, 5, 3, 5, 3, -2, 0 },8);
	    System.out.println(getLargestSubArraySumCloseToK(new int[]{ 2, 2, -1, 5, -3, -2 }, 7));
	    longest_increasing_subsequence(new int[]{3,4,-1,0,6,2,3});
	    longest_common_substring("ABC", "BABA");
	    number_of_ways_to_cover_a_distance(3);
	    edit_Distance("horizontal", "horizon");
	    set_partition_with_equal_sum(new int[]{15,15,20,45});
	    int result = min_insertion_to_form_palindromic_string("geeks",0,4);
	    System.out.println("min_insertion_to_form_palindromic_string " + result);
		length_shortest_common_supersequence("ABCBDAB", "BDCABA",7,6 );
		System.out.println(" find_subset_that_adds_to_the_input_number ");
		find_subset_that_adds_to_the_input_number(new int[]{3, 2, 7, 1},0,0,6,new int[4]);
		find_subset_with_the_given_sum_dp(new int[]{2, 3, 7, 8,10},11);
		KnapSack_0_1(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7);
		noOfWaysToReachNthStairRecursion(5);
	}

}
