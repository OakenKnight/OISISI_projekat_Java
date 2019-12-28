package controller.listeners.remove;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import view.PredmetiJTable;

public class RemoveSubjectFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2296351424625686775L;
	/**
	 * 
	 */
	private  String sifra;
	private  String naziv;
	private  String semestar;
	private  String godina;
	private  String profesor;
	private  String subjPreIzmene;
	
	public RemoveSubjectFrame() {
		//setLocation(800, 300);
		setTitle("Brisanje predmeta");
		
		JPanel removeSubPanel=new JPanel(new FlowLayout());
		
		removeSubPanel.setBackground(Color.GRAY);
		removeSubPanel.setPreferredSize(new Dimension(100,23));	
		setLocationRelativeTo(null);
		Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
		sifra=sub.getSifra_predmeta();
		naziv=sub.getNaziv();
		semestar=sub.getSemestar();
		godina=sub.getGodina();
		profesor=sub.getPredavac();
		subjPreIzmene=sifra+"|"+naziv+"|"+semestar+"|"+godina+"|"+profesor;
		
			
		JButton okBtn=new JButton("Ok");
		okBtn.setToolTipText("Potvrdi");
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sledeci;
				String sve="";
				
				BufferedReader in=null;
				
				try {
					in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Predmeti.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while((sledeci = in.readLine()) != null) {
						sledeci.trim();
						if(sledeci.equals(subjPreIzmene)) {
							continue;
						}
						sve += sledeci+"\n";
					}
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter out  = null;
				try {
					out = new BufferedWriter( new FileWriter("datoteke/Predmeti.txt"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.write(sve);

				} catch (IOException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(out != null)
						try {
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
				PredmetController.getInstance().removePredmet(sifra,naziv,semestar,godina,profesor);
				
				setVisible(false);
				
				
				dispose();
			}
			
			
		});
		
		JButton cancelBtn=new JButton("Cancel");
		cancelBtn.setToolTipText("Odustani");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO ugasi taj window
				setVisible(false);
				dispose();
				
			}
		});
		removeSubPanel.add(cancelBtn);
		removeSubPanel.add(okBtn);
		
		
		add(removeSubPanel);
		//setPreferredSize(new Dimension(200,100));
		setSize(300, 100);
		setVisible(true);
	}
}
