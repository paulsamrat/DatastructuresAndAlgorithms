package com.practise.programs;

public class Parent {
	public int msg(int data)
	{
		System.out.println("in the parent class");
		return data;
	}
	
	protected char A = 'A';
	char get(){return A;};
}
