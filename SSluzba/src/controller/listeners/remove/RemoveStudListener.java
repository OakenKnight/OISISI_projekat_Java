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

import javax.swing.JOptionPane;

import controller.StudentiController;
import model.BazaStudenata;
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
				
					StudentiController.getInstance().removeStudent(StudentiJTable.getInstance().selektovanRed);

				
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());	
			}
		}
		
	}		
}