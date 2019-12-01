package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		//TODO: preraditi metodu da dodaje entitete
		JFrame unosPredmeta = new JFrame();
		//GridBagLayout gb = new GridBagLayout();
		//GridLayout experimentLayout = new GridLayout(0,2);

		JPanel unosPanel=new JPanel();
		unosPanel.setLayout(new GridBagLayout());
		unosPredmeta.setTitle("Dodavanje predmeta");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		unosPredmeta.setSize(2*screenWidth/7,3*screenHeight/5);
		unosPredmeta.setTitle("Studentska sluzba");
		unosPredmeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unosPredmeta.setLocationRelativeTo(null);
		
		JLabel spL=new JLabel("Sifra predmeta");
		JTextField spTF = new JTextField(10);
		JLabel npL=new JLabel("Naziv predmeta");
		JTextField npTF = new JTextField(30);
		JLabel semestarL=new JLabel("Semestar");
		String[] semestri= {"I (Prvi)","II (Drugi)","III (Treci)","IV (Cetvrti)","V (Peti)","VI (Sesti)","VII (Sedmi)","VIII (Osmi)"};
		JComboBox semestarCB=new JComboBox(semestri);
		//JTextField spTF = new JTextField(10);
		JLabel godinaL=new JLabel("Godina");
		//JTextField spTF = new JTextField(10);
		JLabel profL=new JLabel("Profesor");
		
		GridBagConstraints gbcLblSifraPredmeta= new GridBagConstraints();
		gbcLblSifraPredmeta.gridx = 0;
		gbcLblSifraPredmeta.gridy = 0;
		gbcLblSifraPredmeta.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(spL, gbcLblSifraPredmeta);
		
		GridBagConstraints gbcTxtSifraPredmeta = new GridBagConstraints();
		gbcTxtSifraPredmeta.gridx = 1;
		gbcTxtSifraPredmeta.gridy = 0;
		gbcTxtSifraPredmeta.weightx = 100;
		gbcTxtSifraPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifraPredmeta.insets = new Insets(20, 20, 0, 20);
		unosPanel.add(spTF, gbcTxtSifraPredmeta);
			
		//unosPanel.add(spTF);
		
		GridBagConstraints gbcLNazivPredmeta = new GridBagConstraints();
		gbcLNazivPredmeta.gridx = 0;
		gbcLNazivPredmeta.gridy = 1;
		gbcLNazivPredmeta.insets = new Insets(20, 0, 0, 0);
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
		gbLblSemestar.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(semestarL, gbLblSemestar);
		
		GridBagConstraints gbCBSemestar= new GridBagConstraints();
		gbCBSemestar.gridx = 1;
		gbCBSemestar.gridy = 2;
		gbCBSemestar.insets = new Insets(20, 0, 0, 0);
		unosPanel.add(semestarCB, gbCBSemestar);
		
		
		//unosPanel.add(godinaL);
		//unosPanel.add(profL);
 		unosPredmeta.add(unosPanel);
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
