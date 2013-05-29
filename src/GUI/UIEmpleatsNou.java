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
import main.Empleat;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class UIEmpleatsNou extends JDialog implements ActionListener {
	private JTextField 	txtDNI;
	private JTextField 	txtNom;
	private JTextField 	txtTenda;
	private JTextField 	txtSS;
	private JButton 	btnGuardar;
	private JLabel 		lblDNI;
	private JLabel 		lblNom;
	private JLabel 		lblTenda;
	private JLabel 		lblSS;
	private JLabel 		lblTitol;
	private Font 		font;
	private Frame 		parent;
	private String[] 	dades;

	/**
	 * Constructor per a una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UIEmpleatsNou(Frame parent) {
		super(parent, "Nou Empleat");
		this.parent = parent;
		carregarGUI();
		lblTitol.setText("Nou Joc");
	}

	/**
	 * Constructor per editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UIEmpleatsNou(Frame parent, String[] dades) {
		super(parent, "Editar empleat");
		this.dades = dades;
		this.parent = parent;
		carregarGUI();
		lblTitol.setText("Editar Empleat");
		// Assignem valors
		txtNom.setText(dades[1]);
		txtSS.setText(dades[2]);
		txtDNI.setText(dades[3]);
		txtTenda.setText(dades[4]);
		// Indiquem que es una modificació
		btnGuardar.setActionCommand("modificar");
	}

	/**
	 * Métode per carregar tota la interficie
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

			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setBounds(12, 12, 354, 16);
			lblTitol.setFont(font);

			// Etiqueta de nom
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Nom");
			lblNom.setBounds(40, 50, 100, 16);
			lblNom.setFont(font);

			// Etiqueta de DNI
			lblDNI = new JLabel();
			getContentPane().add(lblDNI);
			lblDNI.setText("DNI");
			lblDNI.setBounds(40, 80, 100, 16);
			lblDNI.setFont(font);

			// Etiqueta de tenda
			lblTenda = new JLabel();
			getContentPane().add(lblTenda);
			lblTenda.setText("IDTenda");
			lblTenda.setBounds(40, 110, 100, 16);
			lblTenda.setFont(font);

			// Etiqueta del numero de la seguretat social
			lblSS = new JLabel();
			getContentPane().add(lblSS);
			lblSS.setText("SS");
			lblSS.setBounds(40, 140, 100, 16);
			lblSS.setFont(font);

			// Camp per introduir el nom
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 50, 228, 23);

			// Camp per introduir el DNI
			txtDNI = new JTextField();
			getContentPane().add(txtDNI);
			txtDNI.setBounds(138, 80, 228, 23);

			// Camp per introduir la tenda
			txtTenda = new JTextField();
			getContentPane().add(txtTenda);
			txtTenda.setBounds(138, 110, 228, 23);

			// Camp per introduir el numero de la seguretat social
			txtSS = new JTextField();
			getContentPane().add(txtSS);
			txtSS.setBounds(138, 140, 228, 23);

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
	 * Métode que s'executara al fer clic al botó i que realitzara la acció especificada
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("modificar")) {
			Empleat empleat = new Empleat(Integer.parseInt(dades[0]),
					txtNom.getText(), txtSS.getText(), txtDNI.getText(),
					Integer.parseInt(txtTenda.getText()));
			if (BD.updateEmpleat(empleat)) {
				this.dispose();
				parent.dispose();
				UIEmpleats inst = new UIEmpleats();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al modificar empleat");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		} else {
			Empleat treballador = new Empleat(0, txtNom.getText(),
					txtSS.getText(), txtDNI.getText(),
					Integer.parseInt(txtTenda.getText()));
			if (BD.addEmpleat(treballador)) {
				this.dispose();
				parent.dispose();
				UIEmpleats inst = new UIEmpleats();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al crear empleat");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		}

	}

}
