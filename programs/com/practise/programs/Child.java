package com.practise.programs;

public class Child extends Parent{
//	private static int data;
//	public Child()
//	{
//		data =25;
//	}
//	public void msg(){
//		static int a  = 10;
//		System.out.println( " in the child classs");
//		
//	}
//	
//	public static void main(String[] args)
//	{
//		Parent obj = new Child();
//		System.out.println(obj.);
//	}
	
	protected char A = 'B';
	char get() {return A;}
	
	
	public static void main(String[] args)
	{
		Child obj = new Child();
		obj.msg();
		//System.out.println(obj.A + obj.get());
	}
}
