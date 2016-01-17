package com.singleton;

public class Thread2 extends Thread{

	@Override
	public void run() {
		
		Animal a = Animal.getInstance();
		System.out.println("t2: "+a.getBreed()+"_"+a.getName());
	}
	
}
