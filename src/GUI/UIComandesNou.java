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

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llaurad�
 *
 */
public class UIComandesNou extends JDialog implements ActionListener {

	private JTextField 	txtData;
	private JTextField 	txtEmpleat;
	private JTextField 	txtProveidor;
	private JTextField 	txtArticle;
	private JTextField 	txtPreu;
	private JButton 	btnGuardar;
	private JLabel 		lblTitol;
	private JLabel 		lblData;
	private JLabel 		lblEmpleat;
	private JLabel 		lblProveidor;
	private JLabel 		lblArticle;
	private JLabel 		lblPreu;
	private Font 		font;
	private Frame 		parent;

	public UIComandesNou(Frame parent, boolean modal) {
		super(parent, "Nova comanda", modal);
		this.parent = parent;
		carregarGUI();		
	}
	
	private void carregarGUI(){
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
			lblTitol.setText("Nova comanda");
			lblTitol.setBounds(12, 12, 354, 16);
			lblTitol.setFont(font);

			// Etiqueta de "Data"
			lblData = new JLabel();
			getContentPane().add(lblData);
			lblData.setText("Data");
			lblData.setBounds(50, 66, 66, 16);
			lblData.setFont(font);

			// Camp que guarda la data
			txtData = new JTextField();
			getContentPane().add(txtData);
			txtData.setBounds(144, 63, 168, 23);

			// Etiqueta de "Empleat"
			lblEmpleat = new JLabel();
			getContentPane().add(lblEmpleat);
			lblEmpleat.setText("Empleat");
			lblEmpleat.setBounds(51, 101, 87, 16);
			lblEmpleat.setFont(font);

			// Camp que guarda l'empleat
			txtEmpleat = new JTextField();
			getContentPane().add(txtEmpleat);
			txtEmpleat.setBounds(144, 98, 169, 23);

			// Etiqueta de "Proveidor"
			lblProveidor = new JLabel();
			getContentPane().add(lblProveidor);
			lblProveidor.setText("Proveidor");
			lblProveidor.setBounds(50, 136, 87, 16);
			lblProveidor.setFont(font);

			// Camp que guarda el Proveidor
			txtProveidor = new JTextField();
			getContentPane().add(txtProveidor);
			txtProveidor.setBounds(144, 133, 168, 23);

			// Etiqueta de article
			lblArticle = new JLabel();
			getContentPane().add(lblArticle);
			lblArticle.setText("IDArticle");
			lblArticle.setBounds(52, 171, 87, 16);
			lblArticle.setFont(font);

			// Camp que guarda article
			txtArticle = new JTextField();
			getContentPane().add(txtArticle);
			txtArticle.setBounds(144, 168, 168, 23);

			// Etiqueta de preu
			txtPreu = new JTextField();
			getContentPane().add(txtPreu);
			txtPreu.setBounds(144, 203, 168, 23);

			// Camp que gaurda el preu
			lblPreu = new JLabel();
			getContentPane().add(lblPreu);
			lblPreu.setText("Preu");
			lblPreu.setBounds(52, 206, 92, 16);
			lblPreu.setFont(font);

			// Bot� guardar
			btnGuardar = new JButton();
			getContentPane().add(btnGuardar);
			btnGuardar.setText("Guardar Entrada");
			btnGuardar.setBounds(12, 251, 270, 23);
			btnGuardar.setSize(224, 23);
			btnGuardar.setFont(font);

			pack();
			this.setSize(400, 319);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
