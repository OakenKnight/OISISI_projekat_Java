package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class PrikazPredmetaNaKojeStudentIde extends JFrame{
	public PrikazPredmetaNaKojeStudentIde() {
		setSize(400, 300);
		setLocationRelativeTo(null);

		setTitle("Spisak predmeta");
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		DefaultListModel<String> tx = new DefaultListModel<String>();
		

		Student st = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().selektovanRed));
		int i = 0;
		for(Predmet temp : st.getPredmeti()) {
			tx.add(i++,temp.getSifra_predmeta());
		}
		JList<String> lista = new JList<String>(tx);
		lista.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista);
		scrollPane.createVerticalScrollBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(20, 60, 100, 60);
		scrollPane.setBorder(emptyBorder);

	
		
		JPanel nazad = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnNazad = new JButton("Nazad");
		
		
		btnNazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
	
		nazad.add(btnNazad);

		

		
		Box struktura = Box.createVerticalBox();
		struktura.add(nazad);
		struktura.add(donjiPanel);
		struktura.setPreferredSize(new Dimension(50,50));
		this.add(scrollPane,BorderLayout.CENTER);
		this.add(struktura,BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
