package com.practise.design.pattern.creational;

import java.util.Scanner;

import com.practise.datastructures.entities.IPayment;
import com.practise.datastructures.entities.IPaymentFactory;

public class PaymentAbstractFactoryClientImpl {
	
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println(" Input debit card factory value ");
		IPaymentFactory paymentFactory = PaymentAbstractFactory.getPaymentChannelFactory(sc.next());
		IPayment payment = paymentFactory.getPaymentChannel("YES_BANK");		
		
	}
}
