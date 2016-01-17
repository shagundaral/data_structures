package com.singleton;

public class Animal {
	
	private Animal(String breed, String name) {
		super();
		this.breed = breed;
		this.name = name;
	}
	private String breed;
	private String name;
	private static Animal animal;
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static Animal getInstance(){
		System.out.println("in");
		synchronized (Animal.class) {
			if(null == animal){ 
				animal = new Animal("Lion", "Sher");
			}
		}
		return animal;
	}

}
