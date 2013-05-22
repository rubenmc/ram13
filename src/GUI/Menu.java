package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
	private JLabel lblMenu;
	private JButton btnComandes;
	private JButton btnSortir;
	private JButton btnConsultes;
	private JButton btnEmpleats;
	private JButton btnTancar;
	private JButton btnClients;
	private JButton btnTendes;
	private JButton btnJocs;
	private JButton btnUnitats;
	private Font font;

	public Menu() {
		super("Men� Principal");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 16);
			JLabel bg = new JLabel();
			setContentPane(bg);
			setBackground(new Color(140, 210, 228));

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			// Etiqueta del t�tol de la finestra
			lblMenu = new JLabel();
			getContentPane().add(lblMenu);
			lblMenu.setText("MEN� PRINCIPAL");
			lblMenu.setBounds(0, 12, 400, 23);
			lblMenu.setFont(font);
			lblMenu.setHorizontalAlignment(JLabel.CENTER);

			// Bot� d'acc�s a l'apartat de jocs
			btnJocs = new JButton();
			getContentPane().add(btnJocs);
			btnJocs.setText("Gesti� de Jocs");
			btnJocs.setBounds(44, 40, 292, 23);
			btnJocs.addActionListener(this);
			btnJocs.setActionCommand("btnJocs");
			btnJocs.setFont(font);
			btnJocs.setHorizontalAlignment(JLabel.CENTER);

			// Bot� d'acc�s a la gesti� de tendes
			btnTendes = new JButton();
			getContentPane().add(btnTendes);
			btnTendes.setText("Gesti� de Tendes");
			btnTendes.setBounds(44, 70, 292, 23);
			btnTendes.addActionListener(this);
			btnTendes.setActionCommand("btnTendes");
			btnTendes.setFont(font);
			btnTendes.setHorizontalAlignment(JLabel.CENTER);

			// Bot� d'acc�s a l'apartat de comandes
			btnComandes = new JButton();
			getContentPane().add(btnComandes);
			btnComandes.setText("Gesti� de Comandes");
			btnComandes.setBounds(44, 100, 292, 23);
			btnComandes.addActionListener(this);
			btnComandes.setActionCommand("btnComandes");
			btnComandes.setFont(font);
			btnComandes.setHorizontalAlignment(JLabel.CENTER);

			// Bot� d'acc�s a la gesti� de clients
			btnClients = new JButton();
			getContentPane().add(btnClients);
			btnClients.setText("Gesti� de Clients");
			btnClients.setBounds(44, 130, 292, 23);
			btnClients.addActionListener(this);
			btnClients.setActionCommand("btnClients");
			btnClients.setFont(font);
			btnClients.setHorizontalAlignment(JLabel.CENTER);

			// Bot� que dona acc�s a la gesti� d'empleats
			btnEmpleats = new JButton();
			getContentPane().add(btnEmpleats);
			btnEmpleats.setText("Gesti� d'Empleats");
			btnEmpleats.setBounds(44, 160, 292, 23);
			btnEmpleats.addActionListener(this);
			btnEmpleats.setActionCommand("btnEmpleat");
			btnEmpleats.setFont(font);
			btnEmpleats.setHorizontalAlignment(JLabel.CENTER);
			
			// Bot� que dona acc�s a la gesti� d'empleats
			btnUnitats = new JButton();
			getContentPane().add(btnUnitats);
			btnUnitats.setText("Gesti� d'Unitats");
			btnUnitats.setBounds(44, 190, 292, 23);
			btnUnitats.addActionListener(this);
			btnUnitats.setActionCommand("btnUnitats");
			btnUnitats.setFont(font);
			btnUnitats.setHorizontalAlignment(JLabel.CENTER);

			// Bot� que tanca la sesi� de l'usuari
			btnTancar = new JButton();
			getContentPane().add(btnTancar);
			btnTancar.setText("Tancar sessi�");
			btnTancar.setBounds(44, 220, 143, 34);
			btnTancar.addActionListener(this);
			btnTancar.setActionCommand("btnTancar");
			btnTancar.setFont(font);
			btnTancar.setHorizontalAlignment(JLabel.CENTER);

			// Bot� que crida a la finestra de consultes
			btnConsultes = new JButton();
			getContentPane().add(btnConsultes);
			btnConsultes.setText("Consultar");
			btnConsultes.setBounds(192, 220, 143, 34);
			btnConsultes.addActionListener(this);
			btnConsultes.setActionCommand("btnConsulta");
			btnConsultes.setFont(font);
			btnConsultes.setHorizontalAlignment(JLabel.CENTER);

			// Bot� que tanca la sessio i surt de l'aplicaciu
			btnSortir = new JButton();
			getContentPane().add(btnSortir);
			btnSortir.setText("Sortir");
			btnSortir.setBounds(43, 270, 292, 35);
			btnSortir.addActionListener(this);
			btnSortir.setActionCommand("btnSortir");
			btnSortir.setFont(font);
			btnSortir.setHorizontalAlignment(JLabel.CENTER);
			
			pack();
			this.setSize(400, 365);
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
		} else if (e.getActionCommand().equals("btnUnitats")) {
			this.dispose();
			UIUnitats inst = new UIUnitats();
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