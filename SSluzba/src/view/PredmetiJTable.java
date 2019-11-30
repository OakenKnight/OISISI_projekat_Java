package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiJTable extends JTable{
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public Component prepareRenderer(TableCellRenderer renderer,int row,int col) {
		Component c=super.prepareRenderer(renderer, row, col);
		if(isRowSelected(row)) {
			c.setBackground(Color.yellow);
		}else {
			c.setBackground(Color.white);
		}		
		return c;
	}
}
