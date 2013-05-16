package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.BD;

@SuppressWarnings("serial")
public class UIConsultes extends JFrame implements ActionListener {
	private JTabbedPane panelPestanyes;
	private JButton btnTornar;
	private Taula taula1;
	private Taula taula2;
	private Taula taula3;
	private Taula taula4;
	private Taula taula5;
	private Taula taula6;
	private Insets scnMax = getToolkit().getScreenInsets(
			getGraphicsConfiguration());
	private int taskBarSize = scnMax.bottom;
	private Dimension pantalla = getToolkit().getScreenSize();
	private URL imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon bgimg = new ImageIcon(imageURLbg);

	public UIConsultes() {
		JLabel bg = new JLabel();
		bg.setIcon(bgimg);
		bg.setSize(pantalla.width, pantalla.height);
		setContentPane(bg);

		setTitle("Consultes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculateLocation();
		setBackground(new Color(140, 210, 228));

		taula1 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula1.setBackground(new Color(140, 210, 228));
		taula1.setBounds(0, 0, pantalla.width, taula1.getTableHeight());

		taula2 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula2.setBackground(new Color(140, 210, 228));
		taula2.setBounds(0, 0, pantalla.width, taula2.getTableHeight());

		taula3 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula3.setBackground(new Color(140, 210, 228));
		taula3.setBounds(0, 0, pantalla.width, taula3.getTableHeight());

		taula4 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula4.setBackground(new Color(140, 210, 228));
		taula4.setBounds(0, 0, pantalla.width, taula4.getTableHeight());

		taula5 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula5.setBackground(new Color(140, 210, 228));
		taula5.setBounds(0, 0, pantalla.width, taula5.getTableHeight());

		taula6 = BD.getDadesParticular(pantalla.width, pantalla.height
				- taskBarSize);
		taula6.setBackground(new Color(140, 210, 228));
		taula6.setBounds(0, 0, pantalla.width, taula6.getTableHeight());

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
				pantalla.width / 4,
				(int) ((pantalla.height - taskBarSize) / 10));
		btnTornar.addActionListener(this);
		btnTornar.setActionCommand("btnTornar");

		// PESTANYA JOCS
		JPanel jocsPane = new JPanel();
		panelPestanyes.addTab("Jocs", null, jocsPane, null);
		jocsPane.setLayout(null);
		jocsPane.add(taula1);
		jocsPane.setBackground((new Color(140, 210, 228)));

		// PESTANYA TENDES
		JPanel tendesPane = new JPanel();
		panelPestanyes.addTab("Tendes", null, tendesPane, null);
		tendesPane.setLayout(null);
		tendesPane.add(taula2);
		tendesPane.setBackground((new Color(140, 210, 228)));

		// PESTANYA COMANDES
		JPanel comandesPane = new JPanel();
		panelPestanyes.addTab("Comandes", null, comandesPane, null);
		comandesPane.setLayout(null);
		comandesPane.add(taula3);
		comandesPane.setBackground((new Color(140, 210, 228)));

		// PESTANYA CLIENTS
		JPanel clientsPane = new JPanel();
		panelPestanyes.addTab("Clients", null, clientsPane, null);
		clientsPane.setLayout(null);
		clientsPane.add(taula4);
		clientsPane.setBackground((new Color(140, 210, 228)));

		// PESTANYA MAJORISTES
		JPanel majoristesPane = new JPanel();
		panelPestanyes.addTab("Majoristes", null, majoristesPane, null);
		majoristesPane.setLayout(null);
		majoristesPane.add(taula5);
		majoristesPane.setBackground((new Color(140, 210, 228)));

		// PESTANYA EMPLEATS
		JPanel empleatsPane = new JPanel();
		panelPestanyes.addTab("Empleats", null, empleatsPane, null);
		empleatsPane.setLayout(null);
		empleatsPane.add(taula6);
		empleatsPane.setBackground((new Color(140, 210, 228)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("btnTornar")) {
			this.dispose();
			Menu inst = new Menu();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
	}

	private void calculateLocation() {
		setSize(pantalla.width, pantalla.height - taskBarSize);
		int locationx = (pantalla.width) / 2;
		int locationy = (pantalla.height) / 2;
		setLocation(locationx, locationy);

	}

}
