package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import main.BD;
import main.Particular;

@SuppressWarnings("serial")
public class UIClientsNou extends JDialog implements ActionListener {
	private JTextField txtMail;
	private JTextField txtDNI;
	private JTextField txtNaixement;
	private JTextField txtNom;
	private JTextField txtTelefon;
	private JButton btnGuardar;
	private JLabel lblNaixement;
	private JLabel lblClientsNou;
	private JLabel lblDNI;
	private JLabel lblNom;
	private JLabel lblTelefon;
	private JLabel lblMail;
	private Frame parent;

	public UIClientsNou(Frame parent, boolean modal) {
		super(parent, "Nou Client", modal);
		try {
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));

			this.parent = parent;
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblClientsNou = new JLabel();
			getContentPane().add(lblClientsNou);
			lblClientsNou.setText("Nou Client");
			lblClientsNou.setBounds(12, 12, 354, 16);

			// Etiqueta de "Nom del treballador"
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Client");
			lblNom.setBounds(39, 58, 66, 16);

			// Camp que guarda el nom del client
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);

			// Etiqueta de "DNI"
			lblDNI = new JLabel();
			getContentPane().add(lblDNI);
			lblDNI.setText("DNI");
			lblDNI.setBounds(39, 87, 87, 16);

			// Camp que guarda el DNI
			txtDNI = new JTextField();
			getContentPane().add(txtDNI);
			txtDNI.setBounds(138, 84, 98, 23);

			// Etiqueta de "Telefon"
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 116, 87, 16);

			// Camp que guarda la el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 113, 133, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 226, 224, 23);
			btnGuardar.addActionListener(this);

			// Text Field per guardar la data de naixement
			txtNaixement = new JTextField();
			getContentPane().add(txtNaixement);
			txtNaixement.setBounds(138, 142, 98, 23);

			// Etiqueta de "Naixement"
			lblNaixement = new JLabel();
			getContentPane().add(lblNaixement);
			lblNaixement.setText("Naixement");
			lblNaixement.setBounds(39, 145, 99, 16);

			// TextField per guardar el mail
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(138, 173, 201, 23);

			// Etiqueta de "Mail"
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Correu.e");
			lblMail.setBounds(39, 176, 87, 16);

			pack();
			this.setSize(399, 293);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UIClientsNou(Frame parent, boolean modal, String[] dades) {
		super(parent, "Modificar Client", modal);
		try {
			this.parent = parent;
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblClientsNou = new JLabel();
			getContentPane().add(lblClientsNou);
			lblClientsNou.setText("Modificar Client");
			lblClientsNou.setBounds(12, 12, 354, 16);

			// Etiqueta de "Nom del treballador"
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Client");
			lblNom.setBounds(39, 58, 66, 16);

			// Camp que guarda el nom del client
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);
			txtNom.setText(dades[0]);

			// Etiqueta de "DNI"
			lblDNI = new JLabel();
			getContentPane().add(lblDNI);
			lblDNI.setText("DNI");
			lblDNI.setBounds(39, 87, 87, 16);

			// Camp que guarda el DNI
			txtDNI = new JTextField();
			getContentPane().add(txtDNI);
			txtDNI.setBounds(138, 84, 98, 23);
			txtDNI.setText(dades[2]);

			// Etiqueta de "Telefon"
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 116, 87, 16);

			// Camp que guarda la el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 113, 133, 23);
			txtTelefon.setText(dades[1]);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Actualitzar Client");
			btnGuardar.setBounds(12, 226, 224, 23);
			btnGuardar.addActionListener(this);
			btnGuardar.setActionCommand("modificar");

			// Text Field per guardar la data de naixement
			txtNaixement = new JTextField();
			getContentPane().add(txtNaixement);
			txtNaixement.setBounds(138, 142, 98, 23);
			txtNaixement.setText(dades[3]);

			// Etiqueta de "Naixement"
			lblNaixement = new JLabel();
			getContentPane().add(lblNaixement);
			lblNaixement.setText("Naixement");
			lblNaixement.setBounds(39, 145, 99, 16);

			// TextField per guardar el mail
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(138, 173, 201, 23);
			txtMail.setText(dades[4]);

			// Etiqueta de "Mail"
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Correu.e");
			lblMail.setBounds(39, 176, 87, 16);

			pack();
			this.setSize(399, 293);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Date data = null;

		try {
			data = new Date(txtNaixement.getText());

			if (comprovaMail(txtMail.getText())) {
				String id = BD.getParticularNextID();
				if (id != null) {
					Particular particular = new Particular(id,
							txtNom.getText(), txtTelefon.getText(),
							txtDNI.getText(), txtMail.getText(),
							new java.sql.Date(data.getTime()));

					if (arg0.getActionCommand().equals("modificar")) {
						if (BD.modificaParticular(particular)) {
							this.dispose();
							parent.dispose();
							UIClients inst = new UIClients();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this, true,
									"Error al modificar usuari");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					} else {
						if (BD.afegeixParticular(particular)) {
							this.dispose();
							parent.dispose();
							UIClients inst = new UIClients();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this, true,
									"Error al crear usuari");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					}
				} else {
					ErrorDialog error = new ErrorDialog(this, true,
							"Error al crear usuari");
					error.setLocationRelativeTo(null);
					error.setVisible(true);
				}
			} else {
				ErrorDialog error = new ErrorDialog(this, true,
						"Mail incorrecte");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}

		} catch (IllegalArgumentException e) {
			ErrorDialog error = new ErrorDialog(this, true,
					"Data incorrecta. El format correcte és dia/mes/any");
			error.setLocationRelativeTo(null);
			error.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
