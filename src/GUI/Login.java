package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
	private JPasswordField txtPass;
	private JTextField txtUser;
	private JButton btnEntrar;
	private JLabel lblTitol;
	private JLabel lblPass;
	private JLabel lblUser;
	private Font font;
	private BD bd;

	public Login() {
		super("Inici de Sessió");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 16);
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// TextField que guarda el nom de l'usuari
			txtUser = new JTextField();
			getContentPane().add(txtUser);
			txtUser.setBounds(98, 37, 185, 23);

			// TextField que guarda el password del usuari
			txtPass = new JPasswordField();
			getContentPane().add(txtPass);
			txtPass.setBounds(98, 65, 185, 23);

			// Etiqueta de login
			lblUser = new JLabel();
			getContentPane().add(lblUser);
			lblUser.setText("Usuari");
			lblUser.setBounds(18, 40, 74, 16);
			lblUser.setFont(font);

			// Etiqueta del password
			lblPass = new JLabel();
			getContentPane().add(lblPass);
			lblPass.setText("Clau");
			lblPass.setBounds(18, 68, 74, 16);
			lblPass.setFont(font);

			// Etiqueta títol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Introdueix les dades de l'usuari");
			lblTitol.setBounds(72, 12, 211, 16);
			lblTitol.setFont(font);

			// Botó per verificar el login
			btnEntrar = new JButton();
			getContentPane().add(btnEntrar);
			btnEntrar.setText("Accedir al programa");
			btnEntrar.setBounds(18, 96, 265, 23);
			btnEntrar.addActionListener(this);
			btnEntrar.setFont(font);

			pack();
			this.setSize(340, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metode principal
	 * @param args
	 */
	public static void main(String[] args) {
		Login inst = new Login();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	/**
	 * Metode que s'executara al ingresar un usuari i una contrasenya
	 */
	public void actionPerformed(ActionEvent arg0) {
		try {
			bd = new BD();
			// Intentem accedir a l'aplicatiu
			int res = bd.connecta(txtUser.getText(), txtPass.getText());
			// Si el metode per connectar-nos retorna un numero diferent a 1
			// significa que hi ha hagut un error
			if (res != 1) {
				// Creem un dialog indicant l'error
				String missatge = null;
				switch (res) {
				case 0:
					missatge = new String("Usuari o contrasenya incorrecta");
					break;
				case 2:
					missatge = new String("Ja estas conectat");
					break;
				}
				ErrorDialog error = new ErrorDialog(this, true, missatge);
				error.setLocationRelativeTo(null);
				error.setVisible(true);
			} else {
				// Si el metode no dona error ocultem el login i obrim el menu
				this.dispose();
				Menu menu = new Menu();
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch  (IllegalAccessException e){
			e.printStackTrace();
		}
	}
}
