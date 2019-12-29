package controller.listeners.remove;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import controller.ProfesorController;
import model.BazaProfesori;
import model.Profesor;
import view.ProfesoriJTable;
import view.TabbedPane;

public class RemoveProfListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(TabbedPane.getInstance().getSelectedIndex()==1) {
			try {
			int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje profesora?",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION) {
				Profesor prof =new Profesor(BazaProfesori.getInstance().getRow(ProfesoriJTable.getInstance().selektovanRed));
				
				String ime=prof.getIme();
				String prezime=prof.getPrezime();
				LocalDate datum=prof.getDatumRodjenja();
				String adresa=prof.getAdresaStanovanja();
				String telefon=prof.getKontaktTel();
				String email=prof.getEmail();
				String kancelarija=prof.getAdresa_kancelarije();
				String blk=prof.getBLK();
				String titula=prof.getTitula();
				String zvanje=prof.getZvanje();
				
				ProfesorController.getInstance().removeProfesor(ime, prezime, datum, adresa, telefon, email, kancelarija, blk, titula, zvanje);
				
				}
			}catch (Exception e) {

			System.out.println(e.getMessage());
			}
		}
	}		
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
