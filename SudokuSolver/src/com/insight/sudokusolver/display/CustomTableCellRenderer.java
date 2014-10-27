package com.insight.sudokusolver.display;

import java.awt.Component;
import java.awt.Color;

//import javax.swing.BorderFactory;
//import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.border.Border;
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
        Component cell = super.getTableCellRendererComponent
           (table, value, isSelected, hasFocus, row, col);
       // TableCellRenderer render=table.getDefaultRenderer(Object.class);
       //JComponent result = (JComponent)render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
       // Border b;
       // b = BorderFactory.createCompoundBorder();
       
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
            /*if(row==0 || row==3 || row==6){
            	//b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(2,0,0,0,Color.BLACK));
                //result.setBorder(b);  
            	cell.setBorderColorTop(Color.GREEN);
            }*/
             
        }
        return cell;
    }
}