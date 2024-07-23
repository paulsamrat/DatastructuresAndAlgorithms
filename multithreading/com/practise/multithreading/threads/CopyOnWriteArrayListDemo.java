package com.practise.multithreading.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
	
	// issue with Array List
	// Not Thread safe
	// Fail - Fast on concurrent modifications
	
	private static void demo_fail_fast_array_list()
	{
		List<String> list = new ArrayList<String>();
		list.add("samrat");
		list.add("paul");
		list.add("samrat1");
		list.add("paul1");
		list.add("samrat2");
		
		for (String str : list)
		{	
			System.out.println(str + " --> ");
			list.add("samrat3");
		}
	}
	
	private static void demo_fail_safe_array_list()
	{
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("samrat");
		list.add("paul");
		list.add("samrat1");
		list.add("paul1");
		list.add("samrat2");
		
		for (String str : list)
		{	
			list.add("samrat3");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//demo_fail_fast_array_list();
		demo_fail_safe_array_list();
		
	}

}
