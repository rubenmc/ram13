package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.JButton;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import main.BD;

@SuppressWarnings("serial")
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class UIConsultes extends JFrame implements ActionListener {
	private JTabbedPane panelPestanyes;
	private JButton btnTornar;
	private Taula 		taulaJocs;
	private Taula 		taulaTendes;
	private Taula 		taulaComandes;
	private Taula 		taulaParticulars;
	private Taula 		taulaMajoristes;
	private Taula 		taulaEmpleats;
	private JLabel 		lblTitol;
	private Insets 		scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int 		taskBarSize = scnMax.bottom;
	private Dimension 	pantalla = getToolkit().getScreenSize();
	private URL 		imageURL = ClassLoader.getSystemResource("img/consultes.png");
	private URL 		imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon 		icon = new ImageIcon(imageURL);
	private Icon 		bgimg = new ImageIcon(imageURLbg);
	private Font 		font;

	public UIConsultes() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 24);
		} catch (Exception e) {
			font = null;
		}
		// Fons
		JLabel bg = new JLabel();
		bg.setIcon(bgimg);
		bg.setSize(pantalla.width, pantalla.height);
		setContentPane(bg);

		setTitle("Consultes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Calculem i ajustem la mida de la finestra
		calculateLocation();
		setBackground(new Color(140, 210, 228));

		// Etiqueta de titol
		lblTitol = new JLabel();
		getContentPane().add(lblTitol);
		lblTitol.setIcon(icon);
		lblTitol.setBounds(pantalla.width / 4, pantalla.height / 40,
				pantalla.width / 2, 60);
		lblTitol.setHorizontalAlignment(SwingConstants.CENTER);

		// Omplim les taules
		taulaJocs = BD.getDadesConsulta("jocs", pantalla.width, pantalla.height
				- taskBarSize);

		taulaTendes = BD.getDadesConsulta("tendes", pantalla.width,
				pantalla.height - taskBarSize);

		taulaComandes = BD.getDadesConsulta("comandes", pantalla.width,
				pantalla.height - taskBarSize);

		taulaParticulars = BD.getDadesConsulta("particulars", pantalla.width,
				pantalla.height - taskBarSize);

		taulaMajoristes = BD.getDadesConsulta("majoristes", pantalla.width,
				pantalla.height - taskBarSize);

		taulaEmpleats = BD.getDadesConsulta("empleats", pantalla.width,
				pantalla.height - taskBarSize);

		// Instanciem el panell per les pestanyes
		panelPestanyes = new JTabbedPane(SwingConstants.TOP);
		panelPestanyes.setBounds(0, (pantalla.height - taskBarSize) / 4,
				pantalla.width, (pantalla.height - taskBarSize) / 2);
		panelPestanyes.setBackground(new Color(140, 210, 228));
		add(panelPestanyes);

		// Boto per tornar al menu
		btnTornar = new JButton();
		add(btnTornar);
		btnTornar.setText("Tornar");
		btnTornar.setBounds((pantalla.width / 2) - pantalla.width / 8,
				(int) ((pantalla.height - taskBarSize) / 1.25),
				pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
		btnTornar.addActionListener(this);
		btnTornar.setActionCommand("btnTornar");
		btnTornar.setFont(font);

		// Pestanya de jocs
		JPanel jocsPane = new JPanel();
		panelPestanyes.addTab("Jocs", null, jocsPane, null);
		jocsPane.setLayout(null);
		if (taulaJocs != null) {
			taulaJocs.setBackground(new Color(140, 210, 228));
			taulaJocs.setBounds(0, 0, pantalla.width,
					taulaJocs.getTableHeight());
			jocsPane.add(taulaJocs);
		}

		jocsPane.setBackground((new Color(140, 210, 228)));

		// Pestanya de tendes
		JPanel tendesPane = new JPanel();
		panelPestanyes.addTab("Tendes", null, tendesPane, null);
		tendesPane.setLayout(null);
		if (taulaTendes != null) {
			taulaTendes.setBackground(new Color(140, 210, 228));
			taulaTendes.setBounds(0, 0, pantalla.width,
					taulaTendes.getTableHeight());
			tendesPane.add(taulaTendes);
		}
		tendesPane.setBackground((new Color(140, 210, 228)));

		// Pestanya de comandes
		JPanel comandesPane = new JPanel();
		panelPestanyes.addTab("Comandes", null, comandesPane, null);
		comandesPane.setLayout(null);
		if (taulaComandes != null) {
			taulaComandes.setBackground(new Color(140, 210, 228));
			taulaComandes.setBounds(0, 0, pantalla.width,
					taulaComandes.getTableHeight());
			comandesPane.add(taulaComandes);
		}
		comandesPane.setBackground((new Color(140, 210, 228)));

		// Pestanya de particulars
		JPanel clientsPane = new JPanel();
		panelPestanyes.addTab("Particulars", null, clientsPane, null);
		clientsPane.setLayout(null);
		if (taulaParticulars != null) {
			taulaParticulars.setBackground(new Color(140, 210, 228));
			taulaParticulars.setBounds(0, 0, pantalla.width,
					taulaParticulars.getTableHeight());
			clientsPane.add(taulaParticulars);
		}
		clientsPane.setBackground((new Color(140, 210, 228)));

		// Pestanya de majoristes
		JPanel majoristesPane = new JPanel();
		panelPestanyes.addTab("Majoristes", null, majoristesPane, null);
		majoristesPane.setLayout(null);
		if (taulaMajoristes != null) {
			taulaMajoristes.setBackground(new Color(140, 210, 228));
			taulaMajoristes.setBounds(0, 0, pantalla.width,
					taulaMajoristes.getTableHeight());
			majoristesPane.add(taulaMajoristes);
		}
		majoristesPane.setBackground((new Color(140, 210, 228)));

		// Pestanya de empleats
		JPanel empleatsPane = new JPanel();
		panelPestanyes.addTab("Empleats", null, empleatsPane, null);
		empleatsPane.setLayout(null);
		if (taulaEmpleats != null) {
			taulaEmpleats.setBackground(new Color(140, 210, 228));
			taulaEmpleats.setBounds(0, 0, pantalla.width,
					taulaEmpleats.getTableHeight());
			empleatsPane.add(taulaEmpleats);
		}
		empleatsPane.setBackground((new Color(140, 210, 228)));
	}

	@Override
	/**
	 * Métode que s'executara al fer clic a un botó i que realitzara la acció indicada
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnTornar")) {
			this.dispose();
			Menu inst = new Menu();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
	}

	/**
	 * Métode per calcular i ajustar la mida que ha d'agafar la finestra
	 */
	private void calculateLocation() {
		setSize(pantalla.width, pantalla.height - taskBarSize);
		int locationx = (pantalla.width) / 2;
		int locationy = (pantalla.height) / 2;
		setLocation(locationx, locationy);

	}

}
