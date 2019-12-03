package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
//lupetanje nes ne valja ovako
public class FocusListenerPredmetNaziv implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
		
		if(txt.getName().equals("txtNaziv")) {
			if(txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite naziv...")) {
				txt.setText("Unesite naziv...");
				txt.requestFocus();
				txt.setForeground(Color.RED);
			}else {
				txt.setForeground(Color.BLACK);
			}
		}
	}

}
