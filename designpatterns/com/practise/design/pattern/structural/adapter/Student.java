package com.practise.design.pattern.structural.adapter;

public class Student implements IStudent{
	private String firstName;
	private String lastName;
	
	public Student(final String firstName , final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}
	
}
