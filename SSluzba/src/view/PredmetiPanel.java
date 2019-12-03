package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PredmetiPanel extends JPanel{
	private JTable tabelaPredmeti;
	
	public PredmetiPanel(){
		
		prikaziTabeluPredmeta();
		
		
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
