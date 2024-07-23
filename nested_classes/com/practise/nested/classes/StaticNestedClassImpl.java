package com.practise.nested.classes;

public class StaticNestedClassImpl {

	
	 static private int data =30;
	
	private static class staticInnerClass
	{
		void msg(){
			System.out.println("Class Name " + staticInnerClass.class.getName());
			System.out.println(data);
		}
		static void msg(String input)
		{
			System.out.println(input);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticNestedClassImpl.staticInnerClass object = new StaticNestedClassImpl.staticInnerClass();
		/*
		 * static class TestOuter1$Inner  
			{  
			TestOuter1$Inner(){}  
			void msg(){  
			System.out.println((new StringBuilder()).append("data is ")  
			.append(TestOuter1.data).toString());  
			} 
		*/
		object.msg();
		StaticNestedClassImpl.staticInnerClass.msg("Its a static method of static nested class");
	}

}
