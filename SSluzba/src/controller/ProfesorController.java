package controller;

import javax.swing.JFrame;

import model.BazaPredmeta;
import model.BazaProfesori;
import model.BazaStudenata;
import view.AbstractTableModelPredmeti;
import view.PredmetiJTable;
import view.TabbedPane;

public class ProfesorController {
private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	private ProfesorController() {}

	public void addProfesor(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		//TODO: preraditi metodu da dodaje entitete
		BazaProfesori.getInstance().dodajProfesor(ime, prezime, datum, adresa_stanovanja, kontakt_telefon, email_adresa, adresa_kancelarije, BLK, titula, zvanje);
		TabbedPane.getInstance().azurirajProfesori();
		
		//ne uradi nista, ali ne pukne sad???????
	}
	public void editProfesor(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		//TODO: preraditi metodu da menja entitete
		BazaProfesori.getInstance().izmeniProfesora(ime, prezime, datum, adresa_stanovanja, kontakt_telefon, email_adresa, adresa_kancelarije, BLK, titula, zvanje);
		TabbedPane.getInstance().azurirajProfesori();
	}
	public void removeProfesor(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		//TODO: preraditi metodu da brise entitete
		BazaProfesori.getInstance().izbrisiProfesora(BLK);
		TabbedPane.getInstance().azurirajProfesori();
	}
	public void searchProfesor() {
		//TODO: preraditi metodu da trazi entitete
		
	}
}
