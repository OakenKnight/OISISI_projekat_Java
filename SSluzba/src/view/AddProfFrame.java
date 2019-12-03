package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8592866674972968760L;

	public AddProfFrame() {
		
	    setLocation(800, 300);
		setTitle("Dodavanje profesora");
				
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		JPanel imeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeL=new JLabel("Ime: *");
		JTextField imeTF=new JTextField();
		imeTF.setPreferredSize(new Dimension(200,25));
		
		imeP.add(imeL);
		imeP.add(imeTF);
		
		
		JPanel prezimeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeL=new JLabel("Prezime: *");
		JTextField prezimeTF=new JTextField();
		prezimeTF.setPreferredSize(new Dimension(200,25));
		
		prezimeP.add(prezimeL);
		prezimeP.add(prezimeTF);
		
		JPanel datumP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumL=new JLabel("Datum rodjenja: *");
		JTextField datumTF=new JTextField();
		datumTF.setPreferredSize(new Dimension(200,25));
		
		datumP.add(datumL);
		datumP.add(datumTF);
		
		JPanel telefonP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonL=new JLabel("Kontakt telefon: *");
		JTextField telefonTF=new JTextField();
		telefonTF.setPreferredSize(new Dimension(200,25));
		
		telefonP.add(telefonL);
		telefonP.add(telefonTF);
		
		JPanel adresaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaL= new JLabel("Adresa stanovanja* ");
		JTextField adresaTF = new JTextField();
		adresaTF.setPreferredSize(new Dimension(200,25));
		
		adresaP.add(adresaL);
		adresaP.add(adresaTF);
		
		JPanel emailP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailL=new JLabel("E-mail adresa: *");
		JTextField emailTF=new JTextField();
		emailTF.setPreferredSize(new Dimension(200,25));
		
		emailP.add(emailL);
		emailP.add(emailTF);
		
		
		JPanel kancelarijaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel kancelarijaL=new JLabel("Adresa kancelarije: *");
		JTextField kancelarijaTF=new JTextField();
		kancelarijaTF.setPreferredSize(new Dimension(200,25));
		
		kancelarijaP.add(kancelarijaL);
		kancelarijaP.add(kancelarijaTF);
		
		JPanel blkP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel blkL=new JLabel("Broj licne karte: *");
		JTextField  blkTF=new JTextField();
		blkTF.setPreferredSize(new Dimension(200,25));
		
		blkP.add(blkL);
		blkP.add(blkTF);
		
		JPanel titulaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel titulaL=new JLabel("Titula: *");
		String[] titule= {"BSc","MSc","PhD"};
		JComboBox<Object> tituleCB=new JComboBox<Object>(titule);
				
		titulaP.add(titulaL);
		titulaP.add(tituleCB);
		
		JPanel zvanjeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel zvanjeL=new JLabel("Zvanje: *");
		String[] zvanja= {"Saradnik u nastavi","Asistent","Docent","Vanredni profesor","Redovni profesor"};
		JComboBox<Object> zvanjeCB=new JComboBox<Object>(zvanja);
		
		
		zvanjeP.add(zvanjeL);
		zvanjeP.add(zvanjeCB);
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(imeTF.getText().equals("") || prezimeTF.getText().equals("") || datumTF.getText().equals("") || adresaTF.getText().equals("") || 
						telefonTF.getText().equals("") || emailTF.getText().equals("") || kancelarijaTF.getText().equals("")  ) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
					
				}else {
					setVisible(false);
					dispose();
				}
				
			}
		});
		odustanakPotvrda.add(odustanak);
		odustanakPotvrda.add(potvrda);

		Box obrazac = Box.createVerticalBox();
		obrazac.add(Box.createVerticalStrut(10));
		obrazac.add(imeP);
		obrazac.add(prezimeP);
		obrazac.add(datumP);
		obrazac.add(adresaP);
		obrazac.add(telefonP);
		obrazac.add(emailP);
		obrazac.add(kancelarijaP);
		obrazac.add(blkP);
		obrazac.add(titulaP);
		obrazac.add(zvanjeP);
		obrazac.add(odustanakPotvrda);
		obrazac.add(Box.createGlue());
		
		
		this.add(obrazac,BorderLayout.CENTER);
		
		this.add(donjiPanel,BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);
			
	}
}
