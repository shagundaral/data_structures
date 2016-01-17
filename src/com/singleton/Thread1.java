package com.singleton;

public class Thread1 extends Thread{
	
	@Override
	public void run() {
		Animal a = Animal.getInstance();
		System.out.println("t1: "+a.getBreed()+"_"+a.getName());
	}

}
