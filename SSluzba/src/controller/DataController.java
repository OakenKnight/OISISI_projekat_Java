package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Student;

public class DataController {
	private static DataController instance = null;
	
	public static DataController getInstance() {
		if (instance == null) {
			instance = new DataController();
		}
		return instance;
	}
	private DataController() {}

	public void saveDataSubj(ArrayList<Predmet> sviPredmeti) {
		BufferedWriter out  = null;
		try {
			out = new BufferedWriter( new FileWriter("datoteke/Predmeti.txt",true));
			FileWriter fw = new FileWriter("datoteke/Predmeti.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush(); 
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (Predmet predmet : sviPredmeti) {
				StringBuilder s = new StringBuilder("");
				s.append(predmet.getSifra_predmeta()+"|"+predmet.getNaziv()+"|"+predmet.getSemestar()+"|"+predmet.getGodina()+"|"+predmet.getPredavac()+"|");	
				for(Student st : predmet.getBrIndeksaStudenata()) {
					s.append(st.getBrIndex() + "#");
				}
				s.deleteCharAt(s.length()-1);
				
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void saveDataProf(ArrayList<Profesor> sviProfesori) {
		BufferedWriter out  = null;
		try {
			out = new BufferedWriter( new FileWriter("datoteke/Profesori.txt",true));
			FileWriter fw = new FileWriter("datoteke/Profesori.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush(); 
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (Profesor profesor : sviProfesori) {
				StringBuilder s=new StringBuilder("");
				s.append(profesor.getIme()+"|"+profesor.getPrezime()+"|"+profesor.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"|"+profesor.getAdresaStanovanja()+"|"+ profesor.getKontaktTel()+"|"+ profesor.getEmail()+"|"+ profesor.getAdresa_kancelarije()+"|"+ profesor.getBLK()+"|"+ profesor.getTitula()+"|"+ profesor.getZvanje()+"|");
				for(Predmet st : profesor.getPredmeti()) {
					s.append(st.getSifra_predmeta() + "#");
				}
				s.deleteCharAt(s.length()-1);
				out.write(s.toString());
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	public void saveDataStud(ArrayList<Student> sviStudenti) {
		BufferedWriter out  = null;
		try {
			out = new BufferedWriter( new FileWriter("datoteke/Studenti.txt",true));
			FileWriter fw = new FileWriter("datoteke/Studenti.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush(); 
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (Student student : sviStudenti) {
				out.write(student.getIme()+"|"+student.getPrezime()+"|"+student.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"|"+student.getAdresaStanovanja()+"|"+ student.getKontaktTel()+"|"+ student.getEmail()+"|"+ student.getBrIndex()+"|"+ student.getDatumUpisa().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"|"+ student.getTrenutnaGodina()+"|"+ student.getStatus()+"|"+student.getProsecnaOcena()+"|");
				out.write("\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
