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
import main.Joc;

@SuppressWarnings("serial")
public class UIJocsNou extends JDialog implements ActionListener {
	private JTextField 	txtPreu;
	private JTextField 	txtProveidor;
	private JTextField 	txtNom;
	private JTextField 	txtGenere;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblProveidor;
	private JLabel 		lblPreu;
	private JLabel 		lblNom;
	private JLabel 		lblGenere;
	private Font 		font;
	private Frame 		parent;
	private String[] 	dades;

	/**
	 * Constructor per a una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UIJocsNou(Frame parent) {
		super(parent, "Nou Joc");
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
	public UIJocsNou(Frame parent, String[] dades) {
		super(parent, "Editar Joc");
		this.dades = dades;
		this.parent = parent;
		carregarGUI();
		lblTitol.setText("Editar Joc");
		txtProveidor.setText(dades[1]);
		txtNom.setText(dades[2]);
		txtGenere.setText(dades[3]);
		txtPreu.setText(dades[4]);
		btnGuardar.setActionCommand("modificar");
	}

	/**
	 * M�tode per carregar tota la interficie
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
			lblNom.setBounds(40, 50, 100, 16);
			lblNom.setFont(font);

			// Etiqueta de preu
			lblPreu = new JLabel();
			getContentPane().add(lblPreu);
			lblPreu.setText("Preu");
			lblPreu.setBounds(40, 80, 100, 16);
			lblPreu.setFont(font);

			// Etiqueta de proveidr
			lblProveidor = new JLabel();
			getContentPane().add(lblProveidor);
			lblProveidor.setText("Proveidor");
			lblProveidor.setBounds(40, 110, 100, 16);
			lblProveidor.setFont(font);

			// Etiquesta de genere
			lblGenere = new JLabel();
			getContentPane().add(lblGenere);
			lblGenere.setText("Genere");
			lblGenere.setBounds(40, 140, 100, 16);
			lblGenere.setFont(font);

			// Camp que guarda el nom del joc
			txtNom = new JTextField();
			getContentPane().add(txtNom);
			txtNom.setBounds(138, 50, 228, 23);

			// Camp que guarda el preu
			txtPreu = new JTextField();
			getContentPane().add(txtPreu);
			txtPreu.setBounds(138, 80, 228, 23);

			// Camp que guarda el proveidor
			txtProveidor = new JTextField();
			getContentPane().add(txtProveidor);
			txtProveidor.setBounds(138, 110, 228, 23);

			// Camp que guarda el genere
			txtGenere = new JTextField();
			getContentPane().add(txtGenere);
			txtGenere.setBounds(138, 140, 228, 23);

			// Bot� guardar
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
	 * M�tode que s'executara al fer clic al bot� i que realitzara la acci� especificada
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("modificar")) {
			Joc joc = new Joc(Integer.parseInt(dades[0]), txtNom.getText(),
					txtProveidor.getText(),
					Float.parseFloat(txtPreu.getText()), txtGenere.getText());
			if (BD.updateJoc(joc)) {
				this.dispose();
				parent.dispose();
				UIJocs inst = new UIJocs();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al modificar joc");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		} else {
			Joc joc = new Joc(0, txtNom.getText(), txtProveidor.getText(),
					Float.parseFloat(txtPreu.getText()), txtGenere.getText());
			if (BD.addJoc(joc)) {
				this.dispose();
				parent.dispose();
				UIJocs inst = new UIJocs();
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
