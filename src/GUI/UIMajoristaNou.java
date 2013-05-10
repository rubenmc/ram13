package GUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

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

	public UIMajoristaNou(Frame parent, boolean modal) {
		super(parent, "Nova comanda", modal);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Majorista nou");
			lblTitol.setBounds(12, 12, 354, 16);

			// Etiqueta de "Data"
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Nom");
			lblNom.setBounds(39, 58, 66, 16);

			// Camp que guarda la data
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);

			// Etiqueta de "Emisor"
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 87, 87, 16);

			// Camp que guarda el emisor
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 84, 98, 23);

			// Etiqueta de "Receptor"
			lblNIF = new JLabel();
			getContentPane().add(lblNIF);
			lblNIF.setText("NIF");
			lblNIF.setBounds(39, 116, 87, 16);

			// Camp que guarda el Receptor
			txtNIF = new JTextField();
			getContentPane().add(txtNIF);
			txtNIF.setBounds(138, 113, 133, 23);

			// Etiqueta de "Estat"
			lblContacte = new JLabel();
			getContentPane().add(lblContacte);
			lblContacte.setText("Persona de Contacte");
			lblContacte.setBounds(38, 148, 100, 16);

			// Camp que guarda el estat
			txtContacte = new JTextField();
			getContentPane().add(txtContacte);
			txtContacte.setBounds(138, 145, 168, 23);

			// Etiqueta de ventes
			lblMail = new JLabel();
			getContentPane().add(lblMail);
			lblMail.setText("Correu.e");
			lblMail.setBounds(40, 177, 99, 16);

			// Camp que guarda ventes
			txtMail = new JTextField();
			getContentPane().add(txtMail);
			txtMail.setBounds(139, 174, 167, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 212, 224, 23);

			pack();
			this.setSize(408, 285);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
