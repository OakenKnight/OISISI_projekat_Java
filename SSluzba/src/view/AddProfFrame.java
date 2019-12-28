package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FocusProfesori;
import controller.ProfesorController;

public class AddProfFrame extends JFrame{
	/**
	 * 
	 */
	public static JTextField imeTF;
	public static JTextField prezimeTF;
	public static JTextField datumTF;
	public static JTextField telefonTF;
	public static JTextField adresaTF;
	public static JTextField kancelarijaTF;
	public static JTextField blkTF;
	public static JTextField emailTF;
	public static String titula;
	public static String zvanje;

	private static final long serialVersionUID = 8592866674972968760L;

	public AddProfFrame() {
		
	    setLocation(800, 300);
		setTitle("Dodavanje profesora");
				
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		FocusProfesori fokus=new FocusProfesori();
		
		
		JPanel imeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeL=new JLabel("Ime: *");
		imeTF=new JTextField();
		imeTF.setName("txt");
		imeTF.setPreferredSize(new Dimension(200,25));
		imeTF.addFocusListener(fokus);
		
		
		imeP.add(imeL);
		imeP.add(imeTF);
		
		
		JPanel prezimeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeL=new JLabel("Prezime: *");
		prezimeTF=new JTextField();
		prezimeTF.setName("txt");
		prezimeTF.setPreferredSize(new Dimension(200,25));
		prezimeTF.addFocusListener(fokus);
		
		
		prezimeP.add(prezimeL);
		prezimeP.add(prezimeTF);
		
		JPanel datumP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumL=new JLabel("Datum rodjenja: *");
		datumTF=new JTextField();
		datumTF.setName("txt");
		datumTF.setPreferredSize(new Dimension(200,25));
		datumTF.addFocusListener(fokus);
		
		
		datumP.add(datumL);
		datumP.add(datumTF);
		
		JPanel telefonP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonL=new JLabel("Kontakt telefon: *");
		telefonTF=new JTextField();
		telefonTF.setName("txt");
		telefonTF.setPreferredSize(new Dimension(200,25));
		telefonTF.addFocusListener(fokus);
		
		telefonP.add(telefonL);
		telefonP.add(telefonTF);
		
		JPanel emailP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailL=new JLabel("Email: *");
		emailTF=new JTextField();
		emailTF.setName("txt");
		emailTF.setPreferredSize(new Dimension(200,25));
		emailTF.addFocusListener(fokus);
		
		
		emailP.add(emailL);
		emailP.add(emailTF);
		
		
		JPanel adresaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaL= new JLabel("Adresa stanovanja* ");
		adresaTF = new JTextField();
		adresaTF.setName("txt");
		adresaTF.setPreferredSize(new Dimension(200,25));
		adresaTF.addFocusListener(fokus);
		
		
		adresaP.add(adresaL);
		adresaP.add(adresaTF);

		
		
		JPanel kancelarijaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel kancelarijaL=new JLabel("Adresa kancelarije: *");
		kancelarijaTF=new JTextField();
		kancelarijaTF.setName("txt");
		kancelarijaTF.setPreferredSize(new Dimension(200,25));
		kancelarijaTF.addFocusListener(fokus);
		
		
		kancelarijaP.add(kancelarijaL);
		kancelarijaP.add(kancelarijaTF);
		
		JPanel blkP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel blkL=new JLabel("Broj licne karte: *");
		blkTF=new JTextField();
		blkTF.setName("txt");
		blkTF.setPreferredSize(new Dimension(200,25));
		blkTF.addFocusListener(fokus);
		
		
		blkP.add(blkL);
		blkP.add(blkTF);
		
		JPanel titulaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel titulaL=new JLabel("Titula: *");
		String[] titule= {"BSc","MSc","PhD"};
		JComboBox<Object> tituleCB=new JComboBox<Object>(titule);
		titula=(String)tituleCB.getSelectedItem();
		
		titulaP.add(titulaL);
		titulaP.add(tituleCB);
		
		JPanel zvanjeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel zvanjeL=new JLabel("Zvanje: *");
		String[] zvanja= {"Saradnik u nastavi","Asistent","Docent","Vanredni profesor","Redovni profesor"};
		JComboBox<Object> zvanjeCB=new JComboBox<Object>(zvanja);
		zvanje=(String)zvanjeCB.getSelectedItem();

		
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
		//implementiram serijalizaciju
		potvrda.addActionListener(new ActionListener() {
			String imeReg="[A-Z][a-z]+";
			String adresaReg="[a-zA-Z ]*[0-9][a-z]*";
			String telReg="[0-9]+";
			String emailReg="[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-z]+";
			String kancReg="[0-9a-zA-z ]*";
			String blkReg="[0-9]+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(imeTF.getText().equals("") || prezimeTF.getText().equals("") || datumTF.getText().equals("") || adresaTF.getText().equals("") || 
						telefonTF.getText().equals("") || emailTF.getText().equals("") || kancelarijaTF.getText().equals("")  || blkTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
				
				}else if(!imeTF.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Ime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!prezimeTF.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumTF.getText())){
					JOptionPane.showMessageDialog(null, "Datum nije unesen kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!adresaTF.getText().trim().matches(adresaReg)) {
					JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!telefonTF.getText().matches(telReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailTF.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!kancelarijaTF.getText().matches(kancReg)) {
					JOptionPane.showMessageDialog(null, "Kancelarija nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!blkTF.getText().matches(blkReg)){
					JOptionPane.showMessageDialog(null, "BLK nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else {
					
					
					ProfesorController.getInstance().addProfesor(imeTF.getText(), prezimeTF.getText(), datumTF.getText(), adresaTF.getText(), telefonTF.getText(), emailTF.getText(), kancelarijaTF.getText(), blkTF.getText(), titula, zvanje);
					
					setVisible(false);
					//dispose();
				}
				
			}
			private boolean proveriDatum(String text) {
				// TODO Auto-generated method stub
				if(!text.isEmpty()) {
					

					String regexdatum="^\\d{1,2}\\.\\d{1,2}\\.\\d{4}.$";
					
					if(!text.matches(regexdatum)) {
						return false;
					}else {
						String[] datumi=text.split("\\.");
						int dan=Integer.parseInt(datumi[0]);
						int mesec=Integer.parseInt(datumi[1]);

						if(dan<1) {
							return false;
						}else if(mesec>12) {
							return false;
						}else if(mesec<1) {
							return false;
						}else if(mesec==2) {
							if(dan>29 ) {
								return false;
							}
						}else if(mesec==1 || mesec==3 || mesec==5 || mesec==7 ||mesec==8 || mesec==10 || mesec==12) {
							if(dan>31) {
								return false;
							}
						}else if(mesec==4 || mesec==6 || mesec==9 || mesec==11) {
							if(dan>30) {
								return false;
							}
						}
						return true;
						}
					}
				return false;
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
