package com.practise.design.pattern.structural.adapter;

public class StudentLegacyAdapter implements IStudent{
	final StudentLegacy studentLeg;
	public StudentLegacyAdapter(final StudentLegacy studentLeg) {
		this.studentLeg = studentLeg;
	}
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.studentLeg.getFirstName();
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.studentLeg.getLastName();
	}



}
