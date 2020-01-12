package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

		
		initProfesor();

	}

	private void initProfesor() {
		
		this.profesori = new ArrayList<Profesor>();
		this.sviProfesori = new ArrayList<Profesor>();

		String sledeci = null;
		String [] kolone = null;
		String [] datum = null;
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
				datum = kolone[2].split("\\.");

				String[] predmetiSifre=kolone[10].split("\\#");
				ArrayList<Predmet> predmeti=new ArrayList<Predmet>();
				Predmet p;
				for(String pred:predmetiSifre) {
					p=BazaPredmeta.getInstanceBazaPredmeta().nadjiPredmet(pred);
					if(p==null) {
						predmeti.add(new Predmet(pred,"nepoznato","nepoznato","nepoznato",kolone[0].trim()+" "+kolone[1].trim()));
						continue;
					}
					predmeti.add(p);
				}
				
				LocalDate lc = LocalDate.of(Integer.parseInt(datum[2]), Integer.parseInt(datum[1]), Integer.parseInt(datum[0]));
				Profesor profa=new Profesor(kolone[0].trim(),kolone[1].trim(),lc,kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(),kolone[8].trim(),kolone[9].trim());
				profa.setPredmeti(predmeti);
				profesori.add(profa); //new Profesor(kolone[0].trim(),kolone[1].trim(),lc,kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(),kolone[8].trim(),kolone[9].trim()));
				sviProfesori.add(profa); //new Profesor(kolone[0].trim(),kolone[1].trim(),lc,kolone[3].trim(), kolone[4].trim(), kolone[5].trim(), kolone[6].trim(), kolone[7].trim(),kolone[8].trim(),kolone[9].trim()));	
				//System.out.println(predmeti);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Object getValAt(int row, int col) {
		Profesor profesori=this.profesori.get(row);
		switch(col) {
		case 0:
			return profesori.getIme();
		case 1:
			return profesori.getPrezime();
		case 2:
			return profesori.getDatumRodjenja();//.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		case 3:
			return profesori.getAdresaStanovanja();
		case 4:
			return profesori.getKontaktTel();
		case 5:
			return profesori.getEmail();
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
	public void dodajProfesor(String ime, String prezime, LocalDate datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		
		this.profesori.add(new Profesor(ime,prezime,datum,adresa_stanovanja,kontakt_telefon,email_adresa,adresa_kancelarije,BLK,titula,zvanje));
		this.sviProfesori.add(new Profesor(ime,prezime,datum,adresa_stanovanja,kontakt_telefon,email_adresa,adresa_kancelarije,BLK,titula,zvanje));

	}

	public void izbrisiProfesora(String BLK) {
		for (Profesor i : profesori) {
			if (i.getBLK().equals(BLK)) {
				profesori.remove(i);
				deleteProfFromSubj(i);
				break;
			}
		}
		
		try {	
			for (Profesor i : sviProfesori) {
				if (i.getBLK().equals(BLK)) {
					sviProfesori.remove(i);
					deleteProfFromSubj(i);
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void deleteSubjFromProf(Predmet p, Profesor prof) {
		ArrayList<Predmet> predmeti = prof.getPredmeti();
		int idx=-1;
		int i=0;
		for (Predmet predmet : predmeti) {
			if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				idx=i;
				continue;
			}
			i++;
		}
		predmeti.remove(idx);
		prof.setPredmeti(predmeti);
	}
	public void deleteProfFromCertainSubj(Profesor prof, Predmet pred) {
		ArrayList<Predmet> predmetiSvi =BazaPredmeta.getInstanceBazaPredmeta().getSviPredmeti();
		for (Predmet predmet : predmetiSvi) {
			if(predmet.getSifra_predmeta().equals(pred.getSifra_predmeta()))
				predmet.setPredavac("");
		}
		
		ArrayList<Predmet> predmeti =BazaPredmeta.getInstanceBazaPredmeta().getPredmeti();
		for (Predmet predmet : predmeti) {
			
		}
		
		
		
	}
	public void deleteProfFromSubj(Profesor p) {
		ArrayList<Predmet> predmeti=p.getPredmeti();
		for (Predmet predmet : predmeti) {
			BazaPredmeta.getInstanceBazaPredmeta().setProfUnknown(predmet);
		}
	}
	public void izmeniProfesora(String ime, String prezime, LocalDate datum, String adresa_stanovanja, String kontakt_telefon,String email_adresa, String adresa_kancelarije, String BLK, String titula, String zvanje) {
		for (Profesor i : profesori) {
			if (i.getBLK().equals(BLK)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datum);
				i.setAdresaStanovanja(adresa_stanovanja);
				i.setKontaktTel(kontakt_telefon);
				i.setEmail(email_adresa);
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
					i.setDatumRodjenja(datum);
					i.setAdresaStanovanja(adresa_stanovanja);
					i.setKontaktTel(kontakt_telefon);
					i.setEmail(email_adresa);
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


	public HashMap<String, String> spremiString(String uneseno){
		
		String[] parovi=uneseno.split("\\|");
		String[] podeljeni;
	
		
		String ime="ime";
		String prezime="prezime";
		String godinaR="godinaR";
		String adresa="adresa";
		String brTel="brTel";
		String mail="mail";
		String kanc="kanc";
		String blk="blk";
		String titula="titula";
		String zvanje="zvanje";
		
		HashMap<String,String> mapa= new HashMap<String,String>();
		
		for(int i=0;i<parovi.length;i++) {
			podeljeni=parovi[i].split("\\:");
			if(podeljeni[0].equals(ime)) {
				mapa.put(ime, podeljeni[1]);
			}else if(podeljeni[0].equals(prezime)) {
				mapa.put(prezime, podeljeni[1]);
			}else if(podeljeni[0].equals(godinaR)) {
				mapa.put(godinaR, podeljeni[1]);
			}else if(podeljeni[0].equals(adresa)) {
				mapa.put(adresa, podeljeni[1]);
			}else if(podeljeni[0].equals(brTel)) {
				mapa.put(brTel, podeljeni[1]);
			}else if(podeljeni[0].equals(mail)) {
				mapa.put(mail, podeljeni[1]);
			}else if(podeljeni[0].equals(kanc)) {
				mapa.put(kanc, podeljeni[1]);
			}else if(podeljeni[0].equals(blk)) {
				mapa.put(blk, podeljeni[1]);
			}else if(podeljeni[0].equals(titula)) {
				mapa.put(titula, podeljeni[1]);
			}else if(podeljeni[0].equals(zvanje)) {
				mapa.put(zvanje, podeljeni[1]);
			}
		}
		
		return mapa;
	}
	
	public void searchProfesori(String uneseno) {
		if(uneseno.equals("")) {
			this.profesori=this.sviProfesori;
		}else {
			
			HashMap<String, String> mapa=spremiString(uneseno);
			
			Set<String> kljucevi=mapa.keySet();
			Set<Profesor> set=new HashSet<Profesor>();
			
			for(String key:kljucevi) {
				for(Profesor p:sviProfesori) {
					if(key.equals("ime")) {
						if(p.getIme().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("prezime")) {
						if(p.getPrezime().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("godinaR")) {
						if(p.getDatumRodjenja().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("adresa")) {
						if(p.getAdresaStanovanja().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("brTel")) {
						if(p.getKontaktTel().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("mail")) {
						if(p.getEmail().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("kanc")) {
						if(p.getAdresa_kancelarije().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("blk")) {
						if(p.getBLK().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("titula")) {
						if(p.getTitula().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("zvanje")) {
						if(p.getZvanje().equals(mapa.get(key))) {
							set.add(p);
						}
					}
				}
				
				
			}
			ArrayList<Profesor> novaLista=new ArrayList<Profesor>(set);

			this.profesori=novaLista;	
			
		}
				
	}
	public void resetSearchProfesori() {
		this.profesori=this.sviProfesori;
	}
	public Profesor getProfHavingBlk(String blk) {
	
			
		for (Profesor p : sviProfesori) {
			if(p.getBLK().equals(blk)) {
				return p;
			}
		}
		return null;
	}
	/*
	public ArrayList<Predmet> getProfsSubject(Profesor p){
		return p.getPredmeti();
	}
	*/
	public Profesor getProfHavingSubj(Predmet p) {
		for (Profesor pr : sviProfesori) {
			ArrayList<Predmet> profesoroviPredmeti = pr.getPredmeti();
			for (Predmet predmet : profesoroviPredmeti) {
				if(p.getSifra_predmeta().equals(predmet.getSifra_predmeta()))
					return pr;
			}
		}
		
		return null;
		
	}
}
