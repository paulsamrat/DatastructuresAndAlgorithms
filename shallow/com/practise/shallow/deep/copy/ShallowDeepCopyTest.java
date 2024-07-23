package com.practise.shallow.deep.copy;

public class ShallowDeepCopyTest {
	
	private String className;
	
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public ShallowDeepCopyTest()
	{
		this.className = ShallowDeepCopyTest.class.getName();
	}
	protected void func1(){System.out.println("ShallowDeepCopyImpl");}

	public static void main(String args[])
	{
		ShallowDeepCopyTest obj =  new ShallowDeepCopyTest();
		((ShallowDeepCopyTest) obj).func1();
	}
}
