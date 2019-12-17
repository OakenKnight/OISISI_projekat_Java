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
	/**
	 * 
	 */
	private static final long serialVersionUID = 8657108270475531153L;
	
	public static int stanje;
	private static PredmetiJTable tabelaPredmeti;
	private static ProfesoriJTable tabelaProfesori;
	private static StudentiJTable tabelaStudenti;
	
	
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
		
		tabelaPredmeti=new PredmetiJTable();
		JScrollPane skrolPredmeti=new JScrollPane(tabelaPredmeti);
		
		tabelaProfesori=new ProfesoriJTable();
		JScrollPane skrolProfesori=new JScrollPane(tabelaProfesori);

		tabelaStudenti=new StudentiJTable();
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
			    //System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(stanje));
			  }
			};
			addChangeListener(changeListener);
	}
	public static int getStanje() {
		return stanje;
	}
	public void azurirajStudentiO() {
		AbstractTableModelStudenti model=(AbstractTableModelStudenti)tabelaStudenti.getModel();
		model.fireTableDataChanged();
	}
	public void azurirajProfesori() {
		AbstractTableModelProfesor model=(AbstractTableModelProfesor) tabelaProfesori.getModel();
		model.fireTableDataChanged();


	}
	public void azurirajPredmeti() {
		// TODO Auto-generated method stub
		//?????????
		
		AbstractTableModelPredmeti model=(AbstractTableModelPredmeti) tabelaPredmeti.getModel();
		
		model.fireTableDataChanged();
		//tabelaPredmeti.revalidate();
	}
}
