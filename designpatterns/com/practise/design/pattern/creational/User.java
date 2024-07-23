package com.practise.design.pattern.creational;


/*
 * Builder design pattern is a creational design pattern like Factory Pattern and Abstract Factory Pattern. 
 * This pattern was introduced to solve some of the problems with Factory and Abstract Factory design patterns 
 * when the Object contains  a lot of attributes.

   There are three major issues with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.

	1. Too Many arguments to pass from client program to the Factory class that can be error prone because most of the time, 
	   the type of arguments are same and from client side its hard to maintain the order of the argument.
	
	2. Some of the parameters might be optional but in Factory pattern, 
	   we are forced to send all the parameters and optional parameters need to send as NULL.
	   
	3. If the object is heavy and its creation is complex, then all that complexity will be part of Factory classes that is confusing.
 
 We already know the benefits of immutability and immutable instances in application.
  If you have any question over it, the please let me remind you of String class in java. 
  And as I already said, builder pattern helps us in creating immutable classes with large set of state attributes.

Let’s discuss a common problem in our application. In any user management module, 
primary entity is User, let’s say. Ideally and practically as well, once a user object is fully created, 
you will not want to change it’s state. It simply does not make sense, right? 
Now, let’s assume, our User object has following 5 attributes i.e. firstName, lastName, age, phone and address.

In normal practice, if you want to make a immutable User class, t
hen you must pass all five information as parameters to constructor. It will look like this:
 
 */
//http://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
public class User
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
 
    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder 
    {
    	private final String firstName;
    	private final String lastName;
    	private int age;
    	private String phone;
    	private String address;

    	public UserBuilder(String firstName, String lastName) {
    		this.firstName = firstName;
    		this.lastName = lastName;
    	}
    	public UserBuilder age(int age) {
    		this.age = age;
    		return this;
    	}
    	public UserBuilder phone(String phone) {
    		this.phone = phone;
    		return this;
    	}
    	public UserBuilder address(String address) {
    		this.address = address;
    		return this;
    	}
    	//Return the finally consrcuted User object
    	public User build() {
    		User user =  new User(this);
    		validateUserObject(user);
    		return user;
    	}
    	private void validateUserObject(User user) {
    		//Do some basic validations to check 
    		//if user object does not break any assumption of system
    	}
    }

    public static void main(String[] args) {
    	User user1 = new User.UserBuilder("Lokesh", "Gupta")
    			.age(30)
    			.phone("1234567")
    			.address("Fake address 1234")
    			.build();

    	System.out.println(user1);

    	User user2 = new User.UserBuilder("Jack", "Reacher")
    			.age(40)
    			.phone("5655")
    			//no address
    			.build();

    	System.out.println(user2);

    	User user3 = new User.UserBuilder("Super", "Man")
    			//No age
    			//No phone
    			//no address
    			.build();

    	System.out.println(user3);
}
 
/*Output:
 
User: Lokesh, Gupta, 30, 1234567, Fake address 1234
User: Jack, Reacher, 40, 5655, null
User: Super, Man, 0, null, null*/
}
