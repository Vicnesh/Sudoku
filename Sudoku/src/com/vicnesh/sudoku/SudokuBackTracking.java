package com.vicnesh.sudoku;


/* Sudoku Backtracking Algorithm
 * This algorithm is used to generate a solved puzzle.
 * Access each cell and checks if it is empty. If cell is empty, set a value to cell in a sequential order 1-9.
 * Check if the value to set in cell complies to the constraints, if it doesnt, backtrack and retry.
 * 
 * 
 * 
 */


public class SudokuBackTracking {
	
	SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
	
	
	/*
	 * Constructor
	 * @parameter
	 * @return
	 */
	public SudokuBackTracking() {
		this.solveSudokuBoard();
	}
	
	
	/*
	 * Get sudoku puzzle array
	 * Calls method from SudokuPuzzle
	 * @parameter
	 * @return - array of sudoku puzzle
	 */
	public int[][] getSudokuPuzzle() {
		return sudokuPuzzle.getSudokuPuzzle();
	}
	
	
	/*
	 * Check constraints
	 * Calls method from SudokuPuzzle
	 * @parameter - int row, int column of grid puzzle, int value to check for contraints
	 * @return - boolean, true if value exist in any constraint, false if value does not exist in any constraint
	 */
	private boolean checkConstraints(int row, int col, int value) {
		return sudokuPuzzle.checkConstraints(row, col, value);
	}

	
	
	/*
	 * Backtracking Algorithm used to generate a solved sudoku board.
	 * @parameter - 
	 * @return - 
	 */
	public boolean solveSudokuBoard() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudokuPuzzle.checkIfCellIsEmpty(row, col)) {
					for (int value = 1; value <= 9; value++) {
						if (this.checkConstraints(row, col, value)) {
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
