package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BazaPredmeta;
import model.Predmet;

public class AddStudToSubjectFrame extends JFrame{
	private static String idx;
	private static String subjPreIzmene;
	public AddStudToSubjectFrame() {
		
		setLocation(800, 400);
		setSize(500, 200);
		setTitle("Dodavanje studenta na predmet");
		
		JPanel dodajStudentaPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel dugmici=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel dodajStudentaL=new JLabel("Unesite broj indeksa studenta");
		JTextField indeks=new JTextField(20);
		
		dodajStudentaPanel.add(dodajStudentaL);
		dodajStudentaPanel.add(indeks);
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		
		dugmici.add(odustanak);
		dugmici.add(potvrda);
		Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
		String sifra=sub.getSifra_predmeta();
		String naziv=sub.getNaziv();
		String semestar=sub.getSemestar();
		String godina=sub.getGodina();
		String profesor=sub.getPredavac();
		 subjPreIzmene=sifra+"|"+naziv+"|"+semestar+"|"+godina+"|"+profesor;
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		potvrda.addActionListener(new ActionListener() {
			String idxReg="[a-z]+[0-9]+/[0-9]+";

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(indeks.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);

				}else if(!indeks.getText().matches(idxReg)) {
						JOptionPane.showMessageDialog(null, "Indeks nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else {

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
								subjPreIzmene+="|"+ indeks + ",";
								sve+=subjPreIzmene;
								continue;
							}
							sve += sledeci+"\n";
						}
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				setVisible(false);
			}
			
			
		});
		
		
		
		add(dodajStudentaPanel,BorderLayout.NORTH);
		//add(donjiPanel,BorderLayout.SOUTH);
		add(dugmici,BorderLayout.CENTER);
		add(donjiPanel,BorderLayout.SOUTH);

		//idx=indeks.getText();
		
		
		setVisible(true);	
	}
}
