package com.practise.datastructures.algo.amazon;

public class AmazonMatrixQuestions {
	private void print_matrix_spirally(final char[][] array)
	{
		int colStartIdx = 0 , colEndIdx = array[0].length - 1 , rowStartIdx = 0 , rowEndIdx = array.length - 1 ;
		
		while (rowStartIdx <= rowEndIdx && colStartIdx <= colEndIdx)
		{
			//print first row 
			for (int i = colStartIdx ; i <= colEndIdx ; i++)
			{
				System.out.print(array[rowStartIdx][i] + " ");
				
			}
			//first row is done 
			++rowStartIdx;
			
			//print last column
			
			for (int i = rowStartIdx ; i <= rowEndIdx ; i++)
			{
				System.out.print(array[i][colEndIdx] + " ");
			}
			
			//last column done
			--colEndIdx;
			
			//is any row available
			if (rowStartIdx <= rowEndIdx)
			{
				//print last row
				for (int i = colEndIdx ; i >= colStartIdx ; i--)
				{
					System.out.print(array[rowEndIdx][i] + " ");
				}
				--rowEndIdx;
			}
			
			//is any column available after printing the last column
			if (colStartIdx <= colEndIdx)
			{
				//print first column
				for (int i = rowEndIdx ; i >= rowStartIdx ; i--)
				{
					System.out.print(array[i][colStartIdx] + " ");
				}
				++colStartIdx;
			}
		}
	}
	
	private void print_matrix_diagonally(final char[][] array)
	{
		
	}
	
	//https://algorithms.tutorialhorizon.com/dynamic-programming-maximum-size-square-sub-matrix-with-all-1s/
	//https://www.youtube.com/watch?v=_Lf1looyJMU
	private void max_sub_matrix_with_all_1s(final int[][] matrix)
	{
		int[][] solution = new int[matrix.length][matrix[0].length];
		//first row - all cells with '1' is itself a max sub square matrix of 1
		//first col - all cells with '1' is itself a max sub square matrix of 1
		
		// copy first row and first cell as is
		for(int i= 0 ;i < matrix[0].length ; i++)
		{
			solution[0][i] = matrix[0][i];
		}
		//copy first column
		for(int i= 0 ;i < matrix.length ; i++)
		{
			solution[i][0] = matrix[i][0];
		}
		
		//rest matrix
		for (int i = 1 ; i < matrix.length ; i++)
		{
			for (int j = 1 ; j < matrix[0].length ; j++)
			{
				// if curr cell is 0 . then largest sq matrix that can be formed at this location is '0'
				if (matrix[i][j] == 0) solution[i][j] = 0 ;
				else
				{
					solution[i][j] = Math.min(solution[i][j-1], Math.min(solution[i-1][j-1], solution[i-1][j])) + 1;
				}
			}
		}
		
		// find the maximum size of sub matrix
		int maxSize = 0;
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix[0].length ; j++) {
				if (solution[i][j] > maxSize) {
					maxSize = solution[i][j];
				}
			}
		}
		System.out.println("\nMaximum size square sub-matrix with all 1s: " + maxSize);
	}
	//https://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degrees-inplace.html
	public void rotate_a_2d_matrix_in_place(final int[][] matrix)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonMatrixQuestions obj = new AmazonMatrixQuestions();
		obj.print_matrix_spirally(new char[][]{{'a','b' ,'c' , 'd','e'},{'f','g','h','i','j'},{'k','l','m','n','o'},{'p','q','r','s','t'}});
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		obj.max_sub_matrix_with_all_1s(arrA);
	}

}
