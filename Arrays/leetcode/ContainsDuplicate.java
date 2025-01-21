package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	//https://leetcode.com/problems/contains-duplicate/description/
	public boolean containsDuplicate(int[] nums) {
	       Set<Integer> mySet = new HashSet<>();
	       for (int num : nums) {
	        if (!mySet.add(num)) {
	            return true;
	        }
	       }
	       return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
