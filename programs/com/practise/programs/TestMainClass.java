package com.practise.programs;

public class TestMainClass {
	public static void main(String[] args)
	{
		Child c =  (Child) new Parent();
		c.msg();
	}
}
