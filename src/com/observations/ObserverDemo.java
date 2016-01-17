package com.observations;

public class ObserverDemo {
	public static void main(String[] args) {
		Subject sub = new Subject();

		new BinaryObserver(sub);
		new HexObserver(sub);
		new OctalObserver(sub);

		sub.setValue(15);
		System.out.println("----------");
		sub.setValue(10);
		System.out.println("----------");
		sub.setValue(10);

	}
}
