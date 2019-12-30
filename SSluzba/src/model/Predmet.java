package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Predmet {
	private String sifra_predmeta;
	private String naziv;
	private String semestar;
	private String godina;
	private String predavac; //treba da bude private Profesor profesor al nmg to jos pa nek za sad bude String
	private ArrayList<String> brIndeksaStudenata;
	
	/*
	public Predmet(String string, String naziv, String string2, String string3, String string4) {
		super();
		this.sifra_predmeta = string;
		this.naziv = naziv;
		this.semestar = string2;
		this.godina = string3;
		this.predavac = string4;
	}
	
	public Predmet(Predmet p) {
		super();
		sifra_predmeta = p.sifra_predmeta;
		naziv = p.naziv;
		semestar = p.semestar;
		godina = p.godina;
		predavac = p.predavac;
	}

	public Predmet(String string, String naziv2, String string2, String string3, String string4) {

		super();
		this.sifra_predmeta = string;
		this.naziv = naziv2;
		this.semestar = string2;
		this.godina = string3;
		this.predavac = string4;
	}
	*/

	public Predmet(String sifra_predmeta, String naziv, String semestar, String godina, String predavac) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.predavac = predavac;
		this.brIndeksaStudenata = new ArrayList<String>();
	}
	public Predmet(String sifra_predmeta, String naziv, String semestar, String godina, String predavac,ArrayList<String> studenti) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.predavac = predavac;
		this.brIndeksaStudenata = studenti;
	}
	
	public Predmet(Predmet p) {
		super();
		this.sifra_predmeta = p.sifra_predmeta;
		this.naziv = p.naziv;
		this.semestar = p.semestar;
		this.godina = p.godina;
		this.predavac = p.predavac;
		this.brIndeksaStudenata = p.getBrIndeksaStudenata();
	}
	
	
	public ArrayList<String> getBrIndeksaStudenata() {
		return brIndeksaStudenata;
	}

	public void setBrIndeksaStudenata(ArrayList<String> brIndeksaStudenata) {
		this.brIndeksaStudenata = brIndeksaStudenata;
	}

	public String getSifra_predmeta() {
		return sifra_predmeta;
	}

	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public String getPredavac() {
		return predavac;
	}

	public void setPredavac(String predavac) {
		this.predavac = predavac;
	}


	@Override
	public String toString() {
		return "Predmet [sifra_predmeta=" + sifra_predmeta + ", naziv=" + naziv + ", semestar=" + semestar + ", godina="
				+ godina + ", predavac=" + predavac +","+brIndeksaStudenata +"]";
	}
	
	
}
