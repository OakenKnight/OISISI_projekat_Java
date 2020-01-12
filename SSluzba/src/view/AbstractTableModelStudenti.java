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
	@Override
	public Class<?> getColumnClass(int c){
		if(this.getRowCount()!=0) {
			return this.getValueAt(0, c).getClass();
		}else {
			
			return String.class;
		}
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex<11)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		else {
			JButton btn = new JButton();
			return btn;
		}
	}

	
	
}
