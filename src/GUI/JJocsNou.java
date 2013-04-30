package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JJocsNou extends JFrame implements ActionListener {
	private JLabel jlJocsNoi;
	private JTextField jtfPreu;
	private JButton jbGuardar;
	private JLabel jlCia;
	private JLabel jlPreu;
	private JLabel jlNom;
	private JTextField jtfCompanyia;
	private JTextField jtfNom;

	public JJocsNou() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Títol de la finestra
				jlJocsNoi = new JLabel();
				getContentPane().add(jlJocsNoi);
				jlJocsNoi.setText("Esteu Introduïnt un joc nou");
				jlJocsNoi.setBounds(12, 12, 354, 16);
				
				//Etiqueta de "joc"
				jlNom = new JLabel();
				getContentPane().add(jlNom);
				jlNom.setText("Joc");
				jlNom.setBounds(39, 78, 66, 16);
				
				//Camp que guarda el nom del joc
				jtfNom = new JTextField();
				getContentPane().add(jtfNom);
				jtfNom.setBounds(138, 75, 228, 23);
				
				//Etiqueta de "preu"
				jlPreu = new JLabel();
				getContentPane().add(jlPreu);
				jlPreu.setText("Preu");
				jlPreu.setBounds(39, 113, 87, 16);
				
				//Camp que guarda el preu
				jtfPreu = new JTextField();
				getContentPane().add(jtfPreu);
				jtfPreu.setBounds(138, 110, 98, 23);
				
				//Etiquesta de "Companyia"
				jlCia = new JLabel();
				getContentPane().add(jlCia);
				jlCia.setText("Companyia");
				jlCia.setBounds(39, 148, 87, 16);

				//Camp que guarda la companyia
				jtfCompanyia = new JTextField();
				getContentPane().add(jtfCompanyia);
				jtfCompanyia.setBounds(138, 145, 133, 23);
				
				//Botó guardar
				jbGuardar = new JButton();
				getContentPane().add(jbGuardar);
				jbGuardar.setText("Guardar Entrada");
				jbGuardar.setBounds(66, 204, 270, 23);
		
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JJocsNou inst = new JJocsNou();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
