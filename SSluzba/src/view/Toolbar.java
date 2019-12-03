package view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.AddStudListener;
import controller.EntityController;

public class Toolbar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204353317907193077L;

	public Toolbar(){
		
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		
		JButton btnNewEntity= new JButton();
		btnNewEntity.setToolTipText("Make new...");
		btnNewEntity.setIcon(new ImageIcon("images/user1.png"));
		add(btnNewEntity);
		btnNewEntity.addMouseListener(new AddStudListener());
		btnNewEntity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EntityController.getInstance().addEntity();

			}
		});
		
		JButton btnEditEntity= new JButton();
		btnEditEntity.setToolTipText("Edit...");
		btnEditEntity.setIcon(new ImageIcon("images/pencil1.png"));
		add(btnEditEntity);
		btnEditEntity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EntityController.getInstance().editEntity();
				
			}
		});
		
		//addSeparator();

		JButton btnDeleteEntity= new JButton();
		btnDeleteEntity.setToolTipText("Edit...");
		btnDeleteEntity.setIcon(new ImageIcon("images/bin1.png"));
		add(btnDeleteEntity);
		btnDeleteEntity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EntityController.getInstance().removeEntity();

			}
		});
		
		//addSeparator();

		
		JTextField searchEntityTextField=new JTextField(50);
		//Dimension dim= new Dimension(30,20);
		searchEntityTextField.setPreferredSize(new Dimension(90,25));
		searchEntityTextField.setMaximumSize(searchEntityTextField.getPreferredSize());
		searchEntityTextField.setToolTipText("Enter name...");
		add(Box.createHorizontalGlue());
		add(searchEntityTextField);
		
		//addSeparator();

		JButton btnSearchEntity= new JButton();
		btnSearchEntity.setToolTipText("Edit...");
		btnSearchEntity.setIcon(new ImageIcon("images/search1.png"));
		add(btnSearchEntity);
		btnSearchEntity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EntityController.getInstance().searchEntity();

			}
		});
		
	}
}
