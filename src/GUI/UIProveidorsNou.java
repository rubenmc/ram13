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
import main.Proveidor;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class UIProveidorsNou extends JDialog implements ActionListener {
	private JTextField txtNom;
	private JTextField 	txtTelefon;
	private JTextField 	txtNIF;
	private JTextField 	txtCompte;
	private JTextField 	txtMail;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblNom;
	private JLabel 		lblTelefon;
	private JLabel 		lblNIF;
	private JLabel		lblCompte;
	private JLabel 		lblMail;
	private Font 		font;
	private Frame 		parent;
	private String[] 	dades;

	/**
	 * Constructor per a una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UIProveidorsNou(Frame parent) {
		super(parent, "Nou Proveidor");
		this.parent = parent;
		// Carreguem la interficie
		carregarGUI();
		// Modifiquem el titol
		lblTitol.setText("Nou Proveidor");
	}

	/**
	 * Constructor per a editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UIProveidorsNou(Frame parent, String[] dades) {
		super(parent, "Nou Proveidor");
		try {
			this.dades = dades;
			this.parent = parent;
			// Carreguem la interficie
			carregarGUI();
			// Modifiquem el titol
			lblTitol.setText("Editar Proveidor");
			// Assignem les dades al seu camp de text corresponent
			txtNom.setText(dades[1]);
			txtTelefon.setText(dades[2]);
			txtNIF.setText(dades[3]);
			txtMail.setText(dades[4]);
			txtCompte.setText(dades[5]);
			// Indiquem que es una modificació
			btnGuardar.setActionCommand("modificar");

		} catch (Exception e) {
			e.printStackTrace();
		}
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
			lblTitol.setFont(font);

			// Etiqueta de nom
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Nom");
			lblNom.setBounds(39, 58, 66, 16);
			lblNom.setFont(font);

			// Camp que guarda el nom
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);

			// Etiqueta de NIF
			lblNIF = new JLabel();
			getContentPane().add(lblNIF);
			lblNIF.setText("NIF");
			lblNIF.setBounds(39, 87, 228, 16);
			lblNIF.setFont(font);

			// Camp que guarda el NIF
			txtNIF = new JTextField();
			getContentPane().add(txtNIF);
			txtNIF.setBounds(138, 84, 228, 23);

			// Etiqueta de telefon
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 116, 228, 16);
			lblTelefon.setFont(font);

			// Camp que guarda el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 113, 228, 23);

			// Etiqueta de compte corrent
			lblCompte = new JLabel();
			getContentPane().add(lblCompte);
			lblCompte.setText("Compte corrent");
			lblCompte.setBounds(39, 145, 99, 16);
			lblCompte.setFont(font);

			// Camp que guarda el compte corrent
			txtCompte = new JTextField();
			getContentPane().add(txtCompte);
			txtCompte.setBounds(138, 142, 228, 23);

			// Etiqueta de mail
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Mail");
			lblMail.setBounds(39, 176, 87, 16);
			lblMail.setFont(font);

			// Camp que guarda el mail
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(138, 173, 228, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 226, 224, 23);
			btnGuardar.addActionListener(this);
			btnGuardar.setFont(font);

			pack();
			this.setSize(400, 300);
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
			Proveidor proveidor = new Proveidor(dades[0], txtNom.getText(),
					txtTelefon.getText(), txtNIF.getText(), txtMail.getText(),
					txtCompte.getText());
			if (BD.updateProveidor(proveidor)) {
				this.dispose();
				parent.dispose();
				UIProveidors inst = new UIProveidors();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al modificar proveidor");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		} else {
			Proveidor proveidor = new Proveidor("0", txtNom.getText(),
					txtTelefon.getText(), txtNIF.getText(), txtMail.getText(),
					txtCompte.getText());
			if (BD.addProveidor(proveidor)) {
				this.dispose();
				parent.dispose();
				UIProveidors inst = new UIProveidors();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this, "Error al crear joc");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		}
	}
}
