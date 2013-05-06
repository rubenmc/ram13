package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JMenu extends JFrame implements ActionListener {
	private JLabel 	jlMen�;
	private JButton jbComandes;
	private JButton jbSortir;
	private JButton jEmpleat;
	private JButton jbTancar;
	private JButton jbClients;
	private JButton jbTendes;
	private JButton jbJocs;

	public JMenu() {
		super("Men� Principal");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
				
				//Etiqeta del t�tol de la finestra
				jlMen� = new JLabel();
				getContentPane().add(jlMen�);
				jlMen�.setText("MEN� PRINCIPAL DE L'APLICATIU");
				jlMen�.setBounds(86, 12, 242, 16);
				
				//Bot� d'acc�s a l'apartat de joc
				jbJocs = new JButton();
				getContentPane().add(jbJocs);
				jbJocs.setText("Gesti� de Jocs");
				jbJocs.setBounds(44, 40, 292, 23);
				jbJocs.addActionListener(this);
				jbJocs.setActionCommand("btnJocs");
				
				//Bot� d'acc�s a la gestio de tendes
				jbTendes = new JButton();
				getContentPane().add(jbTendes);
				jbTendes.setText("Gesti� de Tendes");
				jbTendes.setBounds(44, 74, 292, 23);
				jbTendes.addActionListener(this);
				jbTendes.setActionCommand("btnTendes");
				
				//Bot� d'acc�s a l'apartat de comandes
				jbComandes = new JButton();
				getContentPane().add(jbComandes);
				jbComandes.setText("Gesti� de Comandes");
				jbComandes.setBounds(44, 108, 292, 23);
				jbComandes.addActionListener(this);
				jbComandes.setActionCommand("btnComandes");

				//Bot� d'acc�s a la gesti� de clients
				jbClients = new JButton();
				getContentPane().add(jbClients);
				jbClients.setText("Gesti� de Clients");
				jbClients.setBounds(44, 142, 292, 23);
				jbClients.addActionListener(this);
				jbClients.setActionCommand("btnClients");
				
				//Bot� que dona acc�s a 
				jEmpleat = new JButton();
				getContentPane().add(jEmpleat);
				jEmpleat.setText("Gesti� d'Empleats");
				jEmpleat.setBounds(44, 173, 292, 23);
				jEmpleat.addActionListener(this);
				jEmpleat.setActionCommand("btnEmpleat");
				
				//Bot� que tanca la sesi� de l'usuari
				jbTancar = new JButton();
				getContentPane().add(jbTancar);
				jbTancar.setText("Tancar la sessi�");
				jbTancar.setBounds(44, 207, 143, 34);
				jbTancar.addActionListener(this);
				jbTancar.setActionCommand("btnTancar");
				
				//Bot� que surt de l'aplicaciu
				jbSortir = new JButton();
				getContentPane().add(jbSortir);
				jbSortir.setText("Sortir de l'aplicatiu");
				jbSortir.setBounds(192, 206, 144, 35);
				jbSortir.addActionListener(this);
				jbSortir.setActionCommand("btnSortir");

			pack();
			this.setSize(412, 291);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Part del actionPerformed on hem de cridar a les finestres de cada apartat
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnJocs")) {
			this.setVisible(false);
			JJocs inst = new JJocs();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTendes")) {
			this.setVisible(false);
			JTendes inst = new JTendes();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnComandes")) {
			this.setVisible(false);
			JComandes inst = new JComandes();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnClients")) {
			this.setVisible(false);
			JClients inst = new JClients();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEmpleat")) {
			this.setVisible(false);
			JTreballadors inst = new JTreballadors();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTancar")) {
			this.setVisible(false);
			JLogin inst = new JLogin();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnSortir")) {
			System.exit(0);
		}
	}

}
