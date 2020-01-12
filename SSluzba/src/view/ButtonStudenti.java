package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonStudenti extends AbstractCellEditor implements TableCellEditor,TableCellRenderer,MouseListener{

	
	private JButton renderB;
	private JButton editB;
	private JTable table;
	
	
	public ButtonStudenti(JTable t ,  int column) {
		this.table = t;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		this.renderB = new JButton("Prikazi");
		this.editB = new JButton("Prikazi");

		
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		JPanel p = new JPanel(new BorderLayout());
		p.add(this.renderB);
		return p;
	}


	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		JPanel p = new JPanel(new BorderLayout());
		p.add(this.editB);
		return p;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(PredmetiJTable.getInstance().getSelectedColumn() == 5) {
			PrikazStudenataUPredmetu p = new PrikazStudenataUPredmetu();
			//p.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
	}

}
