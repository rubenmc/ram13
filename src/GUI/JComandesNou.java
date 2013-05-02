package GUI;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JComandesNou extends JDialog implements ActionListener {
	
	private JLabel 		jlComandesNou;

	private JTextField 	jtfData;
	private JTextField 	jtfEmisor;
	private JTextField 	jtfReceptor;
	private JTextField 	jtfEstat;
	private JTextField 	jtfArticle;
	private JTextField 	jtfPreu;

	private JLabel 		jlData;
	private JLabel 		jlEmisor;
	private JLabel 		jlReceptor;
	private JLabel 		jlEstat;
	private JLabel 		jlArticle;
	private JLabel 		jlPreu;

	private JButton 	jbGuardar;

	public JComandesNou(Frame parent, boolean modal) {
		super(parent,"Nova comanda",modal);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Títol de la finestra
				jlComandesNou = new JLabel();
				getContentPane().add(jlComandesNou);
				jlComandesNou.setText("Esteu Introduïnt una comanda nova");
				jlComandesNou.setBounds(12, 12, 354, 16);
				
				//Etiqueta de "Data"
				jlData = new JLabel();
				getContentPane().add(jlData);
				jlData.setText("Data");
				jlData.setBounds(39, 78, 66, 16);
				
				//Camp que guarda la data
				jtfData = new JTextField();
				getContentPane().add(jtfData);
				jtfData.setBounds(138, 75, 228, 23);
				
				//Etiqueta de "Emisor"
				jlEmisor = new JLabel();
				getContentPane().add(jlEmisor);
				jlEmisor.setText("Emisor");
				jlEmisor.setBounds(39, 113, 87, 16);
				
				//Camp que guarda el emisor
				jtfEmisor = new JTextField();
				getContentPane().add(jtfEmisor);
				jtfEmisor.setBounds(138, 110, 98, 23);
				
				//Etiqueta de "Receptor"
				jlReceptor = new JLabel();
				getContentPane().add(jlReceptor);
				jlReceptor.setText("Receptor");
				jlReceptor.setBounds(39, 148, 87, 16);

				//Camp que guarda el Receptor
				jtfReceptor = new JTextField();
				getContentPane().add(jtfReceptor);
				jtfReceptor.setBounds(138, 145, 133, 23);
				
				//Etiqueta de "Estat"
				jlEstat = new JLabel();
				getContentPane().add(jlEstat);
				jlEstat.setText("Estat");
				jlEstat.setBounds(39, 183, 37, 16);
				
				//Camp que guarda el estat
				jtfEstat = new JTextField();
				getContentPane().add(jtfEstat);
				jtfEstat.setBounds(138, 180, 168, 23);
				
				//Etiqueta de ventes
				jlArticle = new JLabel();
				getContentPane().add(jlArticle);
				jlArticle.setText("Article");
				jlArticle.setBounds(39, 223, 37, 16);
				
				//Camp que guarda ventes
				jtfArticle = new JTextField();
				getContentPane().add(jtfArticle);
				jtfArticle.setBounds(138, 220, 140, 23);
				
				//Etiqueta de preu
				jtfPreu = new JTextField();
				getContentPane().add(jtfPreu);
				jtfPreu.setBounds(138, 255, 140, 23);
				
				//Camp que gaurda el preu
				jlPreu = new JLabel();
				getContentPane().add(jlPreu);
				jlPreu.setText("Preu");
				jlPreu.setBounds(39, 258, 24, 16);
				
				//Botó guardar
				jbGuardar = new JButton();
				getContentPane().add(jbGuardar);
				jbGuardar.setText("Guardar Entrada");
				jbGuardar.setBounds(64, 296, 270, 23);

			pack();
			this.setSize(407, 388);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
