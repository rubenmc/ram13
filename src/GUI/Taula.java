package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class Taula extends JPanel {
	private MyTableModel 	tableModel;
	private String[] 		camps;
	private JTable table;

	public Taula(Object[][] values, String[] camps, int width, int height) {
		// Cridem al constructor del pare
		super();
		
		this.camps = camps;
		// Creem el model de la taula
		tableModel = new MyTableModel(this.camps);
		// Creem la taula assignant-li el model creat anteriorment
		table = new JTable(tableModel);
		// Indiquem la mida de la taula
		table.setPreferredScrollableViewportSize(new Dimension(width, height));
		// Indiquem que les columnes es podran auto ordenar
		table.setAutoCreateRowSorter(true);
		// For per omplir la taula
		for (int x = 0; x < values.length; x++) {
			tableModel.insertData(values[x]);
		}
		
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(0, 204, 255));
		header.setFont(new Font("Dialog", Font.BOLD, 14));
		// Creem un JScrollPane i li afegim la taula.
		JScrollPane scrollPane = new JScrollPane(table);
		
		// Afegim el JScrollPane a la UI
		add(scrollPane);
		
	}
	
	public MyTableModel getTableModel(){
		return tableModel;
	}
	
	public int getTableHeight(){
		return table.getRowCount()*table.getRowHeight()+30;
	}
}
