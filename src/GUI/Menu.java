package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
	private JLabel 	lblMenu;
	private JButton btnComandes;
	private JButton btnSortir;
	private JButton btnConsultes;
	private JButton btnEmpleat;
	private JButton btnTancar;
	private JButton btnClients;
	private JButton btnTendes;
	private JButton btnJocs;


	public Menu() {
		super("Men� Principal");
		try {

			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			// Etiqueta del t�tol de la finestra
			lblMenu = new JLabel();
			getContentPane().add(lblMenu);
			lblMenu.setText("MEN� PRINCIPAL DE L'APLICATIU");
			lblMenu.setBounds(86, 12, 242, 16);

			// Bot� d'acc�s a l'apartat de jocs
			btnJocs = new JButton();
			getContentPane().add(btnJocs);
			btnJocs.setText("Gesti� de Jocs");
			btnJocs.setBounds(44, 40, 292, 23);
			btnJocs.addActionListener(this);
			btnJocs.setActionCommand("btnJocs");

			// Bot� d'acc�s a la gesti� de tendes
			btnTendes = new JButton();
			getContentPane().add(btnTendes);
			btnTendes.setText("Gesti� de Tendes");
			btnTendes.setBounds(44, 74, 292, 23);
			btnTendes.addActionListener(this);
			btnTendes.setActionCommand("btnTendes");

			// Bot� d'acc�s a l'apartat de comandes
			btnComandes = new JButton();
			getContentPane().add(btnComandes);
			btnComandes.setText("Gesti� de Comandes");
			btnComandes.setBounds(44, 108, 292, 23);
			btnComandes.addActionListener(this);
			btnComandes.setActionCommand("btnComandes");

			// Bot� d'acc�s a la gesti� de clients
			btnClients = new JButton();
			getContentPane().add(btnClients);
			btnClients.setText("Gesti� de Clients");
			btnClients.setBounds(44, 142, 292, 23);
			btnClients.addActionListener(this);
			btnClients.setActionCommand("btnClients");

			// Bot� que dona acc�s a la gesti� d'empleats
			btnEmpleat = new JButton();
			getContentPane().add(btnEmpleat);
			btnEmpleat.setText("Gesti� d'Empleats");
			btnEmpleat.setBounds(44, 173, 292, 23);
			btnEmpleat.addActionListener(this);
			btnEmpleat.setActionCommand("btnEmpleat");

			// Bot� que tanca la sesi� de l'usuari
			btnTancar = new JButton();
			getContentPane().add(btnTancar);
			btnTancar.setText("Tancar la sessi�");
			btnTancar.setBounds(44, 207, 143, 34);
			btnTancar.addActionListener(this);
			btnTancar.setActionCommand("btnTancar");

			// Bot� que crida a la finestra de consultes
			btnConsultes = new JButton();
			getContentPane().add(btnConsultes);
			btnConsultes.setText("Consultar");
			btnConsultes.setBounds(192, 207, 143, 34);
			btnConsultes.addActionListener(this);
			btnConsultes.setActionCommand("btnConsulta");

			// Bot� que tanca la sessio i surt de l'aplicaciu
			btnSortir = new JButton();
			getContentPane().add(btnSortir);
			btnSortir.setText("Sortir de l'aplicatiu");
			btnSortir.setBounds(43, 252, 292, 35);
			btnSortir.addActionListener(this);
			btnSortir.setActionCommand("btnSortir");
			pack();
			this.setSize(391, 364);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metode que obrir� la finestra indicada depenent de quin bot� premem
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnJocs")) {
			this.dispose();
			UIJocs inst = new UIJocs();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTendes")) {
			this.dispose();
			UITendes inst = new UITendes();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnComandes")) {
			this.dispose();
			UIComandes inst = new UIComandes();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnClients")) {
			this.dispose();
			UIClients inst = new UIClients();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEmpleat")) {
			this.dispose();
			UITreballadors inst = new UITreballadors();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnConsulta")) {
			this.dispose();
			UIConsultes inst = new UIConsultes();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTancar")) {
			this.dispose();
			BD.close();
			Login inst = new Login();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnSortir")) {
			BD.close();
			System.exit(0);
		}
	}
	
}