package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.BazaPredmeta;

public class TabbedPane extends JTabbedPane{
	private  static int stanje;
	public TabbedPane() {
		stanje=1;
		JPanel studentPanel=new JPanel();
		JPanel profPanel=new JPanel();
		JPanel subjPanel=new JPanel();
		
		PredmetiPanel predmetiP=new PredmetiPanel();
		
		JLabel studLabel=new JLabel("nesto1");
		JLabel profLabel=new JLabel("nesto2");
		JLabel subjLabel=new JLabel("nesto3");
		
		//JTable predmeti=new PredmetiJTable();
		//dodate labele na panele
		studentPanel.add(studLabel);
		profPanel.add(profLabel);
		//BazaPredmeta bp=new BazaPredmeta();
		//dodati paneli
		add("Studenti",studentPanel);
		add("Profesori",profPanel);
		add("Predmeti",predmetiP);
		
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
