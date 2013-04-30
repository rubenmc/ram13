package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JTreballadorsNou extends JFrame implements ActionListener {
	
	private JLabel 		jlTreballadorsNou;

	private JTextField 	jtfDNI;
	private JTextField 	jtfNom;
	private JTextField 	jtfTelefon;
	private JTextField 	jtfSS;
	private JTextField 	jtfVentes;

	private JLabel 		jlDNI;
	private JLabel 		jlNom;
	private JLabel 		jlTelefon;
	private JLabel 		jlSS;
	private JLabel 		jlVentes;

	private JButton 	jbGuardar;

	public JTreballadorsNou() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Títol de la finestra
				jlTreballadorsNou = new JLabel();
				getContentPane().add(jlTreballadorsNou);
				jlTreballadorsNou.setText("Esteu Introduïnt un Treballador nou");
				jlTreballadorsNou.setBounds(12, 12, 354, 16);
				
				//Etiqueta de "Nom del treballador"
				jlNom = new JLabel();
				getContentPane().add(jlNom);
				jlNom.setText("Treballador");
				jlNom.setBounds(39, 78, 66, 16);
				
				//Camp que guarda el nom del joc
				jtfNom = new JTextField();
				getContentPane().add(jtfNom);
				jtfNom.setBounds(138, 75, 228, 23);
				
				//Etiqueta de "preu"
				jlDNI = new JLabel();
				getContentPane().add(jlDNI);
				jlDNI.setText("DNI");
				jlDNI.setBounds(39, 113, 87, 16);
				
				//Camp que guarda el preu
				jtfDNI = new JTextField();
				getContentPane().add(jtfDNI);
				jtfDNI.setBounds(138, 110, 98, 23);
				
				//Etiqueta de "Companyia"
				jlTelefon = new JLabel();
				getContentPane().add(jlTelefon);
				jlTelefon.setText("Telefon");
				jlTelefon.setBounds(39, 148, 87, 16);

				//Camp que guarda la companyia
				jtfTelefon = new JTextField();
				getContentPane().add(jtfTelefon);
				jtfTelefon.setBounds(138, 145, 133, 23);
				
				//Etiqueta de la seguretat social
				jlSS = new JLabel();
				getContentPane().add(jlSS);
				jlSS.setText("NSS");
				jlSS.setBounds(39, 183, 37, 16);
				
				//Camp que guarda el numero de la seguretat social
				jtfSS = new JTextField();
				getContentPane().add(jtfSS);
				jtfSS.setBounds(138, 180, 168, 23);
				
				//Etiqueta de ventes
				jlVentes = new JLabel();
				getContentPane().add(jlVentes);
				jlVentes.setText("Ventes");
				jlVentes.setBounds(39, 223, 37, 16);
				
				//Camp que guarda ventes
				jtfVentes = new JTextField();
				getContentPane().add(jtfVentes);
				jtfVentes.setBounds(138, 220, 140, 23);
				
				//Botó guardar
				jbGuardar = new JButton();
				getContentPane().add(jbGuardar);
				jbGuardar.setText("Guardar Entrada");
				jbGuardar.setBounds(64, 277, 270, 23);

			pack();
			this.setSize(402, 370);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JTreballadorsNou inst = new JTreballadorsNou();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
