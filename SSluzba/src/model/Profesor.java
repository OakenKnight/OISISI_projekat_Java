package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Osoba{

	private String adresa_kancelarije;
	private String BLK;
	private String titula;
	private String zvanje;
	//ArrayList<Predmet> predmeti = new ArrayList<Predmet>(); // Create an ArrayList object
	//dodaj listu predmeta na kojima je profesor;
	public Profesor(String ime, String prezime, LocalDate datum, String adresa_stanovanja, String kontakt_telefon,
			String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		super(ime,prezime,datum,adresa_stanovanja,kontakt_telefon,email_adresa);
		this.adresa_kancelarije = adresa_kancelarije;
		this.BLK = BLK;
		this.titula = titula;
		this.zvanje = zvanje;
		//this.predmeti=predmeti1;
	}
	
	public Profesor(Profesor p) {
		super(p.getIme(),p.getPrezime(),p.getDatumRodjenja(),p.getAdresaStanovanja(),p.getKontaktTel(),p.getEmail());
		adresa_kancelarije = p.adresa_kancelarije;
		BLK = p.BLK;
		titula = p.titula;
		zvanje = p.zvanje;
		//predmeti=p.predmeti;
	}

	

	public String getAdresa_kancelarije() {
		return adresa_kancelarije;
	}

	public void setAdresa_kancelarije(String adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
	}

	public String getBLK() {
		return BLK;
	}

	public void setBLK(String bLK) {
		BLK = bLK;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	/*
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	*/
	@Override
	public String toString() {
		return "Profesor [ime=" + ime + ", prezime=" + prezime + ", datum=" + datumRodjenja + ", adresa_stanovanja="
				+ adresaStanovanja + ", kontakt_telefon=" + kontaktTel+ ", email_adresa=" + email
				+ ", adresa_kancelarije=" + adresa_kancelarije + ", BLK=" + BLK + ", titula=" + titula + ", zvanje="
				+ zvanje + "]";
	}
	
	
		
	
	
	
}
