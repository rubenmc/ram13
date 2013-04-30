package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JLogin extends JFrame implements ActionListener {
	private JTextField 	jtfLogin;
	private JButton 	jbEntrar;
	private JLabel 		jlLoginTitol;
	private JLabel 		jlPass;
	private JLabel 		jlLogin;
	private JTextField 	jtfPass;

	public JLogin() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//TextField que guarda el nom del usuari o login
				jtfLogin = new JTextField();
				getContentPane().add(jtfLogin);
				jtfLogin.setBounds(98, 37, 185, 23);
				
				//TextField que guarda el password del usuari
				jtfPass = new JTextField();
				getContentPane().add(jtfPass);
				jtfPass.setBounds(98, 65, 185, 23);
				
				//Etiqueta de login
				jlLogin = new JLabel();
				getContentPane().add(jlLogin);
				jlLogin.setText("Usuari");
				jlLogin.setBounds(18, 40, 74, 16);
				
				//Etiqueta del password
				jlPass = new JLabel();
				getContentPane().add(jlPass);
				jlPass.setText("Clau");
				jlPass.setBounds(18, 68, 74, 16);
				
				//Etiquesta títol
				jlLoginTitol = new JLabel();
				getContentPane().add(jlLoginTitol);
				jlLoginTitol.setText("Introdueix les dades de l'usuari");
				jlLoginTitol.setBounds(72, 12, 211, 16);
				
				//Botó d'accio amb actionPerformed ja implementat
				jbEntrar = new JButton();
				getContentPane().add(jbEntrar);
				jbEntrar.setText("Accedir al programa");
				jbEntrar.setBounds(18, 96, 265, 23);
			
			pack();
			this.setSize(332, 176);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Main del programa
	public static void main(String[] args) {
		JLogin inst = new JLogin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	//ActionPerformed del botó accedir a la base de dades
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
