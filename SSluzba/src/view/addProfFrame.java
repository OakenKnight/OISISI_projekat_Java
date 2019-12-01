package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addProfFrame {
	public addProfFrame() {
		JFrame unosProf=new JFrame();
		JPanel unosPanel=new JPanel();
		
		unosPanel.setLayout(new GridBagLayout());
		unosProf.setTitle("Dodavanje profesora");
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		unosProf.setSize(2*screenWidth/7,3*screenHeight/6);
		unosProf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		unosProf.setLocationRelativeTo(null);
		
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
		);	
			
			GridBagConstraints gbcLblIme= new GridBagConstraints();
			gbcLblIme.gridx = 0;
			gbcLblIme.gridy = 0;
			gbcLblIme.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(imeL, gbcLblIme);
			
			GridBagConstraints gbcTxtIme = new GridBagConstraints();
			gbcTxtIme.gridx = 1;
			gbcTxtIme.gridy = 0;
			//gbcTxtIme.weightx = 100;
			gbcTxtIme.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtIme.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(imeTF, gbcTxtIme);
			
			GridBagConstraints gbcLblPrz= new GridBagConstraints();
			gbcLblPrz.gridx = 0;
			gbcLblPrz.gridy = 1;
			gbcLblPrz.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(prezimeL, gbcLblPrz);
			
			GridBagConstraints gbcTxtPrz = new GridBagConstraints();
			gbcTxtPrz.gridx = 1;
			gbcTxtPrz.gridy = 1;
			//gbcTxtPrz.weightx = 100;
			gbcTxtPrz.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtPrz.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(prezimeTF, gbcTxtPrz);
			
			GridBagConstraints gbcLblDatum= new GridBagConstraints();
			gbcLblDatum.gridx = 0;
			gbcLblDatum.gridy = 2;
			gbcLblDatum.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(datumL, gbcLblDatum);
			
			GridBagConstraints gbcTxtDatum = new GridBagConstraints();
			gbcTxtDatum.gridx = 1;
			gbcTxtDatum.gridy = 2;
			//gbcTxtDatum.weightx = 100;
			gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtDatum.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(datumTF, gbcTxtDatum);
			
			GridBagConstraints gbcLblTelefon= new GridBagConstraints();
			gbcLblTelefon.gridx = 0;
			gbcLblTelefon.gridy = 3;
			gbcLblTelefon.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(telefonL, gbcLblTelefon);
			
			GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
			gbcTxtTelefon.gridx = 1;
			gbcTxtTelefon.gridy = 3;
			//gbcTxtDatum.weightx = 100;
			gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(telefonTF, gbcTxtTelefon);
			
			GridBagConstraints gbcLblEmail= new GridBagConstraints();
			gbcLblEmail.gridx = 0;
			gbcLblEmail.gridy = 4;
			gbcLblEmail.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(emailL, gbcLblEmail);
			
			GridBagConstraints gbcTxtEmail = new GridBagConstraints();
			gbcTxtEmail.gridx = 1;
			gbcTxtEmail.gridy = 4;
			//gbcTxtDatum.weightx = 100;
			gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(emailTF, gbcTxtEmail);
			
			

			GridBagConstraints gbcLblAdresaKanc= new GridBagConstraints();
			gbcLblAdresaKanc.gridx = 0;
			gbcLblAdresaKanc.gridy = 5;
			gbcLblAdresaKanc.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(kancelarijaL, gbcLblAdresaKanc);
			
			GridBagConstraints gbcTxtAdresaKanc = new GridBagConstraints();
			gbcTxtAdresaKanc.gridx = 1;
			gbcTxtAdresaKanc.gridy = 5;
			//gbcTxtDatum.weightx = 100;
			gbcTxtAdresaKanc.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtAdresaKanc.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(kancelarijaTF, gbcTxtAdresaKanc);
			
			/*
			GridBagConstraints gbcLblBlk= new GridBagConstraints();
			gbcLblBlk.gridx = 0;
			gbcLblBlk.gridy = 6;
			gbcLblBlk.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(blkL, gbcLblBlk);
			
			GridBagConstraints gbcTxtBlk = new GridBagConstraints();
			gbcTxtBlk.gridx = 1;
			gbcTxtBlk.gridy = 6;
			gbcTxtBlk.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtBlk.insets = new Insets(20, 20, 0, 20);
			unosPanel.add(blkTF, gbcTxtBlk);
			
			GridBagConstraints gbLblTitula= new GridBagConstraints();
			gbLblTitula.gridx = 0;
			gbLblTitula.gridy = 7;
			gbLblTitula.anchor=GridBagConstraints.WEST;
			gbLblTitula.insets = new Insets(20, 10, 0, 0);
			unosPanel.add(titulaL, gbLblTitula);
			
			GridBagConstraints gbCBTitula= new GridBagConstraints();
			gbCBTitula.gridx = 1;
			gbCBTitula.gridy = 7;
			gbCBTitula.insets = new Insets(20, 0, 0, 0);
			unosPanel.add(tituleCB, gbCBTitula);
			
			*/
			unosProf.add(unosPanel);

		unosProf.setVisible(true);
	}
}
