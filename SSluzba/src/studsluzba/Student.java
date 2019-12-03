package studsluzba;

enum Status {
	S , B, N;
}

public class Student {
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTel;
	private String email;
	private String brIndex;
	private String datumUpisa;
	private int trenutnaGodina;
	private Status status;
	private double prosecnaOcena;
	//private ArrayList<Predmet> predmeti;
	
	public Student() {
		this.ime = "Nepoznato";
		this.prezime = "Nepoznato";
		this.datumRodjenja = "Nepoznato";
		this.adresaStanovanja = "Nepoznato";
		this.kontaktTel = "Nepoznato";
		this.email = "Nepoznato";
		this.brIndex = "Nepoznato";
		this.datumUpisa = "Nepoznato";
		this.trenutnaGodina = -1;
		this.status = Status.N;
		this.prosecnaOcena = 0.0;
		// this.predmeti = new ArrayList<Predmeti> ;
	}
	public Student(String ime,String prezime,String datumR,String adresaS,String kontaktT,String email,String brI,String datumU,int trenutnaG,Status status,double prosecnaO) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumR;
		this.adresaStanovanja = adresaS;
		this.kontaktTel = kontaktT;
		this.email = email;
		this.brIndex = brI;
		this.datumUpisa = datumU;
		this.trenutnaGodina = trenutnaG;
		this.status = status;
		this.prosecnaOcena = prosecnaO;
		//this.predmeti = predmeti;
		
	}
	public Student(Student s) {
		this.ime = s.ime;
		this.prezime = s.prezime;
		this.datumRodjenja = s.datumRodjenja;
		this.adresaStanovanja = s.adresaStanovanja;
		this.kontaktTel = s.kontaktTel;
		this.email = s.email;
		this.brIndex = s.brIndex;
		this.datumUpisa = s.datumUpisa;
		this.trenutnaGodina = s.trenutnaGodina;
		this.status = s.status;
		this.prosecnaOcena = s.prosecnaOcena;
		//this.predmeti = s.predmeti;
	}
	
	
	
	@Override
	public String toString() {
		String st = "";
		if(this.status == Status.S){
			st = "Samofinansiranje";
		}else if(this.status == Status.B) {
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
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getKontaktTel() {
		return kontaktTel;
	}
	public void setKontaktTel(String kontaktTel) {
		this.kontaktTel = kontaktTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrIndex() {
		return brIndex;
	}
	public void setBrIndex(String brIndex) {
		this.brIndex = brIndex;
	}
	public String getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}
	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	
}
