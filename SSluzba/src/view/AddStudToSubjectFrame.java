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
import model.BazaStudenata;
import model.Predmet;
import model.Student;

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
			String idxReg="[a-zA-Z]+[0-9]+/[0-9]+";

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean moze = false;
				String s = indeks.getText();
				for(Student stud : BazaStudenata.getInstance().getStudenti()) {
					if(s.equals(stud.getBrIndex())){
						moze = true;
					}
				}
				if(indeks.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);

				}else if(!indeks.getText().matches(idxReg)) {
						JOptionPane.showMessageDialog(null, "Indeks nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!moze){
					JOptionPane.showMessageDialog(null, "Student sa unetim indeksom nije u evidenciji!","",JOptionPane.ERROR_MESSAGE);
				}else {
					
					Predmet p = BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed );
					Student zaUnos = null;
					for(Student stud : BazaStudenata.getInstance().getStudenti()) {
						if(s.equals(stud.getBrIndex())) {
							zaUnos = new Student(stud);
						}
					}
					for(Predmet pred : BazaPredmeta.getInstanceBazaPredmeta().getPredmeti()) {
						if(p.getSifra_predmeta().equals(pred.getSifra_predmeta())) {
							pred.getBrIndeksaStudenata().add(zaUnos);
						}
					}
					
					
					setVisible(false);
					dispose();
					
				}
				
				
				
					
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
