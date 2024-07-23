package com.algo.stacks.queues;

import java.util.Stack;

public class AsteroidCollision {
	/**
	We are given an array asteroids of integers representing asteroids in a row.

	For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

	Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

	 

	Example 1:

	Input: asteroids = [5,10,-5]
	Output: [5,10]
	Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
	Example 2:

	Input: asteroids = [8,-8]
	Output: []
	Explanation: The 8 and -8 collide exploding each other.
	Example 3:

	Input: asteroids = [10,2,-5]
	Output: [10]
	Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
	*/
	
	private static void asteroidCollision(final int[] input) {
		final Stack<Integer> stack = new Stack<Integer>();
		stack.push(input[0]);
		for (int i = 1 ; i < input.length ; i++) {
			if (input[i] < 0 ) {
				while(!stack.isEmpty()   && stack.peek() <= Math.abs(input[i])) {
					stack.pop();
				if (stack.isEmpty()) {
					
				
			}else {
				stack.push(input[i]);
			}
		}
			}}
		System.out.println(stack.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		asteroidCollision(new int[]{6,7,-9,7});
	}

}
