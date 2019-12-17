package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BazaStudenata {
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
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
	/*	String sledeci = null;
		String [] kolone = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Studenti.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while((sledeci = in.readLine()) != null) {
				kolone = sledeci.split("\\|");
				Status s;

				if(kolone[9].equals("Status.B"))
					s = Status.B;
				else if (kolone[9].equals("Status.S"))
					s = Status.S;
				else
					s = Status.N;
				studenti.add(new Student(kolone[0],kolone[1],kolone[2],kolone[3],kolone[4],kolone[5],kolone[6],kolone[7],Integer.parseInt(kolone[8]),s,Double.parseDouble(kolone[10])));
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
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
			return student.getDatumRodjenja();
		case 4:
			return student.getAdresaStanovanja();
		case 5:
			return student.getKontaktTel();
		case 6:
			return student.getEmail();
		case 7:
			return student.getDatumUpisa();
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
	
	public void dodajStudenta(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
		this.studenti.add(new Student(ime,prezime,datumR,adresaS,kontaktT,email,brI,datumU,trenutnaG,status,prosecnaO));
	}

	public void izbrisiStudenta( String indx) {
		for (Student i : studenti) {
			if (i.getBrIndex().equals(indx)) {
				studenti.remove(i);
				break;
			}
		}
	}

	public void izmeniStudenta(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
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
	}
}
