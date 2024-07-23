package com.practise.datastructures.entities;

public interface IPayment {
	
	public enum PaymentChannel{
		CREDIT_CARD("CREDIT_CARD"), DEBIT_CARD("DEBIT_CARD");
		private String code;
		private PaymentChannel(String code) {
			this.code = code;
		}
		public String getCode() {
			return code;
		}
		
	}
	public String getCardDetails();
}
