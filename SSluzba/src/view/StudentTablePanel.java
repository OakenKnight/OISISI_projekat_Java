package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class StudentTablePanel extends JPanel{
	
	public StudentTablePanel() {
		setLayout(new BorderLayout());
	}
	
	public StudentTablePanel(Component c) {
		this();
		add(c,BorderLayout.CENTER);
	}
	
}
