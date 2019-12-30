package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class PrikazStudenataUPredmetu extends JFrame{
	
	
	public PrikazStudenataUPredmetu() {
		setLocation(800, 300);
		setTitle("Dodavanje studenta");
		JPanel p = new JPanel();
		JTextArea tx =  new JTextArea();
		
		Predmet st = new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
		StringBuilder svi = new StringBuilder("");
		for(Student temp : st.getBrIndeksaStudenata()) {
			svi.append(temp.getBrIndex()+"\n");
		}
		tx.setText(svi.toString());
		p.add(tx);
		
		add(p,BorderLayout.CENTER);
		
		setSize(400, 600);
		setVisible(true);
	}
}
