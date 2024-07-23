package com.practise.datastructure;

class Library{
	private String[] a;  
	   private int top,i,j,k,m;  
	   public Library(int max) {
	     m=max;  
	     a=new String[m];  
	     top=-1;  
	   }
	   
	   public void push(String key) {
	     if(top==m-1)  System.out.println("No space in stack");  
	     else{  
	       a[++top]=key;  
	     }  
	   }
	   
	   public String pop(){   return(a[top--]); }
	   
	   public String peek() {   return(a[top]);  }  
	   
	   public void showStack() {  
	     for(i=top;i>=0;i--)  
	       System.out.println(top-i+1+"."+a[i]);  
	   }  
	   public boolean isEmpty()  {  
	     if(top==-1)  return true;  
	     else  return false;  
	   }  
}
public class StackArrayImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library a=new Library(8);  
	    a.push("Astronomy");  
	    a.push("Economics");  
	    a.push("java pgm");  
	    a.push("physics");
	    a.showStack();
	    System.out.println("Books taken by 1st student");  
	    for(int i=0;i<2;i++)  
	      System.out.print(a.pop()+"  ");  
	    System.out.println(" ");  
	    System.out.println("Current Stack Top:- "+a.peek());
	    if(a.isEmpty())  
	        System.out.println("Stack is Empty");  
	      else{  
	        System.out.println(" ");  
	        System.out.println("Stack Not Empty");  
	        System.out.println("Current Stack Top:- "+a.peek());
	      }

	}

}
