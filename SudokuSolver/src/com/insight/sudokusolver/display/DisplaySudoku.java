package com.insight.sudokusolver.display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.insight.sudokusolver.solver.CSVReadWrite;
import com.insight.sudokusolver.solver.SudokuSolver;

public class DisplaySudoku {

	int size;
	JTable table;
	JFrame frame;
	DefaultTableModel tableModel;


	@SuppressWarnings("serial")
	public DisplaySudoku(int[][] sudoku_grid,int[][] color_grid) 
	{

	    size = sudoku_grid.length;

	    JFrame.setDefaultLookAndFeelDecorated(true);

	    frame = new JFrame("Sudoku solution");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(new GridBagLayout());

	    GridBagConstraints c =  new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.anchor = GridBagConstraints.CENTER;

	    // table 
	    tableModel = new DefaultTableModel(size,size){
	    	@Override
	    	public boolean isCellEditable(int row,int column){
	    		return false;
	    	}
	    };
	    table = new JTable(tableModel);
	    table.setShowGrid(true);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(false);

	    //theTable.setGridColor(Color.black);
	    table.setDefaultRenderer(Object.class,new CustomTableCellRenderer(color_grid));


	    TableColumn column = null;
	    for (int i=0; i<9; i++) {
	        column = table.getColumnModel().getColumn(i);
	        column.setPreferredWidth(30);
	    }

	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 5;
	    frame.getContentPane().add(table,c);

	    frame.pack();
	    frame.setVisible(true);
	    
	    
	    displayResults(sudoku_grid);

	}
	

	
	private void displayResults(int[][] sudoku_grid){
		 for (int i=0; i<size; i++) {
	           for (int j=0; j<size; j++) {
	        	   table.setValueAt(new Integer(sudoku_grid[i][j]),i,j);
	           }
	       }		
	}


	/* class variables and methods */

	private static void createAndShowGUI(int[][] sudoku_grid,int[][] color_grid)
	{
		@SuppressWarnings("unused")
		DisplaySudoku s = new DisplaySudoku(sudoku_grid,color_grid);
		
	}

	public static void main(String args[]) throws Exception{

		SudokuSolver s = new SudokuSolver();
		boolean result;
		String input_file="InputCSV/Test3.csv";
		int[][] sudoku_grid = new int[9][9];
		int[][] color_grid = new int[9][9];
		sudoku_grid=CSVReadWrite.readReturn2Darray(input_file,9,9);
		color_grid=SudokuSolver.returnColorGrid(sudoku_grid);
		result=s.isCompleteGrid(sudoku_grid);
		if(result==true){
			//SudokuSolver.printGridEntries(sudoku_grid);
			CSVReadWrite.write2DarrayToCSV(sudoku_grid,input_file);
			DisplaySudoku.createAndShowGUI(sudoku_grid,color_grid);
	
		}
				
	}
}


