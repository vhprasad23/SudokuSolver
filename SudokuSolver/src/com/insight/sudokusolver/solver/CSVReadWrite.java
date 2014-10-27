package com.insight.sudokusolver.solver;

import java.io.*;

public class CSVReadWrite {
	
	public static int[][] readReturn2Darray(String input_file,int num_rows,int num_cols) throws IOException{
		int[][] vals_2d_array = new int[num_rows][num_cols];
		int row=0,col=0;
		BufferedReader CSVFile = new BufferedReader(new FileReader(input_file));
		String dataRow = CSVFile.readLine(); // Read first line.

		  while (dataRow != null){
			  String[] dataArray = dataRow.split(",");
		      	for (String item:dataArray) { 
		      		vals_2d_array[row][col]=Integer.parseInt(item);
		      		col++;
		      	}
		      col=0;	
		      row++;
		      dataRow = CSVFile.readLine(); // Read next line of data.
		  }
		  // Close the file once all data has been read.
		  CSVFile.close();
		  return vals_2d_array;

	}
	
	public static void write2DarrayToCSV(int[][] sudoku_grid,String input_file) throws IOException{
		String output_file="OutputCSV/Solved" + input_file.substring(input_file.indexOf("/")+1);
		BufferedWriter CSVFile = new BufferedWriter(new FileWriter(output_file));
		
		for(int i=0;i<sudoku_grid.length;i++){
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<sudoku_grid[0].length;j++){
				sb.append(sudoku_grid[i][j]);
				if(j!=sudoku_grid[0].length-1){
					sb.append(",");
				}
			}
			CSVFile.write(sb.toString());
			CSVFile.newLine();
		}
		CSVFile.close();
	}

	  
}
