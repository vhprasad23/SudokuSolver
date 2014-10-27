package com.insight.sudokusolver.display;

import java.awt.Component;
import java.awt.Color;

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
                cell.setBackground( Color.WHITE );
            }
            else
            {
                cell.setBackground( Color.GREEN );
            }
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