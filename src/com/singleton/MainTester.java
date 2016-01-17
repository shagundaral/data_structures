package com.singleton;

public class MainTester {
	
	public static void main(String[] args) {
		
		new Thread(){
			public void run() {
				Animal a = Animal.getInstance();
				System.out.println(a);
			};
		}.start();
		
        new Thread(){
        	public void run() {
        		Animal a = Animal.getInstance();
        		System.out.println(a);
        	};
		}.start();
		
		
		
		
		
	}

}
