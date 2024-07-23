package com.practise.parent.child;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.practise.serialization.externalization.SerializationImpl;

public class Child  extends Parent implements IHierarchy{
	
	private String className1;
	
	public Child() {
		super("parent");
		//this.className = name;
		System.out.println(this.defaultVal);
	}
	
	public static void main(String[] args){
		Child c = new Child();
//		try {
//			FileOutputStream fos = new FileOutputStream(
//					new File("/home/samrat/EclipseWorkspace/PRACTISE/SerializationImpl.ser"));
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(new Child("Child Class"));
//			oos.flush();
//			oos.close();
//			
//			FileInputStream fileInputStream = new FileInputStream("/home/samrat/EclipseWorkspace/PRACTISE/SerializationImpl.ser");
//			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//			Child objectDeserialize = (Child) objectInputStream.readObject(); //Calls read external
//			System.out.println(objectDeserialize);
//			objectInputStream.close();
//			fileInputStream.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		c.className = "someNewClassName";
		System.out.println(c.className);
		int a[] = new int[]{1,2,3};
		System.out.println(a);
		//for (int a1 : a){
			System.out.println(a[0]);
		//}
			int x = 0 ;
			x  = ++x;
	}

}
