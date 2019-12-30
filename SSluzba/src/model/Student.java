package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Osoba{

	private String brIndex;
	private LocalDate datumUpisa;
	private int trenutnaGodina;
	private StatusStudent status;
	private double prosecnaOcena;
	
	public Student() {
		super("Nepoznato","Nepoznato",LocalDate.now(),"Nepoznato","Nepoznato","Nepoznato");
		this.brIndex = "Nepoznato";
		this.datumUpisa = LocalDate.now();
		this.trenutnaGodina = -1;
		this.status = StatusStudent.N;
		this.prosecnaOcena = 0.0;
	}
	public Student(String ime,String prezime,LocalDate datumR,String adresaS,String kontaktT,String email,String brI,LocalDate datumU,int trenutnaG,StatusStudent status,double prosecnaO) {
		super(ime,prezime,datumR,adresaS,kontaktT,email);
		this.brIndex = brI;
		this.datumUpisa = datumU;
		this.trenutnaGodina = trenutnaG;
		this.status = status;
		this.prosecnaOcena = prosecnaO;
		
	}
	public Student(Student s) {
		super(s.getIme(),s.getPrezime(),s.getDatumRodjenja(),s.getAdresaStanovanja(),s.getKontaktTel(),s.getEmail());
		this.brIndex = s.getBrIndex();
		this.datumUpisa = s.getDatumUpisa();
		this.trenutnaGodina = s.getTrenutnaGodina();
		this.status = s.getStatus();
		this.prosecnaOcena = s.getProsecnaOcena();

	}
	
	
	
	
	@Override
	public String toString() {
		String st = "";
		if(this.status == StatusStudent.S){
			st = "Samofinansiranje";
		}else if(this.status == StatusStudent.B) {
			st = "Budzet";
		}else {
			st = "Nepoznato";
		}
		
		return "Ime i prezime: "+this.ime+this.prezime+"\nBroj indeksa: "+this.brIndex
				+"\nDatum rodjenja: "+this.datumRodjenja+"\nEmail: "+this.email+"\nKontakt telefon: "+this.kontaktTel
				+"\nAdresa stanovanja: "+this.adresaStanovanja+"\nDatum upisa: "+this.datumUpisa+"\nStatus studenta: "+st
				+"Prosecna ocena studija: "+Math.round(this.prosecnaOcena*100)/100;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresaStanovanja == null) ? 0 : adresaStanovanja.hashCode());
		result = prime * result + ((brIndex == null) ? 0 : brIndex.hashCode());
		result = prime * result + ((datumRodjenja == null) ? 0 : datumRodjenja.hashCode());
		result = prime * result + ((datumUpisa == null) ? 0 : datumUpisa.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((kontaktTel == null) ? 0 : kontaktTel.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prosecnaOcena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + trenutnaGodina;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (adresaStanovanja == null) {
			if (other.adresaStanovanja != null)
				return false;
		} else if (!adresaStanovanja.equals(other.adresaStanovanja))
			return false;
		if (brIndex == null) {
			if (other.brIndex != null)
				return false;
		} else if (!brIndex.equals(other.brIndex))
			return false;
		if (datumRodjenja == null) {
			if (other.datumRodjenja != null)
				return false;
		} else if (!datumRodjenja.equals(other.datumRodjenja))
			return false;
		if (datumUpisa == null) {
			if (other.datumUpisa != null)
				return false;
		} else if (!datumUpisa.equals(other.datumUpisa))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (kontaktTel == null) {
			if (other.kontaktTel != null)
				return false;
		} else if (!kontaktTel.equals(other.kontaktTel))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (Double.doubleToLongBits(prosecnaOcena) != Double.doubleToLongBits(other.prosecnaOcena))
			return false;
		if (status != other.status)
			return false;
		if (trenutnaGodina != other.trenutnaGodina)
			return false;
		return true;
	}
	
	
	public String getBrIndex() {
		return brIndex;
	}
	public void setBrIndex(String brIndex) {
		this.brIndex = brIndex;
	}
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}
	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	public StatusStudent getStatus() {
		return status;
	}
	public void setStatus(StatusStudent status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	
}
