package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BazaPredmeta;


public class EntityController {
	
	private static EntityController instance = null;
	
	public static EntityController getInstance() {
		if (instance == null) {
			instance = new EntityController();
		}
		return instance;
	}
	private EntityController() {}

	public void addEntity() {
		//TODO: ovo je samo neka ideja za taj iskacuci meni za predmete
		JFrame unosPredmeta = new JFrame();

		JPanel unosPanel=new JPanel();
		unosPanel.setLayout(new GridBagLayout());
		
		unosPredmeta.setTitle("Dodavanje predmeta");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		unosPredmeta.setSize(2*screenWidth/7,3*screenHeight/10);
		unosPredmeta.setTitle("Dodaj predmet");
		unosPredmeta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		unosPredmeta.setLocationRelativeTo(null);
		
		
		JLabel spL=new JLabel("Sifra predmeta: *");
		JTextField spTF = new JTextField(10);
		spTF.setName("txtSifra");
		//spTF.addFocusListener(focusListener1);
		
		JLabel npL=new JLabel("Naziv predmeta:");
		JTextField npTF = new JTextField(30);
		npTF.setName("txtNaziv");
		//npTF.addFocusListener(focusListener2);

		JLabel semestarL=new JLabel("Semestar:");
		String[] semestri= {"I (Prvi)","II (Drugi)","III (Treci)","IV (Cetvrti)","V (Peti)","VI (Sesti)","VII (Sedmi)","VIII (Osmi)"};
		JComboBox semestarCB=new JComboBox(semestri);
	
		JLabel godinaL=new JLabel("Godina:");
		String[] godine= {"Prva","Druga","Treca","Cetvrta"};
		JComboBox godineCB=new JComboBox(godine);
		
		JLabel profesorL=new JLabel("Profesor:");
		JTextField profesorTF=new JTextField(30);
		
		JButton okBtn=new JButton("Ok");
		okBtn.setToolTipText("Potvrdi");
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO dodaj predmet i ugasi taj window
				
			}
		});
		JButton cancelBtn=new JButton("Cancel");
		okBtn.setToolTipText("Odustani");
		
		
		
		GridBagConstraints gbcLblSifraPredmeta= new GridBagConstraints();
		gbcLblSifraPredmeta.gridx = 0;
		gbcLblSifraPredmeta.gridy = 0;
		gbcLblSifraPredmeta.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(spL, gbcLblSifraPredmeta);
		
		GridBagConstraints gbcTxtSifraPredmeta = new GridBagConstraints();
		gbcTxtSifraPredmeta.gridx = 1;
		gbcTxtSifraPredmeta.gridy = 0;
		gbcTxtSifraPredmeta.weightx = 100;
		gbcTxtSifraPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifraPredmeta.insets = new Insets(20, 20, 0, 20);
		unosPanel.add(spTF, gbcTxtSifraPredmeta);
					
		GridBagConstraints gbcLNazivPredmeta = new GridBagConstraints();
		gbcLNazivPredmeta.gridx = 0;
		gbcLNazivPredmeta.gridy = 1;
		
		gbcLNazivPredmeta.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(npL, gbcLNazivPredmeta);

		
		GridBagConstraints gbcTxtNazivPredmeta = new GridBagConstraints();
		gbcTxtNazivPredmeta.gridx = 1;
		gbcTxtNazivPredmeta.gridy = 1;
		gbcTxtNazivPredmeta.weightx = 100;
		gbcTxtNazivPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNazivPredmeta.insets = new Insets(20, 20, 0, 20);
		unosPanel.add(npTF, gbcTxtNazivPredmeta);
		
		GridBagConstraints gbLblSemestar= new GridBagConstraints();
		gbLblSemestar.gridx = 0;
		gbLblSemestar.gridy = 2;
		gbLblSemestar.anchor=GridBagConstraints.WEST;
		gbLblSemestar.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(semestarL, gbLblSemestar);
		
		GridBagConstraints gbCBSemestar= new GridBagConstraints();
		gbCBSemestar.gridx = 1;
		gbCBSemestar.gridy = 2;
		gbCBSemestar.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(semestarCB, gbCBSemestar);
		
		GridBagConstraints gbLblGodina= new GridBagConstraints();
		gbLblGodina.gridx = 0;
		gbLblGodina.gridy = 3;
		gbLblGodina.anchor=GridBagConstraints.WEST;
		gbLblGodina.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(godinaL, gbLblGodina);
		
		GridBagConstraints gbCBGodina= new GridBagConstraints();
		gbCBGodina.gridx = 1;
		gbCBGodina.gridy = 3;
		gbCBGodina.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(godineCB, gbCBGodina);
		
		GridBagConstraints gbLblProfesor= new GridBagConstraints();
		gbLblProfesor.gridx = 0;
		gbLblProfesor.gridy = 4;
		gbLblProfesor.anchor=GridBagConstraints.WEST;
		gbLblProfesor.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(profesorL, gbLblProfesor);
		
		GridBagConstraints gbTxtProfesor= new GridBagConstraints();
		gbTxtProfesor.gridx = 1;
		gbTxtProfesor.gridy = 4;
		gbTxtProfesor.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(profesorTF, gbTxtProfesor);
		
		GridBagConstraints gbBtnOk= new GridBagConstraints();
		gbBtnOk.gridx = 0;
		gbBtnOk.gridy = 5;
		gbBtnOk.anchor=GridBagConstraints.CENTER;
		gbBtnOk.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(okBtn,gbBtnOk);
		
		GridBagConstraints gbBtnCancel= new GridBagConstraints();
		gbBtnCancel.gridx = 1;
		gbBtnCancel.gridy = 5;
		gbBtnCancel.anchor=GridBagConstraints.CENTER;
		gbBtnCancel.insets = new Insets(20, 10, 0, 0);
		unosPanel.add(cancelBtn,gbBtnCancel);

 		unosPredmeta.add(unosPanel);
 		
 		
 		//unosPredmeta.add(Box.createGlue());
		unosPredmeta.setVisible(true);
	}
	public void editEntity() {
		//TODO: preraditi metodu da menja entitete
	}
	public void removeEntity() {
		//TODO: preraditi metodu da brise entitete
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
