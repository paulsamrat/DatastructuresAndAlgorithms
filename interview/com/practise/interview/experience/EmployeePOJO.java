package com.practise.interview.experience;

public class EmployeePOJO {
	
	private String name;
	private String salary;
	private String address;
	
	public EmployeePOJO(String name , String salary , String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePOJO other = (EmployeePOJO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
	/*public int hashCode(){
		
		int prime = 31 ;
		return  prime + name.hashCode() + salary.hashCode() + address.hashCode();
	}*/
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.salary + " " + this.address;
	}
}
