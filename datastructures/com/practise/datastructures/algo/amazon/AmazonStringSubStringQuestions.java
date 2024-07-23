package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AmazonStringSubStringQuestions {
	
	// Length : Longest substring with 'M' unique characters
	//KARAPPA
	// M=2  APPA
	// M=3 ARAPPA
 	//faster O(N2)
	private void longest_substring_m_unique_characters_array(final String inputStr , final int M)
	{
		int longestSubStringLength = Integer.MIN_VALUE;
		int[] countArr = new int[126];
		long startTime = System.currentTimeMillis();

		for ( int i = 0 ; i< inputStr.length() ; i++)
		{	
			int tempCount = 0 ;
			int tempLongestSubStringLength = 0 ; 
			for ( int j = i ;  j < inputStr.length() ; j++)
			{	
				int idx = inputStr.charAt(j) - 'A';
				if ( countArr[idx] == 0 ) // is it unique  - unique characters can repeat 
					//occuring for first time or already occured once
				{
					//yes
					countArr[idx]++;
					++tempCount;
				}
			    if (tempCount  > M) break;
				++tempLongestSubStringLength; 
			}
			longestSubStringLength = Math.max(longestSubStringLength, tempLongestSubStringLength);
			Arrays.fill(countArr, 0);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		System.out.println( "longest_substring_m_unique_characters_array = " + longestSubStringLength);

	}
	//O(N)
	//https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
	private void longest_substring_m_unique_characters_array_1(String s, int k) {
	    int[] map = new int[256];
	    int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

	    while (end < s.length()) {
	      final char c1 = s.charAt(end);
	      if (map[c1] == 0) counter++;
	      map[c1]++;
	      end++;

	      while (counter > k) {
	        final char c2 = s.charAt(start);
	        if (map[c2] == 1) counter--;
	        map[c2]--;
	        start++;
	      }

	      maxLen = Math.max(maxLen, end - start);
	    }

	    System.out.println("longest_substring_m_unique_characters_array_1 = " + maxLen);
	  }
	
	//O(N)
	//https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
	private void longest_substring_without_repeating_characters_array(String s) {
	    int[] map = new int[128];
	    int start = 0, end = 0, maxLen = 0, counter = 0;

	    while (end < s.length()) {
	      final char c1 = s.charAt(end);
	      if (map[c1] > 0) counter++;
	      map[c1]++;
	      end++;

	      while (counter > 0) {
	        final char c2 = s.charAt(start);
	        if (map[c2] > 1) counter--;
	        map[c2]--;
	        start++;
	      }

	      maxLen = Math.max(maxLen, end - start);
	    }

	   System.out.println("longest_substring_without_repeating_characters_array = " + maxLen);
	  }
	private void longest_substring_m_unique_characters_HashSet(final String inputStr , final int M)
	{
		int longestSubStringLength = Integer.MIN_VALUE;
		Set<Character> hSet = new HashSet<Character>();
		long startTime = System.currentTimeMillis();
		for ( int i = 0 ; i< inputStr.length() ; i++)
		{	
			int tempUniqueCount = 0 ;
			int tempLongestSubStringLength = 0 ; 
			for ( int j = i ;  j < inputStr.length() ; j++)
			{	
					if(hSet.add(inputStr.charAt(j)))
						++tempUniqueCount;	
					if (tempUniqueCount > M ) break;
					++tempLongestSubStringLength;
			}
			longestSubStringLength = Math.max(longestSubStringLength, tempLongestSubStringLength);
			hSet.clear();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		System.out.println( "longest_substring_m_unique_characters_HashSet = " + longestSubStringLength);
	}
	
	//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	//Input: S = "ADOBECODEBANC", T = "ABC"
	//Output: "BANC"
	
	private void min_window_substring(final String S , final String T )
	{
		int [] map = new int[128];
	    for (char c : T.toCharArray()) {
	      map[c]++;
	    }
	    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = T.length();
	    while (end < S.length()) {
	      final char c1 = S.charAt(end);
	      if (map[c1] > 0) counter--;
	      map[c1]--;
	      end++;
	      while (counter == 0) {
	        if (minLen > end - start) {
	          minLen = end - start;
	          minStart = start;
	        }
	        final char c2 = S.charAt(start);
	        map[c2]++;
	        if (map[c2] > 0) counter++;
	        start++;
	      }
	    }

	    String minLenSubString = ( minLen == Integer.MAX_VALUE ) ? "" : S.substring(minStart, minStart + minLen);
	    System.out.println("min_window_substring " + minLenSubString);
	}
	//https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string/0
	//Given a string S and text T. Output the smallest window in the string S having all characters of the text T. 
	//Both the string S and text T contains lowercase english alphabets.
	private void min_window_subtring_1(final String str1 , final String str2)
	{
		
	}
	//Find All Anagrams in a String
	//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
   //https://leetcode.com/problems/substring-with-concatenation-of-all-words/
	//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
	//
	//The order of output does not matter.
	//
	//Example 1:
	//
	//Input:
	//s: "cbaebabacd" p: "abc"
	//
	//Output:
	//[0, 6]
	//
	//Explanation:
	//The substring with start index = 0 is "cba", which is an anagram of "abc".
	//The substring with start index = 6 is "bac", which is an anagram of "abc".
	//O(N2)
	private void find_all_anagrams_array(final String s , final String p)
	{
		if ( null == s || s.length() == 0 || s.length() < p.length()) return;
		List<Integer> subStringStartIdxList = new ArrayList<Integer>();
		int[] pCount = new int[26];
		int[] sCount = new int[26];
		for(char c : p.toCharArray())
				pCount[c-'a']++;
		for (int i = 0 ; i <= s.length() - p.length() ; i++)
		{	
			for (int j = 0 ; j < p.length() ; j++)
			{
				sCount[s.charAt(i+j)-'a']++;
			}
			//do both arrays have same set of elements
			if ( isBothArraySame(pCount, sCount))
				subStringStartIdxList.add(i);
			Arrays.fill(sCount, 0);
			
		}
		System.out.println("find_all_anagrams_array -- starting indices of all anagrams " + subStringStartIdxList);
	}
	
	private void find_all_anagrams_sliding_window(final String s , final String p)
	{
		if ( null == s || s.length() == 0 || s.length() < p.length()) return;
		List<Integer> subStringStartIdxList = new ArrayList<Integer>();
		int[] pCount = new int[26];
		int[] sCount = new int[26];
		//count p characters count
		for(char c : p.toCharArray())
				pCount[c-'a']++;
		//pre-process  the first window
		for (int i = 0 ; i < p.length() ; i++)
		{
			sCount[s.charAt(i) - 'a']++;
		}
		if (isBothArraySame(sCount, pCount))
			subStringStartIdxList.add(0);
		for (int i = 1 ; i <= s.length()-p.length() ; i++)
		{	
			sCount[s.charAt(i+p.length()-1) - 'a']++; // increase the frequency of the current element 
			sCount[s.charAt(i-1)-'a']--; //reduce the frequency of the preceeding element
	
			//do both arrays have same set of elements
			if ( isBothArraySame(pCount, sCount))
				subStringStartIdxList.add(i);
			
		}
		System.out.println("find_all_anagrams_sliding_window -- starting indices of all anagrams " + subStringStartIdxList);
	}
	
	private boolean isBothArraySame(final int[] array1 , final int[] array2)
	{
		for (int i =  0 ; i < array1.length ; i++)
		{
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
	//Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

	// we need to get all substrings - O(N2)
	private void find_anagramic_pairs(final String str)
	{	
		System.out.println( " -- find_anagramic_pairs -- ");
		Map<String,Integer> map = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < str.length() ; i++)
		{
			for (int j = i+1 ; j <= str.length() ; j++)
			{
				char[] temp = str.substring(i, j).toCharArray();
				if (temp.length >  1 ) 
				{
					Arrays.sort(temp);
				}
				for (char c : temp) sb.append(c);
				final String key = sb.toString();
				if (map.containsKey(key))
						map.put(key, map.get(key)+1);
				else
					map.put(key, 1);
				
				sb.setLength(0);
			}
		}
		
		//calculate anagramic pairs
		int count = 0 ;
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			if (entry.getValue() % 2 == 0) count += entry.getValue() / 2 ;
		}
		
		System.out.println(count);
	}
	
	
	//30. Substring with Concatenation of All Words
	//	You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
	//
	//	Example 1:
	//
	//	Input:
	//	  s = "barfoothefoobarman",
	//	  words = ["foo","bar"]
	//	Output: [0,9]
	//	Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
	//	The output order does not matter, returning [9,0] is fine too.
	//	Example 2:
	//
	//	Input:
	//	  s = "wordgoodgoodgoodbestword",
	//	  words = ["word","good","best","word"]
	//	Output: []
	
	private List<Integer> substring_concat_of_all_words(final String str , final String[] words)
	{
		List<Integer> startingIdxList = new ArrayList<Integer>();
		if ( null == str || str.length() == 0 ||  null == words || words.length == 0 ) return startingIdxList;
		int[] charFreq = new int[26];
		int charCount = 0 ;
		for (String word : words)
		{
			for (char c : word.toCharArray())
			{
				charFreq[c-'a']++;
				++charCount;
			}
		}
		for (int i = 0 ; i < str.length() ; i++)
		{
			charFreq[str.charAt(i)-'a']--;
			if (i>=charCount)
				charFreq[str.charAt(i-charCount)-'a']++;
			//are all counts sums to zero
			if (isCharFreqZero(charFreq))
				 startingIdxList.add(i-charCount+1);
		}
		System.out.println("substring_concat_of_all_words : beginning indices " + startingIdxList);
		return startingIdxList;
	}
	
	
	private boolean isCharFreqZero(int[] charFreq) {
		// TODO Auto-generated method stub
		for (int i : charFreq)
		{
			if ( i != 0) return false;
		}
		return true;
	}
	
	//https://www.ideserve.co.in/learn/index-of-0-replacing-with-1-results-in-longest-continuous-1s-sequence
	private void index_of_zero_to_be_replaced_to_get_longest_substring_of_only_1s(final String str)
	{
		//sliding window
		//find largest window consisting of only 1 zero 
		int start = 0 , end = 0;
		int countOfZero = 0 ;
		int lengthLongestSubStringOf1s = Integer.MIN_VALUE;
		while(end <= str.length() -1 )
		{
				if (str.charAt(end) == '0') ++countOfZero;
				if (countOfZero == 2)
				{
					lengthLongestSubStringOf1s = Math.max(lengthLongestSubStringOf1s, end-start);
					while(countOfZero != 1)
					{
						if (str.charAt(start) == '0') --countOfZero;
						++start;
					}
				}
				++end;
				lengthLongestSubStringOf1s = Math.max(lengthLongestSubStringOf1s, end-start);
		}
		System.out.println("index_of_zero_to_be_replaced_to_get_longest_substring_of_only_1s " +lengthLongestSubStringOf1s );
	}
	
	/*
	 * A traditional competition is: for two given words source and target, find the shortest
	substring of source such that it contains all letters needed to construct target. However,
	people have become quite good at that competition so this year organizers decided to
	enhance the competition. The goal now is to find the shortest circular substring of the
	source, such that it contains all the letters needed to construct the target. For clarification,
	they added the following note to the rules:
	
	A circular substring of a string of length n is any segments of at most n consecutively
	neighboring letters in the string considering the fact that the right neighbor of the last
	letter is the first letter. For example, if the string is "hackerrank", circular substrings can be
	obtained from "ackerrankh", "ckerrankha", "kerrankhac" and so on. The words "rankhack"
	and "ack" are valid circular substrings of this string.
	
	As an example, assume source = melody and target = ldym. In its current form,
	source[0:5], length = 6 contains all of the letters in target. If we rotate source so that
	source' = elodym we see that source'[1:5] contains all the characters of target. Since no
	shorter substring can be found, we choose the shortest substring length of 5 as the
	answer. If there had been no answer, we would have returned -1.				
	 */
	
	public int circular_substring_competition(String target, String source) {
		
		int targetCount[] = new int[26];
		//int sourceCount[] = new int[26];
		//store target count
//		for (char c : target.toCharArray())
//		{
//			targetCount[c-'a']++;
//		}

		//left rotate the array by 1 position till all rotations are done
		// max no of rotations is equal to the size of the array . one more rotation array becomes original 
		//rotating source array
		for(int i = 0 ; i < source.length() ;i++)
		{	
			//left rotate array by 1 position
			source = leftRotate(source);
			Arrays.fill(targetCount, 0);
			for (char c : target.toCharArray())
			{
				targetCount[c-'a']++;
			}
			int start = 0, end = 0, minStart = 0,counter = target.length();
			int shortestCirSubStringLength = Integer.MAX_VALUE;
			while (end < source.length())
			{
				if (targetCount[source.charAt(end)-'a'] > 0 ) --counter;
				targetCount[source.charAt(end)-'a'] --;
				
				
				while ( counter == 0)
				{
					if (shortestCirSubStringLength > (end-start+1))
					{
						shortestCirSubStringLength = (end -start+1);
						minStart = start;
					}
					final int index = source.charAt(start)-'a';
			        targetCount[index]++;
			        if (targetCount[index] > 0) counter++;
			        start++;
				}
				++end;
			}
			String minLenSubString = ( shortestCirSubStringLength == Integer.MAX_VALUE ) ? "" : source.substring(minStart, minStart + shortestCirSubStringLength);
		    System.out.println("min_window_substring values -- " + minLenSubString);
		}
		return -1;
	}
	//left rotate by 1 position
	private String leftRotate(String str)
	{
		return str.substring(1)+str.charAt(0);
	}
	
	private void remove_duplicates_O1_Space(String str)
	{	
		System.out.println( " -- remove_duplicates_O1_Space -- ");
		String result = "";
		for (int i = 0 ; i < str.length() ; i++)
		{
			if ( result.indexOf(str.charAt(i)) < 0 )
			{
				result = result + str.charAt(i);
			}
		}
		System.out.println(result);
	}
	
	/*
	 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
		For Example:
		ab: Number of insertions required is 1. bab or aba
		aa: Number of insertions required is 0. aa
		abcd: Number of insertions required is 3. dcbabcd
	 */
	private int min_insertions_req_to_convert_it_to_palindrome(String str , int start , int end)
	{	
		if ( start < end )
		{
			if (str.charAt(start) == str.charAt(end))
				 return min_insertions_req_to_convert_it_to_palindrome(str,start+1,end-1);
			else
				return 1 + Math.min(min_insertions_req_to_convert_it_to_palindrome(str, start + 1, end),
						min_insertions_req_to_convert_it_to_palindrome(str, start, end - 1));
		}
		else
		{
			return 0;
		}
	}
	
	private void helper_min_insertions_req_to_convert_it_to_palindrome(String str , int start , int end)
	{	 
		System.out.println( " -- min_insertions_req_to_convert_it_to_palindrome -- " );
		int result = min_insertions_req_to_convert_it_to_palindrome(str,start,end);
		System.out.println(result);
	}
	
	//permutations of a string 
	public void permutation(String str) { 
		    Set<String> uniquePermutaions = new HashSet<String>();
			permutation1("", str , uniquePermutaions); 
			System.out.println(uniquePermutaions);
			//permutaions start with one.
			int count = 0 ;
			for ( String val : uniquePermutaions){
				  if ( val.charAt(0) == '1' ) ++count;
			}
			System.out.println( " result " + count);
		}

	private void permutation(String prefix, String str ,  Set<String> uniquePermutaions) {
		    int n = str.length();
		    if (n == 0) {
		    	uniquePermutaions.add(prefix);
		    	//System.out.println(prefix);
		    }
		    else {
		        for (int i = 0; i < n; i++)
		            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n) , uniquePermutaions);
		    }
	}
	
		static void combinationUtil(String str, char data[], int start, int end, int index, int r , Set<String> permutations) 
				{ 
				// Current combination is ready to be printed, print it 
				if (index == r) 
				{ 	
					String temp = "";
					for (int j=0; j<r; j++) 
						temp+=data[j]; 
					permutations.add(temp);
					return; 
				} 
				
				// replace index with all possible elements. The condition 
				// "end-i+1 >= r-index" makes sure that including one element 
				// at index will make a combination with remaining elements 
				// at remaining positions 
				for (int i=start; i<=end && end-i+1 >= r-index; i++) 
				{ 
				data[index] = str.charAt(i); 
				combinationUtil(str, data, i+1, end, index+1, r , permutations); 
				} 
				} 

		// The main function that prints all combinations of size r 
		// in arr[] of size n. This function mainly uses combinationUtil() 
		static void printCombination(String str, int n, int r) 
		{ 
		// A temporary array to store all combination one by one 
		char data[]=new char[r]; 
		
		// Print all combination using temprary array 'data[]' 
		Set<String> permutations = new HashSet<String>();
		combinationUtil(str, data, 0, n-1, 0, r, permutations); 
		System.out.println(permutations);
		} 
	//taking 2 characters at a time 
	private void permutation1(String prefix, String str ,  Set<String> uniquePermutaions) {
	    int n = str.length();
	    if (n == 0) {
	    	uniquePermutaions.add(prefix);
	    	//System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n-1; i++)
	            permutation1(prefix + str.charAt(i)+str.charAt(i+1), str.substring(0, i) + str.substring(i+2, n) , uniquePermutaions);
	    }
}
	
	//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
	/*
	 * Example:
		Input:
		2
		geeksforgeek
		acaaabbbacdddd
		
		Output:
		gksforgk
		acac
	 */
	
	private void remove_all_adjacent_duplicates(final String str)
	{	
		System.out.println( " -- remove_all_adjacent_duplicates -- " );
		StringBuilder sb=new StringBuilder(str);
        for (int i = 1; sb.length()>1 && i <sb.length() ; i++) {
            if(sb.charAt(i)==sb.charAt(i-1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i=-2;
                if(i<0)
                    i=0;
            }
        }
        System.out.println(sb.toString());
	}
	//https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/
//	Time Complexity : Since we are iterating through all the strings and for each string we are iterating though each characters, so we can say that the time complexity is O(N M) where,
//
//	N = Number of strings
//	M = Length of the largest string string 
	private void longest_common_prefix_word_by_word_matching(String[] arr)
	{	
		System.out.println( " -- longest_common_prefix_word_by_word_matching -- " );
		//using divide and conquer
		String prefix = arr[0];
		
		//go through all the words now
		for ( int i = 1 ; i < arr.length ; i++)
		{
			prefix = commonPrefix(prefix, arr[i]);
		}
		System.out.println(prefix);
	}
	
	private String commonPrefix(final String s1 , final String s2)
	{
		StringBuilder sb = new StringBuilder();
		for (int i=0,j=0 ; i < s1.length() && j < s2.length() ; i++,j++)
		{
			if (s1.charAt(i) != s2.charAt(j)) break;
			sb.append(s1.charAt(i));
		}
		return sb.toString();
	}
	
	private void longest_common_prefix_char_by_char_matching(String[] arr)
	{	
		System.out.println("  -- longest_common_prefix_char_by_char_matching -- ");
		//fetch the lowest word length first
		String lowestLengthWord = arr[0];
		for ( int i = 1 ; i < arr.length ; i++)
		{
			if (arr[i].length() < lowestLengthWord.length()) lowestLengthWord = arr[i];
		}
		
		//check char by char 
		StringBuilder longestCommonPrefix = new StringBuilder();
		char current; // The current character 
		  
        for (int i = 0; i < lowestLengthWord.length(); i++) 
        { 
            // Current character (must be same 
            // in all strings to be a part of 
            // result) 
            current = arr[0].charAt(i); 
  
            for (int j = 1; j < arr.length; j++)  
            { 
                if (arr[j].charAt(i) != current)  
                { 
                    System.out.println( longestCommonPrefix.toString() ) ;
                    break;
                } 
            } 
  
            // Append to result 
            longestCommonPrefix.append(current); 
        }
	}
	
	private String longest_common_prefix_divide_and_conquer(String[] arr , int start , int end)
	{
		if (start >= end) return arr[start];
		int mid = start + (end - start) / 2 ; 
		String left = longest_common_prefix_divide_and_conquer(arr, start , mid);
		String right = longest_common_prefix_divide_and_conquer(arr, mid+1 , end);
		return commonPrefix(left,right);
	}
	private void helper_longest_common_prefix_divide_and_conquer(String[] arr , int start , int end)
	{
		System.out.println( " -- longest_common_prefix_divide_and_conquer -- " );
		String result = longest_common_prefix_divide_and_conquer(arr,start,end);
		System.out.println(result);
	}
	
	//https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
	
	//each trie node can have 26 other trie node (childrens) - we are considering only lower case english alphabets
	
	private class Trie
	{
		Trie[] childrens = new Trie[26];
		boolean isLeaf;
		char c ;
		private Trie(final char c){this.c = c;}
	}
	private void longest_common_prefix_trie(String[] arr)
	{	
		System.out.println( " -- longest_common_prefix_trie -- ");
		Trie root = new Trie(' ');
		Trie curr;
		for (String str : arr)
		{
			curr = root; //to traverse the trie
			//push all strings . char by char into trie
			for (char c : str.toCharArray())
			{
				// find index of the current character
				//if character already present go to next children of the occupied trie node
				if ( curr.childrens[c-'a'] == null)
					 curr.childrens[c-'a'] = new Trie(c);
				curr = curr.childrens[c-'a'];
			}
			curr.isLeaf = Boolean.TRUE; // end traversing the string 
		}
		
		//iterate through trie . 
		// the longest common prefix will have single children till the point of diversion
		curr = root;
		StringBuilder longestCommonPrefix = new StringBuilder();
		AtomicInteger i = new AtomicInteger();
		while (  countChildren(curr,i) == 1 && curr.isLeaf != Boolean.TRUE)
		{
			longestCommonPrefix.append(curr.childrens[i.intValue()].c);
			curr = curr.childrens[i.intValue()];
		}
		
		System.out.println(longestCommonPrefix.toString());
		
	}
	private int countChildren(Trie node , AtomicInteger index) 
    { 
        int count = 0; 
        for (int i=0; i<26; i++) 
        { 
            if (node.childrens[i] != null) 
            {
            	count++; 
            	index.set(i);
            }
        } 
        return count; 
    } 
	
	private void find_next_greater_string(final String[] strArray)
	{	
		System.out.println( " --  find_next_greater_string -- ");
		for (int i = 0 ; i < strArray.length ; i++)
		{
			int smallestIdx =  -1; 
			final char[] str = strArray[i].toCharArray();
			for ( int j = str.length - 1 ; j > 0 ; j--)
			{
				if (str[j-1] < str[j])
				{
					smallestIdx = j-1;
					break;
				}
			}
			if (smallestIdx == -1) { System.out.println( " Not Possible "); continue ;}
			// find the next bigger char from the smallestidx 
			char min = str[smallestIdx+1]; 
			int minIdx = smallestIdx+1;
			for (int k = smallestIdx+2 ; k < str.length ; k++)
			{
				if (str[k] > str[smallestIdx] && str[k]  < min)
				{
					min = str[k];
					minIdx = k;
				}	
				
			}
			
			char temp = str[minIdx];
			str[minIdx] = str[smallestIdx] ;
			str[smallestIdx] = temp;
			
			Arrays.sort(str,smallestIdx+1,str.length);
			System.out.println(Arrays.toString(str));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonStringSubStringQuestions obj = new AmazonStringSubStringQuestions();
		obj.longest_substring_m_unique_characters_HashSet("KARAPPA", 3);
		obj.longest_substring_m_unique_characters_array("karappa", 3);
		obj.longest_substring_m_unique_characters_array_1("aabbcc", 2);
		obj.longest_substring_without_repeating_characters_array("aaab");
		obj.min_window_substring("ADOBECODEBANC","BANC");
		obj.find_all_anagrams_array("cbaebabacd","abc");//abab - ab
		obj.find_all_anagrams_sliding_window("abab","ab");
		obj.substring_concat_of_all_words("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
		obj.index_of_zero_to_be_replaced_to_get_longest_substring_of_only_1s("1110011110010111");
		obj.circular_substring_competition("kanah","hackerrank");
		obj.remove_duplicates_O1_Space("geeks for geeks");
		obj.helper_min_insertions_req_to_convert_it_to_palindrome("abcde",0,4);
		obj.permutation("ABCD");
		List<String> list = new ArrayList<String>();
		System.out.println( list);
		obj.remove_all_adjacent_duplicates("geeksforgeek");
		obj.longest_common_prefix_word_by_word_matching( new String[]{"geeksforgeeks", "geeks", "geek", "geezer"});
		obj.longest_common_prefix_char_by_char_matching( new String[]{"geeksforgeeks", "geeks", "geek", "geezer"});
		obj.helper_longest_common_prefix_divide_and_conquer( new String[]{"geeksforgeeks", "geeks", "geek", "geezer"} , 0,3);
		obj.longest_common_prefix_trie( new String[]{"geeksforgeeks", "geeks", "geek", "geezer"});
		obj.find_anagramic_pairs("abba");
		obj.find_next_greater_string(new String[]{"lmno","dcba","dcbb","abdc","abcd","fedcbabcd"});
		printCombination("12345",5,2);
		//1 2 
//		1 3 
//		1 4 
//		2 3 
//		2 4 
//		3 4 
	}
	
}
