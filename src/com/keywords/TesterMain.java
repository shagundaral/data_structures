package com.keywords;

public class TesterMain {

	
	public static void main(String[] args) {
		new Thread(){public void run() {
			System.out.println(Calculator.add(2, 4));
		};}.start();
		new Thread(){public void run() {
			System.out.println(Calculator.add(10, 14));
		};}.start();
	}
	
}
