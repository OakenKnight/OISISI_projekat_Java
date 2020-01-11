package controller.listeners.remove;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
			
			try {
				int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje predmeta?",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION) {
					Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().getSelektovanRed()));
					String sifra=sub.getSifra_predmeta();
					String naziv=sub.getNaziv();
					String semestar=sub.getSemestar();
					String godina=sub.getGodina();
					String profesor=sub.getPredavac();
				
				PredmetController.getInstance().removePredmet(sifra,naziv,semestar,godina,profesor);
				
				}
			}catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Nije selektovan predmet!","",JOptionPane.ERROR_MESSAGE);

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
