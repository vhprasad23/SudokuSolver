package com.insight.sudokusolver.display;

import java.awt.Component;
import java.awt.Color;
/*This class creates a Custom table cell renderer. It creates borders for the 3x3 mini-grids.
 * Also, if a value was calculated by SudokuSolver then it colors that cell green, else if it was provided to us in the CSV file it colors it white.
 * The 2-D matrix color_selector contains only 1's and 0's. A 1 indicates the value in that cell was provided in the CSV file and 0 indicates a value calculated by SudokuSolver
 * This matrix is used to compute the background color for any cell */

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.border.MatteBorder;
@SuppressWarnings("serial")
public class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
	private int[][] color_selector;
	
	public CustomTableCellRenderer(int[][] color_selector){
		 setOpaque(true);		
		 this.color_selector=color_selector;
	}
    @Override public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int col) 
    {
       Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
       JComponent jc = (JComponent) cell;
   
       
        if( value instanceof Integer )
        {
            if( color_selector[row][col] ==1 )
            { 
            	//If the cell was originally provided then color that cell white
                cell.setBackground( Color.WHITE );
            }
            else
            {
                //If the cell value was calculated by SudokuSolver color it green
            	cell.setBackground( Color.GREEN );
            }
            
            //Create borders for the 3x3 mini-grids
            if(row==3 || row==6)
            	jc.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK) );

            if(col==3 || col==6)
            	jc.setBorder(new MatteBorder(0, 1, 0, 0, Color.BLACK) );
            
            if((row==3 && col==3) || (row==6 && col==6) || (row==3 && col==6) || (row==6 && col==3))
            	jc.setBorder(new MatteBorder(1, 1, 0, 0, Color.BLACK) );

        }
        return cell;
    }
}