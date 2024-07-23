package com.practise.serialization.externalization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationImpl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	/**
	 * @param args
	 */
	
	private int version ;
	public String className ;
	private transient int transientVariable;
	//private String changedString;
	
	/*public SerializationImpl()
	{	
		System.out.println("Default Serialization Called!!");
	}*/
	/*public SerializationImpl(int version , String className , int transientVariable) {
		this.version = version;
		this.className = className;
		this.transientVariable = transientVariable;
	}*/
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/*
		 * Serialization 
		 */
		/*SerializationImpl object = new SerializationImpl(1,"SerializationImpl" ,100);
		FileOutputStream fileOutputStream = new  FileOutputStream("/home/samrat/EclipseWorkspace/PRACTISE/SerializationImpl.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(object); //Calls writeExternal
		objectOutputStream.close();
		fileOutputStream.close();*/
		
		/*
		 * DeSerialization
		 */
		FileInputStream fileInputStream = new FileInputStream("/home/samrat/EclipseWorkspace/PRACTISE/SerializationImpl.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		SerializationImpl objectDeserialize = (SerializationImpl) objectInputStream.readObject(); //Calls read external
		System.out.println(objectDeserialize);
		objectInputStream.close();
		fileInputStream.close();
		
	}
	 /* private void writeObject(ObjectOutputStream o)
			    throws IOException {  
			    
			    o.writeObject(propertyOne);  
			    o.writeObject(propertyTwo);
			  }
			  
			  private void readObject(ObjectInputStream o)
			    throws IOException, ClassNotFoundException {  
			    
			    propertyOne = (String) o.readObject();  
			    propertyTwo = (String) o.readObject();
			    validate();
			  }*/
	/*@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println(" In read External");
		version = in.readInt();
		//transientVariable = in.readInt();
		className = in.readUTF();
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println(" Inside Write External");
		out.writeInt(version);
		out.writeUTF(className);
		
	}*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " class name " + this.className + " version " + this.version + " transient variable value "
				+ this.transientVariable;
	}
}
