package com.practise.programs;

import java.util.Arrays;

public class MyArrayListImpl {

	Object[] arrayList =  null;
	int index = 0 ;
	
	public MyArrayListImpl() {
		arrayList = new Object[10];
	}
	
	public boolean add(int inputNumber)
	{
		if (arrayList.length - index <= 5)
			dynamicallyIncrease(arrayList);
		arrayList[index++] = inputNumber;
		return true;
	}
	
	public Object remove(int indexToRemove)
	{
		if (indexToRemove < index) {
			Object number = arrayList[indexToRemove];
			arrayList[indexToRemove] = null;
			
			while (indexToRemove  <  index)
			{
				arrayList[indexToRemove] = arrayList[indexToRemove+1];
				arrayList[indexToRemove+1] = null;
				indexToRemove ++;
			}
			index--;
			return number;
		}
		else
			throw new ArrayIndexOutOfBoundsException();
	}
	public Object get(int indexToFind)
	{
		if (indexToFind < index) return arrayList[indexToFind];
		else
			throw new ArrayIndexOutOfBoundsException();
	}
	
	public  int size(){ return index;}
	private void dynamicallyIncrease(Object[] arrayList2) {
		
		Arrays.copyOf(arrayList , arrayList.length * 2);
		System.out.println("\nNew length: "+arrayList.length); 
	}
	public static void main(String[] args) {
		MyArrayListImpl mal = new MyArrayListImpl();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }

	}

}
