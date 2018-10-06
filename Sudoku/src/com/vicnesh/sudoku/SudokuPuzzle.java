package com.vicnesh.sudoku;

import java.util.Random;


//generate the values for the 9x9 grid
//each cell can hold a value of range 1-9
//each row, col, 3x3 grid value must be of range 1-9



/*check if cell in puzzle has no value
*generate random number for cell
*check if random number exist in
*row, col, 3x3 subgrid
*if exist, place value into current cell
*start from that cell
*else carry on
*/
public class SudokuPuzzle {
	//array for the 9x9 grid value
	private int[][] sudokuPuzzle = new int[9][9];
	Random randomNumber = new Random();
	
	int backTrackRow;
	int backTrackCol;
	
	int currentRow;
	int currentCol;
	
	
	
	//METHODS
	//constructor
	public SudokuPuzzle() {
		this.initializeArray();
		this.loopGridCell();
	}
	
	
	//set all elements in array to 0 
	private void initializeArray() {
		for (int k = 0; k < sudokuPuzzle.length; k ++) {
			for (int i = 0; i < sudokuPuzzle.length; i++) {
				sudokuPuzzle[k][i] = 0;
			}
		}
	}
	
	
	//getter
	public int[][] getSudokuPuzzle() {
		return this.sudokuPuzzle;
	}
	
	public int getSudokuPuzzleRowCol(int row, int col) {
		return this.sudokuPuzzle[row][col];
	}
	
	
	public void setSudokuPuzzleCell(int row, int col, int value) {
		this.sudokuPuzzle[row][col] = value;
	}
	
	//find for cell with 0 value
	public boolean checkIfCellHasNoValue(int row, int col) {
		if (sudokuPuzzle[row][col] == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//generate random number of range 1-9
	private int generateRandomNumber() {
		return randomNumber.nextInt(9)+1;
	}
		
	
	
	//loop through cells
	public void loopGridCell() {
		for (int row = 0; row != this.sudokuPuzzle.length; row++) {
			for (int col = 0; col != this.sudokuPuzzle.length; col++) {
				this.currentRow = 0;
				this.currentCol = 0;
			}
		}
	}
	
	
	//generate values for array of range 1-9 for each cell
	public void generatePuzzleCellValue(int row, int col) {
		
		System.out.println("Now in: " + row + ", " + col);
		
		if (checkIfCellHasNoValue(row, col)) {
			int random = generateRandomNumber();
			if (this.checkIfValueExistInCurrentRow(random, row, col)) {
				sudokuPuzzle[row][col] = random;
			}
			else {
				sudokuPuzzle[row][col] = random;
			}
		}	
	}
	
	
	
	
	//check if value exist in row/col/subgrid
	//return grid of value that is repeated.
	public boolean checkIfValueExistInCurrentRow(int value, int row, int col) {
		//cell of each row
		for (int k = 0; k <= sudokuPuzzle.length-1; k++) {
			if (sudokuPuzzle[row][k] == value || sudokuPuzzle[k][col] == value) {
				sudokuPuzzle[row][k] = 0;
				return true;
			}
			
			/*
			if (sudokuPuzzle[k][col] == value) {
				sudokuPuzzle[k][col] = 0;
				this.backTrackRow = k;
				this.backTrackCol = col;
				return true;
			
			
			}
			*/
		}
		return false;
	}

	
	
	public boolean checkIfValueExistInCurrentCol(int value, int row, int col) {
		System.out.println("checking col");
		//cell of each row
		for (int k = 0; k < sudokuPuzzle.length; k++) {
			if (sudokuPuzzle[k][col] == value) {
				System.out.println(row + " " + k + " " + value);
				sudokuPuzzle[k][col] = 0;
				this.backTrackRow = k;
				this.backTrackCol = col;
				return true;
			}
		}
		return false;
	}	
	
	
	
	
	
	
	
}
