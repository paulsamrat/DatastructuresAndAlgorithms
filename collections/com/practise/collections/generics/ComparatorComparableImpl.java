package com.practise.collections.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorComparableImpl{
	
	private String name;
	private int size;
	
	public ComparatorComparableImpl(String name, int size)
	{
		this.name = name;
		this.size = size;
	}
	public int compareTo(ComparatorComparableImpl o) {
		return this.size - o.size;
	}
	//implementing a comparator
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComparatorComparableImpl obj1 = new ComparatorComparableImpl("samrat", 10);
		ComparatorComparableImpl obj2 = new ComparatorComparableImpl("samrat", 20);
		//using comparable 
		if (obj1.compareTo(obj2) > 0 ) 
			System.out.println( " obj1 is greater than obj2");
		else
			System.out.println( " obj2 is greater than obj1");
		List<ComparatorComparableImpl> listOfObjects = new ArrayList<ComparatorComparableImpl>();
		listOfObjects.add(obj2);
		listOfObjects.add(obj1);
		Collections.sort(listOfObjects, new Comparator<ComparatorComparableImpl>() {

			public int compare(ComparatorComparableImpl o1, ComparatorComparableImpl o2) {
				int objOneSize = o1.size;
				int objTwoSize = o2.size;
				return objOneSize - objTwoSize;

			}
			
		});
	}

	

}
