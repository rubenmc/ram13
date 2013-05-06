package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
public class ErrorDialog extends JDialog implements ActionListener {
	private JButton jbOK;
	private JLabel jlblError;


	public ErrorDialog(JFrame frame, boolean modal, int error) {
		super(frame,"Error de login",modal);
		try {
			{
				getContentPane().setLayout(null);
				
					jbOK = new JButton();
					getContentPane().add(jbOK);
					jbOK.setText("OK");
					jbOK.setBounds(142, 81, 91, 23);
					jbOK.addActionListener(this);
				
				
					jlblError = new JLabel();
					getContentPane().add(jlblError);
					jlblError.setBounds(38, 21, 300, 43);
					jlblError.setHorizontalAlignment(SwingConstants.CENTER);
					jlblError.setHorizontalTextPosition(SwingConstants.CENTER);

					switch(error){
					case 0: jlblError.setText("Ja estas conectat");
					break;
					case 2: jlblError.setText("Contrasenya incorrecta");
					break;
					case 3: jlblError.setText("Usuari incorrecte");
					break;
					case 4: jlblError.setText("Error de conexio");
					break;
					}
				
			}
			this.setSize(401, 163);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		JLogin inst = new JLogin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		
	}
	

}
