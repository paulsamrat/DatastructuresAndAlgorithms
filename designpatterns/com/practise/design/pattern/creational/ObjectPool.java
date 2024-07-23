package com.practise.design.pattern.creational;

import java.util.HashMap;
import java.util.Map;

public abstract class ObjectPool<T> {
	
	private long milisecondsToLive;
	
	private Map<T,Long > locked , unlocked ;
	
	public ObjectPool() {
		// TODO Auto-generated constructor stub
		locked  = new HashMap<T, Long>();
		unlocked = new HashMap<T, Long>();
	}
	
	protected  abstract void create();
}
