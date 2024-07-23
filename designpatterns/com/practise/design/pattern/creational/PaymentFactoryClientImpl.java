package com.practise.design.pattern.creational;

import java.util.Scanner;

import com.practise.datastructures.entities.IPayment;

public class PaymentFactoryClientImpl {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String inputPaymentChannel = sc.next();
		PaymentFactory pf = new PaymentFactory();
		IPayment paymentChannel = pf.getPaymentChannel(inputPaymentChannel);
		System.out.println(null != paymentChannel ? paymentChannel.getCardDetails()
				: " Please provide valid payment channel either \"CREDIT_CARD\" OR \"DEBIT_CARD");
	}
}
