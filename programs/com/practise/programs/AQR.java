package com.practise.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AQR {
	
	public static void sort(List<Integer> arr)
	{
		Map<Integer,Integer> map = new HashMap<Integer, Integer>(arr.size());
		for (Integer val : arr)
		{
			if (map.containsKey(val))
				map.put(val, map.get(val)+1);
			else map.put(val, 1);
		}
		List<Map.Entry<Integer, Integer>> listToSort = new ArrayList(map.entrySet());
		Collections.sort(listToSort,new Comparator<Map.Entry<Integer, Integer>>(
				
				) {

					@Override
					public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
						// TODO Auto-generated method stub
						if (e1.getValue() != e2.getValue())
						{
							
						}
						int freq = e1.getKey().compareTo(e2.getKey());
						int val = e1.getValue().compareTo(e2.getValue());
						if (freq == 0 ) return val;
						else return freq;
					}
		});
		for (Map.Entry<Integer, Integer> entry : listToSort)
		{
			int freq = entry.getValue();
			while (freq != 0 )
			{
				System.out.println(entry.getKey());
				--freq;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		
		list.add(2);
		list.add(2);
		list.add(4);
		sort(list);
	}

}
