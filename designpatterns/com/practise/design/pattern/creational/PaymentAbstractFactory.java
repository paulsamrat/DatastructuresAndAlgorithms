package com.practise.design.pattern.creational;

import com.practise.datastructures.entities.CreditCardFactory;
import com.practise.datastructures.entities.DebitCardFactory;
import com.practise.datastructures.entities.IPaymentFactory;

public class PaymentAbstractFactory {
	
	public static IPaymentFactory getPaymentChannelFactory(String paymentChannel) {
		IPaymentFactory paymentFactory = null;
		if (IPaymentFactory.FactoryConstants.CREDIT_CARD_FACTORY.getCode().equalsIgnoreCase(paymentChannel))
			paymentFactory = new CreditCardFactory();
		if (IPaymentFactory.FactoryConstants.DEBIT_CARD_FACTORY.getCode().equalsIgnoreCase(paymentChannel))
			paymentFactory = new DebitCardFactory();

		System.out.println((null != paymentFactory) ? paymentFactory.getPaymentFactoryDetails()
				: " please provide valid payment facory i.e CREDIT_CARD_FACTORY or DEBIT_CARD_FACTORY");
		return paymentFactory;
	}
}
