package com.practise.nested.classes;

public class LocalInnerClassImpl {

	/**
	 * @param args
	 */
	private int data = 30;
	void display(){  
		  final int r=0;//Local inner class cannot access non-final local variable till JDK 1.7

		  class Local{  
		   void msg(){
			   System.out.println(data);
			   System.out.println(r);
			   } 
		  }  

		  Local l=new Local();  
		  l.msg();  
		 }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalInnerClassImpl object = new LocalInnerClassImpl();
		object.display();
	}

}
