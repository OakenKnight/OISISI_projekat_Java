package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HelpFrame extends JFrame{
	public HelpFrame (){
		setLocation(800, 300);
		setTitle("Uputstvo");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		TextArea uputstvo = new TextArea();
		uputstvo.setText("1) DODAVANJE \n"
				+ "Potrebno je nalaziti se u tabu zeljenog entiteta i zatim kliknuti na dugme za dodavanje novog entiteta (prvo u tulbaru).\n"
				+ "Zatim je potrebno ispuniti obavezna polja u obrascu za unos novog entiteta i kliknuti na 'Potvrdi'. Dodavanje entiteta\n"
				+ "moguce je sprovesti i kroz meni izborom opcija 'File' -> 'New' ili pomocu precise Ctrl+N.\n"
				+ "2) BRISANJE \n"
				+ "Potrebno je oznaciti postojeci entitet u tabeli i zatim kliknuti na dugme za brisanje entiteta (trece u tulbaru).\n"
				+ "Brisanje entiteta je moguce sprovesti i kroz meni izborom opcije 'Edit' -> 'Delete' ili pomocu precice Ctrl+D\n"
				+ "3) IZMENA \n"
				+ "Potrebno je oznaciti postojeci entitet u tabeli i zatim kliknuti na dugme za izmenu entiteta (drugo u tulbaru).\n"
				+ "Izmenu entiteta je moguce sprovesti i kroz meni izborom opcije 'Edit' -> 'Edit' ili pomocu precice Ctrl+E\n"
				+ "4) PRETRAGA \n"
				+ "");
		
		uputstvo.setEnabled(false);
		
		
		
		JPanel panelZaDugme = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btn = new JButton("Cancle");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
		panelZaDugme.add(btn);
		
		Box struktura = Box.createVerticalBox();
		struktura.add(panelZaDugme);
		struktura.add(donjiPanel);
		struktura.setPreferredSize(new Dimension(50,50));
		this.add(uputstvo,BorderLayout.CENTER);
		this.add(struktura,BorderLayout.SOUTH);
		setSize(820, 500);
		setVisible(true);
	}
}
