package com.practise.challenge.problems;

public class ContactEntity {
	
	private String firstName;
	private String lastName;
	private int priPhNumber;
	private String email;
	private int secPhNumber;
	/**
	 * @param firstName
	 * @param lastName
	 * @param phNumber
	 * @param email
	 */
	public ContactEntity(String firstName, String lastName, int priPhNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.priPhNumber = priPhNumber;
		this.email = email;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param phNumber the phNumber to set
	 */
	public void setPhNumber(int priPhNumber) {
		this.priPhNumber = priPhNumber;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the secPhNumber
	 */
	public int getSecPhNumber() {
		return secPhNumber;
	}
	/**
	 * @param secPhNumber the secPhNumber to set
	 */
	public void setSecPhNumber(int secPhNumber) {
		this.secPhNumber = secPhNumber;
	}
	
	
	
}
