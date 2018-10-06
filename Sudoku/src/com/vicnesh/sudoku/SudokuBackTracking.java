package com.vicnesh.sudoku;

public class SudokuBackTracking {
	
	SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
	
	
	//constructor
	public SudokuBackTracking() {
		this.solveSudokuBoard();
	}
	
	
	//getter
	public int[][] getSudokuPuzzle() {
		return sudokuPuzzle.getSudokuPuzzle();
	}
	
	
	//check if in row
	private boolean checkIfValueExistInRow(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudokuPuzzle.getSudokuPuzzleRowCol(row, i) == value) {
				return true;
			}
		}
		return false;
	}
	
	
	//check if in column
	private boolean checkIfValueExistInCol(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudokuPuzzle.getSudokuPuzzleRowCol(i, col) == value) {
				return true;
			}
		}
		return false;
	}
	
	
	//check if in 3x3 box of grid
	private boolean checkIfValueExistIn3x3Grid(int row, int col, int value) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (sudokuPuzzle.getSudokuPuzzleRowCol(i, j) == value) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	//all constraints to be checked
	private boolean checkConstraints(int row, int col, int value) {
		return !this.checkIfValueExistInRow(row, col, value) && !this.checkIfValueExistInCol(row, col, value)
				&& !this.checkIfValueExistIn3x3Grid(row, col, value);
	}
	
	
	/*backtracking algorithm
	 * 
	 * 
	 * 
	 */
	public boolean solveSudokuBoard() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudokuPuzzle.checkIfCellHasNoValue(row, col)) {
					for (int value = 1; value <= 9; value++) {
						if (checkConstraints(row, col, value)) {
							sudokuPuzzle.setSudokuPuzzleCell(row, col, value);
							if (solveSudokuBoard()) {
								return true;
							}
							else {
								sudokuPuzzle.setSudokuPuzzleCell(row, col, 0);
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	
}
