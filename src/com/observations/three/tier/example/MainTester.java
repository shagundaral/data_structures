package com.observations.three.tier.example;

import java.util.concurrent.Semaphore;

public class MainTester {
	
	public static void main(String[] args) {
		
		SubjectOnly subject = new SubjectOnly();
		
		ObserverAndSubject middle = new ObserverAndSubject(subject);
		ObserverOnly observerOnly = new ObserverOnly(middle);
		
		subject.setVal(5);
		
		
		
		
		
	}

}
