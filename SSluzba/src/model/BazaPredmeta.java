package model;

import java.util.ArrayList;


public class BazaPredmeta {
	
	private static BazaPredmeta instance=null;
	//ako ne postoji instanca baze predmeta napravi je
	public static BazaPredmeta getInstanceBazaPredmeta() {
		if(instance==null) {
			instance=new BazaPredmeta(); 
			
		}
		return instance;
	}
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;
	
	private BazaPredmeta() {
		this.kolone=new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina studija");
		this.kolone.add("Predmetni profesor");
		//this.kolone.add("Spisak studenata");
		initPredmete();
	}
	
	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("E201RA","Matematicka Analiza 1","I", "Prva godina","dr. Nebojsa Ralevic"));
		predmeti.add(new Predmet("E202RA","Arhitektura racunara", "II", "Prva godina", "dr. Miroslav Hajdukovic"));
		predmeti.add(new Predmet("E203RA","Objektno Programiranje", "III", "Druga godina","dr. Aleksandar Kupusinac"));
	}
	
	public ArrayList<Predmet> getPredmeti(){
		return predmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti=predmeti;
	}
	
	public int getColumnCnt() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	public String getValAt(int row, int col) {
		Predmet predmet=this.predmeti.get(row);
		switch(col) {
		case 0:
			return predmet.getSifra_predmeta();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getSemestar();
		case 3:
			return predmet.getGodina();
		case 4:
			return predmet.getPredavac();
		default:
			return null;
		}
	}
	
	public void addPredmet(String sifra, String naziv, String semestar, String godina, String profesor) {
		this.predmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor));
	}

	public void deletePredmet(String sifra) {
		for (Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				predmeti.remove(p);
				break;
			}
		}
	}

	
	
	//TODO: uraditi editPredmet
}
