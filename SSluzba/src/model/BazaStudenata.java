package model;

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
	
		initStudente();

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
	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student( "Mika", "Mikic", "13.08.1998","Novi Sad","32145453","sfdfewf@gmail.com","RA20/2017","10.07.2017",3,Status.B,9.41));
		studenti.add(new Student( "Zika", "Zikic", "23.04.1997","Sremaska mitrovica","67467453","aaaaaa@gmail.com","RA120/2016","13.07.2016",4,Status.S,9.00));
		studenti.add(new Student( "Pera", "Peric", "12.10.1999","Kovilovo","98765424","bbbbbbb@gmail.com","RA1/2018","08.07.2018",2,Status.B,9.50));
		
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	/*
	public String getValueAt(int row, int column) {
		Igrac igrac = this.igraci.get(row);
		switch (column) {
		case 0:
			return Long.toString(igrac.getId());
		case 1:
			return igrac.getIme();
		case 2:
			return igrac.getPrezime();
		case 3:
			return igrac.getKlub();
		default:
			return null;
		}
	}
	*/
	public void dodajStudenta(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,Status status,double prosecnaO) {
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

	public void izmeniStudenta(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,Status status,double prosecnaO) {
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
