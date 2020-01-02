package controller.listeners.remove;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import controller.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesori;
import model.BazaStudenata;
import model.Predmet;
import model.StatusStudent;
import model.Student;
import view.StudentiJTable;
import view.TabbedPane;

public class RemoveStudListener extends MouseAdapter{

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex() == 0) {
			try {
				int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje studenta?",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					Student studentZaBrisanje = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().selektovanRed);
					StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().selektovanRed);
					for(Predmet p : BazaPredmeta.getInstanceBazaPredmeta().getPredmeti()) {
						if(p.getBrIndeksaStudenata().contains(studentZaBrisanje)) {
							if(p.getBrIndeksaStudenata().size() == 1) {
								p.getBrIndeksaStudenata().remove(studentZaBrisanje);
								p.getBrIndeksaStudenata().add(new Student("nepoznato","nepoznato",LocalDate.now(),"nepoznato","nepoznato","nepoznato","nepoznato",LocalDate.now(),-1,StatusStudent.N,0.00));
								continue;
							}
							p.getBrIndeksaStudenata().remove(studentZaBrisanje);
						}
					}
				
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());	
			}
		}
		
	}		
}