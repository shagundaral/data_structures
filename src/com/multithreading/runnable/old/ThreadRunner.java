package com.multithreading.runnable.old;

public class ThreadRunner {
	public static void main(String[] args) {
			RunMethod rm = new RunMethod();
			
			/**
			 * rm.run(); Never DO it.this is nothing but invoking a method of the class.
			 **/
			rm.run();
			
			/**
			 * rm.start(); Start is what gives the asynchronicity to the thread.
			 **/
			rm.start();
			
			/**
			 * Anonymous class
			 */
			new Thread(new Runnable() {
				public void run() {
					System.out.println("hello "+Thread.currentThread().getName());
				}
			}).start();
			
			/**
			 * Executing a runnable
			 */
			Runner runner = new Runner();
			new Thread(runner).start();
			
			
			System.out.println("Main Thread :: "+ Thread.currentThread().getName());
	}
}
