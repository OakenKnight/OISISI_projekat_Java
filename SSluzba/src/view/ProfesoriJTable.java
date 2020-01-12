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
public class ProfesoriJTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProfesoriJTable instance = null;
	public static TableModel model;
	public static JTable tabela=null;
		
	public static ProfesoriJTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriJTable();
		}
		return instance;
	}


	public static int  selektovanRed;
;
	private ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		new ButtonPredmetiProfesora(this,10);
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
	public int getSelektovanRed() {
		if(tabela.getSelectedRow()!=-1)
		return tabela.convertRowIndexToModel(tabela.getSelectedRow());
		else return -1;
	}
		
		
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			selektovanRed = this.getSelectedRow();
			Component c = super.prepareRenderer(renderer, row, column);
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