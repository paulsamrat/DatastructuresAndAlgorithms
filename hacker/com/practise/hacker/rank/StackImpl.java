package com.practise.hacker.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackImpl {
	//Balanced Brackets//https://www.hackerrank.com/challenges/balanced-brackets/problem
	public static void main(String[] args) throws Exception {
		/*
		 * 10
			1 97
			2
			1 20
			2
			1 26
			1 20
			2
			3
			1 91
			3
		 */
		//printMaxinO1();
		
		isParanthesisBalanced();
	}
	
	private static void isParanthesisBalanced() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for ( int i = 0 ; i < n ; i++)
        {	
        	String s = br.readLine();
        	if (s.length() % 2 != 0); //print "NO" ; //odd no of characters wont pass
            Stack<Character> stack =  new Stack<Character>();
             for (char c : s.toCharArray())
             {
                if (c == '{' || c == '[' || c =='(')
                    stack.push(c);
                else if (!stack.isEmpty())
                {
                    char c1 = stack.pop();
                    if ((c1=='{' && c != '}') || (c1=='[' && c != ']') || (c1=='(' && c != ')'));// print "NO";
                }  
                else
                {
                    //print  "NO";
                }   
            }

           // stack.isEmpty() ? "YES" :"NO";
        }
		
	}

	//https://www.hackerrank.com/challenges/maximum-element/problem
	public static void printMaxinO1() throws Exception
	{

		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for ( int i = 0 ; i < n ; i++)
		{
			String[] splitArray = br.readLine().split(" ");
			int operation = Integer.parseInt(splitArray[0]);
			switch (operation) {
			case 1:
				int stackVal = Integer.parseInt(splitArray[1]);
				stack.push(stackVal);
				if ( tempStack.isEmpty())
				{
					tempStack.push(stackVal);	
				}
				else
				{
					if (tempStack.peek() < stackVal)
					{
						tempStack.push(stackVal);
					}
					else
					{
						tempStack.push(tempStack.peek());
					}
				}
				break;
			case 2:
				stack.pop();
				if (stack.isEmpty() && !tempStack.isEmpty())
				{
					tempStack.clear();
				}
				else
				{
					tempStack.pop();
				}
				break;
			case 3:
				System.out.println(tempStack.peek());
				break;
			}
		}
	
	}
	
	//https://www.hackerrank.com/challenges/castle-on-the-grid/problem
	//Output an integer denoting the minimum number of steps required to move the castle to the goal position.

	private static void printMinStepsToReachDest() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] charGrid =  new char[n][n];
		for (int i = 0 ; i < n ; i++)
		{
			//forming the nXn char grid
			char[] charArr = br.readLine().toCharArray();
			for (int j = 0 ; j < n ; j++)
			{
				charGrid[i][j] = charArr[j];
			}
		}
		String[] gridPoints = br.readLine().split(" ");
		int startingPointX =  Integer.parseInt(gridPoints[0]);
		int startingPointY = Integer.parseInt(gridPoints[1]);
		int destinationPointX =  Integer.parseInt(gridPoints[2]);
	    int destinationPointY = Integer.parseInt(gridPoints[3]);
	    
	    //min steps to reach destination from starting . // we can only go horizontal or vertical
	    for (int i = startingPointX , j = startingPointY ; i < n ; i++,j++)
	    {
	    	
	    }
	}
	
}
