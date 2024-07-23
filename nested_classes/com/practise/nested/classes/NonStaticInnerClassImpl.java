package com.practise.nested.classes;

public class NonStaticInnerClassImpl {

	/**
	 * @param args
	 */
	private String className = NonStaticInnerClassImpl.class.getName();
	private class Inner 
	{
		void getOuterClassName()
		{
			System.out.println("Outer Class Name " + className);
			System.out.println("Inner Class Name " + Inner.class.getName());
		}
		void getOuterClassVersionFromInnerClassAPI()
		{
			getOuterClassVersion();
		}
	}
	private void getOuterClassVersion()
	{
		System.out.println("Outer Class Version " + 1.0 );
	}
	/*
	 * The java compiler creates two class files in case of inner class. The class file name of inner class is "Outer$Inner". If you want to instantiate inner class, you must have to create the instance of outer class.
	 *  In such case, instance of inner class is created inside the instance of outer class.
	 */
	public static void main(String[] args) {
		
		
		//Calling  Inner class method // getOuterClassName
		NonStaticInnerClassImpl outerObject = new NonStaticInnerClassImpl();
		Inner innerObject = outerObject.new Inner();
		innerObject.getOuterClassName();
		innerObject.getOuterClassVersionFromInnerClassAPI();
	}

}
