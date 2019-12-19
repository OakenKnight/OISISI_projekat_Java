package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BazaPredmeta;
import view.AddSubjFrame;
import view.EditProfFrame;
import view.EditSubjFrame;
import view.TabbedPane;
import view.AddProfFrame;


public class EntityController {
	
	private static EntityController instance = null;
	
	public static EntityController getInstance() {
		if (instance == null) {
			instance = new EntityController();
		}
		return instance;
	}
	private EntityController() {}

	public void addEntity() {
		//TODO: ovo je samo neka ideja za taj iskacuci meni za predmete
		if(TabbedPane.getInstance().getSelectedIndex()==1) {
			AddProfFrame apf=new AddProfFrame();
		}else if(TabbedPane.getInstance().getSelectedIndex()==2) {
			AddSubjFrame asf=new AddSubjFrame();
		}
	}
	public void editEntity() {
		//TODO: preraditi metodu da menja entitete
	}
	public void removeEntity() {
		//TODO: preraditi metodu da brise entitete
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
