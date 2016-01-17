package com.observations.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRunner {
	
	public static void main(String[] args) {
		
//		MainGrid bigGrid = new MainGrid();
		
		
		Cell[][] grid = new Cell[9][9];
		//TODO set default values
//		bigGrid.setGrid(grid);

		initializeSudoku(grid);
		
		setSampleValues(grid);
		
		printGrid(grid);
	}

	/**
	 * @param grid
	 */
	private static void initializeSudoku(Cell[][] grid) {
		
		
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				grid[i][j] = new Cell();
				List<Integer> probableList = new ArrayList<Integer>();
//				List<Integer> definiteList = new ArrayList<Integer>();
				for(int d=1; d<10; d++){
					probableList.add(d);
				}
				grid[i][j].setProbableList(probableList);
			}
		}
		
		//add observers
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				
				for(int k=0; k<9; k++){
					if(k != i){
						grid[i][j].addObserver(grid[i][k]);
					}
				}
				for(int n=0; n<9; n++){
					if(n != j){
						grid[i][j].addObserver(grid[n][j]);
					}
				}
				
				int x = i % 3;
				int y = j % 3;
				
				switch (x) {
				case 1:
					switch (y) {
					case 1:
						grid[i][j].addObserver(grid[i][j-1]);
						grid[i][j].addObserver(grid[i][j+1]);
						grid[i][j].addObserver(grid[i-1][j-1]);
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i-1][j+1]);
						grid[i][j].addObserver(grid[i+1][j-1]);
						grid[i][j].addObserver(grid[i+1][j]);
						grid[i][j].addObserver(grid[i+1][j+1]);
						break;
					case 2:
						grid[i][j].addObserver(grid[i-1][j-2]);
						grid[i][j].addObserver(grid[i-1][j-2]);
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i][j-2]);
						grid[i][j].addObserver(grid[i][j-2]);
						grid[i][j].addObserver(grid[i+1][j-2]);
						grid[i][j].addObserver(grid[i+1][j-1]);
						grid[i][j].addObserver(grid[i+1][j]);
						break;
					default:
						//case 0
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i-1][j+1]);
						grid[i][j].addObserver(grid[i-1][j+2]);
						grid[i][j].addObserver(grid[i+1][j]);
						grid[i][j].addObserver(grid[i+1][j+1]);
						grid[i][j].addObserver(grid[i+1][j+2]);
						grid[i][j].addObserver(grid[i][j+1]);
						grid[i][j].addObserver(grid[i][j+2]);
						break;
					}
					break;
				case 2:
					switch (y) {
					case 1:
						grid[i][j].addObserver(grid[i-2][j-1]);
						grid[i][j].addObserver(grid[i-2][j]);
						grid[i][j].addObserver(grid[i-2][j+1]);
						grid[i][j].addObserver(grid[i-1][j-1]);
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i-1][j+1]);
						grid[i][j].addObserver(grid[i][j-1]);
						grid[i][j].addObserver(grid[i][j+1]);
						break;
					case 2:
						grid[i][j].addObserver(grid[i-2][j-2]);
						grid[i][j].addObserver(grid[i-2][j-1]);
						grid[i][j].addObserver(grid[i-2][j]);
						grid[i][j].addObserver(grid[i-1][j-2]);
						grid[i][j].addObserver(grid[i-1][j-1]);
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i][j-2]);
						grid[i][j].addObserver(grid[i][j-1]);
						break;
					default:
						//case 0
						grid[i][j].addObserver(grid[i-1][j+1]);
						grid[i][j].addObserver(grid[i-1][j+2]);
						grid[i][j].addObserver(grid[i-1][j]);
						grid[i][j].addObserver(grid[i-2][j+1]);
						grid[i][j].addObserver(grid[i-2][j+2]);
						grid[i][j].addObserver(grid[i-2][j]);
						grid[i][j].addObserver(grid[i][j+1]);
						grid[i][j].addObserver(grid[i][j+2]);
						break;
					}
					break;
				default:
					//case 0
					switch (y) {
					case 1:
						grid[i][j].addObserver(grid[i+1][j-1]);
						grid[i][j].addObserver(grid[i+1][j]);
						grid[i][j].addObserver(grid[i+1][j+1]);
						grid[i][j].addObserver(grid[i+2][j-1]);
						grid[i][j].addObserver(grid[i+2][j]);
						grid[i][j].addObserver(grid[i+2][j+1]);
						grid[i][j].addObserver(grid[i][j-1]);
						grid[i][j].addObserver(grid[i][j+1]);
						break;
					case 2:
						grid[i][j].addObserver(grid[i+1][j-1]);
						grid[i][j].addObserver(grid[i+1][j-2]);
						grid[i][j].addObserver(grid[i+1][j]);
						grid[i][j].addObserver(grid[i+2][j-1]);
						grid[i][j].addObserver(grid[i+2][j-2]);
						grid[i][j].addObserver(grid[i+2][j]);
						grid[i][j].addObserver(grid[i][j-1]);
						grid[i][j].addObserver(grid[i][j-2]);
						break;
					default:
						//case 0
						grid[i][j].addObserver(grid[i+1][j+1]);
						grid[i][j].addObserver(grid[i+1][j+2]);
						grid[i][j].addObserver(grid[i+1][j]);
						grid[i][j].addObserver(grid[i+2][j+1]);
						grid[i][j].addObserver(grid[i+2][j+2]);
						grid[i][j].addObserver(grid[i+2][j]);
						grid[i][j].addObserver(grid[i][j+1]);
						grid[i][j].addObserver(grid[i][j+2]);
						break;
					}
					break;
				}				
			}
		}
	}

	private static void printGrid(Cell[][] grid) {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(grid[i][j].getValue() + " -- ");
			}
			System.out.println("");
		}
		
	}

	private static void setSampleValues(Cell[][] grid) {
		
		grid[0][1].setValue(1);
		grid[0][2].setValue(2);
		grid[0][6].setValue(3);
		grid[0][7].setValue(4);
		grid[1][0].setValue(8);
		grid[1][3].setValue(3);
		grid[1][5].setValue(2);
		grid[1][8].setValue(5);
		grid[2][1].setValue(7);
		grid[2][3].setValue(4);
		grid[2][5].setValue(1);
		grid[2][8].setValue(6);
		grid[3][1].setValue(6);
		grid[3][2].setValue(5);
		grid[3][6].setValue(9);
		grid[3][7].setValue(8);
		grid[4][3].setValue(5);
		grid[4][4].setValue(4);
		grid[4][5].setValue(3);
		
		grid[5][1].setValue(2);
		grid[5][2].setValue(1);
		grid[5][6].setValue(4);
		grid[5][7].setValue(5);
		
		grid[6][0].setValue(2);
		grid[6][3].setValue(6);
		grid[6][5].setValue(9);
		grid[6][8].setValue(8);
		
		grid[7][0].setValue(1);		
		grid[7][3].setValue(7);
		grid[7][5].setValue(8);
		grid[7][8].setValue(4);
		
		grid[8][1].setValue(9);
		grid[8][2].setValue(8);
		grid[8][6].setValue(7);
		grid[8][7].setValue(6);
		
	}

}
