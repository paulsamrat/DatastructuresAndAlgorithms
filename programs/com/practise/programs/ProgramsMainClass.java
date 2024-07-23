package com.practise.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ProgramsMainClass {
	
	
	//String having all unique characters
	static boolean isUnique(String characters)
	{
		boolean uniqueString = false;
		for (char c : characters.toCharArray())
		{
			if(characters.indexOf(c) == characters.lastIndexOf(c)) 
				uniqueString = true;
			else
				uniqueString = false;
		}
		return uniqueString;
	}
	
	
	//Using ASCII : To find the unique characters in a string
	//without extra buffer
	static boolean isUniqueASCII(String characters)
	{
		boolean[] char_set  = new boolean[256];
		for (int i=0 ; i <= characters.length() ; i++)
		{
			int value = characters.charAt(i);
			if (char_set[value])
				return false;
			else
				char_set[value] = true;
		}
		return true;
	}	
	
	
	//removing duplicates from a string without using extra buffer
	
	static String removeDuplicate(String str)
	{	
		
		if ( null ==  str) return ""; 
		
		Set<Character>	uniqueStringSet = new LinkedHashSet<Character>();;
		String uniqueString = "";
		for (int i=0; i < str.length() ; i++)
		{	
			char c = str.charAt(i);
			if (!uniqueStringSet.contains(c))
							uniqueStringSet.add(c);

		}
		for ( Iterator<Character> uniqueStringItr = uniqueStringSet.iterator() ; uniqueStringItr.hasNext();)
		{
			 uniqueString += uniqueStringItr.next();
			
		}
	    return uniqueString;
	}
	
	//remove duplicate using ASCII.
	
	static String removeDuplicateASCII(String string)
	{
		 boolean[] char_set = new boolean[256];
		 StringBuilder uniqueString = new StringBuilder();
		 for (char c : string.toCharArray())
		 {	
			 if (char_set[c]) continue;
			 else 
				 char_set[c] = true;
			 	 uniqueString.append(c);
		 }
		 return uniqueString.toString();
	}
	
	//to find whether a string is a rotation of another i.e s1 = apple s2= elppa 
	//using isSubstring api only once.
	
	static boolean isSubstring(String s1 , String s2)
	{
		if (s1.length() != s2.length()) return false;
		String concatenatedString = s1.concat(s1);
		//concatenatedString.substring()//call to substring to check if it contains the string .
		return true;
	}
	
	/*
	 * Reverse a String recursive approach.
	 */
	
	public static String stringReverse(String inputString)
	{	
		String reversedString = "";
		if (inputString.length() == 1 ) return inputString;
		else
			return reversedString += inputString
					.charAt(inputString.length() - 1)
					+ stringReverse(inputString.substring(0,
							inputString.length() - 1));
	}
	/*
	 * Reverse a Number
	 */
	
	public static int numberReverse(int inputNumber)
	{
		int reversedNumber = 0 ;
		while (inputNumber != 0)
		{
			reversedNumber = (reversedNumber*10) + (inputNumber % 10);
			inputNumber = inputNumber / 10;
		}
		return reversedNumber;
	}
	/*
	 * Convert a decimal number to binary
	 */
	static void decimalToBinary(int inputNumber)
	{	
		System.out.println("Binary number Equivalent of : " + inputNumber +" is ");
		int array[] = new int[25];
		int index = 0;
		while (inputNumber > 0 )
		{
			array[index++] = inputNumber % 2 ; 
			 inputNumber =  inputNumber /2; 
		}
		for (int i = index  ; i >= 0 ; i--)
		{
			System.out.print(array[i]);
		}
	}
	/*
	 * Implementing arrays.sort
	 */
	 static int []array = new int[]{4,3,2,1};
	 /*
	  * finding sum of all numbers .
	  */
	 static void sumOfAllNumbers(int inputNumber)
	 {
		 System.out.println("Input Number is " + inputNumber);
		 int sum = 0 ;  
		 while(inputNumber != 0 )
		 {
			 sum += inputNumber%10;
			 inputNumber = inputNumber/10;
		 }
		 System.out.println("The sum is " + sum);
	 }
	 /*
	  * finding sum of all numbers using recursion.
	  */
	 static int sumOfAllNumbersRecursion(int inputNumber)
	 {
		 int sum = 0 ;		 
		 if (inputNumber == 0 ) return sum;
		 else
		 {
			 sum += inputNumber%10;
			 sumOfAllNumbersRecursion(inputNumber / 10 );
		 }
		 System.out.println("The sum is " + sum);
		 return sum;
	 }
	 /*
	  * remove duplicates from a sorted array.
	  */
	 public static int[] removeDuplicates(int[] input){
         
	        int j = 0;
	        int i = 1;
	        //return if the array length is less than 2
	        if(input.length < 2){
	            return input;
	        }
	        while(i < input.length){
	            if(input[i] == input[j]){
	                i++;
	                //printing duplicate elements
	                System.out.println(input[j]);
	            }else{
	                input[++j] = input[i++];
	            }    
	        }
	        int[] output = new int[j+1];
	        for(int k=0; k<output.length; k++){
	            output[k] = input[k];
	        }
	         
	        return output;
	    }
	 private static void printFibonacci(int inputNumber)
	 {
		 int[] fibArray = new int[inputNumber];
		 fibArray[0]=0;
		 fibArray[1]=1;
		 
		 for (int i=2 ; i < inputNumber ;i++)
		 {
			 fibArray[i] = fibArray[i-2] + fibArray[i-1];
		 }
		 for (int i : fibArray) System.out.println(i);
	 }
	 private static void printFibonacci1(int inputNumber)
	 {
		 int fib1 = 0;
		 int fib2 = 1;
		 int fib3 = 0;
		 System.out.println(fib1);
		 System.out.println(fib2);
		 for (int i=2 ; i < inputNumber ;i++)
		 {
			 fib3 = fib1 + fib2;
			 System.out.println(fib3);
			 fib1 = fib2;
			 fib2 = fib3;
		 }
	 }
	 private static int printFibbonacciRecursion(int inputNumber)
	 {
		 if ( inputNumber == 1) return inputNumber;
		 if ( inputNumber ==0 ) return inputNumber;
		 return printFibbonacciRecursion(inputNumber-1) 
		              + printFibbonacciRecursion(inputNumber-2);
	 }
	 
	private static int findHCF(int number1 , int number2)
	{
		if (number2 == 0 ) return number1;
		else
			return findHCF(number2, number1 % number2);
	}
	
	private static void do_bubble_sort(int[] array)
	{
		for (int i = 0 ; i < array.length - 1 ; i++)
		{
			for (int j  = 1 ; j < array.length - i ; j ++)
			{
				if (array[j-1] > array[j])
				{
					int temp = array[j-1] ;
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.println(" bubble - " + Arrays.toString(array));
	}
	
	private static void do_insertion_sort(int[] array)
	{
		for (int i = 1 ; i < array.length ; i++)
		{
			int toPlaceInProperPos = array[i];
			int j =  i ;
			while ( j > 0 &&  array[j-1] > toPlaceInProperPos )
			{
				array[j] = array[j-1];
				--j;
			}
			array[j] = toPlaceInProperPos;
		}
		System.out.println(" do_insertion_sort - " + Arrays.toString(array));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//check whether a string contains unique characters or not.
		//System.out.println( "String passed is unique ? " + isUnique("aaab"));
		//Using ASCII.
		//System.out.println( "String passed is unique ? " + isUniqueASCII("aaab"));
		//unique string check with null / all duplicate // all unique // duplicate + unique
		//System.out.println("Duplicate String passed : " + removeDuplicate(null) );
		//unique string check with null / all duplicate // all unique // duplicate + unique
		//System.out.println("ASCII : Duplicate String passed : " + removeDuplicateASCII("AAA"));
		//Reverse a String using Recursive approach.
		//System.out.println(" Original Input String " + " samrat "  + " Reversed String : " + stringReverse("samrat"));
		//System.out.println("Original Input Number " + 123  + " Reversed Number " + numberReverse(123));
		//Arrays.sort(array);
		//decimalToBinary(6);
		//sumOfAllNumbers(111);
		//sumOfAllNumbersRecursion(1234);
		//removeDuplicates(new int[] {1,2,2,3,4,4});
		//printFibonacci(5);
		//printFibonacci1(5);
		for ( int i =3 ; i<=5 ; i++)
			{System.out.println( printFibbonacciRecursion(i) + "  ");}

		System.out.println(findHCF(17,19));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("1", true);
		map.put("1", true);
		map.put("2", true);
		System.out.println(map.containsValue(false));
		String samrat;
		do
		{
			System.out.println("do some logic");
		}
		while (false);
		if ( null  instanceof NullPointerException)
			System.out.println(" null  instanceof NullPointerException");
		Integer i =1;
		if ( i > 5) System.out.println("print");
		do_insertion_sort(new int[]{1,3,4,2,0});
	}

}
