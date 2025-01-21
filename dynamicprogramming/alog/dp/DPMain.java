package alog.dp;

import java.util.HashMap;
import java.util.Map;

public class DPMain {
	
	//what is the nth fibonacci number
	//T = O(2 power n) . every level 2 branching 
	//Space . height of th tree . for finding the nth fib  = height is n . hence O(n)
	private int fib_rec(int n) {
		//base case
		if (n == 0 || n==1) return n;
		return fib_rec(n-1) + fib_rec(n-2);
	}
	private Map<Integer,Integer> fibmap = new HashMap<Integer, Integer>();
	private int fib_mem(int n) {
		//base
		if (n==0||n==1) return n;
		if (fibmap.containsKey(n))
			return fibmap.get(n);
		int result = fib_mem(n-1) +  fib_mem(n-2);
		fibmap.put(n, result);
		return result;
		
	}
	
	//sum possible . with the numbers provided
	//number= 5 , (2+3) , (3,1,1),(2,1,2)
	private boolean sumPossible(int number, int[] arr) {
		if (number == 0 ) return true;
		if (number < 0) return false;
		
	}
	private static void main(String[] args) {
		DPMain obj = new DPMain();
		obj.sumPossible(5, new int[] {1,2,3});
	}
}
