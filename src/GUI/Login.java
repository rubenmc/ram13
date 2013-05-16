package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private BD bd;

	public Login() {
		super("Inici de Sessió");
		try {
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

			// Etiqueta del password
			lblPass = new JLabel();
			getContentPane().add(lblPass);
			lblPass.setText("Clau");
			lblPass.setBounds(18, 68, 74, 16);

			// Etiqueta títol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("Introdueix les dades de l'usuari");
			lblTitol.setBounds(72, 12, 211, 16);

			// Botó per verificar el login
			btnEntrar = new JButton();
			getContentPane().add(btnEntrar);
			btnEntrar.setText("Accedir al programa");
			btnEntrar.setBounds(18, 96, 265, 23);
			btnEntrar.addActionListener(this);

			pack();
			this.setSize(332, 176);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Main del programa
	public static void main(String[] args) {
		Login inst = new Login();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	// ActionPerformed del botó per accedir a l'aplicatiu
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
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
