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
public class UITendesNou extends JDialog implements ActionListener {
	private JTextField txtDireccio;
	private JTextField txtTelefon;
	private JButton btnGuardar;
	private JLabel lblTitol;
	private JLabel lblDireccio;
	private JLabel lblTelefon;
	private Font font;

	public UITendesNou(Frame parent, boolean modal) {
		super(parent, "Nova tenda", modal);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 24);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Títol de la finestra
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Nova tenda");
			lblTitol.setBounds(12, 12, 354, 16);

			// Etiqueta de "Direccio"
			lblDireccio = new JLabel();
			getContentPane().add(lblDireccio);
			lblDireccio.setText("Direcció");
			lblDireccio.setBounds(39, 61, 66, 16);
			lblDireccio.setFont(font);

			// Camp que guarda la direcció de la tenda
			txtDireccio = new JTextField();
			getContentPane().add(txtDireccio);
			txtDireccio.setBounds(138, 58, 228, 23);

			// Etiqueta de "Telefon"
			lblTelefon = new JLabel();
			getContentPane().add(lblTelefon);
			lblTelefon.setText("Telefon");
			lblTelefon.setBounds(39, 90, 87, 16);
			lblTelefon.setFont(font);

			// Camp que guarda el telefon
			txtTelefon = new JTextField();
			getContentPane().add(txtTelefon);
			txtTelefon.setBounds(138, 87, 133, 23);

			// Botó guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 128, 224, 23);
			btnGuardar.setFont(font);

			pack();
			this.setSize(401, 195);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
