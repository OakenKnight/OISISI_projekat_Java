package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaPredmeta;
import model.BazaProfesori;
import model.BazaStudenata;

public class WindowListeners implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		JFrame frame=(JFrame) arg0.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Are you sure?");
		if(code!=JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}else {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			DataController.getInstance().saveDataSubj(BazaPredmeta.getInstanceBazaPredmeta().getSviPredmeti());
			DataController.getInstance().saveDataProf(BazaProfesori.getInstance().getSviProfesori());
			DataController.getInstance().saveDataStud(BazaStudenata.getInstance().getSviStudenti());
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
