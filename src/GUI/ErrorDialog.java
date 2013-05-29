package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
@SuppressWarnings("serial")
public class ErrorDialog extends JDialog implements ActionListener {
	private JButton btnOK;
	private JLabel 	lblError;

	/**
	 * 
	 * @param frame
	 *            Frame del pare
	 * @param error
	 *            Missatge a mostrar
	 */
	public ErrorDialog(JFrame frame, String error) {
		super(frame, "Error de login");
		try {
			// Fons
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));
			getContentPane().setLayout(null);

			// Boto per tancar el Dialog
			btnOK = new JButton();
			getContentPane().add(btnOK);
			btnOK.setText("OK");
			btnOK.setBounds(142, 81, 91, 23);
			btnOK.addActionListener(this);

			// Etiqueta per mostrar l'error
			lblError = new JLabel();
			getContentPane().add(lblError);
			lblError.setBounds(38, 21, 300, 43);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setHorizontalTextPosition(SwingConstants.CENTER);
			lblError.setText(error);

			this.setSize(400, 165);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param frame
	 *            Frame del pare
	 * @param error
	 *            Missatge a mostrar
	 */
	public ErrorDialog(JDialog frame, String error) {
		super(frame, "Error");
		try {
			// Fons
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));
			getContentPane().setLayout(null);

			// Boto per tancar el Dialog
			btnOK = new JButton();
			getContentPane().add(btnOK);
			btnOK.setText("OK");
			btnOK.setBounds(142, 81, 91, 23);
			btnOK.addActionListener(this);
			// Etiqueta per mostrar l'error
			lblError = new JLabel();
			getContentPane().add(lblError);
			lblError.setBounds(38, 21, 300, 43);
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setHorizontalTextPosition(SwingConstants.CENTER);
			lblError.setText(error);

			this.setSize(400, 165);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

}
