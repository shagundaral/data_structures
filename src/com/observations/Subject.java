package com.observations;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private int value;
	List<Observer> observers = new ArrayList<Observer>();

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (isValueChanged(value)) {
			this.value = value;
			notifyObservers();
		}else{
			System.out.println("No change in value not updating");
		}
	}
	
	public void attachListener(Observer observer){
		this.observers.add(observer);
	}
	

	private void notifyObservers() {
		
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
	private boolean isValueChanged(int value){
		return this.value!=value;
	}

}
