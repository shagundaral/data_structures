package com.observations.three.tier.example;

import java.util.Observable;
import java.util.Observer;

public class ObserverOnly implements Observer{

	ObserverAndSubject obsAndSubject;

	public ObserverOnly(ObserverAndSubject obsAndSubject) {
		this.obsAndSubject = obsAndSubject;
		this.obsAndSubject.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(((ObserverAndSubject) o).getSubject().getVal()*4);
		
	}

}
