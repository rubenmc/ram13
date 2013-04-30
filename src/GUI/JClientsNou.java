package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JClientsNou extends JFrame implements ActionListener {
	
	private JLabel 		jlClientsNou;

	private JTextField 	jtfDNI;
	private JTextField 	jtfNom;
	private JTextField 	jtfTelefon;

	private JLabel 		jlDNI;
	private JLabel 		jlNom;
	private JLabel 		jlTelefon;

	private JButton 	jbGuardar;

	public JClientsNou() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Títol de la finestra
				jlClientsNou = new JLabel();
				getContentPane().add(jlClientsNou);
				jlClientsNou.setText("Esteu Introduïnt un Client nou");
				jlClientsNou.setBounds(12, 12, 354, 16);
				
				//Etiqueta de "Nom del treballador"
				jlNom = new JLabel();
				getContentPane().add(jlNom);
				jlNom.setText("Client");
				jlNom.setBounds(39, 78, 66, 16);
				
				//Camp que guarda el nom del client
				jtfNom = new JTextField();
				getContentPane().add(jtfNom);
				jtfNom.setText("Introdueix el nom del Client");
				jtfNom.setBounds(138, 75, 228, 23);
				
				//Etiqueta de "DNI"
				jlDNI = new JLabel();
				getContentPane().add(jlDNI);
				jlDNI.setText("DNI");
				jlDNI.setBounds(39, 113, 87, 16);
				
				//Camp que guarda el DNI
				jtfDNI = new JTextField();
				getContentPane().add(jtfDNI);
				jtfDNI.setText("Introdueix el DNI");
				jtfDNI.setBounds(138, 110, 98, 23);
				
				//Etiqueta de "Telefon"
				jlTelefon = new JLabel();
				getContentPane().add(jlTelefon);
				jlTelefon.setText("Telefon");
				jlTelefon.setBounds(39, 148, 87, 16);

				//Camp que guarda la el telefon
				jtfTelefon = new JTextField();
				getContentPane().add(jtfTelefon);
				jtfTelefon.setText("Introdueix el Telefon");
				jtfTelefon.setBounds(138, 145, 133, 23);
				
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
		JClientsNou inst = new JClientsNou();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
