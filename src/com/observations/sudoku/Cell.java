package com.observations.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer{
	
	int value;
	List<Integer> probableList;
//	List<Integer> definiteList;
	List<Cell> observers;

	public List<Cell> getObservers() {
		if(null!=observers){
			return observers;
		}
		return new ArrayList<Cell>();
	}
	public void setObservers(List<Cell> observers) {
		this.observers = observers;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
		this.probableList = new ArrayList<Integer>();
		setChanged();
		notifyObservers(this);
		clearChanged();
	}
	public List<Integer> getProbableList() {
		return probableList;
	}
	public void setProbableList(List<Integer> probableList) {
		this.probableList = probableList;
	}
	
	public void addObserver(Cell c){
		super.addObserver(c);
		/*if(null!=c.getObservers() && !c.getObservers().isEmpty()){
			this.observers.add(c);
		}else{
			observers = new ArrayList<Cell>();
			observers.add(c);
		}
		getObservers().add(c);*/
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		int index = getProbableList().indexOf(((Cell) o).getValue());
		
		if(index >= 0){
			getProbableList().remove(index);
		}
		
		if(getProbableList().size() == 1){
			setValue(getProbableList().get(0));
			setChanged();
			notifyObservers(this);
			clearChanged();	
		}
		
	}
	
	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
		/*for (Cell cell : ((Cell)arg).getObservers()) {
			cell.update(this, cell);
		}*/
	}
	
	
}
