package controller.listeners.edit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.EditProfFrame;
import view.EditStudFrame;
import view.TabbedPane;

public class EditProfListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(TabbedPane.getInstance().getSelectedIndex()==1) {
				EditProfFrame diag = new EditProfFrame();			
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
