package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Profesor {
	private String ime;
	private String prezime;
	private String datum;
	private String adresa_stanovanja;
	private String kontakt_telefon;
	private String email_adresa;
	private String adresa_kancelarije;
	private String BLK;
	private String titula;
	private String zvanje;
	//ArrayList<Predmet> predmeti = new ArrayList<Predmet>(); // Create an ArrayList object
	//dodaj listu predmeta na kojima je profesor;
	public Profesor(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,
			String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum = datum;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email_adresa = email_adresa;
		this.adresa_kancelarije = adresa_kancelarije;
		this.BLK = BLK;
		this.titula = titula;
		this.zvanje = zvanje;
		//this.predmeti=predmeti1;
	}
	
	public Profesor(Profesor p) {
		super();
		ime = p.ime;
		prezime = p.prezime;
		datum = p.datum;
		adresa_stanovanja = p.adresa_stanovanja;
		kontakt_telefon = p.kontakt_telefon;
		email_adresa = p.email_adresa;
		adresa_kancelarije = p.adresa_kancelarije;
		BLK = p.BLK;
		titula = p.titula;
		zvanje = p.zvanje;
		//predmeti=p.predmeti;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getAdresa_stanovanja() {
		return adresa_stanovanja;
	}

	public void setAdresa_stanovanja(String adresa_stanovanja) {
		this.adresa_stanovanja = adresa_stanovanja;
	}

	public String getKontakt_telefon() {
		return kontakt_telefon;
	}

	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public String getEmail_adresa() {
		return email_adresa;
	}

	public void setEmail_adresa(String email_adresa) {
		this.email_adresa = email_adresa;
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
		return "Profesor [ime=" + ime + ", prezime=" + prezime + ", datum=" + datum + ", adresa_stanovanja="
				+ adresa_stanovanja + ", kontakt_telefon=" + kontakt_telefon + ", email_adresa=" + email_adresa
				+ ", adresa_kancelarije=" + adresa_kancelarije + ", BLK=" + BLK + ", titula=" + titula + ", zvanje="
				+ zvanje + "]";
	}
	
	
		
	
	
	
}
