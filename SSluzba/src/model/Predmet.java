package model;

public class Predmet {
	private String sifra_predmeta;
	private String naziv;
	private String semestar;
	private String godina;
	private String predavac; //treba da bude private Profesor profesor al nmg to jos pa nek za sad bude String
	//private ArrayList<Student> studenti;
	/*
	public Predmet(String string, String naziv, String string2, String string3, String string4) {
		super();
		this.sifra_predmeta = string;
		this.naziv = naziv;
		this.semestar = string2;
		this.godina = string3;
		this.predavac = string4;
	}
	*/
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
				+ godina + ", predavac=" + predavac + "]";
	}
	
	
}
