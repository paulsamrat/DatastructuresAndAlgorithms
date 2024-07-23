package com.practise.Gayle.datastructures.design;

import java.util.Date;

public abstract class Entry {
	
	private String name;
	private Date created;
	private Date updated;
	private Date lastAccessed;
	private Directory parentDirectory;
	
	public Entry(String name, Directory parentDirectory){
		this.name = name;
		this.parentDirectory = parentDirectory;
		this.created = new Date();
		this.updated = new Date();
		this.lastAccessed = new Date();
	}
	
	protected abstract int getSize();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public Directory getParentDirectory() {
		return parentDirectory;
	}

	public void setParentDirectory(Directory parentDirectory) {
		this.parentDirectory = parentDirectory;
	}
	
}
