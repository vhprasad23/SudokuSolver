package com.insight.sudokusolver.solver;
import java.util.*;
public class SudokuSolver {
	private int MIN_GRID_VAL=1;
	private int MAX_GRID_VAL=9;
	
	public boolean isCompleteGrid(int[][] sudoku_grid){
		int row,col;
		Hashtable<String,Integer> row_col_vals = new Hashtable<String,Integer>();
		row_col_vals=findEmptySpot(sudoku_grid);
		row=row_col_vals.get("RowId");
		col=row_col_vals.get("ColId");
		if(row==-1 && col==-1){
			return true;
		}
			
		for(int i=MIN_GRID_VAL;i<=MAX_GRID_VAL;i++){
			if(isValid(sudoku_grid,row,col,i)){
				sudoku_grid[row][col]=i;
				if(isCompleteGrid(sudoku_grid)){
					return true;
				}
			}
			sudoku_grid[row][col]=0;
		}
		return false;
		
		
	}
	
	public Hashtable<String,Integer> findEmptySpot(int[][] sudoku_grid){
		int row,col;
		Hashtable<String,Integer> row_col_vals = new Hashtable<String,Integer>();
		for(row=0;row<sudoku_grid.length;row++){
			for(col=0;col<sudoku_grid[0].length;col++){
				if(sudoku_grid[row][col]==0){
					row_col_vals.put("RowId", row);
					row_col_vals.put("ColId", col);
					return row_col_vals;
					
				}	
			}
		}
		row_col_vals.put("RowId", -1);
		row_col_vals.put("ColId", -1);
		return row_col_vals;
		
	}
	
	public boolean isValid(int[][] sudoku_grid,int row,int col,int value){
		if(isRowEntryValid(sudoku_grid,row,col,value) && isColEntryValid(sudoku_grid,row,col,value) && isMiniGridEntryValid(sudoku_grid,row,col,value))
			return true;
		else
			return false;
		
	}
	
	public boolean isRowEntryValid(int[][] sudoku_grid,int row,int col,int value){
		for(int i=0;i<sudoku_grid[0].length;i++){
			if(i!=col && sudoku_grid[row][i]==value)
				return false;
		}
		
		return true;
		
	}
	
	public boolean isColEntryValid(int[][] sudoku_grid,int row,int col,int value){
		for(int i=0;i<sudoku_grid.length;i++){
			if(i!=row && sudoku_grid[i][col]==value)
				return false;
		}
		
		return true;
		
	}
	
	public boolean isMiniGridEntryValid(int[][] sudoku_grid,int row,int col,int value){
		int grid_row_lower_bound,grid_row_upper_bound;
		int grid_col_lower_bound,grid_col_upper_bound;
		int grid_len=(int )Math.sqrt(sudoku_grid.length);
		
		grid_row_lower_bound=row-(row%grid_len);
		grid_row_upper_bound=row+(grid_len-row%grid_len)-1;
		
		grid_col_lower_bound=col-(col%grid_len);
		grid_col_upper_bound=col+(grid_len-col%grid_len)-1;
		
		for(int i=grid_row_lower_bound;i<=grid_row_upper_bound;i++){
			for(int j=grid_col_lower_bound;j<=grid_col_upper_bound;j++){
				if(sudoku_grid[i][j]==value)
					return false;
			}
		}
		return true;	
	}
	
	public static void printGridEntries(int[][] sudoku_grid){
		for(int i=0;i<sudoku_grid.length;i++){
			for(int j=0;j<sudoku_grid[0].length;j++){
				System.out.print(" " + sudoku_grid[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	public static int[][] returnColorGrid(int[][] sudoku_grid){
		int num_rows,num_cols;
		num_rows=sudoku_grid.length;
		num_cols=sudoku_grid[0].length;
		int[][] color_grid = new int[num_rows][num_cols];
	
		for(int i=0;i<num_rows;i++){
			for(int j=0;j<num_cols;j++){
				if(sudoku_grid[i][j]==0)
					color_grid[i][j]=0;
				else
					color_grid[i][j]=1;
					
			}
				
		}
		
		return color_grid;
	}
	
}
