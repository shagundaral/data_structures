package com.observations.three.tier.example;

import java.util.Observable;
import java.util.Observer;

public class ObserverAndSubject extends Observable implements Observer{

	SubjectOnly subject;
	
	public SubjectOnly getSubject() {
		return subject;
	}

	public void setSubject(SubjectOnly subject) {
		this.subject = subject;
		super.setChanged();
		notifyObservers();
		super.clearChanged();
	}

	public ObserverAndSubject(SubjectOnly subject) {
		this.subject = subject;
		this.subject.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
			System.out.println("Twice: " + ((SubjectOnly) o).getVal()*2);
			setSubject((SubjectOnly) o);
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

}
