package com.algo.linked.lists;

public class LFUCache {
	/**
	Problem Statement of LFU Cache
	Our goal is to design a data structure that follows the constraints of a
	Least Frequently Used(LFU) cache. Our LFU cache should support the
	following operations:
	
	The frequency for a key in the cache is incremented when either a get or
	put operation is called on it. 
	The operations get and put must each run in O(1) average time complexity.
	
	LFUCache(int capacity): Initialises the object with the capacity of the
	data structure.
	
	int get(int key): Returns the value of the key if the key exists in the
	cache; otherwise, returns -1.
	
	void put(int key, int value): Update the value of the key if present or insert the key if not already present. When the cache reaches its
	capacity, it should invalidate and remove the least frequently used key before inserting a new item. If there is a tie, i.e. two or more keys with
	the same frequency, the least recently used key would be invalidated.
	**/
	
	private int cacheSize = 5 ;
	private class CacheObject{
		private String key;
		private String val;
		private int frequency;
		 
	}
	private int get(final String key) {
		//cache miss
		
		//cache hit
		return -1;
	}
	
	private void put(final String key , final String val) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
