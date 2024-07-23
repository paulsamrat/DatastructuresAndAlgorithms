package com.practise.datastructures.algo.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AmazonStackQueueQuestions {
	
	//balanced parenthesis
		/*
		 * {}()  
		   ({()})
		   {}(
		   []
		   true
		   true
		   false
		   true
		   ({}[])
			(({()})))
			({(){}()})()({(){}()})(){()}
			{}()))(()()({}}{}
			}}}}
			))))
			{{{
			(((
			[]{}(){()}((())){{{}}}{()()}{{}{}}
			[[]][][]
		 */
		private void isBalancedParenthesis(){
			Stack<Character> stack = new Stack<Character>();
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()){
				String str = sc.next();
				boolean isBalanced = true;
				char[] charArray = str.toCharArray();
				stack.clear();
				for (char c : charArray){
					if ( c == '(' || c == '{'  || c == '[')
						stack.push(c);
					else if ( c == ')' || c == '}'  || c == ']'){
						if (!stack.isEmpty()){
							char c1  = stack.pop();
							if ( 1 != isMatched(c1, c))
								isBalanced = false;
						}else{
	                        isBalanced = false;
	                    }
					}
				}
				System.out.println(isBalanced && stack.isEmpty());// need to check whether stack contains any staring parenthesis or not

				}
			}
		
		public int isMatched(char character1 , char character2){
			if (character1 == '(' && character2 == ')')
				return 1;
			else if (character1 == '{' && character2 == '}')
				return 1;
			else if (character1 == '[' && character2 == ']')
				return 1;
			else
				return -1;
		}
		public  boolean isBalancedParenthesisMap(String str){
			Map<Character,Character> hashMap = new HashMap<Character, Character>();
			hashMap.put('{', '}');
			hashMap.put('[', ']');
			hashMap.put('(', ')');
			Stack<Character> stack = new Stack<Character>();
			int longestValidParenthesis = 0;
			for (char c : str.toCharArray()){
				if (hashMap.keySet().contains(c))
						stack.push(c);
				else if (hashMap.values().contains(c)){
					    if (!stack.isEmpty() && hashMap.get(stack.peek()) == c){
					    	 stack.pop();
					    	 longestValidParenthesis+=2; // longest parenthesis
					    }
					    else
					       return false;
				}
			}
			return stack.isEmpty();

		}
		
	private void queue_using_two_stacks(final int[] operations)
	{	
		System.out.println( " -- queue_using_two_stacks -- ");
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for ( int i = 0 ; i < operations.length ;)
		{
			switch (operations[i]) {
			case 1: //enque operation
				//always push to stack1
				stack1.push(operations[i+1]);
				i = i+2;
				break;

			case 2:
				//pop
				//deque all elements expect the first 
				if (stack2.isEmpty())
				{
					while (!stack1.isEmpty())
					{
						stack2.push(stack1.pop());
					}
				}
				System.out.println(" popped element - " + stack2.pop());
				++i;
				break;
			}
		}
	}
	
	private void stack_using_two_queues(final int[] operations)
	{	
		System.out.println( " -- stack_using_two_queues -- ");
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		for ( int i = 0 ; i < operations.length ;)
		{
			switch (operations[i]) {
			case 1: //push into stack
				//always push to queue1
				queue1.offer(operations[i+1]);
				i = i+2;
				break;

			case 2:
				//pop
				//deque all elements expect the first 
				
				if (!queue1.isEmpty())
				{	
					int queue1Size = queue1.size();
					while(queue1Size != 1)
					{
					queue2.offer(queue1.poll());
					--queue1Size;
					}
					System.out.println(" popped element - " + queue1.poll());
				}
				else
				{
					System.out.println(" popped element - " + -1);
				}
				Queue<Integer> tempQueue = queue1;
				queue1 = queue2;
				queue2 = tempQueue;
				++i;
				break;
			}
		}
	}
	//https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
	private void  first_non_repeating_character_in_a_stream(final String str)
	{	
		System.out.println( " -- first_non_repeating_character_in_a_stream -- ");
		int[] count = new int[26];
		Queue<Character> queue = new LinkedList<Character>();
		for (char c : str.toCharArray())
		{
			//increse the incoming char count
			count[c-'a']++;
			//enque
			queue.offer(c);
			
			// check for the non repeating character 
            while (!queue.isEmpty()) { 
                if (count[queue.peek() - 'a'] > 1) 
                	queue.remove(); 
                else { 
                    System.out.print(queue.peek() + " "); 
                    break; 
                } 
            } 
            if (queue.isEmpty()) 
                System.out.print(-1 + " "); 
		}
	}
	/*
	 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
		0: Empty cell
		
		1: Cells have fresh oranges
		
		2: Cells have rotten oranges 
		So we have to determine what is the minimum time required so that all the oranges become rotten. 
		A rotten orange at index [i,j] 
		can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
		If it is impossible to rot every orange then simply return -1.
	 */
	//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
	private class OrangeLocation{
		private int xCellIdx;
		private int yCellIdx;
		
		private OrangeLocation(final int xCellIdx , final int yCellIdx)
		{
			this.xCellIdx = xCellIdx;
			this.yCellIdx = yCellIdx;
		}
	}
	private void min_time_req_to_rot_all_oranges(final int[][] matrix)
	{
		Queue<OrangeLocation> queue = new LinkedList<AmazonStackQueueQuestions.OrangeLocation>();
		
		//store all already rotten oranges location
		for (int i=0 ; i < matrix.length ; i++)
		{
			for (int j = 0 ;  j < matrix[0].length ; j++)
			{
				if (matrix[i][j] == 2) queue.add(new OrangeLocation(i, j));
			}
		}
		int minTime = 0 ;
		//boolean validOrangesFound  = Boolean.FALSE;
		// insert a delimiter to assure all rotten oranges are traversed in the first pass
		queue.add(new OrangeLocation(-1, -1));
		
		while(!queue.isEmpty())
		{
			
			// consider all already rotten oranges 
			// check neighbors of a single rotten orange
			// rot the neighbor if possible
			
			OrangeLocation orangeLoc = queue.poll();
			if (orangeLoc.xCellIdx == -1 && orangeLoc.yCellIdx == -1 )
			{	
				++minTime;
				//once all the rotten neighbors are checked -  ***/
				// insert delimiter
				if (queue.size() > 1 )
					queue.add(new OrangeLocation(-1, -1)) ;
				continue;
				
				
			}
			//validOrangesFound  = Boolean.FALSE;
			if ( orangeLoc.xCellIdx > 0 && (matrix[orangeLoc.xCellIdx-1][orangeLoc.yCellIdx] == 1 ))
			{
				// orange at this box is a candidate of being rotten
				matrix[orangeLoc.xCellIdx-1][orangeLoc.yCellIdx] =  2;
				//validOrangesFound = Boolean.TRUE;
				queue.offer(new OrangeLocation(orangeLoc.xCellIdx-1, orangeLoc.yCellIdx));
			}
			if (orangeLoc.xCellIdx < matrix.length - 1 && (matrix[orangeLoc.xCellIdx+1][orangeLoc.yCellIdx] == 1 ))	
			{	
				matrix[orangeLoc.xCellIdx+1][orangeLoc.yCellIdx] =  2;
				//validOrangesFound = Boolean.TRUE;
				queue.offer(new OrangeLocation(orangeLoc.xCellIdx+1, orangeLoc.yCellIdx));
			}
			
			if (orangeLoc.yCellIdx > 0 && (matrix[orangeLoc.xCellIdx][orangeLoc.yCellIdx-1] == 1 ))
			{
				matrix[orangeLoc.xCellIdx][orangeLoc.yCellIdx-1] = 2;
				//validOrangesFound = Boolean.TRUE;
				queue.offer(new OrangeLocation(orangeLoc.xCellIdx, orangeLoc.yCellIdx-1));
			}

			
			if (orangeLoc.yCellIdx < matrix[0].length - 1 && (matrix[orangeLoc.xCellIdx][orangeLoc.yCellIdx+1] == 1 ))
			{
				matrix[orangeLoc.xCellIdx][orangeLoc.yCellIdx+1]  = 2 ;
				//validOrangesFound = Boolean.TRUE;
				queue.offer(new OrangeLocation(orangeLoc.xCellIdx, orangeLoc.yCellIdx+1));
			}
			

		}
		
		//traverse the whole array . can check if there are any remaining fresh oranges
		// if yes " not possible"
		// if no " possible" and mintime required
		
		boolean areAllOrangesRotten = Boolean.TRUE;
		for(int i = 0 ; i < matrix.length ; i++)
		{
			for ( int j = 0 ; j < matrix[0].length ; j++)
			{
				if (matrix[i][j] == 1 ){areAllOrangesRotten = Boolean.FALSE ; break;}
			}
		}
		
		System.out.println(areAllOrangesRotten ? "Possible : Minimum Time Required = " + minTime : " Not Possible");
	}
	/*
	 * Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.

		Note : It may be assumed that the string has only lowercase English alphabets.
		
		Examples:
		
		Input: aaabc 
		Output: abaca 
		
		Input: aaabb
		Output: ababa 
		
		Input: aa 
		Output: Not Possible
		
		Input: aaaabc 
		Output: Not Possible
	 */
	private class CharFreqData{
		private int freq;
		private char c;
		
		private CharFreqData(final int freq , final char c )
		{
			this.freq = freq;
			this.c = c;
		}
	}
	private void no_two_adjacent_characters_are_same(final String str)
	{	
		System.out.println();
		System.out.println( " -- no_two_adjacent_characters_are_same -- " );
		// we will be using the concept of time slicing - cpu
		// all highest priorities characters will be given a chance in a round robin fashion
		
		// lets calculate all frequencies in a freq count array
		int count[] = new int[26];
		for (char c : str.toCharArray())
			count[c-'a']++;
		//lets store all frequencies in a max heap sorted based on frequencies
		Queue<CharFreqData> queue = new PriorityQueue<AmazonStackQueueQuestions.CharFreqData>(new Comparator<CharFreqData>(){

			@Override
			public int compare(CharFreqData o1, CharFreqData o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;  // decreasing
			}
		});
		for (char c : str.toCharArray())
		{
			if (count[c-'a']  > 0 )
			{
				//push it to queue and make the entry as 0 in the count array, so it wont the considered next time
				queue.offer(new CharFreqData(count[c-'a'], c));
				count[c-'a'] = 0 ;
			}
		}
		//queue is sorted by frequencies 
		CharFreqData prevElement = new CharFreqData(-1, '#'); // no two similar characters can be adjacent
		String result = "";
		//traverse queue
		while (!queue.isEmpty())
		{
			//pick the highest freq element from top
			CharFreqData data = queue.poll();
			result = result + (data.c);
			if (prevElement.freq > 0 ) 
			{
				//add back the prev element so it can be consumed in sub sequent calls
				queue.offer(prevElement);
			}
			//reduce the freq
			data.freq --;
			//now this is  will be the prev element
			prevElement = data;
			
		}
		
		//check if the result string is same as original string
		System.out.println(result.length() != str.length() ? " Not Possible " : " Possible");

	}
	//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
	//https://www.youtube.com/watch?v=VmogG01IjYc
	private void median_in_a_stream(final int[] arr)
	{	
		System.out.println( " -- median_in_a_stream -- ");
		//using two pq's
		Queue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
		Queue<Integer> highers = new PriorityQueue<Integer>(); // min heap
		double[] result = new double[arr.length];
		for (int i = 0 ; i < arr.length ; i++)
		{
			// pick the right queue
			if ( lowers.size() == 0 || arr[i] < lowers.peek()) lowers.offer(arr[i]);
			else highers.offer(arr[i]);
			//rebalance if needed
			Queue<Integer> smallerQ = lowers.size() < highers.size() ?lowers:highers ;
			Queue<Integer> biggerQ = lowers.size() < highers.size() ?highers:lowers ;;
			if (biggerQ.size() - smallerQ.size() >=2)
					smallerQ.offer(biggerQ.poll());
			// find median
			if (smallerQ.size() == biggerQ.size())
				 result[i] = (double)(smallerQ.peek() + biggerQ.peek()) / 2 ; 
			else
				result[i] = biggerQ.peek();
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonStackQueueQuestions obj = new AmazonStackQueueQuestions();
		//obj.isBalancedParenthesisMap(")()())");
		//obj.isBalancedParenthesis();
		obj.stack_using_two_queues(new int[]{1 ,2 ,2 ,2 ,1 ,3});
		obj.queue_using_two_stacks(new int[]{1 ,2 ,1 ,3 ,2 ,1 ,4 ,2});
		obj.first_non_repeating_character_in_a_stream("aabc");
		obj.no_two_adjacent_characters_are_same("bbbaa");
		obj.median_in_a_stream(new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4});
		obj.min_time_req_to_rot_all_oranges(new int[][]{  {2, 1, 0, 2, 1},
														  {1, 0, 1, 2, 1},
														  {1, 0, 0, 2, 1}});

	}

}
