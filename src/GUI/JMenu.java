package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JMenu extends JFrame implements ActionListener {
	private JLabel jlMenú;
	private JButton jbComandes;
	private JButton jbSortir;
	private JButton jEmpleat;
	private JButton jbTancar;
	private JButton jbClients;
	private JButton jbTendes;
	private JButton jbJocs;

	public JMenu() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Etiqeta del títol de la finestra
				jlMenú = new JLabel();
				getContentPane().add(jlMenú);
				jlMenú.setText("MENÚ PRINCIPAL DE L'APLICATIU");
				jlMenú.setBounds(86, 12, 242, 16);
				
				//Botó d'accés a l'apartat de joc
				jbJocs = new JButton();
				getContentPane().add(jbJocs);
				jbJocs.setText("Gestió de Jocs");
				jbJocs.setBounds(44, 40, 292, 23);
				
				//Botó d'accés a la gestio de tendes
				jbTendes = new JButton();
				getContentPane().add(jbTendes);
				jbTendes.setText("Gestió de Tendes");
				jbTendes.setBounds(44, 74, 292, 23);
				
				//Botó d'accés a l'apartat de comandes
				jbComandes = new JButton();
				getContentPane().add(jbComandes);
				jbComandes.setText("Gestió de Comandes");
				jbComandes.setBounds(44, 108, 292, 23);

				//Botó d'accés a la gestió de clients
				jbClients = new JButton();
				getContentPane().add(jbClients);
				jbClients.setText("Gestió de Clients");
				jbClients.setBounds(44, 142, 292, 23);
				
				//Botó que dona accés a 
				jEmpleat = new JButton();
				getContentPane().add(jEmpleat);
				jEmpleat.setText("Gestió d'Empleats");
				jEmpleat.setBounds(44, 173, 292, 23);
				
				//Botó que tanca la sesió de l'usuari
				jbTancar = new JButton();
				getContentPane().add(jbTancar);
				jbTancar.setText("Tancar la sessió");
				jbTancar.setBounds(44, 207, 143, 34);
				
				//Botó que surt de l'aplicaciu
				jbSortir = new JButton();
				getContentPane().add(jbSortir);
				jbSortir.setText("Sortir de l'aplicatiu");
				jbSortir.setBounds(192, 206, 144, 35);

			pack();
			this.setSize(412, 291);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Main de la part del menú (tiene los dias contados ^^)
	public static void main(String[] args) {
		JMenu inst = new JMenu();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	//Part del actionPerformed on hem de cridar a les finestres de cada apartat
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
