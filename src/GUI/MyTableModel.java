package GUI;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class MyTableModel extends AbstractTableModel {
	// Array amb els titols de les columnes
		private String[] columnName;
		// Vector per recogir dades
		private Vector data = new Vector();

		public MyTableModel(String[] columnes){
			columnName = columnes;
		}
		// Metodes
		// Numero de columnes
		@Override
		public int getColumnCount() {
			return columnName.length;
		}

		// Numero de dades a la fila
		@Override
		public int getRowCount() {
			return data.size();
		}

		// Obtenir un valor
		@Override
		public Object getValueAt(int row, int col) {
			return ((Vector) data.get(row)).get(col);
		}

		// Obtenir nom de la columna
		@Override
		public String getColumnName(int col) {
			return columnName[col];
		}

		// Obtenir clase de la columna
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// Posar un valor a una posició
		@Override
		public void setValueAt(Object value, int row, int col) {
			((Vector) data.get(row)).setElementAt(value, col);
			fireTableCellUpdated(row, col);
		}

		// Afegir una fila nova
		public void insertData(Object[] values) {
			data.add(new Vector());
			for (int i = 0; i < values.length; i++) {
				((Vector) data.get(data.size() - 1)).add(values[i]);
			}
			fireTableDataChanged();
		}
    
}
