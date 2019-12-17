package controller;

import javax.swing.JFrame;

import model.BazaStudenata;
import model.StatusStudent;
import view.TabbedPane;

public class StudentiController {
private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	private StudentiController() {}

	public void addStudent(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,StatusStudent status,double prosecnaO) {//TODO: preraditi metodu da dodaje entitete
		//JFrame unosStudenata = new JFrame();
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datumR, adresaS, kontaktT, email, brI, datumU, trenutnaG, status, prosecnaO);
		TabbedPane.getInstance().azurirajStudentiO();
		//unosStudenata.setVisible(true);
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
