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

import javax.swing.JOptionPane;

import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import view.PredmetiJTable;
import view.TabbedPane;

public class RemoveSubjListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex()==2) {
			/*RemoveSubjectFrame rm=new RemoveSubjectFrame();
			rm.setVisible(true);
			*/
			int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje predmeta?",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION) {
				Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
				String sifra=sub.getSifra_predmeta();
				String naziv=sub.getNaziv();
				String semestar=sub.getSemestar();
				String godina=sub.getGodina();
				String profesor=sub.getPredavac();
				//String subjPreIzmene=sifra+"|"+naziv+"|"+semestar+"|"+godina+"|"+profesor;
				/*
				String sledeci;
				String sve="";
				
				BufferedReader in=null;
				
				try {
					in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Predmeti.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while((sledeci = in.readLine()) != null) {
						sledeci.trim();
						if(sledeci.equals(subjPreIzmene)) {
							continue;
						}
						sve += sledeci+"\n";
					}
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter out  = null;
				try {
					out = new BufferedWriter( new FileWriter("datoteke/Predmeti.txt"));
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
				*/
				PredmetController.getInstance().removePredmet(sifra,naziv,semestar,godina,profesor);
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
