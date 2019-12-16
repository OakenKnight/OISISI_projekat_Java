package controller;

import javax.swing.JFrame;

public class StudentiController {
private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	private StudentiController() {}

	public void addStudent() {
		//TODO: preraditi metodu da dodaje entitete
		JFrame unosStudenata = new JFrame();
		
		unosStudenata.setVisible(true);
	}
	public void editStudent() {
		//TODO: preraditi metodu da menja entitete
	}
	public void removeStudent() {
		//TODO: preraditi metodu da brise entitete
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
