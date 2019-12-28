package view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.StudentiController;
import controller.listeners.add.AddProfListener;
import controller.listeners.add.AddProfToSubjListener;
import controller.listeners.add.AddStudListener;
import controller.listeners.add.AddStudentToSubjListener;
import controller.listeners.add.AddSubjListener;
import controller.listeners.edit.EditProfListener;
import controller.listeners.edit.EditStudListener;
import controller.listeners.edit.EditSubjListener;
import controller.listeners.remove.RemoveProfListener;
import controller.listeners.remove.RemoveStudListener;
import controller.listeners.remove.RemoveSubjListener;
import model.BazaStudenata;
//import controller.RemoveProfListener;

public class Toolbar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204353317907193077L;

	private static Toolbar instance = null;
	private JButton btnNewStudentToSubject;
	private JButton btnNewProfToSubject;
	private JTextField search;
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
		btnNewEntity.addMouseListener(new AddProfListener());
		btnNewEntity.addMouseListener(new AddSubjListener());
		
		
		JButton btnEditEntity= new JButton();
		btnEditEntity.setToolTipText("Edit...");
		btnEditEntity.setIcon(new ImageIcon("images/pencil1.png"));
		add(btnEditEntity);
		btnEditEntity.addMouseListener(new EditStudListener());
		btnEditEntity.addMouseListener(new EditProfListener());
		btnEditEntity.addMouseListener(new EditSubjListener());
		
		//addSeparator();

		JButton btnDeleteEntity= new JButton();
		btnDeleteEntity.setToolTipText("Delete...");
		btnDeleteEntity.setIcon(new ImageIcon("images/bin1.png"));
		add(btnDeleteEntity);
		btnDeleteEntity.addMouseListener(new RemoveSubjListener());
		btnDeleteEntity.addMouseListener(new RemoveProfListener());
		btnDeleteEntity.addMouseListener(new RemoveStudListener());
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

		
		
		
		search=new JTextField(50);
		//Dimension dim= new Dimension(30,20);
		
		//ovo bas ne radi kako treba
		if(TabbedPane.getInstance().getSelectedIndex()==0)
			search.setToolTipText("ime:______|prezime:______|indeks:_______");
		else if(TabbedPane.getInstance().getSelectedIndex()==1)
			search.setToolTipText("ime:______|prezime:______|brojLicneKarte:_______");
		else
			search.setToolTipText("sifra:______|naziv:______");
		
		search.setPreferredSize(new Dimension(90,25));
		search.setMaximumSize(search.getPreferredSize());
		add(Box.createHorizontalGlue());
		add(search);
		
		//addSeparator();

		JButton btnSearchEntity= new JButton();
		btnSearchEntity.setToolTipText("Search...");
		btnSearchEntity.setIcon(new ImageIcon("images/search1.png"));
		add(btnSearchEntity);
		
		
	}
	public void setBtnNewStudentToSubject(boolean b) {
		this.btnNewStudentToSubject.setVisible(b);
	}
	public void setBtnNewProfToSubject(boolean b) {
		this.btnNewProfToSubject.setVisible(b);
	}
	public void setTooltipForSearchStud() {
		this.search.setToolTipText("ime:______|prezime:______|indeks:_______");
	}
	public void setTooltipForSearchProf() {
		this.search.setToolTipText("ime:______|prezime:______|blk:_______");
	}
	public void setTooltipForSearchSubj() {
		this.search.setToolTipText("sifra:______|naziv:______");
	}
}
