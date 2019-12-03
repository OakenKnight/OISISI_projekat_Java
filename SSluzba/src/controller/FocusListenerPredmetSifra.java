package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
//lupetanje nes ne valja ovako
public class FocusListenerPredmetSifra implements FocusListener{

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
		
		if(txt.getName().equals("txtSifra")) {
			if(txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite sifru...")) {
				txt.setText("Unesite sifru...");
				txt.requestFocus();
				txt.setForeground(Color.RED);
			}else {
				txt.setForeground(Color.BLACK);
			}
		}
	}

}
