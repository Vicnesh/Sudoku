package com.vicnesh.sudoku;

import java.util.Random;


/* 
 * Constraints for each cell value:
 * 1) Generate the values for the 9x9 grid
 * 2) Each cell can hold a value of range 1-9
 * 3) Each row, col, 3x3 grid value must be of range 1-9
 * 
 */



public class SudokuPuzzle {
	
	private int[][] sudokuPuzzle = new int[9][9];
	Random randomNumber = new Random();
	
	private static final int EMPTY_CELL = 0;
	private static final int GRID_SIZE = 9;

	
	/*
	 * Constructor
	 * @parameter
	 * @return
	 */
	public SudokuPuzzle() {
		this.initializeArray();
		this.generateRandomPuzzleValues();
	}
	
	
	/*
	 * Initialize Array.
	 * Loop through each cell of row and column and set value to 0 (Empty Cell)
	 * @parameter
	 * @return
	 */
	private void initializeArray() {
		for (int k = 0; k < sudokuPuzzle.length; k ++) {
			for (int i = 0; i < sudokuPuzzle.length; i++) {
				sudokuPuzzle[k][i] = SudokuPuzzle.EMPTY_CELL;
			}
		}
	}
	
	
	/*
	 * Set random values for random cells
	 * Initializes a puzzle to be solved by setting random values of range {1...9} into a randomly selected cell,
	 * Each value generated must abide the constraints.
	 * @parameter
	 * @return
	 */
	private void generateRandomPuzzleValues() {
		for (int i = 0; i < 10; i++) {
			int row = randomNumber.nextInt(9);
			int col = randomNumber.nextInt(9);
			int randomValue = randomNumber.nextInt(9)+1;
			if (this.checkConstraints(row, col, randomValue)) {
				this.sudokuPuzzle[row][col] = randomValue;
			}
			else {
				this.generateRandomNumber();
			}	
		}
	}
	
	
	/*
	 * Get puzzle array
	 * @parameter
	 * @return - sudoku puzzle array
	 */
	public int[][] getSudokuPuzzle() {
		return this.sudokuPuzzle;
	}
	
	
	/*
	 * Get in cell
	 * @parameter - int row, int column of the cell value to return
	 * @return - value in cell of row and column
	 */
	public int getSudokuPuzzleRowCol(int row, int col) {
		return this.sudokuPuzzle[row][col];
	}
	
	
	/*
	 * Set value in cell
	 * @parameter - int row, int column of the cell, int value to set
	 * @return 
	 */
	public void setSudokuPuzzleCell(int row, int col, int value) {
		this.sudokuPuzzle[row][col] = value;
	}
	
	
	/*
	 * Check if cell is empty
	 * @parameter - int row, int column of the cell
	 * @return - boolean, true if cell is empty, false if cell is not empty
	 */
	public boolean checkIfCellIsEmpty(int row, int col) {
		if (sudokuPuzzle[row][col] == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * Generates a random number from 1-9
	 * @parameter
	 * @return 
	 */
	private int generateRandomNumber() {
		return randomNumber.nextInt(9)+1;
	}

	
	/*
	 * Constraint 1: Value must not exist in any cell of row
	 * @parameter - row of grid, column of grid, value to check if exist in cell of current row 
	 * @return - boolean, true if value exist in cell of row, false if value does not exist in cell of row
	 */
	private boolean checkIfValueExistInRow(int row, int col, int value) {
		for (int i = 0; i < SudokuPuzzle.GRID_SIZE; i++) {
			if (this.getSudokuPuzzleRowCol(row, i) == value) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Constraint 2: Value must not exist in any cell of column
	 * @parameter - row of grid, column of grid, value to check if exist in cell of current column
	 * @return - boolean, true if value exist in cell of row, false if value does not exist in cell of column
	 */
	private boolean checkIfValueExistInCol(int row, int col, int value) {
		for (int i = 0; i < SudokuPuzzle.GRID_SIZE; i++) {
			if (this.getSudokuPuzzleRowCol(i, col) == value) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Constraint 3: Value must not exist in any cell of 3x3 sub-grid
	 * @parameter - row of grid, column of grid, value to check if exist in cell of current 3x3 subgrid
	 * @return - boolean, true if value exist in cell of row, false if value does not exist in cell of current 3x3 subgrid
	 */
	 boolean checkIfValueExistIn3x3Grid(int row, int col, int value) {
		int subGridRow = row - row % 3;
		int subGridCol = col - col % 3;
		
		for (int i = subGridRow; i < subGridRow + 3; i++) {
			for (int j = subGridCol; j < subGridCol + 3; j++) {
				if (this.getSudokuPuzzleRowCol(i, j) == value) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/*
	 * Check All Constraints
	 * @parameter - row of grid, column of grid, value to check if exists in all 3 constraints
	 * @return - boolean, true if value exist in any constraint, false if value does not exist in any constraint
	 */
	public boolean checkConstraints(int row, int col, int value) {
		return !this.checkIfValueExistInRow(row, col, value) && !this.checkIfValueExistInCol(row, col, value)
				&& !this.checkIfValueExistIn3x3Grid(row, col, value);
	}
	

}
