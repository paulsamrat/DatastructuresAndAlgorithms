package com.practise.datastructures.entities;

public interface IPaymentFactory {
	
	public enum FactoryConstants{
		CREDIT_CARD_FACTORY(
				"CREDIT_CARD_FACTORY"), DEBIT_CARD_FACTORY("DEBIT_CARD_FACTORY");
		private String code;
		private FactoryConstants(String code) {
			this.code = code;
		}
		public String getCode() {
			return code;
		}
	} 
	public String getPaymentFactoryDetails();
	
	public IPayment getPaymentChannel(String cardBankName);
}
