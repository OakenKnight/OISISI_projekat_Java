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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FocusPredmeti;
import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;
import model.Student;

public class EditSubjFrame extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5868601545868734820L;
	private static JTextField spTF;
	private static JTextField npTF;
	private static String semestar;
	private static JTextField profesorTF;
	private static String godina;
	private static String proff;
	private static String subjPreIzmene;
	private static ArrayList<Student> stNaPredmetu;
	
	public EditSubjFrame() {
		try {	
			setModal(true);
			JPanel unosPanel=new JPanel();
			unosPanel.setLayout(new GridBagLayout());
		
			setTitle("Izmena predmeta");
			
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize=kit.getScreenSize();
			int screenHeight=screenSize.height;
			int screenWidth=screenSize.width;
			
			if(3*screenHeight/7 < 320 || 2*screenWidth/10 < 545){
				setSize(550,324);
			}else {
				setSize(2*screenWidth/7,3*screenHeight/10);
			}
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			
			
			JPanel donjiPanel = new JPanel(new FlowLayout());
			donjiPanel.setBackground(Color.DARK_GRAY);
			donjiPanel.setPreferredSize(new Dimension(100,23));
			
			FocusPredmeti fokus=new FocusPredmeti();
	
			
			
			JLabel spL=new JLabel("Sifra predmeta: *");
			spTF = new JTextField(10);
			spTF.setName("txt");
			spTF.setEditable(false);		
			spTF.addFocusListener(fokus);

			JLabel npL=new JLabel("Naziv predmeta: *");
			npTF = new JTextField(30);
			npTF.setName("txt");
			npTF.addFocusListener(fokus);
			npTF.setToolTipText("npr. Naziv nekog predmeta");
			
			JLabel semestarL=new JLabel("Semestar: *");
			String[] semestri= {"Letnji","Zimski"};
			JComboBox semestarCB=new JComboBox(semestri);
		
		
			JLabel godinaL=new JLabel("Godina: *");
			String[] godine= {"Prva","Druga","Treca","Cetvrta"};
			JComboBox godineCB=new JComboBox(godine);
		
		/*
			JLabel profesorL=new JLabel("Profesor(BLK): ");
			profesorTF=new JTextField(30);
			profesorTF.setName("txt");
			//profesorTF.addFocusListener(fokus);
			*/
			
			Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().getSelektovanRed()));
			
			//String prof=BazaProfesori.getInstance().getProfHavingSubj(sub).getBLK();

			spTF.setText(sub.getSifra_predmeta());
			npTF.setText(sub.getNaziv());
			semestar=sub.getSemestar();
			godina=sub.getGodina()+" godina";
			stNaPredmetu = sub.getBrIndeksaStudenata();
			
		
		
			JButton okBtn=new JButton("Ok");
			okBtn.setToolTipText("Potvrdi");
			okBtn.addActionListener(new ActionListener() {

			String regex1="[a-žA-Ž ]*[0-9]*";
			String blkReg="[0-9]+";
			
			
			
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(spTF.getText().equals("") || npTF.getText().equals("")) {
					  JOptionPane.showMessageDialog(null,"Nisu unesena sva polja","",JOptionPane.ERROR_MESSAGE);	 
					}else if(npTF.getText().matches(regex1)==false) {
						JOptionPane.showMessageDialog(null,"Nije unet dobro naziv predmeta","",JOptionPane.ERROR_MESSAGE);
					}else {
						
						semestar=(String)semestarCB.getSelectedItem();
						godina=(String)godineCB.getSelectedItem()+" godina";
						

						
						System.out.println(proff);
						PredmetController.getInstance().editPredmet(spTF.getText(),npTF.getText(),semestar,godina,stNaPredmetu);
						setVisible(false);
							
							
						dispose();
					}

					
				}
			});
		
			
			
			JButton cancelBtn=new JButton("Cancel");
			cancelBtn.setToolTipText("Odustani");
			cancelBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO ugasi taj window
					setVisible(false);
					dispose();
					
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
			/*
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
			*/
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
	
			
			add(unosPanel,BorderLayout.CENTER);
			add(donjiPanel,BorderLayout.SOUTH);
			
			//unosPredmeta.add(Box.createGlue());
			setVisible(true);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nije selektovan predmet!","",JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
		}
		
			
	}
}

