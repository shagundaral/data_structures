package com.observations;

public class OctalObserver extends Observer {

	public OctalObserver(Subject sub){
		super.subject = sub;
		subject.attachListener(this);
	}
	
	@Override
	public void update() {
		System.out.println("Octal Observer "+Integer.toOctalString(subject.getValue()));
	}

}
