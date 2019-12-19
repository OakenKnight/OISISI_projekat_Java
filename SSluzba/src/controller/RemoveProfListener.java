package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import model.BazaProfesori;
import model.Profesor;
import view.ProfesoriJTable;
import view.TabbedPane;

public class RemoveProfListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(TabbedPane.getInstance().getSelectedIndex()==1) {
			int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje profesora?",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION) {
				Profesor prof =new Profesor(BazaProfesori.getInstance().getRow(ProfesoriJTable.getInstance().selektovanRed));
				
				String ime=prof.getIme();
				String prezime=prof.getPrezime();
				String datum=prof.getDatum();
				String adresa=prof.getAdresa_stanovanja();
				String telefon=prof.getKontakt_telefon();
				String email=prof.getEmail_adresa();
				String kancelarija=prof.getAdresa_kancelarije();
				String blk=prof.getBLK();
				String titula=prof.getTitula();
				String zvanje=prof.getZvanje();
				String profPreIzmene =ime+"|"+prezime+"|"+datum+"|"+adresa+"|"+ telefon+"|"+ email+"|"+ kancelarija+"|"+ blk+"|"+ titula+"|"+ zvanje;
				
				String sledeci;
				String sve="";
				
				BufferedReader in=null;
				
				try {
					in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Profesori.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while((sledeci = in.readLine()) != null) {
						sledeci.trim();
						if(sledeci.equals(profPreIzmene)) {
							continue;
						}
						sve += sledeci+"\n";
					}
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter out = null;
				try {
					out = new BufferedWriter( new FileWriter("datoteke/Profesori.txt"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					out.write(sve);

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
				ProfesorController.getInstance().removeProfesor(ime, prezime, datum, adresa, telefon, email, kancelarija, blk, titula, zvanje);
				
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
