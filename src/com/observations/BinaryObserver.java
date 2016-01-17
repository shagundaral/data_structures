package com.observations;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject sub){
		super.subject = sub;
		subject.attachListener(this);
	}
	
	@Override
	public void update() {
		System.out.println("Binary Observer "+Integer.toBinaryString(subject.getValue()));
	}

}
