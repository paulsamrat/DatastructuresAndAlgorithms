package com.practise.design.pattern.structural.adapter;

public class StudentLegacy {
	private String firstName;
	private String lastName;
	
	public StudentLegacy(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	
}
