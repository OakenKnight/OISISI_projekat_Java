package controller;

import javax.swing.JFrame;

import model.BazaPredmeta;
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
		//TODO: preraditi metodu da dodaje entitete
		BazaPredmeta.getInstanceBazaPredmeta().addPredmet(sifra, naziv, semestar, godina, profesor);
		
		TabbedPane.getInstance().azurirajPredmeti();
		
		//ne uradi nista, ali ne pukne sad???????
	}
	public void editPredmet() {
		//TODO: preraditi metodu da menja entitete
	}
	public void removePredmet() {
		//TODO: preraditi metodu da brise entitete
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
