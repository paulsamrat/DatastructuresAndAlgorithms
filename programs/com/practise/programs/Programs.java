package com.practise.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Programs {
	
	
	/*
	 *  Duplicate Character in a String.
	 */
	public static void fetchDuplicateCharacter(String inputString)
	{
		Map<Character , Integer> inpStringMap = new LinkedHashMap<Character, Integer>();
		//Code for finding Duplicates
		for (char c  : inputString.toCharArray())
		{
			if ( null != inpStringMap.get(c))
				inpStringMap.put(c, inpStringMap.get(c) + 1);
			else
				inpStringMap.put(c,1);

		}
		
		for (Map.Entry<Character , Integer> entry : inpStringMap.entrySet())
		{
		    if (entry.getValue() > 1 )
		    	System.out.println("Duplicated Character : " + entry.getKey() + " No.of times duplicated " + entry.getValue());
		}
		
		//first Non -repeated character  in a string.
		for (Map.Entry<Character , Integer> entry : inpStringMap.entrySet())
		{
		    if (entry.getValue() == 1 )
		    	System.out.println("First Non- repeated Character : " + entry.getKey());
		    break;
		}
	}
	private static void findNoOfWordsInAString(String inputString) {
		// TODO Auto-generated method stub
		String stringArray[] = inputString.trim().split(" ");
		System.out.println("findNoOfWordsInAString : " + stringArray.length);
	}
	
	/*
	 * Recursion :  Summation of all Numbers.
	 */
	static int recursionSumOfAllNumbers(int inputNumber)
	{
		int sum = 0;
		if ( inputNumber == 0 ) return 0;
		sum += inputNumber % 10 ; 
		return (sum + recursionSumOfAllNumbers(inputNumber / 10 ));
	}
	/*
	 * String to Number without using Integer.ParseInt.
	 */
	static int convert_String_To_Number(String numStr){
         
	        char ch[] = numStr.toCharArray();
	        int sum = 0;
	        //get ascii value for zero
	        int zeroAscii = '0';
	        for(char c:ch){
	            int tmpAscii = c;
	            sum = (sum*10)+(tmpAscii-zeroAscii);
	        }
	        return sum;
	    }
	
	static void printFibonacci(int inputNumber)
	{	
		int count=1;
        int c=0,a=0,b=1;
        System.out.print(a);
        System.out.print(b);
        while(count<=inputNumber){

        	c=a+b;
        	System.out.print(c);
        	a=b;
        	b=c;

        	count++;
        }
     }
	
	
	static int printFibonacciRecursion(int inputNumber)
	{
		 	  if(inputNumber==0)
			   return 0;
			  if(inputNumber==1)
			   return 1;
			  else
			   return   printFibonacciRecursion(inputNumber-1)
			   +printFibonacciRecursion(inputNumber-2);
			 
			
	}
	
	/**
     * Recursive and slow version of breaking word problem.
     * If no words can be formed it returns null
     */
	static final Map<String, String> memoized = new HashMap<String, String>();
	static String SegmentString(String input, Set<String> dict) {
		  if (dict.contains(input)) return input;
		  //if (memoized.containsKey(input)) {
		    //return memoized.get(input);
		  //}
		  int len = input.length();
		  for (int i = 1; i < len; i++) {
		    String prefix = input.substring(0, i);
		    if (dict.contains(prefix)) {
		      String suffix = input.substring(i, len);
		      String segSuffix = SegmentString(suffix, dict);
		      if (segSuffix != null) 
		        return prefix + " " + segSuffix;
		    }
		}
		//memoized.put(input, null);
		return null;
		}
	/*
	 * Longest palindrome
	 */
	public static String longestPalindrome(String s) {
		 
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();
	 
		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (curr.length() > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = curr.length();
					}
				}
			}
		}
	 
		return longestPalindrome;
	}
	 
	public static boolean isPalindrome(String s) {
	 
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
	 
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> str1 = null;
		for (String str : str1)
		{
			System.out.println("passwd");
		}
		// TODO Auto-generated method stub
		char[] str = {'1','a','b','c','3'};
		List<Character> list1 = new ArrayList<Character>();
		for (int i = 0 , j = str.length ; i != j ;)
		{
			//c,a,b,1,3, c,1,b,a,3,
			
		}
		fetchDuplicateCharacter("samrat"); // Also  fetches first non-repeative character 
		findNoOfWordsInAString("My Name is samrat");
		System.out.println("Summation of Integer Number is " + recursionSumOfAllNumbers(12367));
		System.out.println(convert_String_To_Number("54321"));
		printFibonacci(5);
		for(int i=0;i<5;i++)
		{
		  System.out.print("   "+printFibonacciRecursion(i)); 
		}
		
		/*
		 * breaking word problem
		 */
		Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("Play");
        dictionary.add("to");
        //String str = "Iliketo";
        System.out.println("hashcode"+str.hashCode());//-739501605
        System.out.println("test"+dictionary.contains("play"));
        //System.out.println(SegmentString(str, dictionary));
        
        System.out.println(longestPalindrome("12321"));
	}
//	@Override
//	public void method1() {
//		// TODO Auto-generated method stub
//		System.out.println("method1");
//	}


	static String isValid(String s) {
	     int[] count = new int[26];
	     int maxFreq = Integer.MIN_VALUE;
	     int totalFreq = 0 ;
	     int totalDistinctChars = 0 ; 
	     char charHavMaxFreq = ' ';
	     for (char c : s.toCharArray())   
	    {   
	              if (count[c-'a'] == 0 ) ++totalDistinctChars;
	              count[c-'a']++;
	              ++totalFreq;
	              if ( count[c-'a'] > maxFreq) 
	               {
	                    maxFreq = count[c-'a'];
	                    charHavMaxFreq = c;
	               }     
	    }

	    if ( (totalFreq % totalDistinctChars ) ==  0) return "YES";
	    count[charHavMaxFreq-'a']--;
	    boolean val ;
	    for(char c : s.toCharArray())
	    {
	         if (count[c-'a'] != 0  && count[c-'a'] != maxFreq-1)
	        	 return "NO";
	    }
		return val;
	    }

}
