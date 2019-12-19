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
	private TabbedPane() {
		JPanel studentPanel=new JPanel();
		JPanel profPanel=new JPanel();
		JPanel subjPanel=new JPanel();
		
		tabelaPredmeti=PredmetiJTable.getInstance();
		JScrollPane skrolPredmeti=new JScrollPane(tabelaPredmeti);
		
		tabelaProfesori=ProfesoriJTable.getInstance();
		JScrollPane skrolProfesori=new JScrollPane(tabelaProfesori);

		tabelaStudenti=StudentiJTable.getInstance();
		JScrollPane skrolStudenti=new JScrollPane(tabelaStudenti);
		
		JLabel studLabel=new JLabel("nesto1");
		JLabel profLabel=new JLabel("nesto2");
		JLabel subjLabel=new JLabel("nesto3");
		
		System.out.println(this.getSelectedIndex());
		
		add("Studenti",skrolStudenti);
		add("Profesori",skrolProfesori);
		add("Predmeti",skrolPredmeti);
		
		tabelaStudenti.setAutoCreateRowSorter(true);
		tabelaProfesori.setAutoCreateRowSorter(true);
		tabelaPredmeti.setAutoCreateRowSorter(true);
		
		
	}
	public int getStanje() {
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
	public StudentiJTable getTabelatudenti() {
		return tabelaStudenti;
		
	}
}
