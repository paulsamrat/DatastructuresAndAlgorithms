package com.algo.stacks.queues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	//well formed parenthesis
	private void genwellformedparenthesis() {
		int pairs = 2;
		final Stack<Character> stack = new Stack<Character>();
		stack.push('(');
	}
//	private generateparenthesis(int pairs,final Stack<Character> stack ) {
//		if (stack.isEmpty())
//	}
	
	//min in sorted rotated array
	public static int findMin() {
		int[] nums = new int[] {3,4,5,1,2};
		int left = 0 , right = nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if (mid == 0 || mid == nums.length-1)return nums[mid];
			if (nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid])
				return nums[mid];
			//which side to reject
			//check which side has the lowest
			if (nums[right] > nums[mid])
					right = mid-1;
			else
				left = mid+1;
		}
		return -1;
	}
	public static void func1() {
		final List<String> res = new ArrayList<String>();
		genparenthesis("(",2,res);
	}
	public static void genparenthesis(final String str,final int pairs,final List<String>res) {
		if (str.charAt(str.length()-1) == ')' && str.charAt(str.length()-2) != '(') return;
		if (str.length() == pairs*2)
			res.add(str);
		genparenthesis(str+'(',);
		genparenthesis(str+')');
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nextGreaterElement1(new int[] {9,8,7,3,2,1,6});
		System.out.println(findMin());
	}

}
