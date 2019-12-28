package controller.listeners.add;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfToSubjListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JFrame dodajProfu=new JFrame();
		dodajProfu.setLocation(800, 300);
		dodajProfu.setSize(500, 100);
		dodajProfu.setTitle("Dodavanje profesora na predmet");
		
		JPanel dodajProfuPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel dodajProf=new JLabel("Unesite broj licne karte profesora");
		JTextField blk=new JTextField(20);
		dodajProfuPanel.add(dodajProf);
		dodajProfuPanel.add(blk);
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		dodajProfu.add(dodajProfuPanel,BorderLayout.CENTER);
		dodajProfu.add(donjiPanel,BorderLayout.SOUTH);
		
		dodajProfu.setVisible(true);
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
