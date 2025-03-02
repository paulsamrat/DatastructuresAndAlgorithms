package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Map<String, List<String>> hmap =new HashMap<String,List<String>>();
		//System.out.println(nextGreaterElements(new int[] {1,2,1}));
		//System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
		nextGreaterElement();
	}
	
	
	public static int[] nextGreaterElements(int[] nums) {
        // passes but still ON2
        /**
        final int length = nums.length;
        final int[] result = new int[length];
        Arrays.fill(result,-1);,,
        for (int i = 0 ; i < leng,th;i++){
            for (int j = i+1 ; j <, length*2 ; j++){
                if (nums[j%length] > nums[i])
                {   
                    result[i] = nums[j%length];
                    break;
                }
            }
        }
        return result;
         */
        //stack approach
        final int length = nums.length;
        final int[] result = new int[length];
        Arrays.fill(result,-1);
        final Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0 ; i < length*2;i++) //making the array as circular
        {
           while(!stack.isEmpty() && nums[i%length] > nums[stack.peek()] ){
                result[stack.pop()] = nums[i%length];
           }
           if (i < length)
        	   stack.push(i); 
        }
        //final List<List<Integer>> result = new List<ArrayList<>>();
        return result;
    }
	
	
	
	public static int findMin(int[] nums) {
        int left = 0 , right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid])
                return nums[mid];
            if (nums[left] < nums[mid]) left = mid+1;
            else if (nums[right] > nums[mid]) right = mid-1;
        }
        return -1;
    }
	
	private static void nextGreaterElement() {
		//int[] arr = new int[] {3,2,8,7,9,17,12};
		int[] arr = new int[] {4,5,2,25,10};
		final int[] res = new int[arr.length];
		final Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for(int i = 1 ; i < arr.length ; i++) {
			while(!stack.isEmpty()  && arr[i] > arr[stack.peek()]) {
				res[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}
		//still stack is not empty
		while(!stack.isEmpty())
			res[stack.pop()]=-1;
		System.out.println(res);
	}
}
