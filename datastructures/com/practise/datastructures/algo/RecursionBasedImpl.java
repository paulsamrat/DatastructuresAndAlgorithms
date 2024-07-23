package com.practise.datastructures.algo;

import java.util.Arrays;

public class RecursionBasedImpl {
	/*
	 * Print All N Length Strings from Given String of Length K where char­ac­ters can appear mul­ti­ple time.
		
		String k = "ALGO" , N=2
		Result:
		AA LA GA OA AL LL GL OL AG LG GG OG AO LO GO OO
	 */
	//public 
	/*
	 * Print All N Length Strings from Given Number K
	   N = 2, K = 3
	   [1, 1] [2, 1] [3, 1] [1, 2] [2, 2] [3, 2] [1, 3] [2, 3] [3, 3]
	 */
	//O(N2)
	public static void printAllNLengthStringsForAGivenNumberK(int length , int number){
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i <= number ; i++){
			 for (int j  = 1 ; j <= number ; j++){
				 sb.append("[").append(i).append(",").append(j).append("]");
			 }
		}
		System.out.println(sb);
	}
	//recursive approach
	private static void permutation(String str, String prefix, int lengthOfPermutationString){
		if(prefix.length()==lengthOfPermutationString){
			System.out.println(prefix);
		}else{
			for (int i = 0; i < str.length(); i++) {
				permutation(str, prefix + str.charAt(i), lengthOfPermutationString);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Print All N length from Given Number K");
		printAllNLengthStringsForAGivenNumberK(2,3);
		permutation("ABC", "",2);
	}

}
