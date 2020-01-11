package controller.listeners.add;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.AddProfFrame;
import view.AddStudentFrame;
import view.AddSubjFrame;
import view.TabbedPane;

public class AddSubjListener implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex()==2) {
			AddSubjFrame diag = new AddSubjFrame();
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
