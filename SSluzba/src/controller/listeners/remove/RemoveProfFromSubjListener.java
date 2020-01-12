package controller.listeners.remove;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import view.PredmetiJTable;

public class RemoveProfFromSubjListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try{
			int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da profesora sa predmeta?","Brisanje profesora sa predmeta?",JOptionPane.YES_NO_OPTION);
			
			if(option == JOptionPane.YES_OPTION) {
				Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().getSelektovanRed()));
				if(sub.getPredavac().equals("")) {
					JOptionPane.showMessageDialog(null, "Predmet nema profesora, nemoguce obrisati profesora!","",JOptionPane.ERROR_MESSAGE);
				}else {
				String brojLicneKarte=BazaPredmeta.getInstanceBazaPredmeta().returnBlkFromPredavac(sub);
				System.out.println(brojLicneKarte);

				PredmetController.getInstance().removeProfFromSubj(brojLicneKarte, sub);
				}
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Nije selektovan predmet!","",JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
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
