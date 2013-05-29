package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.BD;
import main.Unitat;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class UIUnitatsNou extends JDialog implements ActionListener {
	private JTextField 	txtTenda;
	private JTextField 	txtJoc;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblTenda;
	private JLabel 		lblJoc;
	private Font 		font;
	private Frame 		parent;
	private String[] 	dades;

	/**
	 * Constructor per a una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UIUnitatsNou(Frame parent) {
		super(parent, "Nova unitat");
		// Carreguem la interficie
		carregarGUI();
		this.parent = parent;
		// Modifiquem el titol
		lblTitol.setText("Nova unitat");
	}

	/**
	 * Constructor per editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UIUnitatsNou(Frame parent, String[] dades) {
		super(parent, "Modificar unitat");
		// Carreguem la interficie
		carregarGUI();
		this.parent = parent;
		this.dades = dades;
		// Assignem les dades al seu camp de text corresponent
		txtTenda.setText(dades[1]);
		txtJoc.setText(dades[2]);
		// Indiquem que es una modificació
		btnGuardar.setActionCommand("modificar");
		// Modifiquem el titol
		lblTitol.setText("Modificar unitat");
	}

	/**
	 * Métode per a carregar la interficie
	 */
	private void carregarGUI() {
		try {
			// Instanciem la font
			font = Font.createFont(Font.TRUETYPE_FONT,
					new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 12);

			// Fons
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setBounds(12, 12, 354, 16);

			// Etiqueta de tenda
			lblTenda = new JLabel();
			getContentPane().add(lblTenda);
			lblTenda.setText("Tenda");
			lblTenda.setBounds(40, 50, 100, 16);
			lblTenda.setFont(font);

			// Camp que guarda l'identificador de la tenda
			txtTenda = new JTextField();
			getContentPane().add(txtTenda);
			txtTenda.setBounds(138, 50, 228, 23);

			// Etiqueta de joc
			lblJoc = new JLabel();
			getContentPane().add(lblJoc);
			lblJoc.setText("Joc");
			lblJoc.setBounds(40, 80, 100, 16);
			lblJoc.setFont(font);

			// Camp que guarda l'identificador del joc
			txtJoc = new JTextField();
			getContentPane().add(txtJoc);
			txtJoc.setBounds(138, 80, 228, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 180, 224, 23);
			btnGuardar.setFont(font);
			btnGuardar.addActionListener(this);

			pack();
			this.setSize(400, 250);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Métode que s'executara al fer clic a un botó i que realitzara la acció indicada
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("modificar")) {
			Unitat unitat = new Unitat(Integer.parseInt(dades[0]),
					Integer.parseInt(txtTenda.getText()),
					Integer.parseInt(txtJoc.getText()));
			if (BD.updateUnitat(unitat)) {
				this.dispose();
				parent.dispose();
				UIUnitats inst = new UIUnitats();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al modificar unitat");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		} else {
			Unitat unitat = new Unitat(0, Integer.parseInt(txtTenda.getText()),
					Integer.parseInt(txtJoc.getText()));
			if (BD.addUnitat(unitat)) {
				this.dispose();
				parent.dispose();
				UIUnitats inst = new UIUnitats();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al crear unitat");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		}
	}
}
