package com.observations.sudoku;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MainGrid extends Observable implements Observer{
	
	Cell[][] grid = new Cell[9][9];
	
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
		notifyObservers();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	


}
