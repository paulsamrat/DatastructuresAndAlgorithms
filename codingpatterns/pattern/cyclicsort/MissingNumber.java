package pattern.cyclicsort;

//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
	//Given an array nums containing n distinct numbers in the range [0, n], 
	//return the only number in the range that is missing from the array.
	 public static int missingNumber(int[] nums) {
	        int i = 0 ;
	        while ( i < nums.length){
	            if (nums[i] != i ){
	                //can be out of range . i.e out of array length
	                // ignore and move
	                if (nums[i] > nums.length-1) ++i;
	                else{
	                    //swap and put the number in its right place
	                    int temp = nums[i];
	                    nums[i] = nums[temp];
	                    nums[temp] = temp;
	                    //after this . the value is at correct place
	                }
	            }else
	                i++;
	        }
	         for(int j = 0 ; j < nums.length; j++){
	            if (nums[j] != j) return j;
	         }
	        return nums.length;
	    }
	public static void main(String[] args) {
		
		System.out.println(missingNumber(new int[] {3,0,1}));
	}

}
