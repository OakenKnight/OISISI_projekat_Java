package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.BazaPredmeta;

public class TabbedPane extends JTabbedPane{
	public TabbedPane() {
		JPanel studentPanel=new JPanel();
		JPanel profPanel=new JPanel();
		JPanel subjPanel=new JPanel();
		
		JLabel studLabel=new JLabel("nesto1");
		JLabel profLabel=new JLabel("nesto2");
		JLabel subjLabel=new JLabel("nesto3");
		
		//JTable predmeti=new PredmetiJTable();
		//dodate labele na panele
		studentPanel.add(studLabel);
		profPanel.add(profLabel);
		
		
		subjPanel.add(subjLabel);
		//BazaPredmeta bp=new BazaPredmeta();
		//dodati paneli
		add("Studenti",studentPanel);
		add("Profesori",profPanel);
		add("Predmeti",subjPanel);
		
	}
}
