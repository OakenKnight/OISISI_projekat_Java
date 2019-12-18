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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FocusPredmeti;
import controller.PredmetController;

public class AddSubjFrame extends JFrame{
	public static JTextField spTF;
	public static JTextField npTF;
	public static String semestar;
	public static JTextField profesorTF;
	private static int brojac;
	public AddSubjFrame() {
		

		JFrame unosPredmeta=new JFrame();
		
		JPanel unosPanel=new JPanel();
		unosPanel.setLayout(new GridBagLayout());
	
		unosPredmeta.setTitle("Dodavanje predmeta");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		unosPredmeta.setSize(2*screenWidth/7,3*screenHeight/10);
		unosPredmeta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		unosPredmeta.setLocationRelativeTo(null);
		
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		FocusPredmeti fokus=new FocusPredmeti();

		
		
		JLabel spL=new JLabel("Sifra predmeta: *");
		spTF = new JTextField(10);
		spTF.setName("txt");
		//spTF.addFocusListener(focusListener1);		
		spTF.addFocusListener(fokus);

		
		JLabel npL=new JLabel("Naziv predmeta: *");
		npTF = new JTextField(30);
		npTF.setName("txt");
		npTF.addFocusListener(fokus);

		//npTF.addFocusListener(focusListener2);
	
		
		JLabel semestarL=new JLabel("Semestar: *");
		String[] semestri= {"I (Prvi)","II (Drugi)","III (Treci)","IV (Cetvrti)","V (Peti)","VI (Sesti)","VII (Sedmi)","VIII (Osmi)"};
		JComboBox semestarCB=new JComboBox(semestri);
		semestar=(String)semestarCB.getSelectedItem();
		
		
		JLabel godinaL=new JLabel("Godina: *");
		String[] godine= {"Prva","Druga","Treca","Cetvrta"};
		JComboBox godineCB=new JComboBox(godine);
		String godina=(String)godineCB.getSelectedItem();
		String god=godina + " godina";
		
		
		JLabel profesorL=new JLabel("Profesor: *");
		profesorTF=new JTextField(30);
		profesorTF.setName("txt");
		profesorTF.addFocusListener(fokus);
		
		JButton okBtn=new JButton("Ok");
		okBtn.setToolTipText("Potvrdi");
		okBtn.addActionListener(new ActionListener() {
		String sifraReg="[a-zA-Z0-9]";
		String regex1="[a-zA-Z ]+[0-9]";
		String regex2="[a-zA-Z ]+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(spTF.getText().equals("") || npTF.getText().equals("") || profesorTF.getText().equals("")) {
				  JOptionPane.showMessageDialog(null,"Nisu unesena sva polja","",JOptionPane.ERROR_MESSAGE);	 
				}else if(spTF.getText().matches(sifraReg)) {
					JOptionPane.showMessageDialog(null,"Nije uneta dobro sifra predmeta","",JOptionPane.ERROR_MESSAGE);
					
				} else if(npTF.getText().matches(regex1)==false) {
					JOptionPane.showMessageDialog(null,"Nije uneto dobro ime predmeta","",JOptionPane.ERROR_MESSAGE);
				}else if(profesorTF.getText().matches(regex2)==false){
					JOptionPane.showMessageDialog(null,"Nije uneto dobro ime profesora","",JOptionPane.ERROR_MESSAGE);
				}else {
					BufferedWriter out  = null;
					try {
						out = new BufferedWriter( new FileWriter("datoteke/Predmeti.txt",true));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						out.write("\n");
						out.write(spTF.getText()+"|"+npTF.getText()+"|"+profesorTF.getText()+"|"+semestar+"|"+godina+"|"+profesorTF.getText()+"|");

					} catch (IOException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(out != null)
							try {
								out.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					
					
					PredmetController.getInstance().addPredmet(spTF.getText(),npTF.getText(),semestar,god,profesorTF.getText());
					
					unosPredmeta.setVisible(false);
					
					
					//unosPredmeta.dispose();
				}
				
			}
		});
		JButton cancelBtn=new JButton("Cancel");
		cancelBtn.setToolTipText("Odustani");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO ugasi taj window
				unosPredmeta.setVisible(false);
				unosPredmeta.dispose();
				
			}
		});
		
		
		
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

		
			unosPredmeta.add(unosPanel,BorderLayout.CENTER);
			unosPredmeta.add(donjiPanel,BorderLayout.SOUTH);
		
		//unosPredmeta.add(Box.createGlue());
		unosPredmeta.setVisible(true);
	}
}
