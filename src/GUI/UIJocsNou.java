package GUI;

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

@SuppressWarnings("serial")
public class UIJocsNou extends JDialog implements ActionListener {
	private JTextField txtPreu;
	private JTextField txtProveidor;
	private JTextField txtNom;
	private JButton btnGuardar;
	private JLabel lblTitol;
	private JLabel lblProveidor;
	private JLabel lblPreu;
	private JLabel lblNom;
	private Font font;

	public UIJocsNou(Frame parent, boolean modal) {
		super(parent, "Nou Joc", modal);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 24);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Nou Joc");
			lblTitol.setBounds(12, 12, 354, 16);
			lblTitol.setFont(font);

			// Etiqueta de "joc"
			lblNom = new JLabel();
			getContentPane().add(lblNom);
			lblNom.setText("Joc");
			lblNom.setBounds(39, 50, 66, 16);
			lblNom.setFont(font);

			// Camp que guarda el nom del joc
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 47, 228, 23);

			// Etiqueta de "preu"
			lblPreu = new JLabel();
			getContentPane().add(lblPreu);
			lblPreu.setText("Preu");
			lblPreu.setBounds(39, 78, 87, 16);
			lblPreu.setFont(font);

			// Camp que guarda el preu
			txtPreu = new JTextField();
			getContentPane().add(txtPreu);
			txtPreu.setBounds(138, 75, 98, 23);

			// Etiquesta de "Proveidor"
			lblProveidor = new JLabel();
			getContentPane().add(lblProveidor);
			lblProveidor.setText("Proveidor");
			lblProveidor.setBounds(39, 107, 99, 16);
			lblProveidor.setFont(font);

			// Camp que guarda el proveidor
			txtProveidor = new JTextField();
			getContentPane().add(txtProveidor);
			txtProveidor.setBounds(138, 104, 228, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 149, 224, 23);
			btnGuardar.setFont(font);

			pack();
			this.setSize(407, 217);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
