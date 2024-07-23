package com.practise.design.pattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Student student = new Student("samrat", "paul");
		final StudentLegacy studentLeg = new StudentLegacy("samrat1", "paul1");
		
		List<IStudent> students = new ArrayList<IStudent>();
		students.add(student);
		//students.add(studentLeg); // incompatible - lets use adapter to make it compatible 
		
		//after making the student leg into adapter 
		students.add(new StudentLegacyAdapter(studentLeg));
	}

}
