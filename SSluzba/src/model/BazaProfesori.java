package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BazaProfesori {
	private static BazaProfesori instance = null;

	public static BazaProfesori getInstance() {
		if (instance == null) {
			instance = new BazaProfesori();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;
	private ArrayList<Profesor> sviProfesori;

	private List<String> kolone;

	private BazaProfesori() {
	
		initProfesor();

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA");
		this.kolone.add("TEL.");
		this.kolone.add("EMAIL");
		this.kolone.add("ADRESA KANCELARIJE");
		this.kolone.add("BLK");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
	}

	private void initProfesor() {
		
		this.profesori = new ArrayList<Profesor>();
		this.sviProfesori = new ArrayList<Profesor>();

		String sledeci = null;
		String [] kolone = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Profesori.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while((sledeci = in.readLine()) != null) {
				if(sledeci.equals("")) {
					continue;
				}
				kolone = sledeci.split("\\|");
				profesori.add(new Profesor(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(),kolone[8].trim(),kolone[9].trim()));
				sviProfesori.add(new Profesor(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(),kolone[8].trim(),kolone[9].trim()));

			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//profesori.add(new Student( "Mika", "Mikic", "13.08.1998","Novi Sad","32145453","sfdfewf@gmail.com","RA20/2017","10.07.2017",3,Status.B,9.41));
		//profesori.add(new Student( "Zika", "Zikic", "23.04.1997","Sremaska mitrovica","67467453","aaaaaa@gmail.com","RA120/2016","13.07.2016",4,Status.S,9.00));
		//profesori.add(new Student( "Pera", "Peric", "12.10.1999","Kovilovo","98765424","bbbbbbb@gmail.com","RA1/2018","08.07.2018",2,Status.B,9.50));
		//profesori.add(new Profesor("Miroslav","Hajdukovic", "12-March-1901"	 ,"Na marsu","021666420","ajduk@gmail.com","420","696642","PhD","redovan profesor"));
		//profesori.add(new Profesor("Miroslav2","Hajdukovic1", "13-March-1901"	 ,"Na marsu","021666420","ajduk@gmail.com","420","696642","PhD","redovan profesor"));
		//profesori.add(new Profesor("Miroslav2","Hajdukovic1", "13-December-1901"	 ,"Na marsu","021666420","ajduk@gmail.com","420","696642","PhD","redovan profesor"));

	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	public ArrayList<Profesor> getSviProfesori() {
		return sviProfesori;
	}
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	
	public int getColumnCount() {
		return 10;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValAt(int row, int col) {
		Profesor profesori=this.profesori.get(row);
		switch(col) {
		case 0:
			return profesori.getIme();
		case 1:
			return profesori.getPrezime();
		case 2:
			return profesori.getDatum();
		case 3:
			return profesori.getAdresa_stanovanja();
		case 4:
			return profesori.getKontakt_telefon();
		case 5:
			return profesori.getEmail_adresa();
		case 6:
			return profesori.getAdresa_kancelarije();
		case 7:
			return profesori.getBLK();
		case 8:
			return profesori.getTitula();
		case 9:
			return profesori.getZvanje();
			
		default:
			return null;
		}
	}
	public void dodajProfesor(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		
		this.profesori.add(new Profesor(ime,prezime,datum,adresa_stanovanja,kontakt_telefon,email_adresa,adresa_kancelarije,BLK,titula,zvanje));
		this.sviProfesori.add(new Profesor(ime,prezime,datum,adresa_stanovanja,kontakt_telefon,email_adresa,adresa_kancelarije,BLK,titula,zvanje));

	}

	public void izbrisiProfesora(String BLK) {
		for (Profesor i : profesori) {
			if (i.getBLK().equals(BLK)) {
				profesori.remove(i);
				break;
			}
		}
		try {	
			for (Profesor i : sviProfesori) {
				if (i.getBLK().equals(BLK)) {
					sviProfesori.remove(i);
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void izmeniProfesora(String ime, String prezime, String datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		for (Profesor i : profesori) {
			if (i.getBLK().equals(BLK)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatum(datum);
				i.setAdresa_stanovanja(adresa_stanovanja);
				i.setKontakt_telefon(kontakt_telefon);
				i.setEmail_adresa(email_adresa);
				i.setAdresa_kancelarije(adresa_kancelarije) ;
				i.setBLK(BLK);
				i.setTitula(titula);
				i.setZvanje(zvanje);
			}
		}
		try {
			for (Profesor i : sviProfesori) {
				if (i.getBLK().equals(BLK)) {
					i.setIme(ime);
					i.setPrezime(prezime);
					i.setDatum(datum);
					i.setAdresa_stanovanja(adresa_stanovanja);
					i.setKontakt_telefon(kontakt_telefon);
					i.setEmail_adresa(email_adresa);
					i.setAdresa_kancelarije(adresa_kancelarije) ;
					i.setBLK(BLK);
					i.setTitula(titula);
					i.setZvanje(zvanje);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
