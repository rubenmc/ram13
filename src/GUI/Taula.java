package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
@SuppressWarnings("serial")
public class Taula extends JPanel {
	private MyTableModel 	tableModel;
	private String[] 		camps;
	private JTable 			table;

	/**
	 * 
	 * @param values
	 *            Matriu amb els valors
	 * @param camps
	 *            Array amb els noms de les columnes
	 * @param width
	 *            Ample que ha d'ocupar la taula
	 * @param height
	 *            Alçada que ha d'ocupar la taula
	 */
	public Taula(Object[][] values, String[] camps, int width, int height) {
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
		// Centrem la informació que surt a la taula
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		// Modifiqueml l'aspecte de la capçalera
		JTableHeader header = table.getTableHeader();
		header.setForeground(new Color(140, 210, 228));
		header.setBackground(new Color(0, 0, 0));
		header.setFont(new Font("Dialog", Font.BOLD, 14));

		// Creem un JScrollPane i li afegim la taula.
		JScrollPane scrollPane = new JScrollPane(table);

		// Afegim el JScrollPane a la UI
		add(scrollPane);

	}

	/**
	 * 
	 * @return El model de la taula
	 */
	public MyTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * 
	 * @return L'alçada total de la taula
	 */
	public int getTableHeight() {
		return table.getRowCount() * table.getRowHeight() + 30;
	}
}
