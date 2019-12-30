package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;

public class AddProfToSubjFrame extends JFrame{

	public AddProfToSubjFrame() {
		try {
			setLocation(800, 300);
			setSize(500, 150);
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

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//dodati metodu koja dodaje u listu predmeta na profesoru
					
					String stariProf=BazaPredmeta.getInstanceBazaPredmeta().returnBlkFromPredavac(predmet);
					String noviProf=blk.getText();

					PredmetController.getInstance().changeProf(stariProf,noviProf,predmet);
					setVisible(false);
				}
			});
			
			
			setVisible(true);
		}catch(Exception e) {
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
