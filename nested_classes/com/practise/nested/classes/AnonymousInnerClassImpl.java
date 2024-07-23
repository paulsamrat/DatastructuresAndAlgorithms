package com.practise.nested.classes;

abstract class Person{
	abstract void eat();
}

interface Gender{
	public void isMale();
}

class Country
{
	public void getCountry()
	{
		System.out.println("India");
	}
}
public class AnonymousInnerClassImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Abstract Implementation
		Person person = new Person(){

			@Override
			void eat() {
					System.out.println("Non Veg / Veg");				
			}
			
		};
		person.eat();
		
		//Interface Implementation
		Gender gender = new Gender()
		{

			@Override
			public void isMale() {
					System.out.println("Person is of Male Gender");				
			}
			
		};
		gender.isMale();
		//Concrete Implementation
		Country country = new Country();
			country.getCountry();
	
	}

}
