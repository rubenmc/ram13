package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class JTendesNou extends JFrame implements ActionListener {
	
	private JLabel 		jlTendesNou;

	private JTextField 	jtfDireccio;
	private JTextField 	jtfTelefon;

	private JLabel 		jlDireccio;
	private JLabel 		jlTelefon;

	private JButton 	jbGuardar;

	public JTendesNou() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Títol de la finestra
				jlTendesNou = new JLabel();
				getContentPane().add(jlTendesNou);
				jlTendesNou.setText("Esteu Introduïnt una tenda nova");
				jlTendesNou.setBounds(12, 12, 354, 16);
				
				//Etiqueta de "Nom del treballador"
				jlDireccio = new JLabel();
				getContentPane().add(jlDireccio);
				jlDireccio.setText("Direcció");
				jlDireccio.setBounds(39, 97, 66, 16);
				
				//Camp que guarda la direcció de la tenda
				jtfDireccio = new JTextField();
				getContentPane().add(jtfDireccio);
				jtfDireccio.setBounds(138, 94, 228, 23);
				
				//Etiqueta de "Companyia"
				jlTelefon = new JLabel();
				getContentPane().add(jlTelefon);
				jlTelefon.setText("Telefon");
				jlTelefon.setBounds(39, 132, 87, 16);

				//Camp que guarda la companyia
				jtfTelefon = new JTextField();
				getContentPane().add(jtfTelefon);
				jtfTelefon.setBounds(138, 129, 133, 23);
				
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
		JTendesNou inst = new JTendesNou();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
