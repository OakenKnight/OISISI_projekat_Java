package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudentToSubjListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
				JFrame dodajStudenta=new JFrame();
				dodajStudenta.setLocation(800, 300);
				dodajStudenta.setSize(500, 100);
				dodajStudenta.setTitle("Dodavanje studenta na predmet");
				
				JPanel dodajStudentaPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel dodajStudentaL=new JLabel("Unesite broj indeksa studenta");
				JTextField indeks=new JTextField(20);
				dodajStudentaPanel.add(dodajStudentaL);
				dodajStudentaPanel.add(indeks);
				
				JPanel donjiPanel = new JPanel(new FlowLayout());
				donjiPanel.setBackground(Color.DARK_GRAY);
				donjiPanel.setPreferredSize(new Dimension(100,23));
				
				dodajStudenta.add(dodajStudentaPanel,BorderLayout.CENTER);
				dodajStudenta.add(donjiPanel,BorderLayout.SOUTH);
				
				dodajStudenta.setVisible(true);		
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
