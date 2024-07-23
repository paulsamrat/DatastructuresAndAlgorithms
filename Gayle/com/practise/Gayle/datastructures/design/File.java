package com.practise.Gayle.datastructures.design;

public class File extends Entry{
	private int size;
	private String contents;
	private boolean isLocked;
	
	public File(String name,Directory parent, int size, String contents, boolean isLocked){
		super(name,parent);
		this.size = size;
		this.contents = contents;
		this.isLocked = isLocked;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	
}
