package controller;

import java.time.LocalDate;

import javax.swing.JFrame;

import model.BazaProfesori;
import model.BazaStudenata;
import model.StatusStudent;
import model.Student;
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

	public void addStudent(String ime,String prezime,LocalDate datumR,String adresaS,String kontaktT,String email,String brI,LocalDate datumU,int trenutnaG,StatusStudent status,double prosecnaO) {//TODO: preraditi metodu da dodaje entitete
		//JFrame unosStudenata = new JFrame();
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datumR, adresaS, kontaktT, email, brI, datumU, trenutnaG, status, prosecnaO);
		TabbedPane.getInstance().azurirajStudentiO();
		//unosStudenata.setVisible(true);
	}
	public void editStudent(String ime,String prezime,LocalDate datumR,String adresaS,String kontaktT,String email,String brI,LocalDate datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
		BazaStudenata.getInstance().izmeniStudenta(ime, prezime, datumR, adresaS, kontaktT, email, brI, datumU, trenutnaG, status, prosecnaO);
		TabbedPane.getInstance().azurirajStudentiO();
	}
	public void removeStudent(int rowSelectedIndex) {
		System.out.println(rowSelectedIndex);
		Student std = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(std.getBrIndex());
		TabbedPane.getInstance().azurirajStudentiO();

		
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
