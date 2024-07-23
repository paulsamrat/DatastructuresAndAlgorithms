package com.practise.design.pattern.creational;

import com.practise.datastructures.entities.CreditCard;
import com.practise.datastructures.entities.DebitCard;
import com.practise.datastructures.entities.IPayment;

public class PaymentFactory {
	
	public static IPayment getPaymentChannel(String paymentChannelCode){
		IPayment paymentChannel = null;
		if (IPayment.PaymentChannel.CREDIT_CARD.getCode().equalsIgnoreCase(paymentChannelCode))
				 paymentChannel = new CreditCard("VISA", "CITI BANK");
		else if (IPayment.PaymentChannel.DEBIT_CARD.getCode().equalsIgnoreCase(paymentChannelCode))
				 paymentChannel = new DebitCard("MASTER_CARD", "YES BANK");
		return paymentChannel;
	}
}
