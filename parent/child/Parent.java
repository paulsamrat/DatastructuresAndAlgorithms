package com.practise.parent.child;

import java.io.Serializable;

public class Parent implements Serializable{
	public String className = "parent";
	//public Parent(){}
	public Parent(String name){
		this.className = name;
	}
	
	public void setParentClassName(String newClassName)
	{
		this.className = newClassName;
	}
}
