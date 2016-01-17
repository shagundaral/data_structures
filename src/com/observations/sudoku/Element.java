package com.observations.sudoku;

import java.util.List;

public class Element {
	
	int value;
	List<Integer> probableList;
//	List<Integer> definiteList;
	List<Cell> observers;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Integer> getProbableList() {
		return probableList;
	}
	public void setProbableList(List<Integer> probableList) {
		this.probableList = probableList;
	}
	public List<Cell> getObservers() {
		return observers;
	}
	public void setObservers(List<Cell> observers) {
		this.observers = observers;
	}

}
