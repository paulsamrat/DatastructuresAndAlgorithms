package com.practise.Gayle.datastructures.design;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	
	private List<Entry> contents;
	
	public Directory(String name, Directory parent){
		super(name,parent);
		contents = new ArrayList<Entry>();
	}
	//states
	public int getSize(){
		int size = Integer.MIN_VALUE;
		for(Entry e : contents){
			size += e.getSize();
		}
		return size;
	}
	//behaviours
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	protected List<Entry> getContents() { return contents; }
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
	
	
}
