package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Menu extends JMenuBar{
	
	
	public Menu() {
		//Pravljenje  File menija i pravljenje i dodavanje itema
		JMenu file = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New          Ctrl+N",new ImageIcon("images/plus.png"));
		JMenuItem closeItem = new JMenuItem("Close          Ctel+C",new ImageIcon("images/x.png"));
		file.add(newItem);
		file.addSeparator();
		file.add(closeItem);
		//Pravljenje  Edit menija i pravljenje i dodavanje itema
		JMenu edit = new JMenu("Edit");
		JMenuItem editItem = new JMenuItem("Edit");
		JMenuItem deleteItem = new JMenuItem("Delete");
		edit.add(editItem);
		edit.addSeparator();
		edit.add(deleteItem);
		//Pravljenje  Help menija i pravljenje i dodavanje itema
		JMenu help = new JMenu("Help");
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		help.add(helpItem);
		help.addSeparator();
		help.add(aboutItem);
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}
