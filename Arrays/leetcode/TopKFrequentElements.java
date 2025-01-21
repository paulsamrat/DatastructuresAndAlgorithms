package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopKFrequentElements {
	//https://leetcode.com/problems/top-k-frequent-elements/description/
	
	//passes 
	public static void topKFrequent_1(int[] nums, int k) {
	        final Map<Integer,Integer> m = new HashMap<Integer, Integer>();
	        int[] result = new int[k];
	        for (int val : nums) {
	        	 if (!m.containsKey(val))
	        		 	m.put(val, 1);
	        	 else
	        		 m.put(val, m.get(val)+1);
	        }
	        //sort the map based on map values
	        List<Map.Entry<Integer, Integer> > list =
	                new LinkedList<Map.Entry<Integer, Integer> >(m.entrySet());
	        
	        Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

				@Override
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
					// TODO Auto-generated method stub
					return o2.getValue()-o1.getValue();
				}
			});
	        for (int i = 0 ; i < k ; i++)
	        		result[i] = list.get(i).getKey();
	        System.out.println(result);
	}
	
	//using priority queue
	public static void topKFrequent(int[] nums, int k) {
		Queue<E>
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//topKFrequent(new int[] {1,1,1,2,2,3}, 2);
		topKFrequent(new int[] {1}, 1);
	}

}
