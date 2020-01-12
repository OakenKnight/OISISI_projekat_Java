package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesori;

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

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaProfesori.getInstance().getValAt(arg0, arg1);
	}
	
	@Override
	public Class<?> getColumnClass(int c){
		if(this.getRowCount()!=0) {
			
			return this.getValueAt(0, c).getClass();
		}else {
			
			return Integer.class;
		}
	}
	
	public String getColumnName(int column) {
		return BazaProfesori.getInstance().getColumnName(column);
	}
}
