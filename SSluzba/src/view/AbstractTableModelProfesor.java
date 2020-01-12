package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesori;
import model.BazaStudenata;

public class AbstractTableModelProfesor extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesori.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesori.getInstance().getProfesori().size();
	}
	
	public String getColumnName(int column) {
		return BazaProfesori.getInstance().getColumnName(column);
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
		if(columnIndex<10)
			return BazaProfesori.getInstance().getValAt(rowIndex, columnIndex);
		else {
			JButton btn = new JButton();
			return btn;
		}	
	}

	
}
