package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//TODO: treba da se implementira renderer tabele
public class PredmetiJTable extends JTable{
	private static PredmetiJTable instance = null;
	public static int selektovanRed;
	public static TableModel model;
	public static JTable tabela=null;
		
	public static PredmetiJTable getInstance() {
		if (instance == null) {
			instance = new PredmetiJTable();
		}
		return instance;
	}


	
	private PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		tabela=this;
		model=this.getModel();
		sort();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable tabela=(JTable)e.getComponent();

				if(tabela.getSelectedRow()!=-1)
					selektovanRed=tabela.convertRowIndexToModel(tabela.getSelectedRow());
			}
		});
	}
		
		
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			// selektovani red ce imati drugaciju boju od ostalih
			selektovanRed = this.getSelectedRow();
			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}
		public void sort() {
			TableRowSorter<TableModel> sort=new TableRowSorter<TableModel>(model);
			this.setRowSorter(sort);
		}
}
