package com.algo.arrays;

public class Arrays {
	//anagram check
	public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        int totSum = 0;
        for (char c : s.toCharArray()){
            int index = c - 'a';
            ++array[index];
        }
        for (char c : t.toCharArray()){
            int index = c - 'a';
            --array[index];
        }
        for(int i = 0 ; i < 26 ; i++)
            if (array[i] < 0 ) return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays obj = new Arrays();
		System.out.println(obj.isAnagram("rat","car"));
	}
}
