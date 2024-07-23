package com.practise.datastructures.entities;

public class DebitCard implements IPayment{
	
	private String type;
	private String authorizedBank;
	
	public DebitCard(String type, String authorizedBank){
		this.type = type;
		this.authorizedBank = authorizedBank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthorizedBank() {
		return authorizedBank;
	}

	public void setAuthorizedBank(String authorizedBank) {
		this.authorizedBank = authorizedBank;
	}

	public String getCardDetails() {
		return  "Card Type : " + getType() + " Authorized Bank : " +  getAuthorizedBank();
	}
}
