package com.algo.linked.lists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	//LRU Cache implementation through Double Linked Lists
	
	//functional requirements
	//1. putting data into cache
	//2. retrieving data from cache
	
	// requirements
	// it should be KV insertion
	// access should be in 0(1)
	// retrieve the LRU element in O(1)
	// insertion into cache in O(1)
	// space required should be O(N)
	
	
	//designing LRU Cache Brute Force Approach
	//using the array to perform the brute force
	private class CacheObject{
		private String key;
		private String val;
		private int freshnessCounter; //less the counter the more fresh the cache object is 
		
		private CacheObject(final String key, final String val) {
			this.key = key;
			this.val = val;
		}
		
	}
	//initialize the cache capacity
	final int cacheSize = 5;
	final CacheObject[] lruCache = new CacheObject[cacheSize];
	
	private boolean isCacheFull() {
		for (int i = 0 ; i < lruCache.length ; i++) {
			 if (lruCache[i] == null)
				 return false;
		}
		return true;
	}
	//O(N)
	private void insert(final String key , final String val) {
		final CacheObject cacheObj = new CacheObject(key, val);
		
		//check if the cache is full
		if (isCacheFull()) {
			//remove the least recently used cache object
			// traverse and check the cache obj with highest freshness counter
			int indexToSwap = -1 , highestFreshnessCtr = -1;
			
			for (int i = 0 ; i < lruCache.length ; i++) {
				if (lruCache[i].freshnessCounter > highestFreshnessCtr) {
					highestFreshnessCtr = lruCache[i].freshnessCounter;
					indexToSwap = i;
				}
				lruCache[i].freshnessCounter++;
			}
			// we got the index to swap
			lruCache[indexToSwap] = cacheObj;
		}else {
			for (int i = 0 ; i < lruCache.length ; i++) {
				//look for empty slot
				if (lruCache[i] == null)
					lruCache[i] = cacheObj;
				else
					lruCache[i].freshnessCounter++;
			}
		}
	}
	//O(N)
	//get or update
	private CacheObject acessCache(final String key , final boolean isUpdate) {
		for (int i = 0 ; i < lruCache.length ; i++) {
			if (lruCache[i].key.equalsIgnoreCase(key)) {
				if(isUpdate)
					lruCache[i].val = "new val";
				lruCache[i].freshnessCounter = 0;
				return lruCache[i];
			}
		}
		return null; //key not found 
	}
	
	private class DLLCacheObject{
		private String key;
		private String val;
		private DLLCacheObject next;
		private DLLCacheObject prev;
		
		private DLLCacheObject(final String key , final String val) {
			this.key = key;
			this.val = val;
		}
	}
	
	//implement LRU Cache using hashtable and   linked lists .
	//hashtable will store the dll node for quicker access and update 
	final Map<String,DLLCacheObject> lruCacheMap = new HashMap<String, DLLCacheObject>();
	private DLLCacheObject head = null;
	private DLLCacheObject tail = null;
	
	//insertion should be O(1)
	private void insertIntoCache(final String key, final String val) {
		// insert into map
		final DLLCacheObject dllCacheNode = new DLLCacheObject(key, val);
		if (lruCacheMap.size() == cacheSize) {
			//cache is full . evict LRU cache node also evict the same key from hashmap
			
			//evict from DLL , remove the tail record thats LRU Node
			tail = tail.prev;
			tail.next = null;
			//remove from map
			lruCacheMap.remove(key);
			
			//and now insert 
			lruCacheMap.put(key, dllCacheNode);
			//add the new cache obj at head
			head.prev =  dllCacheNode;
			dllCacheNode.next = head;
			head = dllCacheNode;
			
		}else { // cache not full
			lruCacheMap.put(key, dllCacheNode);
			//update DLL
			if (head == null) {
				head = tail = dllCacheNode;
				
			}else { // cache miss
				// make the incoming cache object as head and existing head will be moved to non head
				// this way the most recently used cache obj will be at head and least recently used will be at the tail
				head.prev =  dllCacheNode;
				dllCacheNode.next = head;
				head = dllCacheNode;
			}
		}
	}
	//lookup should be O(1)
	private DLLCacheObject lookup(final String key) {
		//cache hit
		final DLLCacheObject obj =  lruCacheMap.get(key);
		if (null != obj)
			return obj;
		return null ; //cache miss
	}
	
	//disadvantages - consumes O(N) as DLL and HashMap is involved 
	// else all in 0(1) //constant time retrieval
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
	}


}
