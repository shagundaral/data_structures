package com.multithreading.procucerConsumer;

public class MainRunner {
	
	public static void main(String[] args) {
		InteractionHandler interaction = new InteractionHandler();
		new EvenThread(interaction);
		new OddThread(interaction);
	}
	
}
