package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.BazaPredmeta;

public class TabbedPane extends JTabbedPane{
	public static int stanje;
	
	
	public static JTable tabelaPredmeti;
	public static JScrollPane skrolPredmeti;
	
	
	private static TabbedPane instance = null;

	public static TabbedPane getInstance() {
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	public TabbedPane() {
		JPanel studentPanel=new JPanel();
		JPanel profPanel=new JPanel();
		JPanel subjPanel=new JPanel();
		
		JTable tabelaPredmeti=new PredmetiJTable();
		JScrollPane skrolPredmeti=new JScrollPane(tabelaPredmeti);
		
		JTable tabelaProfesori=new ProfesoriJTable();
		JScrollPane skrolProfesori=new JScrollPane(tabelaProfesori);

		JTable tabelaStudenti=new StudentiJTable();
		JScrollPane skrolStudenti=new JScrollPane(tabelaStudenti);
		
		JLabel studLabel=new JLabel("nesto1");
		JLabel profLabel=new JLabel("nesto2");
		JLabel subjLabel=new JLabel("nesto3");
		
		
		
		addTab("Studenti",skrolStudenti);
		add("Profesori",skrolProfesori);
		add("Predmeti",skrolPredmeti);
		
		tabelaStudenti.setAutoCreateRowSorter(true);
		tabelaProfesori.setAutoCreateRowSorter(true);
		tabelaPredmeti.setAutoCreateRowSorter(true);

		
		ChangeListener changeListener = new ChangeListener() {
			  public void stateChanged(ChangeEvent changeEvent) {
			    JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
			    stanje = sourceTabbedPane.getSelectedIndex();
			    System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(stanje));
			  }
			};
			addChangeListener(changeListener);
	}
	public static int getStanje() {
		return stanje;
	}
	
	public void azurirajPredmeti() {
		// TODO Auto-generated method stub
		//?????????
		
		//AbstractTableModelPredmeti model=(AbstractTableModelPredmeti) tabelaPredmeti.getModel();
		
		//model.fireTableDataChanged();
		//tabelaPredmeti.revalidate();
	}
}
