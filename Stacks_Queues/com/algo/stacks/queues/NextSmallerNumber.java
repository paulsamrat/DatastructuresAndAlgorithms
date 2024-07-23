package com.algo.stacks.queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextSmallerNumber {
	private static void nextSmallerNumber(final int[] arr) {
		final Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		final Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = arr.length -1 ; i>= 0 ; i--) {
			
			while (!stack.isEmpty() && stack.peek() > arr[i]) {
				stack.pop();
			}
			
			map.put(arr[i], stack.isEmpty() ?  -1 : stack.peek());
			stack.push(arr[i]);
		}
		
		System.out.println(map.toString());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextSmallerNumber(new int[] {13, 7, 6, 12});
	}

}
