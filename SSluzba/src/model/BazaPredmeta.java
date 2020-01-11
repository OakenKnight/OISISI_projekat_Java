package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;


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
	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	
	private BazaPredmeta() {
		this.kolone=new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina studija");
		this.kolone.add("Predmetni profesor");
		this.kolone.add("Spisak studenata");
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
			    String[] indeksi = kolone[5].split("\\#");
			    
				ArrayList<Student> stud = new ArrayList<Student>();
				Student s;
				for(String st : indeksi) {
					s = BazaStudenata.getInstance().nadjiStudenta(st);
					if(s == null) {
						stud.add(new Student("nepoznato","nepoznato",LocalDate.now(),"nepoznato","nepoznato","nepoznato",st,LocalDate.now(),-1,StatusStudent.N,0.00));
						continue;
					}
					stud.add(s);
					BazaStudenata.getInstance().nadjiStudenta(st).getPredmeti().add(new Predmet(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(),kolone[4].trim(),stud));

				}
				
				predmeti.add(new Predmet(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(),kolone[4].trim(),stud));
				sviPredmeti.add(new Predmet(kolone[0].trim(),kolone[1].trim(),kolone[2].trim(),kolone[3].trim(),kolone[4].trim(),stud));

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
		return 6;
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
	
	public void addPredmet(String sifra, String naziv, String semestar, String godina, String profesor,ArrayList<Student> s) {
		this.predmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor,s));
		this.sviPredmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor,s));

	}

	public void deletePredmet(String sifra) {
		for (Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				predmeti.remove(p);
				
				
				break;
			}
		}
		
		deleteSubjFromProf(sifra);

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
		
		//potrebno sad obrisati predmet sa profesora :D
		
		
	}
	public void deleteSubjFromProf(String sifra) {
		ArrayList<Profesor> profesori=BazaProfesori.getInstance().getProfesori();
		for (Profesor profesor : profesori) {
			ArrayList<Predmet> predmeti=profesor.getPredmeti();
			int i=0;
			int idx=-1;
			for (Predmet predmet : predmeti) {
				if(predmet.getSifra_predmeta().equals(sifra)) {
					idx=i;
					predmeti.remove(idx);
					break;
				}
				i++;
			}
		}
	}
	public void setProfUnknown(Predmet p) {
		for (Predmet predmet : predmeti) {
			if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				predmet.setPredavac("");
			}
		}
		for (Predmet predmet : sviPredmeti) {
			if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				predmet.setPredavac("");
			}
		}
	}
	public void editPredmet(String sifra, String naziv, String semestar, String godina, String profesor,ArrayList<Student> s) {
		for(Predmet p:predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				p.setSifra_predmeta(sifra);
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodina(godina);
				p.setPredavac(profesor);
				p.setBrIndeksaStudenata(s);
				
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
					p.setBrIndeksaStudenata(s);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public HashMap<String, String> spremiString(String uneseno){
		
		String[] parovi=uneseno.split("\\|");
		String[] podeljeni;
		
		String sifra="sifra";
		String naziv="naziv";
		String semestar="semestar";
		String godina="godina";
		String prof="prof";
		
		HashMap<String,String> mapa= new HashMap<String,String>();
		
		for(int i=0;i<parovi.length;i++) {
			podeljeni=parovi[i].split("\\:");
			if(podeljeni[0].equals(sifra)) {
				mapa.put(sifra, podeljeni[1]);
			}else if(podeljeni[0].equals(naziv)) {
				mapa.put(naziv, podeljeni[1]);
			}else if(podeljeni[0].equals(semestar)) {
				mapa.put(semestar, podeljeni[1]);
			}else if(podeljeni[0].equals(godina)) {
				mapa.put(godina, podeljeni[1]);
			}else if(podeljeni[0].equals(prof)) {
				mapa.put(prof, podeljeni[1]);
			}
		}
		
		return mapa;
	}
	public void searchPredmet(String uneseno) {
		if(uneseno.equals("")) {
			this.predmeti=this.sviPredmeti;
		}else {
			
			HashMap<String, String> mapa=spremiString(uneseno);
			Set<String> kljucevi=mapa.keySet();
			Set<Predmet> set=new HashSet<Predmet>();
			for(String key:kljucevi) {
				for(Predmet p:sviPredmeti) {
					if(key.equals("sifra")) {
						if(p.getSifra_predmeta().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("naziv")) {
						if(p.getNaziv().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("semestar")) {
						if(p.getSemestar().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("godina")) {
						if(p.getGodina().equals(mapa.get(key))) {
							set.add(p);
						}
					}else if(key.equals("prof")) {
						if(p.getPredavac().equals(mapa.get(key))) {
							set.add(p);
						}
					}
				}
				
				
			}
			ArrayList<Predmet> novaLista=new ArrayList<Predmet>(set);

			this.predmeti=novaLista;	
			
		}
		
		
	}

	public void resetSearchPredmet() {
		// TODO Auto-generated method stub
		this.predmeti=this.sviPredmeti;
	}
	//metoda koja stavlja broj licne karte u text field
	public String returnBlkFromPredavac(Predmet p) {
		String blk="";
		
		Profesor profesor=BazaProfesori.getInstance().getProfHavingSubj(p);
		if(profesor==null) {
			return null;
		}else {
			blk=profesor.getBLK();
			return blk;
		}
		
	}
	//metoda koja za datog predavaca nalazi predmet
	public Predmet nadjiPredmet(String pred) {
		// TODO Auto-generated method stub
		for (Predmet predmet : sviPredmeti) {
			if(predmet.getSifra_predmeta().equals(pred)) {
				return predmet;
			}
		}
		return null;
	}
	
	public void putProfToSubj(String blk, Predmet p) {
		Profesor profa=BazaProfesori.getInstance().getProfHavingBlk(blk);
		if(profa==null){
			System.out.println("AAAAAAAAAAAAAAAA KURVOOOOOOOOO");
		}else {
			ArrayList<Predmet> predmeti=profa.getPredmeti();
			//syso ovo ne radi ovde msm kao ga doda, al ustv ne doda
			//nmp
			
			predmeti.add(p);
			
			for (Predmet predmet : predmeti) {
				System.out.println(predmet.getNaziv());
			}
			
		}
	}
	
	public void deleteProfFromSubj(String blk, Predmet p) {
		Profesor profa=BazaProfesori.getInstance().getProfHavingBlk(blk);
		if(profa==null){
		}else {
			ArrayList<Predmet> predmeti=profa.getPredmeti();
			int idx=-1;
			int i=0;
			for (Predmet predmet : predmeti) {
				if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
					idx=i;
					continue;
				}
				i++;
			}
			System.out.println(i);
			predmeti.remove(idx);
		}
	}
	
	public void izmeniListuZaPrikaz(String blkNovi,Predmet p) {
		for(Predmet predmet:sviPredmeti) {
			if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				Profesor profa=BazaProfesori.getInstance().getProfHavingBlk(blkNovi);
				predmet.setPredavac(profa.getIme()+" "+profa.getPrezime());
				continue;
			}
		}
		for(Predmet predmet1:predmeti) {
			if(predmet1.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				Profesor profa=BazaProfesori.getInstance().getProfHavingBlk(blkNovi);
				predmet1.setPredavac(profa.getIme()+" "+profa.getPrezime());
				continue;
			}
		}
	}
	
	public void izmeniProfesora(String stariProf, String noviProf, Predmet p) {
		try {
			deleteProfFromSubj(stariProf,p);
			}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Nemoguce uraditi izmenu profesora! Pogresan broj licne karte profesora unesen!","",JOptionPane.ERROR_MESSAGE);

		}	
		try {
			putProfToSubj(noviProf, p);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Hvatam gresku stavljanja","",JOptionPane.ERROR_MESSAGE);

		}	
		try {
			
			izmeniListuZaPrikaz(noviProf, p);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Hvatam gresku izmene lsite za prikaz!","",JOptionPane.ERROR_MESSAGE);

		}	
	}

	public void obrisiProfesoraSaPredmeta(String bLK) {
		// TODO Auto-generated method stub
		Profesor profesor=BazaProfesori.getInstance().getProfHavingBlk(bLK);
		ArrayList<Predmet> predmetiProfesorovi=profesor.getPredmeti();
	
		for (Predmet p : sviPredmeti) {
			for(Predmet p1:predmetiProfesorovi) {
				if(p1.getSifra_predmeta().equals(p.getSifra_predmeta())) {
					p.setPredavac("");
				}
			}
		}
		
		for (Predmet p : predmeti) {
			for(Predmet p1:predmetiProfesorovi) {
				if(p1.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				
					p.setPredavac("");
				}
			}
		}
		
	}
	public void izmeniListuZaPrikazPosleBrisanja(String blk) {
		Profesor p=BazaProfesori.getInstance().getProfHavingBlk(blk);
		ArrayList<Predmet> predmeti=p.getPredmeti();
		
		for(Predmet predmet:sviPredmeti) {
			if(predmet.getSifra_predmeta().equals(predmet.getSifra_predmeta())) {
				Profesor profa=BazaProfesori.getInstance().getProfHavingBlk(blk);
				predmet.setPredavac(profa.getIme()+" "+profa.getPrezime());
				continue;
			}
		}
	}
}
