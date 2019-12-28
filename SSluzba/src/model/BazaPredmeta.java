package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class BazaPredmeta {
	
	public static BazaPredmeta instance=null;
	//ako ne postoji instanca baze predmeta napravi je
	public static BazaPredmeta getInstanceBazaPredmeta() {
		if(instance==null) {
			instance=new BazaPredmeta(); 
			
		}
		return instance;
	}
	private ArrayList<Predmet> predmeti;
	private ArrayList<Predmet> sviPredmeti;
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
		this.sviPredmeti=new ArrayList<Predmet>();
		
		String sledeci=null;
		String[] kolone=null;
		BufferedReader in=null;
		
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Predmeti.txt")));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((sledeci=in.readLine())!=null) {
				if(sledeci.equals("")) {
					continue;
				}
				kolone=sledeci.split("\\|");
				predmeti.add(new Predmet(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(),kolone[4].trim()));
				sviPredmeti.add(new Predmet(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(),kolone[4].trim()));

			}
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Predmet> getSviPredmeti(){
		return sviPredmeti;
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
		this.sviPredmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor));

	}

	public void deletePredmet(String sifra) {
		for (Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				predmeti.remove(p);
				
				
				break;
			}
		}
		try {
			for (Predmet p : sviPredmeti) {
				if(p.getSifra_predmeta().equals(sifra)) {
					sviPredmeti.remove(p);		
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
	}
	public void editPredmet(String sifra, String naziv, String semestar, String godina, String profesor) {
		for(Predmet p:predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				p.setSifra_predmeta(sifra);
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodina(godina);
				p.setPredavac(profesor);
				
			}
		}
		try {
			for(Predmet p:sviPredmeti) {
				if(p.getSifra_predmeta().equals(sifra)) {
					p.setSifra_predmeta(sifra);
					p.setNaziv(naziv);
					p.setSemestar(semestar);
					p.setGodina(godina);
					p.setPredavac(profesor);	
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
