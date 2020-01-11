package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.StudentiController;
import model.BazaStudenata;
import model.StatusStudent;
import model.Student;

public class EditStudFrame extends JDialog{
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
	private StatusStudent stats;
	
	public EditStudFrame() {
		
		// RUCNO UNETI STUDENTI SE NE MOGU MENJATI NA NIVOU DATOTEKE 
		  
	   // setUndecorated(true);
		try {
		setModal(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
			
		setSize(2*screenWidth/9,3*screenHeight/8);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje studenta");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		JPanel imeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeLabela = new JLabel("Ime* ");
		imePolje = new JTextField();
		imePolje.setPreferredSize(new Dimension(200,25));
		imePolje.setToolTipText("npr. Ivan");

		imeStudenta.add(imeLabela);
		imeStudenta.add(imePolje);
		
		JPanel prezimeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeLabela = new JLabel("Prezime* ");
		prezimePolje = new JTextField();
		prezimePolje.setPreferredSize(new Dimension(200,25));
		prezimePolje.setToolTipText("npr. Ivanović");

		prezimeStudenta.add(prezimeLabela);
		prezimeStudenta.add(prezimePolje);
		
		JPanel datumRodjenjaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumRodjenjaLabela = new JLabel("Datum rodjenja* ");
		datumRodjenjaPolje = new JTextField();
		datumRodjenjaPolje.setPreferredSize(new Dimension(200,25));
		datumRodjenjaPolje.setToolTipText("npr. 19.09.1999");

		datumRodjenjaStudenta.add(datumRodjenjaLabela);
		datumRodjenjaStudenta.add(datumRodjenjaPolje);
		
		JPanel adresaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaLabela = new JLabel("Adresa stanovanja* ");
		adresaPolje= new JTextField();
		adresaPolje.setPreferredSize(new Dimension(200,25));
		adresaPolje.setToolTipText("npr. Karađorđeva 83, Novi Sad");

		adresaStudenta.add(adresaLabela);
		adresaStudenta.add(adresaPolje);
		
		JPanel telefonStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonLabela = new JLabel("Broj telefona* ");
		telefonPolje = new JTextField();
		telefonPolje.setPreferredSize(new Dimension(200,25));
		telefonPolje.setToolTipText("npr. 024/333-559");

		telefonStudenta.add(telefonLabela);
		telefonStudenta.add(telefonPolje);
		
		JPanel indexStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel indexLabela = new JLabel("Broj indeksa* ");
		indexPolje = new JTextField();
		indexPolje.setPreferredSize(new Dimension(200,25));
		indexPolje.setEnabled(false);
		indexPolje.setToolTipText("npr. RA201/2017");

		indexStudenta.add(indexLabela);
		indexStudenta.add(indexPolje);
		
		JPanel emailStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabela = new JLabel("Email* ");
		emailPolje = new JTextField();
		emailPolje.setPreferredSize(new Dimension(200,25));
		emailPolje.setToolTipText("npr. ivan.ivanovic@aol.com");

		emailStudenta.add(emailLabela);
		emailStudenta.add(emailPolje);
		
		JPanel datumUpisaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumUpisaStudentaLabela = new JLabel("Datum upisa* ");
		datumUpisaPolje = new JTextField();
		datumUpisaPolje.setPreferredSize(new Dimension(200,25));
		datumUpisaPolje.setToolTipText("npr. 12.07.2017");

		datumUpisaStudenta.add(datumUpisaStudentaLabela);
		datumUpisaStudenta.add(datumUpisaPolje);
		
		
		JPanel prosekStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prosekLabela = new JLabel("Prosek* ");
		prosekPolje = new JTextField();
		prosekPolje.setPreferredSize(new Dimension(200,25));
		prosekPolje.setToolTipText("npr. 6.66");

		prosekStudenta.add(prosekLabela);
		prosekStudenta.add(prosekPolje);
		
		JPanel trenutnaGodStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel trenutnaGodLabela = new JLabel("Trenutna godina studija* ");
		String [] lista = {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
		JComboBox<Object> godine = new JComboBox<Object>(lista);
		
		trenutnaGodStudenta.add(trenutnaGodLabela);
		trenutnaGodStudenta.add(godine);
		
		
		JPanel prvoDugem = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel drugoDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton budzet = new JRadioButton("Budzet");
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
		
		ButtonGroup nacinFinansiranja = new ButtonGroup();
		
		nacinFinansiranja.add(budzet);
		nacinFinansiranja.add(samofinansiranje);
		prvoDugem.add(budzet);
		drugoDugme.add(samofinansiranje);
		
		
			Student st = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelektovanRed()));
			imePolje.setText(st.getIme());
			prezimePolje.setText(st.getPrezime());
			datumRodjenjaPolje.setText(st.getDatumRodjenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
			adresaPolje.setText(st.getAdresaStanovanja());
			telefonPolje.setText(st.getKontaktTel());
			emailPolje.setText(st.getEmail());
			indexPolje.setText(st.getBrIndex());
			datumUpisaPolje.setText(st.getDatumUpisa().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
			prosekPolje.setText(String.valueOf(st.getProsecnaOcena()));
			if(st.getTrenutnaGodina() == 1)
				godine.setSelectedItem("I (prva)");
			else if(st.getTrenutnaGodina() == 2)
				godine.setSelectedItem("II (druga)");
			else if(st.getTrenutnaGodina() == 3)
				godine.setSelectedItem("III (treca)");
			else
				godine.setSelectedItem("IV (cetvrta)");
			
			
			if(st.getStatus() == StatusStudent.B)
				budzet.setSelected(true);
			else
				samofinansiranje.setSelected(true);
			
			if(budzet.isSelected()) {
				stats=StatusStudent.B;
			}else {
				stats=StatusStudent.S;
			}
			
			String godina = godine.getSelectedItem().toString();
			if(godina.equals("I (prva)")) {
				god=1;
			}else if(godina.equals("II (druga)")){
				god=2;
			}else if(godina.equals("III (treca)")){
				god=3;
			}else {
				god=4;
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

			String imeReg="[a-žA-Ž]+";
			String adresaReg="[a-žA-Ž0-9 ]*[,][ a-žA-Ž]+";
			String telReg="[0-9]+/[0-9]+[-][0-9]+";
			String emailReg="[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+";
			String idxReg="[A-Z]+[0-9]+/[0-9]+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(imePolje.getText().equals("") || prezimePolje.getText().equals("") || datumRodjenjaPolje.getText().equals("") || adresaPolje.getText().equals("") || 
						telefonPolje.getText().equals("") || indexPolje.getText().equals("")  || datumUpisaPolje.getText().equals("") || emailPolje.getText().equals("") || prosekPolje.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
					
				}else if(!imePolje.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Ime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!prezimePolje.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumRodjenjaPolje.getText())){
					JOptionPane.showMessageDialog(null, "Datum rodjenja nije unesen kako treba! (dd.MM.yyyy)","",JOptionPane.ERROR_MESSAGE);
				}else if(!adresaPolje.getText().trim().matches(adresaReg)) {
					JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!telefonPolje.getText().matches(telReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailPolje.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!indexPolje.getText().matches(idxReg)) {
					JOptionPane.showMessageDialog(null, "Indeks nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumUpisaPolje.getText())){
					JOptionPane.showMessageDialog(null, "Datum upisa nije unesen kako treba! (dd.MM.yyyy)","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriProsek(prosekPolje.getText())){
					JOptionPane.showMessageDialog(null, "Prosek nije unesen kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else {
					
					
					if(budzet.isSelected()) {
						stats=StatusStudent.B;
					}else {
						stats=StatusStudent.S;
					}
					
					String godina = godine.getSelectedItem().toString();
					if(godina.equals("I (prva)")) {
						god=1;
					}else if(godina.equals("II (druga)")){
						god=2;
					}else if(godina.equals("III (treca)")){
						god=3;
					}else {
						god=4;
					}
					
					String [] datum1 = datumRodjenjaPolje.getText().split("\\.");
					String [] datum2 = datumUpisaPolje.getText().split("\\.");
					LocalDate lc1 = LocalDate.of(Integer.parseInt(datum1[2]), Integer.parseInt(datum1[1]), Integer.parseInt(datum1[0]));
					LocalDate lc2 = LocalDate.of(Integer.parseInt(datum2[2]), Integer.parseInt(datum2[1]), Integer.parseInt(datum2[0]));
					
					StudentiController.getInstance().editStudent(imePolje.getText(), prezimePolje.getText(), lc1, adresaPolje.getText(), telefonPolje.getText(), emailPolje.getText(),indexPolje.getText(), lc2,god, stats, Double.parseDouble(prosekPolje.getText()));
					
					setVisible(false);
					dispose();
				}
				

				
			}
			private boolean proveriProsek( String text ) {
				// TODO Auto-generated method stub
				String prosekReg="[0-9]*[0-9][.][0-9][0-9]*";
				if(text.matches(prosekReg)) {
					if(text.isEmpty()==false) {
						Double ocena=Double.parseDouble(text);
						if(ocena<=10.0) {
							if(ocena>=6.0) {
								return true;
							}
						}else {
							return false;
						}
					}
				}
				return false;
			}
			
			private boolean proveriDatum(String text) {
				// TODO Auto-generated method stub
				if(!text.isEmpty()) {
					

					String regexdatum="^\\d{2,2}\\.\\d{2,2}\\.\\d{4}$";
					
					if(!text.matches(regexdatum)) {
						return false;
					}else {
						String[] datumi=text.split("\\.");
						int dan=Integer.parseInt(datumi[0]);
						int mesec=Integer.parseInt(datumi[1]);

						if(dan<1) {
							return false;
						}else if(mesec>12) {
							return false;
						}else if(mesec<1) {
							return false;
						}else if(mesec==2) {
							if(dan>29 ) {
								return false;
							}
						}else if(mesec==1 || mesec==3 || mesec==5 || mesec==7 ||mesec==8 || mesec==10 || mesec==12) {
							if(dan>31) {
								return false;
							}
						}else if(mesec==4 || mesec==6 || mesec==9 || mesec==11) {
							if(dan>30) {
								return false;
							}
						}
						return true;
						}
					}
				return false;
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
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Nije selektovan student!","",JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
			
		}
		
	}
}
