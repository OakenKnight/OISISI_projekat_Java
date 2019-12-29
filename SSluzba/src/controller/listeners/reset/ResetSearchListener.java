package controller.listeners.reset;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.PredmetController;
import controller.ProfesorController;
import view.TabbedPane;
import view.Toolbar;

public class ResetSearchListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(TabbedPane.getInstance().getSelectedIndex()==2) {
			PredmetController.getInstance().resetSearch();
		}else if(TabbedPane.getInstance().getSelectedIndex()==1) {
			ProfesorController.getInstance().resetSearch();
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
