package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;

public class AddProfToSubjFrame extends JDialog{

	public AddProfToSubjFrame() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize=kit.getScreenSize();
			int screenHeight=screenSize.height;
			int screenWidth=screenSize.width;
			setModal(true);
			
			if(3*screenHeight/7 < 160 || 2*screenWidth/10 < 545){
				setSize(550,162);
			}else {
				setSize(2*screenWidth/7,3*screenHeight/20);
			}
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			setTitle("Dodavanje profesora na predmet");
			
			JPanel dodajProfuPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel dodajProf=new JLabel("Unesite broj licne karte profesora");
			JTextField blk=new JTextField(20);
			dodajProfuPanel.add(dodajProf);
			dodajProfuPanel.add(blk);
			
			JPanel donjiPanel = new JPanel(new FlowLayout());
			donjiPanel.setBackground(Color.DARK_GRAY);
			donjiPanel.setPreferredSize(new Dimension(100,23));
			
			add(dodajProfuPanel,BorderLayout.NORTH);
			
			Predmet predmet=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
			//sad treba ovde na osnovu neke metode da se dobavi blk od profesora, al ne ide zbog toga sto nemam ostalo, msm mogu na osnovu imena, al ne ide to tako bas
			String brojLicneKarte=BazaPredmeta.getInstanceBazaPredmeta().returnBlkFromPredavac(predmet);
			
			blk.setText(brojLicneKarte);
			
			JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JButton odustanak = new JButton("Odustanak");
			JButton potvrda = new JButton("Potvrda");
			odustanakPotvrda.add(odustanak);
			odustanakPotvrda.add(potvrda);
			add(odustanakPotvrda,BorderLayout.CENTER);
			add(donjiPanel,BorderLayout.SOUTH);
			odustanak.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					dispose();

				}
			});
			potvrda.addActionListener(new ActionListener() {
				String blkReg="[0-9]+";

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//dodati metodu koja dodaje u listu predmeta na profesoru
					if(!blk.getText().isEmpty()) {
						if(!blk.getText().matches(blkReg)) {
							JOptionPane.showMessageDialog(null,"Nije unet dobro blk profesora","",JOptionPane.ERROR_MESSAGE);
						}else {
							String stariProf=BazaPredmeta.getInstanceBazaPredmeta().returnBlkFromPredavac(predmet);
							String noviProf=blk.getText();

							PredmetController.getInstance().changeProf(stariProf,noviProf,predmet);
							setVisible(false);
						}
						

					}else {
						JOptionPane.showMessageDialog(null,"Nije uneto nista!","",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			
			setVisible(true);
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Nije selektovan predmet!","",JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
		}
	}
	
	public boolean proveriPostojanje(String blk) {
		ArrayList<Profesor> profesori=BazaProfesori.getInstance().getSviProfesori();
		
		for (Profesor profesor : profesori) {
			if(profesor.getBLK().equals(blk)) {
				return true;
			}
		}
		return false;
	}
}
