package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.WindowListeners;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8456560429229699542L;

	public MainFrame() {
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		setSize(3*screenWidth/4,3*screenHeight/4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowListeners());
		
		//Ubacivanje menija
		Menu menu = new Menu();
		this.setJMenuBar(menu);
		
		Toolbar toolbar=Toolbar.getInstance();
		add(toolbar,BorderLayout.NORTH);
		
		//Pravljenje STATUS BARA
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel labela = new JLabel("Studentska sluzba");
		labela.setPreferredSize(new Dimension(151,20));
		LocalDate currentDate = LocalDate.now();
		JLabel date = new JLabel(currentDate.toString());
		date.setPreferredSize(new Dimension(81,20));
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss"); //Pravljenje formata za vreme
		JLabel time = new JLabel(LocalTime.now().format(timeFormat));
		time.setPreferredSize(new Dimension(65,20));
		//Dodavanje komponenti u status bar
		panel.add(date,FlowLayout.LEFT);
		panel.add(time,FlowLayout.LEFT);
		panel.add(Box.createHorizontalStrut(1120),FlowLayout.LEFT);
		panel.add(labela,FlowLayout.LEFT);
		
		
		
	//	add(panel,BorderLayout.SOUTH);
		
		//TabbedPane tabs=new TabbedPane();
		TabbedPane tabs = TabbedPane.getInstance();
		add(tabs, BorderLayout.CENTER);
				
		TabbedPane.getInstance().addChangeListener(new ChangeListener() {
			
			 public void stateChanged(ChangeEvent changeEvent) {
				    //JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				    int state = TabbedPane.getInstance().getSelectedIndex();
				    System.out.println(state);
				    if(state==2) {
				    	Toolbar.getInstance().setBtnNewStudentToSubject(true);
				    	Toolbar.getInstance().setBtnNewProfToSubject(true);
				    	Toolbar.getInstance().setTooltipForSearchSubj();
				    }else {
				    	Toolbar.getInstance().setBtnNewStudentToSubject(false);
				    	Toolbar.getInstance().setBtnNewProfToSubject(false);
				    	
				    	if(TabbedPane.getInstance().getSelectedIndex()==1) {
					    	Toolbar.getInstance().setTooltipForSearchProf();
				    	}else if(TabbedPane.getInstance().getSelectedIndex()==0) {
					    	Toolbar.getInstance().setTooltipForSearchStud();

				    	}
				    
				    }
			 }
		});

	}
	
}
