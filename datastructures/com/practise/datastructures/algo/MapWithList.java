package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapWithList {
	
	class Container {
		Object key;
		Object value;

		public Container(Object k, Object v) {
		this.key = k;
		this.value = v;
		}
	}
	private Object dummy = new Object();
	private List recordList;

	public MapWithList() {

	this.recordList = new ArrayList();
	}
	
	
	public void put(Object k, Object v) {
		Container c = new Container(k, v);
		synchronized (dummy) {
		for (int i = 0; i < recordList.size(); i++) {
		Container c1 = (Container) recordList.get(i);
		if (c1.key.equals(k)) {
		recordList.remove(i);
		break;
		}
		}
		recordList.add(c);
		}

		}
	public Object get(Object k) {
		for (int i = 0; i < this.recordList.size(); i++) {
		Container con = (Container) recordList.get(i);
		if (k.toString() == con.key.toString()) {
		return con.value;
		}
		}
		return null;
		}
	
	
	public static void main(String[] args) {
		MapWithList hm = new MapWithList();
		hm.put("1", "1");
		hm.put("2", "2");
		hm.put("3", "3");
		System.out.println(hm.get("3"));
		hm.put("3", "4");
		System.out.println(hm.get("1"));
		System.out.println(hm.get("3"));
		System.out.println(hm.get("8"));
		
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		hashMap.put(1, 2);
		hashMap.put(null, 2);
		hashMap.put(null, 3);

		Collections.synchronizedMap(hashMap);
		System.out.println(hashMap);
	}
	
	
}
