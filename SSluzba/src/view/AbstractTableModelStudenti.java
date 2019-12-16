package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaStudenata;



public class AbstractTableModelStudenti extends AbstractTableModel{

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column); 
		
	}


	// da bismo mogli prikazati dugme
	/*@Override
	public Class<?> getColumnClass(int columnIndex) {
		
	}*/

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

	
	
}
