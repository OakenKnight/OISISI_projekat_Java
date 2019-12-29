package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;

public class Menu extends JMenuBar{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2401343171737574518L;

	public Menu() {
		//Pravljenje  File menija i pravljenje i dodavanje itema
		JMenu file = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New",new ImageIcon("images/plus.png"));
		//dodao sam ti acceleratore
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		JMenuItem closeItem = new JMenuItem("Close",new ImageIcon("images/x.png"));
		closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		file.add(newItem);
		file.addSeparator();
		file.add(closeItem);
		//Pravljenje  Edit menija i pravljenje i dodavanje itema
		JMenu edit = new JMenu("Edit");
		JMenuItem editItem = new JMenuItem("Edit");
		JMenuItem deleteItem = new JMenuItem("Delete");
		edit.add(editItem);
		edit.addSeparator();
		edit.add(deleteItem);
		//Pravljenje  Help menija i pravljenje i dodavanje itema
		JMenu help = new JMenu("Help");
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		help.add(helpItem);
		help.addSeparator();
		help.add(aboutItem);
		
		newItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabbedPane.getInstance().getSelectedIndex() == 0) {
					AddStudentFrame diag = new AddStudentFrame();
					diag.setVisible(true);
				}else if(TabbedPane.getInstance().getSelectedIndex() == 1) {
					AddProfFrame diag = new AddProfFrame();
					diag.setVisible(true);
				}else if(TabbedPane.getInstance().getSelectedIndex() == 2) {
					AddSubjFrame diag = new AddSubjFrame();
					diag.setVisible(true);
				}
				
			}
		});
		
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		editItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabbedPane.getInstance().getSelectedIndex() == 0) {
					EditStudFrame diag = new EditStudFrame();
					diag.setVisible(true);
				}else if(TabbedPane.getInstance().getSelectedIndex() == 1) {
					EditProfFrame diag = new EditProfFrame();
					diag.setVisible(true);
				}else if(TabbedPane.getInstance().getSelectedIndex() == 2) {
					EditSubjFrame diag = new EditSubjFrame();
					diag.setVisible(true);
				}
				
			
				
			}
		});
		
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabbedPane.getInstance().getSelectedIndex() == 0) {
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje studenta?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().selektovanRed);

						
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());	
					}
				}else if(TabbedPane.getInstance().getSelectedIndex() == 1) {
					try {
						int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje profesora?",JOptionPane.YES_NO_OPTION);
						if(option==JOptionPane.YES_OPTION) {
							Profesor prof =new Profesor(BazaProfesori.getInstance().getRow(ProfesoriJTable.getInstance().selektovanRed));
							
							String ime=prof.getIme();
							String prezime=prof.getPrezime();
							LocalDate datum=prof.getDatumRodjenja();
							String adresa=prof.getAdresaStanovanja();
							String telefon=prof.getKontaktTel();
							String email=prof.getEmail();
							String kancelarija=prof.getAdresa_kancelarije();
							String blk=prof.getBLK();
							String titula=prof.getTitula();
							String zvanje=prof.getZvanje();
							
							ProfesorController.getInstance().removeProfesor(ime, prezime, datum, adresa, telefon, email, kancelarija, blk, titula, zvanje);
							
							}
						}catch (Exception e) {

						System.out.println(e.getMessage());
						}
				}else if(TabbedPane.getInstance().getSelectedIndex() == 2) {
					/*RemoveSubjectFrame rm=new RemoveSubjectFrame();
					rm.setVisible(true);
					*/
					
					try {
						int option=JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Brisanje predmeta?",JOptionPane.YES_NO_OPTION);
						if(option==JOptionPane.YES_OPTION) {
							Predmet sub=new Predmet(BazaPredmeta.getInstanceBazaPredmeta().getRow(PredmetiJTable.getInstance().selektovanRed));
							String sifra=sub.getSifra_predmeta();
							String naziv=sub.getNaziv();
							String semestar=sub.getSemestar();
							String godina=sub.getGodina();
							String profesor=sub.getPredavac();
						//String subjPreIzmene=sifra+"|"+naziv+"|"+semestar+"|"+godina+"|"+profesor;
						/*
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
						*/
						PredmetController.getInstance().removePredmet(sifra,naziv,semestar,godina,profesor);
						
						}
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
				}
				
			}
		});
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}
