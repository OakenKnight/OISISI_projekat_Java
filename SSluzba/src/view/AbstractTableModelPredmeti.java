package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesori;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstanceBazaPredmeta().getColumnCnt();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstanceBazaPredmeta().getPredmeti().size();
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 < 6)
		return BazaPredmeta.getInstanceBazaPredmeta().getValAt(arg0, arg1);
		else {
			JButton btn = new JButton();
			return btn;
		}
	}
	public String getColumnName(int column) {
		return BazaPredmeta.getInstanceBazaPredmeta().getColumnName(column);
	}
}
