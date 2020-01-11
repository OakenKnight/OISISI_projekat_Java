package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AboutFrame extends JFrame{
	public AboutFrame() {
		setLocation(800, 300);
		setTitle("O aplikaciji");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		TextArea uputstvo = new TextArea();
		//ScrollPane sc = new ScrollPane();
		uputstvo.setText("Verzija 1.1\nPoslednje izmene: 05.01.2020.\nAutori aplikacije:\nIgnjatijevic Aleksandar i Zupunski Radovan\n\n"
				+ "Aplikacija 'Studentska sluzba' namenjena je evidenciji informacija o studentima, profesorima i predmetima. \n"
				+ "Pocetni interfejs aplikacije raspolaze sa tri taba i izborom nekog od tabova dolazi se do informacija koje\n"
				+ "su vezane za odabrani entitet. Svaki od tabova raspolaze sa odredjenim akcijama kao sto su dodavanje novog\n"
				+ "ili brisanje i izmena postojeceg entiteta kao i dodavanje drugih entiteta na spisak izabranog entiteta.\n"
				+ "Akcije je moguce sprovesti i iz menija biranjem odgovarajucih opcija.\n\n\nAutori:\n"
				+ "Ignjatijevic Aleksandar, student trece godin Fakulteta tehnickih nauka, rodjen je u Novom Sadu 19. aprila 1998. godine. \n"
				+ "Zavrsio je osnovnu skolu Branko Radicevic u Novom sadu 2013. godine,a potom upisao Gimnaziju Isidora Sekulic u Novom sadu\n"
				+ "koju je zavrsio 2017. godine. "
				+ "\n\n"
				+ "Zupunski Radovan, student trece godine Fakulteta tehnickih nauka, rodjen je u Sremskoj Mitrovici 13. avgusta 1998. godine.\n"
				+ "Zavrsio je osnovnu skolu Jovan Jovanovic Zmaj u Martincima 2013. godine i srednju medicinsku skolu Draginja Niksic u\n"
				+ "Sremskoj Mitrovici 2017. godine.");
		
		uputstvo.setEnabled(false);
		
		
		
		JPanel panelZaDugme = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btn = new JButton("Cancel");
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
