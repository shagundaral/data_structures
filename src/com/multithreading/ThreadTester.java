package com.multithreading;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ThreadTester {

	public static void main(String[] args) {
/*
		final Calculator calc = new Calculator();
		final Calculator calc2 = new Calculator();
		new Thread() {
			public void run() {
				calc.addAndSubtract(10, 20);
			};
		}.start();

		new Thread() {
			public void run() {
				calc.subtractAndAdd(20, 10);
			};
		}.start();

	
	*/
		Thread t1=new Thread(){
			@Override
			public void run() {
				System.out.println(currentThread().getName()+ " - "+currentThread().getPriority());
			}
		};
		Thread t2=new Thread(){
			@Override
			public void run() {
				System.out.println(currentThread().getName()+ " - "+currentThread().getPriority());
			}
		};
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		
	}

}
