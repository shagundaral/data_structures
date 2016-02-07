package com.multithreading.procucerConsumer;

public class InteractionHandler {
	
	boolean flag;
	
	public synchronized void PrintEven(int val){
		if(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(val);
		flag = true;
		notify();
	}
	
	public synchronized void PrintOdd(int val){
		if(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(val);
		flag = false;
		notify();
	}

}
