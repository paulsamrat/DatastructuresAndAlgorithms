/**
 * 
 */
package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Samrat Paul
 *
 */
public class AmazonmiscellaneousQuestions {
	
	//Given two lines . Find whether they intersect or not ?
	
	
	//Your task  is to implement the function atoi. The function takes a string(str) 
	//as argument and converts it to an integer and returns it.

	private void atoi(String str)
	{
		int result = 0 ; 
		
	}
	
	// Custom Sort| Sort elements by their frequency and Index
	//– If two elements have the different
	//	frequencies, then the one which has more frequency should come first.
	//	– If two elements have the same frequencies, then the one which has less index should come first.
	private class CustomElement{
		private int value;
		private int index;
		private int freq;
		
		private CustomElement(final int value , final int index , final int freq)
		{
			this.value = value;
			this.index = index;
			this.freq = freq;
		}
	}
	
	private void customSort(final int[] array)
	{	
		Map<Integer,CustomElement> map = new HashMap<Integer, CustomElement>();
		for(int i = 0 ; i < array.length ;  i++)
		{
			if (map.containsKey(array[i]))
			{
				CustomElement element = map.get(array[i]);
				element.freq++;
			}
			else
			{
				map.put(array[i], new CustomElement(array[i], i, 1));
			}
		}
		
		//sort elements by fre | index
		List<Map.Entry<Integer, CustomElement>> list = new ArrayList<Map.Entry<Integer, CustomElement>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, CustomElement>>(){

			@Override
			public int compare(Entry<Integer, CustomElement> e1, Entry<Integer, CustomElement> e2) {
				// TODO Auto-generated method stub
				if (e2.getValue().freq != e1.getValue().freq)
					return e2.getValue().freq - e1.getValue().freq;
				return e1.getValue().index - e2.getValue().index;
			}

			
			
		});
		for (Map.Entry<Integer, CustomElement> listElement : list)
		{
			System.out.print(listElement.getKey()  + " ");
		}
	}
	
	//*** division w/o using mod multiplication
		//division using binary search algorithm
		//https://www.techiedelight.com/division-two-numbers-using-binary-search-algorithm/
		// Function to perform division of two numbers using 
		// Binary Search Algorithm
		public double divide(double x, double y)
		{
			// handle divisibility by 0
			if (y == 0) {
				return Double.MAX_VALUE;		// return infinity
			}

			// set range for result [left, right]
			// right is set to infinity to handle the case 
			// when y < 1, x < result < Double.MAX_VALUE
			double left = 0.0, right = Double.MAX_VALUE;

			// set accuracy of the result
			double precision = 0.001;

			// store sign of the result
			int sign = 1;
			if (x * y < 0) {
				sign = -1;
			}

			// make both input numbers positive
			x = Math.abs(x);
			y = Math.abs(y);

			while (true) {
				// calculate mid
				double mid = left + ((right - left) / 2);

				// if y*mid is almost equal to x, return mid
				if (Math.abs(y * mid - x) <= precision) {
					return mid * sign;
				}

				// if y*mid is less than x, update left to mid
				if (y * mid < x) {
					left = mid;
				}
				else {
					// if y*mid is more than x, update right to mid
					right = mid;
				}
			}
		}
	/**
	 * @param args
	 */
	//https://www.youtube.com/watch?v=7VPA-HjjUmU
	public void verify_a_prime_number(final int number)
	{
		// as we have seen .
		// for prime number only 2 factors are there . 1 and the number itself
		
		// so if we find any factor other than the above then its nots a prime number .
		
		// for any given number ., if there is no factor till square root of the number . then there is no factor after that
		
		for (int i = 2 ; i <= Math.sqrt(number) ; i++)
			  if (number % i == 0 )  return; // not a prime
	}
	public void square_root()
	{
		
	}
	
	//https://practice.geeksforgeeks.org/problems/find-prime-numbers-in-a-range/0
	//https://www.youtube.com/watch?v=eKp56OLhoQs
	//Finding Prime numbers - Sieve of Eratosthenes
	private void find_all_prime_numbers_in_a_given_range(final int rangeStart , final int rangeEnd)
	{	
		// 1 is neither prime nor composite
		List<Integer> primeNumbers = new ArrayList<Integer>();
		Set<Integer> ignoredNumbers = new HashSet<Integer>();
		for (int i = rangeStart ; i <= rangeEnd ; i++)
		{
			if ( i == 1 ) continue;
			// if i is a prime number . add it to prime numbers list 
			// cancel out all multiples of i .
			// so that it wont be considered while traversing
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonmiscellaneousQuestions obj = new AmazonmiscellaneousQuestions();
		obj.customSort(new int[]{3, 3, 1, 1, 1, 8, 3, 6, 8, 7, 8});
		System.out.println( "divide using binary search algo -- " + obj.divide(22, 7));


	}

}
