package com.multithreading;

public class ThreadTester {

	public static void main(String[] args) {

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
/*
		new Thread() {
			public void run() {
				calc2.multiply(10, 20);
			};
		}.start();

		new Thread() {
			public void run() {
				calc2.divide(10, 20);
			};
		}.start();*/
	}

}
