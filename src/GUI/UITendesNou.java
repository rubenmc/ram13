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
import main.Tenda;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llaurad�
 *
 */
public class UITendesNou extends JDialog implements ActionListener {
	private JTextField 	txtDireccio;
	private JTextField 	txtTelefon;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblDireccio;
	private JLabel 		lblTelefon;
	private Font 		font;
	private Frame 		parent;
	private String[] 	dades;

	/**
	 * Constructor per una nova entrada
	 * 
	 * @param parent
	 *            Frame del pare
	 */
	public UITendesNou(Frame parent) {
		super(parent, "Nova tenda");
		// Carreguem la interficie
		carregarGUI();
		this.parent = parent;
		// Modifiquem el titol
		lblTitol.setText("Nova tenda");
	}

	/**
	 * Constructor per a editar un registre
	 * 
	 * @param parent
	 *            Frame del pare
	 * @param dades
	 *            Dades actuals del registre
	 */
	public UITendesNou(Frame parent, String[] dades) {
		super(parent, "Modificar tenda");
		// Carreguem la interficie
		carregarGUI();
		this.parent = parent;
		this.dades = dades;
		// Assignem les dades al camp de text corresponent
		txtDireccio.setText(dades[1]);
		txtTelefon.setText(dades[2]);
		// Indiquem que es una modificaci�
		btnGuardar.setActionCommand("modificar");
		// Modifiquem el titol
		lblTitol.setText("Modificar tenda");
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

			// Etiqueta de direcci�
			lblDireccio = new JLabel();
			getContentPane().add(lblDireccio);
			lblDireccio.setText("Direcci�");
			lblDireccio.setBounds(40, 50, 100, 16);
			lblDireccio.setFont(font);

			// Camp que guarda la direcci�
			txtDireccio = new JTextField();
			getContentPane().add(txtDireccio);
			txtDireccio.setBounds(138, 50, 228, 23);

			// Etiqueta de telefon
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(40, 80, 100, 16);
			lblTelefon.setFont(font);

			// Camp que guarda el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 80, 228, 23);

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
	 * M�tode que s'executara al fer clic a un bot� i que realitzara la acci� indicada
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("modificar")) {
			Tenda tenda = new Tenda(Integer.parseInt(dades[0]),
					txtDireccio.getText(), txtTelefon.getText());
			if (BD.updateTenda(tenda)) {
				this.dispose();
				parent.dispose();
				UITendes inst = new UITendes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al modificar tenda");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		} else {
			Tenda tenda = new Tenda(0, txtDireccio.getText(),
					txtTelefon.getText());
			if (BD.addTenda(tenda)) {
				this.dispose();
				parent.dispose();
				UITendes inst = new UITendes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			} else {
				ErrorDialog error = new ErrorDialog(this,
						"Error al crear tenda");
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			}
		}
	}

}
