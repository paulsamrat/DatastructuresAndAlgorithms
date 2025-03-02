package com.algo.trees;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String yourString = "samrat";
		byte[] bytesOfMessage = yourString.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] theMD5digest = md.digest(bytesOfMessage);
		System.out.println(theMD5digest); // the checksum
		BigInteger bigInt = new BigInteger(1,theMD5digest);
		System.out.println(bigInt.intValue()%100);
		
	}

}
