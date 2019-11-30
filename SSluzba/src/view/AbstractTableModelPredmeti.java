package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	public AbstractTableModelPredmeti() {
		
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstanceBazaPredmeta().getColumnCnt() + 2;
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

}
