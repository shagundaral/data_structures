package com.pojos;


public class Person implements Comparable<Person>, Cloneable{
	
	private String name;
	private int age;
	private int code;
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private Father infather;
	public Father getInfather() {
		return infather;
	}

	public void setInfather(Father infather) {
		this.infather = infather;
	}

	private static String friend="shagun" ;
	
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getCode() {
		return code;
	}
	
	public Father getPerson(){
		return infather;
	}

	@Override
	public int hashCode() {
		/*int code = super.hashCode();
		System.out.println(code);
		return code;*/
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + code;
		result = prime * result + ((infather == null) ? 0 : infather.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println(result);
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (code != other.code)
			return false;
		if (infather == null) {
			if (other.infather != null)
				return false;
		} else if (!infather.equals(other.infather))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person(String name, int age, int code, Father father) {
		super();
		this.name = name;
		this.age = age;
		this.code = code;
		this.infather = new Father(father.getName(),father.getAge());;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", code=" + code
				+ ", infather=" + infather + "]";
	}

	public static String getFriend() {
		return friend;
	}

	public static void setFriend(String friend) {
		Person.friend = friend;
	}
	
	
	public void testSynchronization(){
			System.out.println("Testing Synchronization");
	}
	
	
	public void testThis(){
		System.out.println(this.getName());
		System.out.println(this.getFriend());
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		Person clonedPerson = (Person)super.clone();
		clonedPerson.setInfather(infather.clone());
		return clonedPerson;
	}
	
}
