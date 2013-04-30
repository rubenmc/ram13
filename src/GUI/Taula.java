package GUI;

import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Taula extends JPanel{
	String[] camps;
	MyTableModel tableModel;
	public Taula(Object[][] values, String[] camps) {
		// Cridem al constructor del pare
		super();
		this.camps=camps;
		// Creem el model de la taula
		tableModel = new MyTableModel(camps);
		// Creem la taula assignant-li el model creat anteriorment
		final JTable table = new JTable(tableModel);
		// Indiquem la mida de la taula
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		//table.setBounds(12, 40, 487, 158);
		// Indiquem que les columnes es podran auto ordenar
		table.setAutoCreateRowSorter(true);
		// For per omplir la taula
		for (int x = 0; x < values.length; x++) {
			tableModel.insertData(values[x]);
		}

		// Creem un JScrollPane i li afegim la taula.
		JScrollPane scrollPane = new JScrollPane(table);

		// Afegim el JScrollPane a la UI
		add(scrollPane);
	}

}
