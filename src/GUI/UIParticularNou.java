package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.BD;
import main.Particular;

@SuppressWarnings("serial")
public class UIParticularNou extends JDialog implements ActionListener {
	private JTextField 	txtMail;
	private JTextField 	txtDNI;
	private JTextField 	txtNaixement;
	private JTextField 	txtNom;
	private JTextField 	txtTelefon;
	private JButton 	btnGuardar;
	private JLabel 		lblNaixement;
	private JLabel 		lblTitol;
	private JLabel 		lblDNI;
	private JLabel 		lblNom;
	private JLabel 		lblTelefon;
	private JLabel 		lblMail;
	private Font 		font;
	private Frame		parent;
	private String[] 	dades;

	/**
	 * Constructor per introduir una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UIParticularNou(Frame parent) {
		super(parent, "Nou Particular");
		this.parent = parent;
		// Carreguem la interficie
		carregarGUI();
		// Modifiquem el titol
		lblTitol.setText("Nou Particular");
	}

	/**
	 * Constructor per a editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UIParticularNou(Frame parent, boolean modal, String[] dades) {
		super(parent, "Modificar Client", modal);
		this.parent = parent;
		this.dades = dades;
		// Carreguem la interficie
		carregarGUI();
		// Modifiquem el titol
		lblTitol.setText("Modificar Particular");
		// Introduim les dades als camps de text corresponents
		txtNom.setText(dades[1]);
		txtTelefon.setText(dades[2]);
		txtDNI.setText(dades[3]);
		txtMail.setText(dades[4]);
		txtNaixement.setText(dades[5].replaceAll("-", "/"));
		// Indiquem que es una modificació
		btnGuardar.setActionCommand("modificar");
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

			// Camp que guarda el nom del client
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);

			// Etiqueta de DNI
			lblDNI = new JLabel();
			getContentPane().add(lblDNI);
			lblDNI.setText("DNI");
			lblDNI.setBounds(39, 87, 228, 16);
			lblDNI.setFont(font);

			// Camp que guarda el DNI
			txtDNI = new JTextField();
			getContentPane().add(txtDNI);
			txtDNI.setBounds(138, 84, 228, 23);

			// Etiqueta de telefon
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 116, 228, 16);
			lblTelefon.setFont(font);

			// Camp que guarda la el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 113, 228, 23);

			// Camp que guarda la data de naixement
			txtNaixement = new JTextField();
			getContentPane().add(txtNaixement);
			txtNaixement.setBounds(138, 142, 228, 23);

			// Etiqueta de naixement
			lblNaixement = new JLabel();
			getContentPane().add(lblNaixement);
			lblNaixement.setText("Naixement");
			lblNaixement.setBounds(39, 145, 99, 16);
			lblNaixement.setFont(font);

			// Camp que guarda el mail
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(138, 173, 228, 23);

			// Etiqueta de mail
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Mail");
			lblMail.setBounds(39, 176, 87, 16);
			lblMail.setFont(font);

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

	@SuppressWarnings("deprecation")
	@Override
	/**
	 * Métode que s'executara al fer clic al botó i que realitzara la acció especificada
	 */
	public void actionPerformed(ActionEvent arg0) {
		Date data = null;
		try {
			// Intentem crear un objecte data
			data = new Date(txtNaixement.getText());
			// Si no falla la data comprovem el mail introduit
			if (comprovaMail(txtMail.getText())) {
				if (arg0.getActionCommand().equals("modificar")) {
					Particular particular = new Particular(dades[0],
							txtNom.getText(), txtTelefon.getText(),
							txtDNI.getText(), txtMail.getText(),
							new java.sql.Date(data.getTime()));
					if (BD.updateParticular(particular)) {
						this.dispose();
						parent.dispose();
						UIClients inst = new UIClients();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					} else {
						ErrorDialog error = new ErrorDialog(this,
								"Error al modificar usuari");
						error.setLocationRelativeTo(null);
						error.setVisible(true);
					}
				} else {
					String id = null;
					try {
						id = BD.getParticularNextID();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (id != null) {
						Particular particular = new Particular(id,
								txtNom.getText(), txtTelefon.getText(),
								txtDNI.getText(), txtMail.getText(),
								new java.sql.Date(data.getTime()));
						if (BD.addParticular(particular)) {
							this.dispose();
							parent.dispose();
							UIClients inst = new UIClients();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al crear usuari");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					} else {
						ErrorDialog error = new ErrorDialog(this,
								"Error al crear usuari");
						error.setLocationRelativeTo(null);
						error.setVisible(true);
					}
				}
			} else {
				ErrorDialog error = new ErrorDialog(this, "Mail incorrecte");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			ErrorDialog error = new ErrorDialog(this,
					"Data incorrecta. El format correcte és dia/mes/any");
			error.setLocationRelativeTo(null);
			error.setVisible(true);
		}
	}

	/**
	 * Metode per a comprovar si el mail introduit és correcte
	 * 
	 * @param mail
	 *            mail introduit
	 * @return resultat de la comprovacio
	 */
	private static boolean comprovaMail(String mail) {
		if (mail.contains("@")) {
			String resta = mail.substring(mail.indexOf('@'));
			if (resta.contains(".")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
