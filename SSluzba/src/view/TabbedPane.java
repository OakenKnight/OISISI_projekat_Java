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
		
		
		JLabel studLabel=new JLabel("nesto1");
		JLabel profLabel=new JLabel("nesto2");
		JLabel subjLabel=new JLabel("nesto3");
		
		studentPanel.add(studLabel);
		profPanel.add(profLabel);
		
		addTab("Studenti",studentPanel);
		add("Profesori",profPanel);
		add("Predmeti",skrolPredmeti);
		
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
}
