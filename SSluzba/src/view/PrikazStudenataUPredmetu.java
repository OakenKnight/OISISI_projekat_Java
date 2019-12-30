package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class PrikazStudenataUPredmetu extends JFrame{
	
	
	public PrikazStudenataUPredmetu() {
		setLocation(800, 300);
		setTitle("Spisak studenta");
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		DefaultListModel<String> tx = new DefaultListModel<String>();
		Predmet st = new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
		int i = 0;
		for(Student temp : st.getBrIndeksaStudenata()) {
			tx.add(i++,temp.getBrIndex());
		}
		JList<String> lista = new JList<String>(tx);
		lista.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lista);
		scrollPane.createVerticalScrollBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(20, 60, 100, 60);
		scrollPane.setBorder(emptyBorder);

	
		
		JPanel nazadBrisanje = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnNazad = new JButton("Nazad");
		JButton btnObrisi = new JButton("Obrisi");
		
		btnNazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(lista.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite studenta kog zelite da obrisete!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje studenta sa predmeta",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						//Treba implementirati
						System.out.println("dobro");
					}
					
				}
				
			}
		});
		
		nazadBrisanje.add(btnObrisi);
		nazadBrisanje.add(btnNazad);
		
		Box struktura = Box.createVerticalBox();
		struktura.add(nazadBrisanje);
		struktura.add(donjiPanel);
		struktura.setPreferredSize(new Dimension(50,50));
		this.add(scrollPane,BorderLayout.CENTER);
		this.add(struktura,BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
	}
}
