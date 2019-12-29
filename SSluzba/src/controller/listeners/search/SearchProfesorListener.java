package controller.listeners.search;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.ProfesorController;
import view.ProfesoriJTable;
import view.TabbedPane;
import view.Toolbar;

public class SearchProfesorListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(TabbedPane.getInstance().getSelectedIndex()==1) {
			ProfesorController.getInstance().searchEntity(Toolbar.getInstance().getSearchText());
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
