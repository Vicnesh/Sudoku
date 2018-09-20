package com.vicnesh.sudoku;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Sudoku extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//size of grid
	public static final int GRID_SIZE = 9;
	//size of sub-grid
	public static final int SUBGRID_SIZE = 3;
	
	//size of cell in pixels
	public static final int CELL_SIZE_PIXEL = 60;
	//array for grid cells
	public static final int GRID_HEIGHT_PIXEL = CELL_SIZE_PIXEL * GRID_SIZE;
	public static final int GRID_WIDTH_PIXEL = CELL_SIZE_PIXEL * GRID_SIZE;
	
	//array for checking if cell is empty or not
	private JTextField[][] sudokuCells = new JTextField[GRID_SIZE][GRID_SIZE]; 
	
	
	//board pixel size
	//cell pixel size
	
	
	public Sudoku() {
		Container cp = getContentPane();	
		cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		
		SudokuPuzzle sp = new SudokuPuzzle();
		int[][] puzzle = sp.getSudokuPuzzle();
		
		//create cells within the grid
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				sudokuCells[row][col] = new JTextField();
				sudokuCells[row][col].setVisible(true);
				sudokuCells[row][col].setText(puzzle[row][col] + "");
				sudokuCells[row][col].setHorizontalAlignment(JTextField.CENTER);
				sudokuCells[row][col].setEditable(false);
				sudokuCells[row][col].setFont(new Font("Monospaced", Font.BOLD, 20));
				cp.add(sudokuCells[row][col]);
			}
		}
		
		cp.setPreferredSize(new Dimension(GRID_HEIGHT_PIXEL, GRID_WIDTH_PIXEL));
		pack();
		
	}
	
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		sudoku.setVisible(true);
		sudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//SudokuPuzzle sp = new SudokuPuzzle();
		
		//sp.generatePuzzleValues();
			
	}
	
	
	
}
