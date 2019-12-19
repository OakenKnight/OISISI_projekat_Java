package view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.AddProfToSubjListener;
import controller.AddStudListener;
import controller.AddStudentToSubjListener;
import controller.EditProfListener;
import controller.EditStudListener;
import controller.EditSubjListener;
//import controller.AddProfToSubjListener;
import controller.AddStudListener;
import controller.AddStudentToSubjListener;
//import controller.AddStudentToSubjListener;
import controller.EntityController;
//import controller.RemoveProfListener;

public class Toolbar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204353317907193077L;

	private static Toolbar instance = null;
	private JButton btnNewStudentToSubject;
	private JButton btnNewProfToSubject;
	public static Toolbar getInstance() {
		if (instance == null) {
			instance = new Toolbar();
		}
		return instance;
	}
	private Toolbar(){
		
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		
		JButton btnNewEntity= new JButton();
		btnNewEntity.setToolTipText("Make new...");
		btnNewEntity.setIcon(new ImageIcon("images/user1.png"));
		add(btnNewEntity);

		btnNewEntity.addMouseListener(new AddStudListener());

		//btnNewEntity.setVisible(false);

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
		btnEditEntity.addMouseListener(new EditStudListener());
		btnEditEntity.addMouseListener(new EditProfListener());
		btnEditEntity.addMouseListener(new EditSubjListener());

		btnEditEntity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//EntityController.getInstance().editEntity();
				
			}
		});
		
		//addSeparator();

		JButton btnDeleteEntity= new JButton();
		btnDeleteEntity.setToolTipText("Edit...");
		btnDeleteEntity.setIcon(new ImageIcon("images/bin1.png"));
		add(btnDeleteEntity);
	//	btnDeleteEntity.addMouseListener(new RemoveProfListener());

		/*btnDeleteEntity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EntityController.getInstance().removeEntity();

			}
		});
		*/
		//addSeparator();
		btnNewStudentToSubject= new JButton();
		btnNewStudentToSubject.setToolTipText("Make new...");
		btnNewStudentToSubject.setIcon(new ImageIcon("images/user1.png"));
		add(btnNewStudentToSubject);

		btnNewStudentToSubject.setVisible(false);
		//?????????????????????????????????????????????
		//zasto fakin copy paste ne radi????????????
	//	btnNewStudentToSubject.addMouseListener(new AddStudentToSubjListener());

		btnNewStudentToSubject.addMouseListener(new AddStudentToSubjListener());


		
		btnNewProfToSubject= new JButton();
		btnNewProfToSubject.setToolTipText("Make new...");
		btnNewProfToSubject.setIcon(new ImageIcon("images/add-user-1.png"));
		add(btnNewProfToSubject);
		
		btnNewProfToSubject.setVisible(false);
	//	btnNewProfToSubject.addMouseListener(new AddProfToSubjListener());
		btnNewProfToSubject.addMouseListener(new AddProfToSubjListener());

		
		
		
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
	public void setBtnNewStudentToSubject(boolean b) {
		this.btnNewStudentToSubject.setVisible(b);
	}
	public void setBtnNewProfToSubject(boolean b) {
		this.btnNewProfToSubject.setVisible(b);
	}
}
