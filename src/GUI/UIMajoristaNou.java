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
import main.Majorista;

@SuppressWarnings("serial")
public class UIMajoristaNou extends JDialog implements ActionListener {

	private JTextField 	txtNom;
	private JTextField 	txtTelefon;
	private JTextField 	txtNIF;
	private JTextField 	txtContacte;
	private JTextField 	txtMail;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblNom;
	private JLabel 		lblTelefon;
	private JLabel 		lblNIF;
	private JLabel 		lblContacte;
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
	public UIMajoristaNou(Frame parent) {
		super(parent, "Nou Majorista");
		this.parent = parent;
		// Carreguem la interficie
		carregarGUI();
		// Modifiquem el titol
		lblTitol.setText("Nou Majorista");
	}

	/**
	 * Constructor per editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UIMajoristaNou(Frame parent, String[] dades) {
		super(parent, "Modificar Client");
		this.dades = dades;
		this.parent = parent;
		// Carreguem la interficie
		carregarGUI();
		// Modifiquem el titol
		lblTitol.setText("Modificar Majorista");
		// Introduim les dades als camps de text corresponents
		txtNom.setText(dades[1]);
		txtTelefon.setText(dades[2]);
		txtNIF.setText(dades[3]);
		txtMail.setText(dades[4]);
		txtContacte.setText(dades[5]);
		// Indiquem que es una modificaci�
		btnGuardar.setActionCommand("modificar");
	}

	/**
	 * M�tode per a carregar la interficie
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

			// T�tol de la finestra
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

			// Camp que guarda el nom de la persona de contacte
			txtContacte = new JTextField();
			getContentPane().add(txtContacte);
			txtContacte.setBounds(138, 142, 228, 23);

			// Etiqueta de contacte
			lblContacte = new JLabel();
			getContentPane().add(lblContacte);
			lblContacte.setText("Contacte");
			lblContacte.setBounds(39, 145, 99, 16);
			lblContacte.setFont(font);

			// Camp per a guardar el mail
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(138, 173, 228, 23);

			// Etiqueta de mail
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Mail");
			lblMail.setBounds(39, 176, 87, 16);
			lblMail.setFont(font);

			// Bot� guardar
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
	 * M�tode que s'executara al fer clic al bot� i que realitzara la acci� especificada
	 */
	public void actionPerformed(ActionEvent arg0) {
		// Comprovem que el mail introduit sigui correcte
		if (comprovaMail(txtMail.getText())) {
			if (arg0.getActionCommand().equals("modificar")) {
				Majorista majorista = new Majorista(dades[0], txtNom.getText(),
						txtTelefon.getText(), txtNIF.getText(),
						txtMail.getText(), txtContacte.getText());
				if (BD.updateMajorista(majorista)) {
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
				String id = BD.getMajoristaNextID();
				if (id != null) {
					Majorista majorista = new Majorista(id, txtNom.getText(),
							txtTelefon.getText(), txtNIF.getText(),
							txtMail.getText(), txtContacte.getText());
					if (BD.addMajorista(majorista)) {
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
	}

	/**
	 * Metode per a comprovar si el mail introduit �s correcte
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
