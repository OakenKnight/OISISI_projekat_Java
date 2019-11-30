package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PredmetiTablePanel extends JTable{
	private JPanel leftPanel=new JPanel();
	private JPanel rightPanel=new JPanel();
	
	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		add(leftPanel,BorderLayout.WEST);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		add(rightPanel,BorderLayout.EAST);
		rightPanel.setBackground(Color.LIGHT_GRAY);
	}
	public PredmetiTablePanel(Component c, int leftGap, int rightGap) {
		this();
		leftPanel.setPreferredSize(new Dimension(leftGap,leftGap));
		rightPanel.setPreferredSize(new Dimension(rightGap,rightGap));
		add(c,BorderLayout.CENTER);
	}
	
	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		if(leftPanel==null || rightPanel==null)
			return;
		leftPanel.setBackground(bg);
		rightPanel.setBackground(bg);
	}
}
