package controller.listeners.edit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import view.EditStudFrame;
import view.TabbedPane;

public class EditStudListener implements MouseListener{
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex()==0) {
			EditStudFrame diag = new EditStudFrame();
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
