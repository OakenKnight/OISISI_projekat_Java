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


public class BazaStudenata {
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private ArrayList<Student> studenti;
	private ArrayList<Student> sviStudenti;

	private List<String> kolone;

	private BazaStudenata() {
	

		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DAT. RODJENJA");
		this.kolone.add("ADRESA");
		this.kolone.add("TEL.");
		this.kolone.add("EMAIL");
		this.kolone.add("DAT. UPISA");
		this.kolone.add("GOD. STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		
		initStudente();

	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		this.sviStudenti = new ArrayList<Student>();

		String sledeci = null;
		String [] kolone = null;
		String [] datum1 = null;
		String [] datum2 = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Studenti.txt")));
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
				StatusStudent s;

				if(kolone[9].trim().equals("B"))
					s = StatusStudent.B;
				else if (kolone[9].equals("S"))
					s = StatusStudent.S;
				else
					s = StatusStudent.N;
				datum1 = kolone[2].split("\\.");
				datum2 = kolone[7].split("\\.");
				LocalDate lc1 = LocalDate.of(Integer.parseInt(datum1[2]), Integer.parseInt(datum1[1]), Integer.parseInt(datum1[0]));
				LocalDate lc2 = LocalDate.of(Integer.parseInt(datum2[2]), Integer.parseInt(datum2[1]), Integer.parseInt(datum2[0]));
				studenti.add(new Student(kolone[0].trim(),kolone[1].trim(),lc1,kolone[3].trim(),kolone[4].trim(),kolone[5].trim(),kolone[6].trim(),lc2,Integer.parseInt(kolone[8].trim()),s,Double.parseDouble(kolone[10].trim())));
				sviStudenti.add(new Student(kolone[0].trim(),kolone[1].trim(),lc1,kolone[3].trim(),kolone[4].trim(),kolone[5].trim(),kolone[6].trim(),lc2,Integer.parseInt(kolone[8].trim()),s,Double.parseDouble(kolone[10].trim())));
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public ArrayList<Student> getSviStudenti() {
		return sviStudenti;
	}
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	
	public int getColumnCount() {
		return 11;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrIndex();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		case 4:
			return student.getAdresaStanovanja();
		case 5:
			return student.getKontaktTel();
		case 6:
			return student.getEmail();
		case 7:
			return student.getDatumUpisa().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		case 8:
			return Integer.toString(student.getTrenutnaGodina());
		case 9:
			if(student.getStatus() == StatusStudent.B)
				return "Budzet";
			else if (student.getStatus() == StatusStudent.S)
				return "Samofinansiranje";
			else
				return "Nepoznato";
		case 10:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String ime,String prezime,LocalDate datumR,String adresaS,String kontaktT,String email,String brI,LocalDate datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
		this.studenti.add(new Student(ime,prezime,datumR,adresaS,kontaktT,email,brI,datumU,trenutnaG,status,prosecnaO));
		this.sviStudenti.add(new Student(ime,prezime,datumR,adresaS,kontaktT,email,brI,datumU,trenutnaG,status,prosecnaO));

	}

	public void izbrisiStudenta( String indx) {
		for (Student i : studenti) {
			if (i.getBrIndex().equals(indx)) {
				studenti.remove(i);
				break;
			}
		}
		try {
			for (Student i : sviStudenti) {
				if (i.getBrIndex().equals(indx)) {
					sviStudenti.remove(i);
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void izmeniStudenta(String ime,String prezime,LocalDate datumR,String adresaS,String kontaktT,String email,String brI,LocalDate datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
		for (Student i : studenti) {
			if (i.getBrIndex().equals(brI)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setAdresaStanovanja(adresaS);
				i.setBrIndex(brI);
				i.setDatumRodjenja(datumR);
				i.setDatumUpisa(datumU);
				i.setEmail(email);
				i.setKontaktTel(kontaktT);
				i.setProsecnaOcena(prosecnaO);
				i.setStatus(status);
				i.setTrenutnaGodina(trenutnaG);
			}
		}
		try {
			for (Student i : sviStudenti) {
				if (i.getBrIndex().equals(brI)) {
					i.setIme(ime);
					i.setPrezime(prezime);
					i.setAdresaStanovanja(adresaS);
					i.setBrIndex(brI);
					i.setDatumRodjenja(datumR);
					i.setDatumUpisa(datumU);
					i.setEmail(email);
					i.setKontaktTel(kontaktT);
					i.setProsecnaOcena(prosecnaO);
					i.setStatus(status);
					i.setTrenutnaGodina(trenutnaG);
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
		public HashMap<String, String> spremiString(String uneseno){
		
		String[] parovi = uneseno.split("\\|");
		String[] podeljeni;
	
		
		String ime = "ime";
		String prezime = "prezime";
		String datumR = "datumR";
		String adresa = "adresa";
		String brTel = "brTel";
		String mail = "mail";
		String indeks = "indeks";
		String datumU = "datumU";
		String godina = "godina";
		String status = "status";
		String prosek = "prosek"; 
		

		HashMap<String,String> mapa= new HashMap<String,String>();
		
		for(int i = 0 ; i < parovi.length ; i++) {
			podeljeni = parovi[i].split("\\:");
			if(podeljeni[0].equals(ime)) {
				mapa.put(ime, podeljeni[1]);
			}else if(podeljeni[0].equals(prezime)) {
				mapa.put(prezime, podeljeni[1]);
			}else if(podeljeni[0].equals(datumR)) {
				mapa.put(datumR, podeljeni[1]);
			}else if(podeljeni[0].equals(adresa)) {
				mapa.put(adresa, podeljeni[1]);
			}else if(podeljeni[0].equals(brTel)) {
				mapa.put(brTel, podeljeni[1]);
			}else if(podeljeni[0].equals(mail)) {
				mapa.put(mail, podeljeni[1]);
			}else if(podeljeni[0].equals(indeks)) {
				mapa.put(indeks, podeljeni[1]);
			}else if(podeljeni[0].equals(datumU)) {
				mapa.put(datumU, podeljeni[1]);
			}else if(podeljeni[0].equals(godina)) {
				mapa.put(godina, podeljeni[1]);
			}else if(podeljeni[0].equals(status)) {
				mapa.put(status, podeljeni[1]);
			}else if (podeljeni[0].equals(prosek)) {
				mapa.put(prosek, podeljeni[1]);
			}
		}
		
		return mapa;
	}
	
	public void searchStudenti(String uneseno) {
		if(uneseno.equals("")) {
			this.studenti=this.sviStudenti;
		}else {
			
			HashMap<String, String> mapa = spremiString(uneseno);
			Set<String> kljucevi = mapa.keySet();
			
			Set<Student> set = new HashSet<Student>();
			
			for(String key:kljucevi) {
				for(Student s : sviStudenti) {
					if(key.equals("ime")) {
						if(s.getIme().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("prezime")) {
						if(s.getPrezime().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("datumR")) {
						if(s.getDatumRodjenja().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("adresa")) {
						if(s.getAdresaStanovanja().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("brTel")) {
						if(s.getKontaktTel().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("mail")) {
						if(s.getEmail().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("indeks")) {
						if(s.getBrIndex().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("datumU")) {
						if(s.getDatumUpisa().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("godina")) {
						if(s.getTrenutnaGodina() == Integer.parseInt(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("status")) {
						if(s.getStatus().equals(mapa.get(key))) {
							set.add(s);
						}
					}else if(key.equals("prosek")) {
						if(s.getProsecnaOcena() == Double.parseDouble(mapa.get(key)) ) {
							set.add(s);
						}
					}
				}
				
				
			}
			ArrayList<Student> novaLista=new ArrayList<Student>(set);

			this.studenti=novaLista;	
			
		}
				
	}
	
	public void resetSearchStudenti() {
		this.studenti=this.sviStudenti;
	}
	public Student nadjiStudenta(String ind) {
		for(Student s : studenti) {
			if(s.getBrIndex().equals(ind)) {
				return s;
			}
		}
		return null;
	}
}
