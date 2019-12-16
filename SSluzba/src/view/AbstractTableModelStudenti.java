package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;



public class AbstractTableModelStudenti extends AbstractTableModel{

	private List<Boolean> koJeOtkacen;

	public AbstractTableModelStudenti() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
			koJeOtkacen.add(false);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 4;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount() + 2;
	}

	@Override
	public String getColumnName(int column) {
		return "Nothing";
	}

	// da bismo mogli prikazati dugme
	/*@Override
	public Class<?> getColumnClass(int columnIndex) {
		
	}*/

	/*@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 4)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 4) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		} else if (columnIndex == 5) {
			return koJeOtkacen.get(rowIndex);
		}
		return null;
	}*/

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}
		koJeOtkacen.set(rowIndex, !koJeOtkacen.get(rowIndex));
	}

	public void studentDodaj() {
		this.koJeOtkacen.add(false);
	}
	
	public void studentObrisan(int rowIndex) {
		this.koJeOtkacen.remove(rowIndex);
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
