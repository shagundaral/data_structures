package com.multithreading.procucerConsumer;

public class EvenThread extends Thread{
	
	InteractionHandler interaction;
	
	public EvenThread(InteractionHandler i) {
		interaction = i;
		new Thread(this, "Even").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(i%2==0){
				interaction.PrintEven(i);
			}
			
		}
	}

}
