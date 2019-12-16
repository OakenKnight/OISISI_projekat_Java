package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

//TODO: treba da se implementira renderer tabele
public class ProfesoriJTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProfesoriJTable instance = null;

	public static ProfesoriJTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriJTable();
		}
		return instance;
	}
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
	}
		
		
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			// selektovani red ce imati drugaciju boju od ostalih
			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}
	
}