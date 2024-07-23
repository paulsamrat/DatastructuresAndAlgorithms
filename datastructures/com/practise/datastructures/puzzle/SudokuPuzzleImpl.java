package com.practise.datastructures.puzzle;

public class SudokuPuzzleImpl {
	
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// check each row
		for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
			boolean[] m = new boolean[9];
			for (int colIndex = 0; colIndex < 9; colIndex++) {
				if (board[rowIndex][colIndex] != '0') {
					if (m[(int) (board[rowIndex][colIndex] - '1')]) {
						return false;
					}
					m[(int) (board[rowIndex][colIndex] - '1')] = true;
				}
			}
		}
	 
		//check each column
		for (int colIndex = 0; colIndex < 9; colIndex++) {
			boolean[] m = new boolean[9];
			for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
				if (board[colIndex][rowIndex] != '0') {
					if (m[(int) (board[colIndex][rowIndex] - '1')]) {
						return false;
					}
					m[(int) (board[colIndex][rowIndex] - '1')] = true;
				}
			}
		}
	 
		//check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '0') {
						if (m[(int) (board[i][j] - '1')]) {
							return false;
						}
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
	 
		return true;
	}
	public static void main(String[] args) {
		// TODO Autgenerated method stub
		SudokuPuzzleImpl obj = new SudokuPuzzleImpl();
		// '0' denotes empty cells
		//http://www.geeksforgeeks.org/backtracking-set-7-suduku/
		char [][] sudokuBoard = new char[][]{
			{'3', '0', '6', '5', '0', '8', '4', '0', '0'},
            {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
            {'0','8', '7', '0', '0', '0', '0', '3', '1'},
            {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
            {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
            {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
            {'1', '3', '0','0', '0', '0', '2', '5', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
            {'0', '0', '5', '2', '0', '6', '3', '0', '0'}
		};
		obj.isValidSudoku(sudokuBoard);
	}

}
