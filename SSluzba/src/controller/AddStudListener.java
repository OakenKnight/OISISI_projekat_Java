package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.AddDialog;

public class AddStudListener implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		AddDialog diag = new AddDialog();
		diag.setVisible(true);
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
