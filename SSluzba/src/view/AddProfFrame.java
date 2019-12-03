package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfFrame extends JDialog{
	public AddProfFrame() {
		
	    setLocation(800, 300);
		setTitle("Dodavanje studenta");
				
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		/*
		JLabel imeL=new JLabel("Ime: *");
		JTextField imeTF=new JTextField(30);
		
		JLabel prezimeL=new JLabel("Prezime: *");
		JTextField prezimeTF=new JTextField(30);
		
		JLabel datumL=new JLabel("Datum rodjenja: *");
		JTextField datumTF=new JTextField(10);
		
		JLabel telefonL=new JLabel("Kontakt telefon: *");
		JTextField telefonTF=new JTextField(16);
		
		JLabel emailL=new JLabel("E-mail adresa: *");
		JTextField emailTF=new JTextField(30);
		
		JLabel kancelarijaL=new JLabel("Adresa kancelarije: *");
		JTextField kancelarijaTF=new JTextField(30);
		
		JLabel blkL=new JLabel("Broj licne karte: *");
		JTextField  blkTF=new JTextField(20);
		
		JLabel titulaL=new JLabel("Titula: *");
		String[] titule= {"BSc","MSc","PhD"};
		JComboBox tituleCB=new JComboBox(titule);
		
		JLabel zvanjeL=new JLabel("Zvanje: *");
		String[] zvanja= {"Saradnik u nastavi","Asistent","Docent","Vanredni profesor","Redovni profesor"};
		JComboBox zvanjeCB=new JComboBox(zvanja);
		

		JButton okBtn=new JButton("Ok");
		okBtn.setToolTipText("Potvrdi");
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO dodaj predmet i ugasi taj window
				unosProf.setVisible(false);
				unosProf.dispose();
				
			}
		});
		JButton cancelBtn=new JButton("Cancel");
		cancelBtn.setToolTipText("Odustani");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO ugasi taj window
				unosProf.setVisible(false);
				unosProf.dispose();
				
			}
		}
		);	*/
		
		//this.add(obrazac,BorderLayout.CENTER);
		
		this.add(donjiPanel,BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);
			
	}
}
