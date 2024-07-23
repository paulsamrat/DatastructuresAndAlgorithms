package com.practise.datastructures.entities;

public class DebitCardFactory implements IPaymentFactory{

	public enum CardBankName{
		YES_BANK("YES_BANK"),HDFC_BANK("HDFC_BANK");
		private String bankName;
		
		private CardBankName(String name) {
				this.bankName = name;
		}

		public String getBankName() {
			return bankName;
		}
	}
	class YesBank implements IPayment{
		private String  type;
		private String  category;
		
		public YesBank(String type,String category){
			this.type = type;
			this.category = category;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		public String getCardDetails() {
			return  "Card Type : " + getType() + " Category : " +  getCategory();
		}
	}
	
	class HDFCBank implements IPayment{
		private String  type;
		private String  category;
		
		public HDFCBank(String type,String category){
			this.type = type;
			this.category = category;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getCardDetails() {
			return  "Card Type : " + getType() + " Category : " +  getCategory();
		}
		
	}

	public String getPaymentFactoryDetails() {
		return "Debit Card Factory";
	}

	public IPayment getPaymentChannel(String cardBankName) {
		IPayment debitCard = null;
		if (DebitCardFactory.CardBankName.YES_BANK.getBankName().equalsIgnoreCase(cardBankName))
				debitCard =  new YesBank("VISA", "PLATINUM");
		if (DebitCardFactory.CardBankName.HDFC_BANK.getBankName().equalsIgnoreCase(cardBankName))
				debitCard =  new YesBank("MASTER", "GOLD");			
		System.out.println(debitCard.getCardDetails());	
		return debitCard;
	}
}
