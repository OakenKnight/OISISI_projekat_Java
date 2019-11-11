package model;

public class Predmet {
	private int sifra_predmeta;
	private String naziv;
	private int semestar;
	private int godina;
	private Profesor predavac;
	//private ArrayList<Student> studenti;
	
	public Predmet(int sifra_predmeta, String naziv, int semestar, int godina, Profesor predavac) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.predavac = predavac;
	}
	
	public Predmet(Predmet p) {
		super();
		sifra_predmeta = p.sifra_predmeta;
		naziv = p.naziv;
		semestar = p.semestar;
		godina = p.godina;
		predavac = p.predavac;
	}

	public int getSifra_predmeta() {
		return sifra_predmeta;
	}

	public void setSifra_predmeta(int sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Profesor getPredavac() {
		return predavac;
	}

	public void setPredavac(Profesor predavac) {
		this.predavac = predavac;
	}

	@Override
	public String toString() {
		return "Predmet [sifra_predmeta=" + sifra_predmeta + ", naziv=" + naziv + ", semestar=" + semestar + ", godina="
				+ godina + ", predavac=" + predavac + "]";
	}
	
	
}
