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
		try {
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
					boolean imaUEvidenciji = false;
					boolean odgovarajucaGodina = false;
					Predmet proveraGodine = new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
					int g =-1;
					if(proveraGodine.getGodina().equals("Prva godina"))
						g = 1;
					else if(proveraGodine.getGodina().equals("Druga godina"))
						g = 2;
					else if(proveraGodine.getGodina().equals("Treca godina"))
						g = 3;
					else
						g = 4;
					
					String s = indeks.getText();
					for(Student stud : BazaStudenata.getInstance().getStudenti()) {
						if(s.equals(stud.getBrIndex())){
							imaUEvidenciji = true;
							
							if(stud.getTrenutnaGodina() == g) {
								odgovarajucaGodina = true;
							}
						}
					}
					
					
					if(indeks.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
	
					}else if(!indeks.getText().matches(idxReg)) {
							JOptionPane.showMessageDialog(null, "Indeks nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
					}else if(!imaUEvidenciji){
						JOptionPane.showMessageDialog(null, "Student sa unetim indeksom nije u evidenciji!","",JOptionPane.ERROR_MESSAGE);
					}else if(!odgovarajucaGodina){
						JOptionPane.showMessageDialog(null, "Student sa unetim indeksom ne slusa oznaceni predmet!","",JOptionPane.ERROR_MESSAGE);
					}else{
						
						Predmet p = BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed );
						if(p.getBrIndeksaStudenata().size() == 1 ) {
							if( p.getBrIndeksaStudenata().get(0).getBrIndex().equals("nepoznato") ) {
								p.getBrIndeksaStudenata().remove(0);
							}
						}
						Student zaUnos = null;
						for(Student stud : BazaStudenata.getInstance().getStudenti()) {
							if(s.equals(stud.getBrIndex())) {
								zaUnos = new Student(stud);
								stud.getPredmeti().add(p);
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Niste selektovali predmet na koji zelite da dodate studenta!","",JOptionPane.ERROR_MESSAGE);

		}
	}
}
