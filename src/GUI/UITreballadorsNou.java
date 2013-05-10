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
public class UITreballadorsNou extends JDialog implements ActionListener {
	private JTextField txtDNI;
	private JTextField txtNom;
	private JTextField txtTelefon;
	private JTextField txtSS;
	private JButton btnGuardar;
	private JLabel lblDNI;
	private JLabel lblNom;
	private JLabel lblTelefon;
	private JLabel lblSS;
	private JLabel lblTitol;

	public UITreballadorsNou(Frame parent, boolean modal) {
		super(parent, "Nou Treballador", modal);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Nou treballador");
			lblTitol.setBounds(12, 12, 354, 16);

			// Etiqueta de "Nom del treballador"
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Nom");
			lblNom.setBounds(39, 58, 66, 16);

			// Camp que guarda el nom del joc
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 55, 228, 23);

			// Etiqueta de "preu"
			lblDNI = new JLabel();
			getContentPane().add(lblDNI);
			lblDNI.setText("DNI");
			lblDNI.setBounds(39, 87, 87, 16);

			// Camp que guarda el preu
			txtDNI = new JTextField();
			getContentPane().add(txtDNI);
			txtDNI.setBounds(138, 84, 98, 23);

			// Etiqueta de "Companyia"
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 116, 87, 16);

			// Camp que guarda la companyia
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 113, 133, 23);

			// Etiqueta de la seguretat social
			lblSS = new JLabel();
			getContentPane().add(lblSS);
			lblSS.setText("Nº de la SS");
			lblSS.setBounds(39, 148, 37, 16);

			// Camp que guarda el numero de la seguretat social
			txtSS = new JTextField();
			getContentPane().add(txtSS);
			txtSS.setBounds(138, 145, 168, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Treballador");
			btnGuardar.setBounds(12, 180, 224, 23);

			pack();
			this.setSize(409, 248);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
