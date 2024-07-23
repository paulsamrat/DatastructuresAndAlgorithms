package com.practise.interview.experience;

import java.util.HashSet;
import java.util.Set;

class CollectionTest{
	private String name;
	private int id;
	public CollectionTest(){}
	public CollectionTest(String name,int id ){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (int) Math.random();
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	
}
public class CollectionsQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<CollectionTest> set = new HashSet<CollectionTest>();
		for (int i = 0 ; i < 5 ; i++)
			 set.add(new CollectionTest());
		System.out.println(set.size());
	}

}
