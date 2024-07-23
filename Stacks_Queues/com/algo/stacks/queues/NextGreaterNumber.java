package com.algo.stacks.queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNumber {
    
	private static void nextGreaterElement1(final int[] arr) {
		final Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		final Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = arr.length -1 ; i >= 0 ; i--) {
			while(!stack.isEmpty() && arr[i] > stack.peek())
				stack.pop();
			map.put(arr[i], stack.isEmpty() ? -1 : stack.peek());
			stack.push(arr[i]);
		}
	}
	
	private static void nextGreaterElement2(final int[] arr) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextGreaterElement1(new int[] {9,8,7,3,2,1,6});
	}

}
