package com.practise.parent.child;

public class ClassB {
	
	public int func1()
	{
		int a1 = 10;
		Integer a2 = 20;
		func(a2 ,a1);
		return a2*a1;
		
	}
	public void func(Integer a , int a1)
	{
		a =40;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassB A1 = new ClassB();
		System.out.println(A1.func1());
	}

}
