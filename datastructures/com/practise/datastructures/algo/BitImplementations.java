package com.practise.datastructures.algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BitImplementations {

	public BitImplementations() {
		// TODO Auto-generated constructor stub
	}

	
	//Given an integer an N, write a program 
	//to print the position of first set bit found from right side in the binary representation of the number.
	public static void findFirstSetBitPosition(int value){
		char[] result = Integer.toBinaryString(value).toCharArray();
		for (int i = result.length-1; i>=0; i--){
			if (result[i] == '1') {
				System.out.println(" First set bit position from right is " + (result.length - i));
				break;
			}
		}
	}
	
	//Given two numbers M and N. Write a program to find the position of rightmost different bit in binary representation of numbers.
	public static void findPositionOfRightmostDiffBit(int val1 , int val2){
		/*
		 *  Approach: Get the bitwise xor of m and n. Let it be xor_value = m ^ n. 
		 *  Now, find the position of rightmost set bit in xor_value.
			Explanation: The bitwise xor operation produces a number which has set bits only at the positions where the bits of m and n differ. 
			Thus, the position of rightmost set bit in xor_value gives the position of rightmost different bit.
		 */
		char[] result = Integer.toBinaryString(val1 ^ val2).toCharArray();
		for (int i = result.length -1 ; i >=0 ; i--){
			if (result[i] == '1') {
				System.out.println(" position of rightmost different  bit is " + (result.length - i));
				break;
			}
		}
		
	}
	
	//Given a non-negative number N and two values L and R. 
	//The problem is to toggle the bits in the range L to R in the binary representation of N, 
	//i.e, to toggle bits from the rightmost Lth bit to the rightmost Rth bit. A toggle operation flips a bit 0 to 1 and a bit 1 to 0.
	
	public static void toggleBits(int val , int leftPos , int rightPos){
		
		char[] result = Integer.toBinaryString(val).toCharArray();
		//toggle bits 
		for (int i = leftPos ; i <= rightPos ; i++)
			 result[i] = ((result[i]) == '0' ) ? '1' : '0' ;
		System.out.println(" toggled number " + Integer.parseInt(String.valueOf(result), 2)) ;
	}
	
	//https://www.geeksforgeeks.org/toggle-last-m-bits/
	//Given a non-negative number n. The problem is to toggle the last m bits in the binary representation of n. 
	//A toggle operation flips a bit 0 to 1 and a bit 1 to 0.
	public static void toggleLastMBits(final int number , final int mBits)
	{
		//create a mbits binary string  and subtract 1 . it will make a mbits binary string with ALL 1's
		int num1 = (1 << mBits) - 1;
		//perform xor and it will reverse the digit 
		System.out.println(Integer.toBinaryString(number ^ num1));
		System.out.println(number ^ num1);
		
	}
	//check if the input mumber is a power of 2 
	public static void isPowerOfTwo(int val){
		//All power of two numbers have only one bit set. So count the no. of set bits and if you get 1 then number is a power of 2.
		int count = 0 ;
		while ( val != 0 ){
			count += val & 1 ;
			val >>=1;
		}
		System.out.print("is the input number power of 2 ? ");
		System.out.print((count > 1) ? "NO" : "YES");
	}

	//Set the K-th bit of a given number
	//Given a number n and a value k. From the right, set the kth bit in the binary representation of n. The position of LSB(or last bit) is 0, 
	//second last bit is 1 and so on. Also, 0 <= k < x, where x is the number of bits in the binary representation of n.
	public static void setTheKthBit(int val , int kval){
			System.out.println("the value after setting kth bit is " +  ((1 << kval) | val));
	}
	
	//You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.
	public static void findBitsToBeFlipped(int val1, int val2){
		//taking xor
		int xorVal = val1 ^ val2;
		int count = 0 ;
		while (xorVal != 0 ){
			count += xorVal & 1;
			xorVal >>= 1;
		}
		System.out.println("no of bits to be flipped to convert val1 to val2 is " + count);
	}
	
	//Find the sum of all bits from numbers 1 to N.
	public static void findSumOfAllBits(int val){
		
	}
	
	//Given a number N, Your task is to find the  length of the longest consecutive 1's in its binary representation.
	public static void findLengthOfLongestConsequetiveOnes(int val){
		int lengthTillNow = 0 ;
		int maxLength = 0 ;
		while (val != 0 ){
			
			if (( val & 1 ) == 0)
			{
				if(lengthTillNow > maxLength) maxLength = lengthTillNow;
				lengthTillNow = 0 ;
			}else
				lengthTillNow += val & 1;
			val >>= 1;
		}
		System.out.println("length of the longest consecutive 1's in its binary representation " + maxLength);
	}
	/*
	 * Given a number N and a bit number K, check if Kth bit of N is set or not. 
	 * A bit is called set if it is 1.
	 * Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number. 
	 * Consider N = 4(100):  0th bit = 0, 1st bit = 0, 2nd bit = 1.
	 */
    public static void checkIfKthBitIsSetOrNot(final int n , final int k)
    {
    	//decimal to binary conversion
    	List<Integer> bits = decimalToBinary(n);
    	if ((bits.size() - k - 1 ) >= 0)
    		System.out.println( " is kth bit set  ? kth bit = " + k +  " " +  (bits.get(bits.size() - k - 1) == 1)  );
    	else
    		System.out.println("invalid bit to check");
    }
    //Given a number N, check whether it is sparse or not. 
    //A number is said to be a sparse number if in the binary representation of the number no two or more consecutive bits are set.
    public static void isSparseNumber(int number)
    {	
    	int numberOfSetBitsTillNow = 0 ;
    	while(number != 0 )
    	{
    		numberOfSetBitsTillNow += number & 1 ;
    		if ( numberOfSetBitsTillNow >= 2 )
    		{
    			System.out.println(" The given number is NOT sparsh");
    			break;
    		}
    		
    		number >>= 1;
    	}
    	if (!(numberOfSetBitsTillNow >= 2) ) System.out.println(" The given number is sparsh");
    	// other way 
    	 // n is not sparse if there is set in AND of n and n/2 
//        if ((n & (n>>1)) >=1) 
//            return 0; 
//       
//        return 1; 
    }
    public static List<Integer> decimalToBinary(int decimalNumber)
    {
    	//int[] result = new int[1000];
    	Stack<Integer> stack = new Stack<Integer>();
    	List<Integer> result = new ArrayList<Integer>();
    	while (decimalNumber != 0 )
    	{
    		stack.push(decimalNumber % 2 );
    		decimalNumber = decimalNumber / 2 ; 
    		
    	}
    	while(!stack.isEmpty())
    		result.add(stack.pop());
    	return result;
    }
    
    //Given a set of positive integers. 
    //The task is to complete the function maxSubarrayXOR which returns an integer denoting the maximum XOR subset value in the given set.
    public static void maxSubarrayXOR(int[] array)
    {
    	List<String> result = powerSetOfAGivenNumberSeries(array);
    	int maxSubSetXORVal = 0 ;
    	for (Iterator<String> itr = result.listIterator(); itr.hasNext();)
    	{
    		final String[] currentSubSet = itr.next().split(",");
    		int currSubSetXORVal = 0 ;
    		for (String currentSubSetVal : currentSubSet)
    		{
    			currSubSetXORVal^=Integer.parseInt(currentSubSetVal);
    		}
    		maxSubSetXORVal = currSubSetXORVal > maxSubSetXORVal ? currSubSetXORVal : maxSubSetXORVal;
    	}
    	System.out.println("maxSubarrayXOR value for input is " + maxSubSetXORVal);
    }
    // toggle k-th bit? form LSB
    public static void toggleKthBit(int decNumber ,  final int kthBit)
    {
    	decNumber =  decNumber ^ ( 1 << (kthBit-1));
    }
    public static List<String> powerSetOfAGivenNumberSeries(int[] array)
    {
    	double numberOfSets = Math.pow(2, array.length); 
    	List<String> result = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder(5);
    	for (int i = 1 ; i < numberOfSets ; i++)
    	{
    		for (int j = 0 ; j < array.length ; j++)
    		{
    			if (BigInteger.valueOf(i).testBit(j)) 
    			{
    				sb.append(array[j]).append(",");
    			} 
    			
    		}
    		result.add(sb.toString()); //creates a new string
    		sb.setLength(0);
    	}
    	return result;
    }
    //https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not/0
    public static void checkIfTwoArraysHaveSameElements(int[] array1 , int[] array2)
    {
    	int sum1 = 0 ;
    	int sum2 = 0 ;
    	for (int i : array1)
    		 sum1+=i;
    	for (int j : array2)
    		sum2+=j;
    	System.out.println( "Does both arrays have equal elements  ? : " + ((sum1 ^ sum2) == 0? "Yes" : "No"));
    }
    
    //https://www.youtube.com/watch?v=RM7jdCcG8sg&t=965s
    // An Array where all elements are repeated thrice except 1 
    // Find the single repeated element
    public static void find_single_repeated_element(final int[] arr)
    {
    	// considering int element as 4 byts and 32 bits 
    	int[] solution = new int[32]; // will store the bit representations
    	for (int element : arr)
    	{	
    		// get the binary representation
    		Stack<Integer> stack = new Stack<Integer>();
    		while (element != 0 )
    		{
    			stack.push(element % 2 );
    			element =  element / 2 ; 
    		}
    		//start setting the bits from front
    		int i = solution.length-1;
    		while (!stack.isEmpty())
    		{	 solution[i] = solution[i]+stack.pop();
    			--i;
    		}
    	}
    	
    	// go through the array and modulo % 3 are all elements are repeated thrice .
    	for (int i = 0 ; i < solution.length ; i++)
    	{
    		if(solution[i] != 0 )
    			 solution[i]  =  solution[i]  % 3 ;
    	}
    	
    }
	public static void main(String[] args) {
		findFirstSetBitPosition(12);
		findPositionOfRightmostDiffBit(52,4);
		toggleBits(50,2,5); //50 , 2,5 
		setTheKthBit(15, 3);
		isPowerOfTwo(8);
		findBitsToBeFlipped(10,20);
		findLengthOfLongestConsequetiveOnes(222);
		checkIfKthBitIsSetOrNot(500,10);
		toggleLastMBits(21, 2);
		isSparseNumber(2);
		maxSubarrayXOR(new int[]{2,4,5});
		checkIfTwoArraysHaveSameElements(new int[]{1,1,1,0} ,new int[]{0,1,1,1});
		find_single_repeated_element(new int[]{7,7,3,4,2,4,3,3,4,7});
	}

}
