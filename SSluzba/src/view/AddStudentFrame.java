package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.StudentiController;
import model.StatusStudent;

public class AddStudentFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6074145523826069140L;
	private static JTextField imePolje;
	private static JTextField prezimePolje;
	private static JTextField datumRodjenjaPolje;
	private static JTextField datumUpisaPolje;
	private static JTextField emailPolje;
	private static JTextField adresaPolje ;
	private static JTextField telefonPolje;
	private static JTextField indexPolje;
	private static JTextField prosekPolje;

	private int god;
	private String finansiranje;
	private StatusStudent stats;
	
	public AddStudentFrame(){
	   // setUndecorated(true);
	    setLocation(800, 300);
		setTitle("Dodavanje studenta");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		JPanel imeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeLabela = new JLabel("Ime* ");
		imePolje = new JTextField();
		imePolje.setPreferredSize(new Dimension(200,25));
		
		imeStudenta.add(imeLabela);
		imeStudenta.add(imePolje);
		
		JPanel prezimeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeLabela = new JLabel("Prezime* ");
		prezimePolje = new JTextField();
		prezimePolje.setPreferredSize(new Dimension(200,25));
		
		prezimeStudenta.add(prezimeLabela);
		prezimeStudenta.add(prezimePolje);
		
		JPanel datumRodjenjaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumRodjenjaLabela = new JLabel("Datum rodjenja* ");
		datumRodjenjaPolje = new JTextField();
		datumRodjenjaPolje.setPreferredSize(new Dimension(200,25));
		
		datumRodjenjaStudenta.add(datumRodjenjaLabela);
		datumRodjenjaStudenta.add(datumRodjenjaPolje);
		
		
		
		JPanel adresaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaLabela = new JLabel("Adresa stanovanja* ");
		adresaPolje= new JTextField();
		adresaPolje.setPreferredSize(new Dimension(200,25));
		
		adresaStudenta.add(adresaLabela);
		adresaStudenta.add(adresaPolje);
		
		JPanel telefonStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonLabela = new JLabel("Broj telefona* ");
		telefonPolje = new JTextField();
		telefonPolje.setPreferredSize(new Dimension(200,25));
		
		telefonStudenta.add(telefonLabela);
		telefonStudenta.add(telefonPolje);
		
		JPanel indexStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel indexLabela = new JLabel("Broj indeksa* ");
		indexPolje = new JTextField();
		indexPolje.setPreferredSize(new Dimension(200,25));
		
		indexStudenta.add(indexLabela);
		indexStudenta.add(indexPolje);
		
		JPanel emailStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabela = new JLabel("Email* ");
		emailPolje = new JTextField();
		emailPolje.setPreferredSize(new Dimension(200,25));
		
		emailStudenta.add(emailLabela);
		emailStudenta.add(emailPolje);
		
		JPanel datumUpisaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumUpisaStudentaLabela = new JLabel("Datum upisa* ");
		datumUpisaPolje = new JTextField();
		datumUpisaPolje.setPreferredSize(new Dimension(200,25));
		
		datumUpisaStudenta.add(datumUpisaStudentaLabela);
		datumUpisaStudenta.add(datumUpisaPolje);
		
		
		JPanel prosekStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prosekLabela = new JLabel("Prosek* ");
		prosekPolje = new JTextField();
		prosekPolje.setPreferredSize(new Dimension(200,25));
		
		prosekStudenta.add(prosekLabela);
		prosekStudenta.add(prosekPolje);
		
		JPanel trenutnaGodStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel trenutnaGodLabela = new JLabel("Trenutna godina studija* ");
		String [] lista = {"I (prva)","II (druga)","III (treca)","IV (druga)"};
		JComboBox<Object> godine = new JComboBox<Object>(lista);
		String godina=godine.getSelectedItem().toString();
		if(godina.equals("I (prva)")) {
			god=1;
		}else if(godina.equals("II (druga)")){
			god=2;
		}else if(godina.equals("III (treca)")){
			god=3;
		}else {
			god=4;
		}
		trenutnaGodStudenta.add(trenutnaGodLabela);
		trenutnaGodStudenta.add(godine);
		
		
		JPanel prvoDugem = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel drugoDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton budzet = new JRadioButton("Budzet",true);
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
		
		ButtonGroup nacinFinansiranja = new ButtonGroup();
		
		nacinFinansiranja.add(budzet);
		nacinFinansiranja.add(samofinansiranje);
		prvoDugem.add(budzet);
		drugoDugme.add(samofinansiranje);
		
		if(budzet.isSelected()==true) {
			stats=StatusStudent.B;
		}else {
			stats=StatusStudent.S;
		}
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		
		
		
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(imePolje.getText().equals("") || prezimePolje.getText().equals("") || datumRodjenjaPolje.getText().equals("") || adresaPolje.getText().equals("") || 
						telefonPolje.getText().equals("") || indexPolje.getText().equals("")  ) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					BufferedWriter out  = null;
					try {
						out = new BufferedWriter( new FileWriter("datoteke/Studenti.txt",true));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						out.write("\n");
						out.write(imePolje.getText()+"|"+prezimePolje.getText()+"|"+datumRodjenjaPolje.getText()+"|"+adresaPolje.getText()+"|"+telefonPolje.getText()+"|");

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
					
					StudentiController.getInstance().addStudent(imePolje.getText(), prezimePolje.getText(), datumRodjenjaPolje.getText(), adresaPolje.getText(), telefonPolje.getText(), emailPolje.getText(),indexPolje.getText(), datumUpisaPolje.getText(),god, stats, Double.parseDouble(prosekPolje.getText()));
			
					setVisible(false);
					dispose();
				}
				
			}
		});
		
		
		odustanakPotvrda.add(odustanak);
		odustanakPotvrda.add(potvrda);

		Box obrazac = Box.createVerticalBox();
		obrazac.add(Box.createVerticalStrut(14));
		obrazac.add(imeStudenta);
		obrazac.add(prezimeStudenta);
		obrazac.add(datumRodjenjaStudenta);
		obrazac.add(adresaStudenta);
		obrazac.add(telefonStudenta);
		obrazac.add(datumUpisaStudenta);
		obrazac.add(emailStudenta);
		obrazac.add(indexStudenta);
		obrazac.add(trenutnaGodStudenta);
		obrazac.add(prosekStudenta);
		obrazac.add(prvoDugem);
		obrazac.add(drugoDugme);
		obrazac.add(odustanakPotvrda);
		obrazac.add(Box.createGlue());
		
		
		
		this.add(obrazac,BorderLayout.CENTER);
		
		this.add(donjiPanel,BorderLayout.SOUTH);

		setSize(400, 600);
		setVisible(true);
		
	}
	
	
}
