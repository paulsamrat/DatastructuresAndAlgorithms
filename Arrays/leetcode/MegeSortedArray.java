package leetcode;

public class MegeSortedArray {
	//https://leetcode.com/problems/merge-sorted-array/
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result =  new int[nums1.length];
        int i=0,j=0,k=0;
        while(i < m && j < n ){
             if (nums1[i] < nums2[j]) {
            	 result[k] = nums1[i];
            	 ++i;
             }else {
            	 result[k] = nums2[j];
            	 ++j;
             }
             k++;
        }
        while(i<m) {
        	result[k] = nums1[i];
        	++i;
        	++k;
        }
        while(j<n) {
        	result[k] = nums2[j];
        	++j;
        	++k;
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge(new int[] {1,2,3,0,0,0},3,new int[] {2,5,6},3);
		//merge(new int[] {1},1,new int[] {},0);
	}

}
