package GUI;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class MyTableModel extends AbstractTableModel {

	private String[] 	columnName;
	private Vector 		data = new Vector();

	// Constructor
	/**
	 * 
	 * @param columnes
	 *            Array amb els noms de les columnes
	 */
	public MyTableModel(String[] columnes) {
		columnName = columnes;
	}

	// Metodes
	@Override
	/**
	 * @return El numero de columnes
	 */
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	/**
	 * @return El numero de files
	 */
	public int getRowCount() {
		return data.size();
	}

	@Override
	/**
	 * @param row
	 * 			La fila a la que volem accedir
	 * @param col
	 * 			La columna a la que volem accedir
	 * @return El valor de la casella indicada
	 */
	public Object getValueAt(int row, int col) {
		return ((Vector) data.get(row)).get(col);
	}

	@Override
	/**
	 * @param col
	 * 			La columna a la que volem accedir
	 * @return El nom de la columna indicada
	 */
	public String getColumnName(int col) {
		return columnName[col];
	}

	// Obtenir clase de la columna
	@Override
	/**
	 * @param col
	 * 			La columna a la que volem accedir
	 * @return El tipus de la columna indicada
	 */
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	@Override
	/**
	 * @param row
	 * 			La fila a la que volem accedir
	 * @param col
	 * 			La columna a la que volem accedir
	 * @param value
	 * 			Valor que volem introduir
	 */
	public void setValueAt(Object value, int row, int col) {
		((Vector) data.get(row)).setElementAt(value, col);
		fireTableCellUpdated(row, col);
	}

	/**
	 * @param values
	 *            Array amb els valors que volem introduir
	 */
	public void insertData(Object[] values) {
		data.add(new Vector());
		for (int i = 0; i < values.length; i++) {
			((Vector) data.get(data.size() - 1)).add(values[i]);
		}
		fireTableDataChanged();
	}

	@Override
	/**
	 * @param row
	 * 			La fila a la que volem accedir
	 * @param col
	 * 			La columna a la que volem accedir
	 */
	public boolean isCellEditable(int row, int col) {
		if (col == columnName.length - 1) {
			return true;
		} else {
			return false;
		}
	}
}
