package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

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
		GridBagLayout gb = new GridBagLayout();
		//GridLayout experimentLayout = new GridLayout(0,2);

		JPanel unosPanel=new JPanel(gb);
		
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
		//JTextField spTF = new JTextField(10);
		JLabel godinaL=new JLabel("Godina");
		//JTextField spTF = new JTextField(10);
		JLabel profL=new JLabel("Profesor");
		//JTextField spTF = new JTextField(10);
		//JLabel spL=new JLabel("Sifra predmeta");
		//JTextField spTF = new JTextField(10);
		//unosPredmeta.getContentPane().setLayout(new FlowLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.insets.top=5;
		c.insets.bottom=5;
		c.insets.left=5;
		c.insets.right=5;
		unosPanel.add(spL,c);
		c.gridx=1;
		c.gridy=0;
		c.gridwidth=4;
		c.gridheight=1;
		unosPanel.add(spTF,c);
		
		//unosPredmeta.getContentPane().setLayout(new FlowLayout());

		unosPanel.add(npL);
		unosPanel.add(npTF);
		unosPanel.add(semestarL);
		unosPanel.add(godinaL);
		unosPanel.add(profL);
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
