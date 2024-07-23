package com.practise.interview.experience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	//sort a map by value and return map
	
	public static Map<Integer,EmployeePOJO> sortByValue(Map<Integer,EmployeePOJO> map){
		Set<Map.Entry<Integer, EmployeePOJO>> entrySet = map.entrySet();
		List<Map.Entry<Integer, EmployeePOJO>> list = new ArrayList<Map.Entry<Integer, EmployeePOJO>>(entrySet);
		Collections.sort(list,new Comparator<Map.Entry<Integer, EmployeePOJO>>() {

			public int compare(Map.Entry<Integer, EmployeePOJO> o1, Map.Entry<Integer, EmployeePOJO> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getName().compareTo(o2.getValue().getName());
			}
		});
		 // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap<Integer,EmployeePOJO> sortedHashMap = new LinkedHashMap<Integer,EmployeePOJO>();
	       for (Iterator<Map.Entry<Integer, EmployeePOJO>> it = list.iterator(); it.hasNext();) {
	              Map.Entry<Integer,EmployeePOJO> entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
		return sortedHashMap;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeePOJO e1 = new EmployeePOJO("samrat","100","address1");
		EmployeePOJO e2 = new EmployeePOJO("sneha","200","address1");
		EmployeePOJO e3 = new EmployeePOJO("saikat","300","address1");
		Map<Integer,EmployeePOJO> map = new HashMap<Integer, EmployeePOJO>();
		map.put(Integer.valueOf(e1.getSalary()), e1);
		map.put(Integer.valueOf(e2.getSalary()), e2);
		map.put(Integer.valueOf(e3.getSalary()), e3);
		sortByValue(map);
	}

}
