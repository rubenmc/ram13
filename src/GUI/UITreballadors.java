package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class UITreballadors extends JFrame implements ActionListener {
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnEliminar;
	private JButton btnNou;
	private JLabel lblTitol;
	private Taula treballadors;
	private Insets scnMax = getToolkit().getScreenInsets(
			getGraphicsConfiguration());
	private int taskBarSize = scnMax.bottom;
	private Dimension pantalla = getToolkit().getScreenSize();
	private URL imageURL = ClassLoader.getSystemResource("img/clients.png");
	private URL imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon icon = new ImageIcon(imageURL);
	private Icon bgimg = new ImageIcon(imageURLbg);

	public UITreballadors() {
		super("Gestió de treballadors");
		try {
			JLabel bg = new JLabel();
			bg.setIcon(bgimg);
			bg.setSize(pantalla.width, pantalla.height);
			setContentPane(bg);

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			calculateLocation();
			setBackground(new Color(140, 210, 228));

			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setIcon(icon);
			lblTitol.setBounds(pantalla.width / 4, pantalla.height / 40,
					pantalla.width / 2, 60);
			lblTitol.setHorizontalAlignment(SwingConstants.CENTER);

			// Taula per veure els treballadors de la BD
			treballadors = BD.getDadesParticular(pantalla.width,
					pantalla.height - taskBarSize);
			treballadors.setBackground(new Color(140, 210, 228));
			treballadors.setBounds(0, pantalla.height / 4, pantalla.width,
					treballadors.getTableHeight());
			add(treballadors);

			// Boto per afegir un nou treballador
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou");
			btnNou.setBounds(0, (int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 10));
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");

			// Boto per eliminar un treballador
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 10));
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");

			// Boto per editar un treballador
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds((pantalla.width / 4) * 2,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 10));
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");

			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds((pantalla.width / 4) * 3,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 10));
			btnTornar.addActionListener(this);
			btnTornar.setActionCommand("btnTornar");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnNou")) {
			UITreballadorsNou inst = new UITreballadorsNou(this, true);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTornar")) {
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
