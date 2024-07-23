package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AmazonStackQuestions {
	
		/*
	 * Given an array, print the Next Greater Element (NGE) for every element.
	 *  The Next greater Element for an element x is the first greater element on the right side of x in array.
	 *   Elements for which no greater element exist, consider next greater element as -1.
	 */
	private void next_greater_element(final int[] array)
	{
		//iterate through array from left to right 
		// if current element greater than top of stack  
		// yes . dont push the current into stack instead //keep popping elements which are smaller than it 
		// NO . push current element 
		
		Stack<Integer> stack = new Stack<Integer>();
		List<String> result = new ArrayList<String>();
		stack.push(array[0]);
		for (int i = 1 ; i< array.length  ; i++)
		{	
			int element = array[i];
			if (element > stack.peek())
			{
				while (!stack.isEmpty() && element > stack.peek())
				{
					result.add(stack.pop() + " next greater --> " + element);
				}
			}
			stack.push(element);
		}
		if (!stack.isEmpty())
		{
			while (!stack.isEmpty())
			{
				result.add(stack.pop() + " next greater --> " + -1);
			}
		}
		System.out.println( " next_greater_element " + result);
	}
	/*
	 * Consider, for example, the string word = abbcccb and K = 3. 
		We can remove 'c', now word = abbb.
		Now we can remove 'b', so the final word will be a.
		It can be easily proven that the final word will be unique. Also, it is guaranteed that the final word consists of at least one character.
		Function Description
		Complete the function compressWord in the editor below. The function must return a string denoting the final word.
	 */
	
	public String compressWord(String word, int K) {	    
	      // Write your code here
	      Stack<Character> characterStack = new Stack<Character>();
	      Stack<Integer> count = new Stack<Integer>();
	      char[] wordChar = word.toCharArray();  
	      characterStack.push(wordChar[0]);
	      count.push(1);
	      int k = K;
	      for (int i = 1 ; i < wordChar.length ; i++)
	      { 
	        if (characterStack.isEmpty()) 
	            count.push(1);
	        else 
	           count.push(characterStack.peek() ==  wordChar[i] ? count.peek()+1 : 1 );
	        
	        characterStack.push(wordChar[i]);
	        if (count.peek() == k)
	        {
	          while ( k > 0 )
	          {
	            characterStack.pop();
	            count.pop();
	            --k;
	          }
	          k=K;
	        }
	      }
	      StringBuilder sb = new StringBuilder();  
	      while (!characterStack.isEmpty())
	      {
	        sb.append(characterStack.pop());
	      }
	      return sb.reverse().toString();
	 }
	//Given an infix expression in the form of a string str. Conver this infix expression to postfix expression.
	private class Precedence
	{
		private char c;
		private int precedence;
		private Precedence(final char c , final int precedence)
		{
			this.c = c;
			this.precedence = precedence;
		}
	}
	public void infix_to_postfix_conversion(final String infixExpression)
	{
		//precedence of operators
		Map<Character,Integer> mapOfPrecedence =  new HashMap<Character, Integer>();
		mapOfPrecedence.put('/', 9);
		mapOfPrecedence.put('*', 11);
		mapOfPrecedence.put('+', 8);
		mapOfPrecedence.put('-', 7);
		mapOfPrecedence.put('^', 12);
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (char  c : infixExpression.toCharArray())
		{ 
			if (c - 'a' >= 0 && c - 'a' < 26) 
				sb.append(c);
			else	
			{	
				 // if its a opening parenthesis push it
				if (c == '(')
				{
					stack.push(c);
				}
				else if ( c == ')')
				{
					// keep popping till we find a opening bracket
					while (!stack.isEmpty() && stack.peek() != '(')
						sb.append(stack.pop());
					stack.pop();
				}
				// keep popping all operator having higher precedence than current operator
				else
				{
					while (!stack.isEmpty() && mapOfPrecedence.get(stack.peek()) != null
							&& mapOfPrecedence.get(stack.peek()) > mapOfPrecedence.get(c))					{
						sb.append(stack.pop());
					}
					stack.push(c);
				}
					
				
			}
		}
		//check whether still any operators present in stack or not
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println( " infix_to_postfix_conversion -- " + infixExpression + " --> " + sb.toString());
	}
	//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
	public void validate_balanced_parentheses(final String string)
	{	
		System.out.print( " -- validate_balanced_parentheses --  ");
		// if there is a closing braces . insert into stack
		Map<Character,Character> hMap = new HashMap<Character, Character>();
		hMap.put('(', ')');
		hMap.put('{', '}');
		hMap.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		for (char c : string.toCharArray())
		{
			if (hMap.containsKey(c))
			{
				stack.push(c);
			}
			else
			{
				if ( hMap.get(stack.pop()) != c)
				{
					System.out.print( " not balanced parentheses  ");
					return;
				}
			}
		}
		System.out.print( " balanced parentheses ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonStackQuestions obj = new AmazonStackQuestions();
		obj.next_greater_element(new int[]{13, 7, 6, 12});
		System.out.println(obj.compressWord("baac", 2));
		obj.infix_to_postfix_conversion("abcd^e-fgh*+^*+i-");
		obj.validate_balanced_parentheses("({[)]");
	}

}
