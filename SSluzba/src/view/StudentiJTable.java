package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellRenderer;



public class StudentiJTable extends JTable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6475626697461183572L;

	private static StudentiJTable instance = null;
    public static int  selektovanRed;
	public static StudentiJTable getInstance() {
		if (instance == null) {
			instance = new StudentiJTable();
		}
		return instance;
	}
	
	private  StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		selektovanRed = this.getSelectedRow();
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
