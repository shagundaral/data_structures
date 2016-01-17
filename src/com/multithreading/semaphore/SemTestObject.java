package com.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SemTestObject {
	
	public int value = 0;
	
	Semaphore semaphore = new Semaphore(10);
	
	public void setVal(int newVal){
		System.out.println(newVal);

//		semaphore.acquire();
		this.value = newVal;
	}

}
