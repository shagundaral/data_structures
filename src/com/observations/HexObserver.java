package com.observations;

public class HexObserver extends Observer {

	public HexObserver(Subject sub){
		super.subject = sub;
		subject.attachListener(this);
	}
	
	@Override
	public void update() {
		System.out.println("HEX Observer "+Integer.toHexString(subject.getValue()));
	}

}
