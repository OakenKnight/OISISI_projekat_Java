package view;

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
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstanceBazaPredmeta().getValAt(arg0, arg1);
	}
	public String getColumnName(int column) {
		return BazaPredmeta.getInstanceBazaPredmeta().getColumnName(column);
	}
}
