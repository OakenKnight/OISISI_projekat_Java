package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.BazaPredmeta;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.AbstractTableModelPredmeti;
import view.PredmetiJTable;
import view.TabbedPane;

public class PredmetController {
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	private PredmetController() {}

	public void addPredmet(String sifra,String naziv,String semestar,String godina,String profesor) {
		BazaPredmeta.getInstanceBazaPredmeta().addPredmet(sifra, naziv, semestar, godina, profesor);
		
		TabbedPane.getInstance().azurirajPredmeti();
		
	}
	public void editPredmet(String sifra,String naziv,String semestar,String godina,String profesor) {
		BazaPredmeta.getInstanceBazaPredmeta().editPredmet(sifra, naziv, semestar, godina, profesor);		
		TabbedPane.getInstance().azurirajPredmeti();
	}
	public void removePredmet(String sifra,String naziv,String semestar,String godina,String profesor) {
		BazaPredmeta.getInstanceBazaPredmeta().deletePredmet(sifra);		
		TabbedPane.getInstance().azurirajPredmeti();
	}
	public void searchEntity(String uneseno) {
		BazaPredmeta.getInstanceBazaPredmeta().searchPredmet(uneseno);
		
		TabbedPane.getInstance().azurirajPredmeti();
	}
	public void resetSearch() {
		// TODO Auto-generated method stub
		BazaPredmeta.getInstanceBazaPredmeta().resetSearchPredmet();
		TabbedPane.getInstance().azurirajPredmeti();
	}
	public void changeProf(String stariProf, String noviProf, Predmet p) {
		BazaPredmeta.getInstanceBazaPredmeta().izmeniProfesora(stariProf,noviProf,p);
		TabbedPane.getInstance().azurirajPredmeti();
		
	}
}
