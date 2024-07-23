package com.practise.datastructures.entities;

public class CreditCardFactory implements IPaymentFactory{
	
	class AmericanExpress implements IPayment{
		private String  type;
		private String  category;
		
		public AmericanExpress(String type,String category){
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
	
	class CitiBank implements IPayment{
		private String  type;
		private String  category;
		
		public CitiBank(String type,String category){
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
		return "Credit Card Factory";		
	}

	public IPayment getPaymentChannel(String cardBankName) {
		// TODO Auto-generated method stub
		return null;
	}
}
