package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PredmetiPanel extends JPanel{
	 JTable tabelaPredmeti = new JTable(new AbstractTableModelPredmeti());

	public PredmetiPanel() { 
		
		
		prikaziTabeluPredmeta();
		
		
	}
	private void JTinit() {
		
		
		
	}
	private void azurirajPrikaz(String akcija, int vr) {
		AbstractTableModelPredmeti model=(AbstractTableModelPredmeti) tabelaPredmeti.getModel();
		
		model.fireTableDataChanged();
		validate();
		
		
	}
	private void prikaziTabeluPredmeta() {
		JTable tabelaPredmeti=new JTable();
		
	}
}
