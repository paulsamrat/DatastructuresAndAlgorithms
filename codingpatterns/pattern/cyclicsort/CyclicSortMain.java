package pattern.cyclicsort;

public class CyclicSortMain {
	
	//sort numbers lying in the range of 1-N
	public static void main(String args[]) {
		final int[] arr = new int[] {4,3,2,7,8,2,3,1};
		int left = 0;
		while (left < arr.length) {
			final int val = arr[left];
			// is the val at the right place . ideally once sorted the value should be at 
			// array index -1 
			if (val == arr[val-1]) ++left;
			else {
				int temp = arr[val-1];
				arr[val-1] = val;
				arr[left] = temp;
			}
		}
		for (int val : arr)
			System.out.println(val);
		
		findAllDisappearedNumbers();
		
		//cyclicSort(new int[] {4,3,2,7,8,2,3,1});
		//findDuplicateNumber();
	}
	
	//code from internet
	
	private static void cyclicSort(final int[] arr) {
		int i =0;
		while(i < arr.length) {
			int correct = arr[i]-1;
			if (arr[i] != arr[correct]) {
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			}else {
				i++;
			}
		}
		for (int val : arr)
			System.out.println(val);
	}
	
	//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
	
//	Given an array nums of n integers where nums[i] is in the range [1, n], 
//	return an array of all the integers in the range [1, n] that do not appear in nums.
	
	private static void findAllDisappearedNumbers() {
		int arr[] = new int[] {4,3,2,7,8,2,3,1};
		
		int left = 0 ;
		
		while(left < arr.length) {
			
			int currVal = arr[left];
			// is curr value at the right place
			if (currVal == arr[currVal-1]) ++left;
			else { //put the curr val at the right place
				int temp = arr[currVal-1];
				arr[currVal-1] = currVal;
				arr[left] = temp;
			}
		}
		//iterate to find all numbers who are not alligned with there indices
		int i = 0 ;
		String str = "";
		while( i < arr.length) {
			if ( i != arr[i]-1) str +=i+1 + " ";
			
			++i;
		}
		for (int val : arr)
			System.out.println(val);
		System.out.println(str);
	}
	
	//https://leetcode.com/problems/find-the-duplicate-number/description/
	//	Given an array of integers nums containing n + 1 integers where 
	//	each integer is in the range [1, n] inclusive.
	//
	//	There is only one repeated number in nums, return this repeated number.

	private static void findDuplicateNumber() {
		int[] arr = new int[] {3,1,3,4,2};
		//cyclic sort
		int left = 0 ;
		while(left < arr.length) {
			
			int currVal = arr[left];
			if (currVal == arr[currVal-1]) ++left;
			else {
				int temp = arr[currVal-1];
				arr[currVal-1] = currVal;
				arr[left] = temp;
			}
		}
		
		for (int var : arr) 
			System.out.println(var);
			
	}
}
