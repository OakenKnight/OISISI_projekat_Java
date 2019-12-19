package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student;
import view.StudentiJTable;
import view.TabbedPane;

public class DeleteStudentMouseListener extends MouseAdapter{

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex() == 0) {
			int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje studenta?",JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				Student st = new Student(BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().selektovanRed));
				String studentZaBrisanje = st.getIme().trim()+"|"+st.getPrezime().trim()+"|"+st.getDatumRodjenja().trim()+"|"+st.getAdresaStanovanja().trim()+"|"+st.getKontaktTel().trim()+"|"+st.getEmail().trim()+"|"+st.getBrIndex().trim()+"|"+st.getDatumUpisa().trim()+"|"+st.getTrenutnaGodina()+"|"+st.getStatus()+"|"+st.getProsecnaOcena();
				String sledeci;
				String sve = "";
				BufferedReader in = null;
				try {
					in = new BufferedReader(new InputStreamReader(new FileInputStream("datoteke/Studenti.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while((sledeci = in.readLine()) != null) {
						sledeci.trim();
						if(sledeci.equals(studentZaBrisanje)) {
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
					out = new BufferedWriter( new FileWriter("datoteke/Studenti.txt"));
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
				StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().selektovanRed);
			}
			
		}
		
	}		
}