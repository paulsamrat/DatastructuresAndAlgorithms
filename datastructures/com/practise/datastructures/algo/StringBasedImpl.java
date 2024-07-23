package com.practise.datastructures.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class StringBasedImpl {
	
	private static boolean isPalindromeStackImpl(String str){
		Stack<Character> stack = new Stack<Character>();
		char[] array = str.toCharArray();
		boolean isPalindrome = true;
		for (char c : array)
		{	
			//put values in stack
			stack.push(c);
		}
		//check is palindrome or not 
		for (int i = 0 ; i<=array.length /2 ; i++){
			if (array[i] != stack.pop()){
					isPalindrome = false;
					break;
			}
		}
		List<?  super Integer> list  = new ArrayList<Integer>();
		return isPalindrome;
	}
	private static boolean isPalindromeRecursive(String str){
		 if(str.length() == 0 || str.length() == 1)
	            return true; 
			if (str.charAt(0) == (str.charAt(str.length()-1)))
					return isPalindromeRecursive(str.substring(1, str.length()-1));
			return  false;
   }
	static boolean isAnagram(String A, String B) {
	      //Complete the function
	       if (A.length() != B.length()) return false;
	       char[] a = A.toLowerCase().toCharArray();
	       Arrays.sort(a);
	       char[] c = B.toLowerCase().toCharArray();
	       Arrays.sort(c);
	       return Arrays.equals(a, c);
	       /*
	        * There are 26 english letters from a to z. You can declare two arrays of integers (each of them with size 26). 
	        * Then you go through the String in a loop doing something like:
			  lettersInA[A[i] - 'a']++;
			  Note that in Java you have to cast A[i] to character first. 
			  Then you check in another loop if lettersInA[i] == lettersInB[i]. If not - return false. 
		      If the loop finishes its work - return true. The solution is linear (O(n)) whereas the one using sort is O(n logn).
	        */
	   }
	
	static void isStringNumeric(String str){
		if ( null != str){
			boolean isNumeric = true;
			int result = 0;
			for (char c : str.toCharArray()){
				 if ( !(c >= '0' && c <='9') && c !='.'){
					 	isNumeric = false;
					 	break;
				 //construct the numeric representation
				 }else{
					result = result * 10 + (c-'0'); 
				 }
			}
			System.out.println(isNumeric?"input string is numeric "+result:"input string is non numeric");
		}
	}
	/*
	 *  Given a string s and a dictionary of words dict, 
	 *  determine if s can be segmented into a space-separated sequence of one or more dictionary words.
		For example, given
		s = "leetcode",
		dict = ["leet", "code"].
		
		Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void wordBreak(String str , Set<String> dictionary){
		
	}
	/*
	 * Given a dictionary of words and a string of characters, 
	 * find if the string of characters can be broken into individual valid words from the dictionary.
	 */
	//public static void (){}
	/*
	 * Given a string of characters consisting of 0 or more spaces, remove all the spaces from this given string. 
	 * Separation of spaces from other characters should be done in-place
	 * (without using extra space). Expected time complexity is O(n).
	 */
	public static void removeSpace(String str){
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < str.length() ; i++ ){
			 if (str.charAt(i) == ' ')
				 continue;
			 else
				 sb.append(str.charAt(i));
		}
		System.out.println(" after removing space from string " +  str + " resultant value : " + sb.toString());
	}
	/*
	 * Given a string, find the longest substring with non-repeating characters.
	   Input : ABCDABDEFGCABD
	   Output: ABDEFGC	 
	 */
	//doesn't work
	public static void longestSubStringNonRepeatingCharacters(String str){
		Set<Character> set = new HashSet<Character>();
		String longestSubStringSoFar = "";
		String longestSubString = "";
		for (int i=0;i<str.length();i++){
			if (set.add(str.charAt(i))){
				longestSubStringSoFar+=str.charAt(i);
			}else{
				set.clear();
				if (longestSubString.length() < longestSubStringSoFar.length()){
					longestSubString = longestSubStringSoFar;
				}
				longestSubStringSoFar = "";
				longestSubStringSoFar+=str.charAt(i);
				set.add(str.charAt(i));
			}
		}
		System.out.println(" Longest substring with non-repeating characters " + longestSubString + " length : " + longestSubString.length());
	}
	//Given an array of strings, sort the array in such a way that all anagrams are grouped together
	public  static void groupAnagramsTogether(){
		String[] array = new String[]{"abcd","abc","abce", "acd","abdc"};
		Map<Integer,String> map = new HashMap<Integer,String>();
		for (String str : array){
			 int ascii = 0;
			 for (char c : str.toCharArray()){
				  ascii += c;
			 }
			 if (map.containsKey(ascii)){
				 map.put(ascii, map.get(ascii) + "," + str);
			 }else
				 map.put(ascii,str);
			
		}
		//op: {"abdc","abcd","abc","abce","acd"} 
		System.out.println(map);
	}
	
	//Given a dictionary of words and a string of characters, 
	//find if the string of characters can be broken into individual valid words from the dictionary.
	//Dictionary: arrays, dynamic, heaps, IDeserve, learn, learning, linked, list, platform, programming, stacks, trees
	/*String    : IDeservelearningplatform
	Output   : true 
	Because the string can be broken into valid words: IDeserve learning platform
	*/
	private static boolean wordBreak(String str){
		//dictionary
		String[] arr = new String[]{"arrays", "dynamic", "heaps", "IDeserve", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"};
		//String[] arr = new String[]{"I","am" ,"a" ,"good" ,"boy"};
		List<String> dict = Arrays.asList(arr);
		boolean[] found = new boolean[str.length()+1];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			String word = "";
			//if(!found[i]){
				for(int j=i+1; j<=str.length(); j++){
					String sub = str.substring(i, j);
					if(dict.contains(sub)){
						found[j]=true;
						word = sub;
					}
				} 
			//}
			if (!word.isEmpty())
			sb.append(word).append(" ");
		}
		System.out.println( " words found " + found[str.length()] + " " + sb.toString());
		return found[str.length()];
	}
	//power set 2(N) INCLUDING EMPTY SET --- using bit manipulation
	//o/p the strongest(lexicographically i.e z--a ) unique string from the list of subsequences of the given string
	public static void generatePowerSetOfAGivenString(String str){
		long start = System.currentTimeMillis();
		char[] strA = str.toCharArray();
		int powerSets = (int)Math.pow(2, str.length());
		//Set<String> result = new HashSet<String>();
		Queue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.compareTo(s1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i < powerSets; i++){
            for (int j = 0; j < str.length(); j++)
            {
                /* Check if jth bit in the ith is set
                    If set then print jth element from arr[] */
       
                if (BigInteger.valueOf(i).testBit(j))
                      sb.append(strA[j]);
            }
            pq.offer(sb.toString());
            sb.setLength(0);
		}
		long end = System.currentTimeMillis();
		System.out.println(pq.peek() + " duration " + (end -start));
		
	}
	//https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/the-strongest-string-1-1/
	//Output the strongest unique string which is subsequence of given string.
	public static void strongestUniqueSubSequence(String str){

		long start = System.currentTimeMillis();
		char[] strA = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		Queue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {

			public int compare(Character c1, Character c2) {
				// TODO Auto-generated method stub
				return c2.compareTo(c1);
			}
		});
		Queue<String> resutPQ = new PriorityQueue<String>(new Comparator<String>() {

			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.compareTo(s1);
			}
		});
		for (char c : strA){
			pq.offer(c);
		}
		//highest character
		char highestC = pq.peek();
		for ( int i = 0 ; i < strA.length ; i++){
			if (strA[i] == highestC) {
				//compute subsequences only where it starts from the  highest character
				//generate power set of the given substring 
				String temp = str.substring(i, str.length());
				int powerSets =  (int)Math.pow(2, temp.length());
				for (int j = 1 ; j < powerSets ; j++){
					if (BigInteger.valueOf(j).testBit(temp.length() - 1)) {
							for (int m = temp.length() - 1 ; m >= 0 ; m--){
								// we wont look for all the bits 
								if (BigInteger.valueOf(j).testBit(temp.length() - 1))
										sb.append(temp.charAt(m));
							}
				}
							resutPQ.offer(sb.toString());
							sb.setLength(0);
						
					
				}
			}
		}
		System.out.println(resutPQ);
	}
	
	public static void generatePowerSetOfIntegers(String str){
		String[] integers = str.split(" ");
		int powersetVal = (int) Math.pow(2, integers.length);
		StringBuffer sb =  new StringBuffer();
		List<String> list = new ArrayList<String>();
		for (int i = powersetVal-1  ; i > 0 ; i--){
			 for (int j = 0 ; j < integers.length ; j++){
				 if (BigInteger.valueOf(i).testBit(j))
					  sb.append(integers[j]).append(",");
			 }
			list.add(sb.toString());
			sb.setLength(0);
		}
		System.out.println(list);
	}
	/*
	 * https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/little-monk-and-good-string/
	 */
	public static void findLongestSubStringConsistingOfOnlyVowels() throws IOException
	{   
		
		//TLE
//		Set<Character> vowelsSet =  new HashSet<Character>();
//		//populate
//		vowelsSet.add('a');
//		vowelsSet.add('e');
//		vowelsSet.add('i');
//		vowelsSet.add('o');
//		vowelsSet.add('u');
//		String subString  = "";
//		int lengthOfLongestSuchString = Integer.MIN_VALUE ;
//		for (int i = 0 ; i < str.length() ; i++)
//		{
//			for ( int j = i ; j <= str.length() ; j++)
//			{
//				subString = str.substring(i, j);
//				int tempCount = 0 ;
//				for (char c : subString.toCharArray())
//				{
//					if (!vowelsSet.contains(c)) break;
//					++tempCount;
//				}
//				if (subString.length() == tempCount && subString.length() > lengthOfLongestSuchString)
//				{
//					lengthOfLongestSuchString = subString.length();
//				}
//			}
//		}
		Set<Character> hSet = new HashSet<Character>();
        hSet.add('a');hSet.add('e');hSet.add('i');hSet.add('o');hSet.add('u');

		        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int longestCount = 0;
        int tempCount = 0 ;
		for (char c : str)
		{
		    //if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
		    //if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
		    if (hSet.contains(c))
		    {
		        ++tempCount;
		        longestCount = Math.max(tempCount,longestCount);
		    }
		    else
		    {
		        tempCount = 0 ;
		    }
		}
		System.out.println(longestCount);
		
	}
     
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("test isPalindromeStackImpl " + isPalindromeStackImpl("RADAR"));
		System.out.println("test isPalindromeRecursive " + isPalindromeRecursive("RADAR"));
		System.out.println("test isAnagram " + isAnagram("hello","Hello"));
		//add(1,2);
		isStringNumeric("12.5");
		removeSpace("s a m rat");
		longestSubStringNonRepeatingCharacters("gwkgfoggeeks");//abababcdefababcdab
		groupAnagramsTogether();
		
		wordBreak("IDeservelearningplatform");
		generatePowerSetOfAGivenString("aacc");
		strongestUniqueSubSequence("dcbd");
		generatePowerSetOfIntegers("1 2");
		findLongestSubStringConsistingOfOnlyVowels(); // "abcaac"
		
	}

}
