package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HelpFrame extends JFrame{
	public HelpFrame (){
		setLocationRelativeTo(null);
		setTitle("Uputstvo");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(101,23));
		TextArea uputstvo = new TextArea();
		uputstvo.setText("1) FUNKCIONALNOSTI NAD TIPOM ENTITETA STUDENT\n"
				+ "1.1) Prikaz studenata: \n"
				+ "Informacije o svim studentima koji se nalaze u evidenciji prikazane su u tabu 'Studenti'. Klikom na naziv svake od kolona\n"
				+ "moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone. Takodje, moguce je vrsiti promenu redosleda \n"
				+ "kolona klikom na naziv kolone i prevlacenjem iste na zeljeno mesto.Poslednja kolona omogucava prikaz svih predmeta ciju nastavu\n"
				+ "pohadja izabrani student.\n"
				+ "1.2) Dodavanje novog studenta: \n"
				+ "Klikom na prvo dugme u tulbaru otvara se obrazac za unos novog studenta. Ovom obrascu je moguce pristupiti i kroz meni izborom\n"
				+ "seldecih akcija: File -> New ili pomocu precice Ctrl+N. Potrebno je popuniti sva polja i kliknuti na dugme 'Potvrdi'. Sledi primer\n"
				+ "ispravnog unosa:\nIme: Pera\nPrezime: Perić\nDatum rodjenja: 01.01.2001\nAdresa stanovanja: Karađorđeva 83, Novi Sad\nBroj telefona: 021/123-123\nDatum upisa: 07.10.2020\nEmail: pera.peric@gmail.com\nBroj indeksa: RA1/2020\nTrenutna godina studija: I(Prva)\nProsek: 10.00\nBudzet\n"
				+ "Nemoguce je uneti studenta ukoliko se navedeni broj indeksa vec nalazi u evidenciji!. Takodje, nije moguce naknadno vrsiti\n"
				+ "izmenu broja indeksa postojeceg studenta\n"
				+ "1.3) Brisanje postojeceg studenta: \n"
				+ "Potrebno je oznaciti studenta u tabeli i zatim kliknuti na dugme za brisanje entiteta (trece u tulbaru).Brisanje studenta\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Delete ili pomocu precice Ctrl+D. Ukoliko se potvrdi brisanje,\n"
				+ "nemoguce je naknadno vratiti izbrisane entitete\n"
				+ "1.4) Izmena postojeceg studenta: \n"
				+ "Potrebno je oznaciti studenta u tabeli i zatim kliknuti na dugme za izmenu entiteta (drugo u tulbaru).Izmenu studenta\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Edit ili pomocu precice Ctrl+E. Kada se pojavi obrazac za izmenu\n"
				+ "studenta potrebno je promeniti zeljena polja i kliknuti na dugme 'Potvrdi'. Nije moguce vrsiti izmenu broja indeksa!!!\n"
				+ "1.5) Pretraga studenata:\n"
				+ "U polje za pretragu studenata potrebno je uneti podatke koje poseduju trazeni studenti. Obrazac prema kome je potrebno uneti\n"
				+ "podatke se pojavljuje prilikom zadrzavanja kursora na polju za pretragu. Sledi primer ispravnog upisa podataka:\n"
				+ "godina:2|prosek:9.00\n"
				+ "Nakon pispravno unesenih podataka potrebno je kliknuti na dugme za pretragu. Pomocu dugmeta za reset moguce je vratiti se\n"
				+ "na prvobitan prikaz svih studenata (skroz desno dugme u toolbaru)\n\n"
				+ "2) FUNKCIONALNOSTI NAD TIPOM ENTITETA PROFESOR\n"
				+ "2.1) Prikaz profesora: \n"
				+ "Informacije o svim profesorima koji se nalaze u evidenciji prikazane su u tabu 'Profesori'. Klikom na naziv svake od kolona\n"
				+ "moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone. Takodje, moguce je vrsiti promenu redosleda \n"
				+ "kolona klikom na naziv kolone i prevlacenjem iste na zeljeno mesto.Poslednja kolona omogucava prikaz svih predmeta na kojima \n"
				+ "izabrani profesor drzi nastavu.\n"
				+ "2.2) Dodavanje novog profesora: \n"
				+ "Klikom na prvo dugme u tulbaru otvara se obrazac za unos novog profesora. Ovom obrascu je moguce pristupiti i kroz meni izborom\n"
				+ "seldecih akcija: File -> New ili pomocu precice Ctrl+N. Potrebno je popuniti sva polja i kliknuti na dugme 'Potvrdi'. Sledi primer\n"
				+ "ispravnog unosa:\nIme: Pera\nPrezime: Perić\nDatum rodjenja: 01.01.2001\nAdresa stanovanja: Karađorđeva 83, Novi Sad\nBroj telefona: 021/123-123\nEmail: pera.peric@gmail.com\nAdresa kancelarije: Dositeja Obradovića 6, Novi Sad, MI 105\nBroj licne karte: 123456789\nTitula: BSc\nZvanje: Asistent\n"
				+ "Nemoguce je uneti profesora ukoliko se navedeni broj licne katre vec nalazi u evidenciji!. Takodje, nije moguce naknadno vrsiti\n"
				+ "izmenu broja licne karte postojeceg profesora\n"
				+ "2.3) Brisanje postojeceg profesora: \n"
				+ "Potrebno je oznaciti profesora u tabeli i zatim kliknuti na dugme za brisanje entiteta (trece u tulbaru).Brisanje profesora\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Delete ili pomocu precice Ctrl+D. Ukoliko se potvrdi brisanje,\n"
				+ "nemoguce je naknadno vratiti izbrisane entitete\n"
				+ "2.4) Izmena postojeceg profesora: \n"
				+ "Potrebno je oznaciti profesora u tabeli i zatim kliknuti na dugme za izmenu entiteta (drugo u tulbaru).Izmenu profesora\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Edit ili pomocu precice Ctrl+E. Kada se pojavi obrazac za izmenu\n"
				+ "profesora potrebno je promeniti zeljena polja i kliknuti na dugme 'Potvrdi'. Nije moguce vrsiti izmenu broja licne karte!!!\n"
				+ "2.5) Pretraga profesora:\n"
				+ "U polje za pretragu profesora potrebno je uneti podatke koje poseduju trazeni profesor. Obrazac prema kome je potrebno uneti\n"
				+ "podatke se pojavljuje prilikom zadrzavanja kursora na polju za pretragu. Sledi primer ispravnog upisa podataka:\n"
				+ "titula:PhD|zvanje:Docent\n"
				+ "Nakon pispravno unesenih podataka potrebno je kliknuti na dugme za pretragu. Pomocu dugmeta za reset moguce je vratiti se\n"
				+ "na prvobitan prikaz svih profesora (skroz desno dugme u toolbaru)\n\n"
				+ "3) FUNKCIONALNOSTI NAD TIPOM ENTITETA PREDMET\n"
				+ "3.1) Prikaz predmeta: \n"
				+ "Informacije o svim predmetima koji se nalaze u evidenciji prikazane su u tabu 'Predmeti'. Klikom na naziv svake od kolona\n"
				+ "moguce je vrsiti opadajuce ili rastuce sortiranje prema vrednosti izabrane kolone. Takodje, moguce je vrsiti promenu redosleda \n"
				+ "kolona klikom na naziv kolone i prevlacenjem iste na zeljeno mesto. Poslednja kolona omogucava prikaz svih studenata koji slusaju\n"
				+ "izabrani predmet. Nakon klika na dugme 'Prikazi', u prozoru koji se pojavljuje, pored uvida u sve studente koji slusaju izabrani\n"
				+ "predmet moguce je i vrsiti brisanje studenata sa predmeta. Potrebno je oznaciti studenta za brisanje i klikom na dugme 'Obrisi'\n"
				+ "izabrani student bice obrisan sa predmeta\n"
				+ "3.2) Dodavanje novog predmeta: \n"
				+ "Klikom na prvo dugme u tulbaru otvara se obrazac za unos novog predmeta. Ovom obrascu je moguce pristupiti i kroz meni izborom\n"
				+ "seldecih akcija: File -> New ili pomocu precice Ctrl+N. Potrebno je popuniti sva polja i kliknuti na dugme 'OK'. Sledi primer\n"
				+ "ispravnog unosa:\nSifra predmeta: PP123\nNaziv predmeta: Matematika\nSemestar: Letnji\nGodina: Prva\nProfesor(BLK): 123456789\n"
				+ "Nemoguce je uneti predmet ukoliko se navedena sifra predmeta vec nalazi u evidenciji!. Takodje, nije moguce naknadno vrsiti\n"
				+ "izmenu sifre predmeta postojeceg predmeta. Polje za unos profesora je opciono\n"
				+ "3.3) Brisanje postojeceg predmeta: \n"
				+ "Potrebno je oznaciti predmet u tabeli i zatim kliknuti na dugme za brisanje entiteta (trece u tulbaru).Brisanje predmeta\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Delete ili pomocu precice Ctrl+D. Ukoliko se potvrdi brisanje,\n"
				+ "nemoguce je naknadno vratiti izbrisane entitete\n"
				+ "3.4) Izmena postojeceg predmeta: \n"
				+ "Potrebno je oznaciti predmet u tabeli i zatim kliknuti na dugme za izmenu entiteta (drugo u tulbaru).Izmenu predmeta\n"
				+ "je moguce sprovesti i kroz meni izborom opcije Edit -> Edit ili pomocu precice Ctrl+E. Kada se pojavi obrazac za izmenu\n"
				+ "predmeta potrebno je promeniti zeljena polja i kliknuti na dugme 'Potvrdi'. Nije moguce vrsiti izmenu sifre predmeta!!!\n"
				+ "3.5) Pretraga predmeta:\n"
				+ "U polje za pretragu predmeta potrebno je uneti podatke koje poseduju trazeni predmet. Obrazac prema kome je potrebno uneti\n"
				+ "podatke se pojavljuje prilikom zadrzavanja kursora na polju za pretragu. Sledi primer ispravnog upisa podataka:\n"
				+ "semestar:Letnji|godina:Prva\n"
				+ "Nakon pispravno unesenih podataka potrebno je kliknuti na dugme za pretragu. Pomocu dugmeta za reset moguce je vratiti se\n"
				+ "na prvobitan prikaz svih predmeta\n"
				+ "3.6) Dodavanje studenta na predmet: \n"
				+ "Potrebno je oznaciti predmet u tabeli i zatim kliknuti na dugme za dodavanje studenta(cetvrto u tulbaru). Nakon sto se pojavi\n"
				+ "obrazac za unos studenta, potrebno je uneti broj indeksa i klikom na dugme 'Potvrdi' uneti student bice dodat na predmet. Na \n"
				+ "odredjeni predmet moguce je dodati samo one studenti koji su trenutno na godini studija na kojoj se realizuje nastava za izabrani\n"
				+ "predmet.\n"
				+ "3.7) Dodavanje profesora na predmet: \n"
				+ "Potrebno je oznaciti predmet u tabeli i zatim kliknuti na dugme za dodavanje profesora(peto u tulbaru). Nakon sto se pojavi\n"
				+ "obrazac za unos profesora, potrebno je uneti broj licne karte i klikom na dugme 'Potvrdi' uneti profesor bice dodat na predmet.\n"
				+ "Ukoliko vec postoji profesor na izabranom predmetu, potrebno je izbrisati postojeci broj licne karte i uneti broj licne\n"
				+ "zeljenog profesora.\n"
				+ "3.8) Brisanje profesora sa predmeta:\n"
				+ "Potrebno je oznaciti predmet u tabeli i zatim kliknuti na dugme za brisanje profesora(sesto u tulbaru). Nakon potvrde bice obrisan\n"
				+ "profesor sa izabranog predmeta (skroz desno dugme u toolbaru)\n"
				+ "4) OSTALE FUNKCIONALNOSTI:\n"
				+ "4.1) Gasenje aplikacije: \n"
				+ "Gasenje aplikacije moguce je izvrsiti na 'x' u gornjem desnom cosku, odabirom opcije Exit iz File padajuceg menija (File->Exit), ali i pomocu precice Ctrl+C! \n"
				+ "4.2) Otvaranje Help:\n"
				+ "Odabirom opcije Help iz Help menija (Help->Help), ali i pomocu precice Ctrl+H\n"
				+ "4.3) Otvaranje About: \n"
				+ "Odabirom opcije About iz Help menija (Help->About), ali i pomocu precice Ctrl+A\n");
		//uputstvo.setEnabled(false);
		uputstvo.setEditable(false);
		
		
		JPanel panelZaDugme = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btn = new JButton("Cancel");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
		panelZaDugme.add(btn);
		
		Box struktura = Box.createVerticalBox();
		struktura.add(panelZaDugme);
		struktura.add(donjiPanel);
		struktura.setPreferredSize(new Dimension(50,50));
		this.add(uputstvo,BorderLayout.CENTER);
		this.add(struktura,BorderLayout.SOUTH);
		setSize(830, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
