package com.observations.three.tier.example;

import java.util.Observable;
import java.util.Observer;

public class SubjectOnly extends Observable {
	
	private int val;
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
		
		  super.setChanged();
		  notifyObservers();
		  super.clearChanged();
		
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}
	

}
