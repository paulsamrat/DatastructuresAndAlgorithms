package com.practise.hacker.rank;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
public class MiscellaneousImpl {
	public enum e{
		a;
		
	}
	public static void main(String args[]) throws NumberFormatException, IOException{

		  Point pnt1 = new Point(0,0);
		  Point pnt2 = new Point(0,0);
		  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
		  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
		  System.out.println(" ");
		  tricky(pnt1,pnt2);
		  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); 
		  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);  
		  System.out.println(e.valueOf("a"));
		  String s = "aa_0";
		  String[] str = s.split("_");
		  System.out.println(str[1]);
				  
		}
	
public static void tricky(Point arg1, Point arg2)
{
  arg1.x = 100;
  arg1.y = 100;
  Point temp = arg1;
  arg1 = arg2;
  arg2 = temp;
}
	 
		public static void accept(ArrayList<Object> al){
			for(Object o: al)
				System.out.println(o);
		}
	}
	
