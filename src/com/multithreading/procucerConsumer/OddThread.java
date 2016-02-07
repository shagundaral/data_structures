package com.multithreading.procucerConsumer;

public class OddThread implements Runnable{
	
	InteractionHandler interact;
	
	public OddThread(InteractionHandler i) {
		interact = i;
		new Thread(this, "Odd").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(!(i%2==0)){
				interact.PrintOdd(i);
			}
		}
	}

}
