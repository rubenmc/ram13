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
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class UIEmpleats extends JFrame implements ActionListener {
	private JButton 	btnEditar;
	private JButton 	btnTornar;
	private JButton 	btnEliminar;
	private JButton 	btnNou;
	private JLabel 		lblTitol;
	private Taula 		empleats;
	private Insets 		scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int 		taskBarSize = scnMax.bottom;
	private Dimension 	pantalla = getToolkit().getScreenSize();
	private URL 		imageURL = ClassLoader.getSystemResource("img/empleats.png");
	private URL 		imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon 		icon = new ImageIcon(imageURL);
	private Icon 		bgimg = new ImageIcon(imageURLbg);
	private Font 		font;

	public UIEmpleats() {
		try {
			// Instanciem la font
			font = Font.createFont(Font.TRUETYPE_FONT,
					new File("src/res/avant.ttf")).deriveFont(Font.BOLD, 24);

			// Fons
			JLabel bg = new JLabel();
			bg.setIcon(bgimg);
			bg.setSize(pantalla.width, pantalla.height);
			setContentPane(bg);

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
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

			// Taula per veure els empleats de la BD
			empleats = BD.getDades("empleats", pantalla.width, pantalla.height
					- taskBarSize);
			if (empleats != null) {
				empleats.setBackground(new Color(140, 210, 228));
				empleats.setBounds(0, pantalla.height / 4, pantalla.width,
						empleats.getTableHeight());
				add(empleats);
			}

			// Boto per afegir un nou empleat
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou empleat");
			btnNou.setBounds(0, (int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			btnNou.setFont(font);

			// Boto per eliminar un empleat
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar empleat");
			btnEliminar.setBounds(pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			btnEliminar.setFont(font);

			// Boto per editar un empleat
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar empleat");
			btnEditar.setBounds((pantalla.width / 4) * 2,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");
			btnEditar.setFont(font);

			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds((pantalla.width / 4) * 3,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
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
			UIEmpleatsNou inst = new UIEmpleatsNou(this);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEditar")) {
			if (empleats != null) {
				// Busquem el primer empleat seleccionat i obrim un dialog per
				// editar-lo
				boolean fi = false;
				for (int x = 0; x < empleats.getTableModel().getRowCount()
						&& !fi; x++) {
					boolean check = (boolean) empleats.getTableModel()
							.getValueAt(x, 5);
					if (check) {
						String[] dades = new String[5];
						dades[0] = empleats.getTableModel().getValueAt(x, 0)
								.toString();// id
						dades[1] = empleats.getTableModel().getValueAt(x, 1)
								.toString();// nom
						dades[2] = empleats.getTableModel().getValueAt(x, 2)
								.toString();// ss
						dades[3] = empleats.getTableModel().getValueAt(x, 3)
								.toString();// dni
						dades[4] = empleats.getTableModel().getValueAt(x, 4)
								.toString();// tenda
						UIEmpleatsNou inst = new UIEmpleatsNou(this, dades);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						fi = true;
					}
				}
			}
		} else if (e.getActionCommand().equals("btnEliminar")) {
			if (empleats != null) {
				// Busquem tots els empleats seleccionats i els eliminem
				for (int x = 0; x < empleats.getTableModel().getRowCount(); x++) {
					boolean check = (boolean) empleats.getTableModel()
							.getValueAt(x, 5);
					if (check) {
						if (BD.deleteEmpleat(empleats.getTableModel()
								.getValueAt(x, 0).toString())) {
							this.dispose();
							UIEmpleats inst = new UIEmpleats();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al eliminar l'empleat");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					}
				}
			}
		} else if (e.getActionCommand().equals("btnTornar")) {
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
