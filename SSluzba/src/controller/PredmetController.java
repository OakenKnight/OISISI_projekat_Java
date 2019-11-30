package controller;

import javax.swing.JFrame;

public class PredmetController {
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	private PredmetController() {}

	public void addPredmet() {
		//TODO: preraditi metodu da dodaje entitete
		JFrame unosPredmeta = new JFrame();
		
		unosPredmeta.setVisible(true);
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
