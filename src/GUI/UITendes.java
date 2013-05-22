package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
public class UITendes extends JFrame implements ActionListener {
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnEliminar;
	private JButton btnNou;
	private JLabel lblTitol;
	private Taula tendes;
	private Insets scnMax = getToolkit().getScreenInsets(
			getGraphicsConfiguration());
	private int taskBarSize = scnMax.bottom;
	private Dimension pantalla = getToolkit().getScreenSize();
	private URL imageURL = ClassLoader.getSystemResource("img/tendes.png");
	private URL imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon icon = new ImageIcon(imageURL);
	private Icon bgimg = new ImageIcon(imageURLbg);
	private Font font;

	public UITendes() {
		super("Apartat de Tendes");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 24);
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
			tendes = BD.getDades("empleats",pantalla.width,
					pantalla.height - taskBarSize);
			if(tendes!=null){
				tendes.setBackground(new Color(140, 210, 228));
				tendes.setBounds(0, pantalla.height / 4, pantalla.width,
						tendes.getTableHeight());
				add(tendes);
			}
			

			// Boto per afegir un nou treballador
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou");
			btnNou.setBounds(0, (int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 10));
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			btnNou.setFont(font);

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
			btnEliminar.setFont(font);

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
			btnEditar.setFont(font);

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
			btnTornar.setFont(font);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnNou")) {
			UITendesNou inst = new UITendesNou(this, true);
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
