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
public class UIClients extends JFrame implements ActionListener {
	private JButton 	btnEditar;
	private JButton 	btnTornar;
	private JButton 	btnMajorista;
	private JButton 	btnEliminar;
	private JButton 	btnParticular;
	private JLabel 		lblTitol;
	private Taula 		particulars;
	private Taula 		majoristes;
	private Insets 		scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int 		taskBarSize = scnMax.bottom;
	private Dimension 	pantalla = getToolkit().getScreenSize();
	private URL 		imageURL = ClassLoader.getSystemResource("img/clients.png");
	private URL 		imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Font 		font;
	private Icon 		icon = new ImageIcon(imageURL);
	private Icon 		bgimg = new ImageIcon(imageURLbg);

	public UIClients() {
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

			// Taules amb els clients de la BD
			particulars = BD.getDades("particulars", pantalla.width,
					pantalla.height - taskBarSize);
			if (particulars != null) {
				particulars.setBackground(new Color(140, 210, 228));
				particulars.setBounds(0, pantalla.height / 4, pantalla.width,
						particulars.getTableHeight());
				add(particulars);
			}

			majoristes = BD.getDades("majoristes", pantalla.width,
					pantalla.height - taskBarSize);
			if (majoristes != null) {
				majoristes.setBackground(new Color(140, 210, 228));
				majoristes.setBounds(0, (pantalla.height / 4) * 2,
						pantalla.width, majoristes.getTableHeight());
				add(majoristes);
			}

			// Boto per afegir un nou particular
			btnParticular = new JButton();
			getContentPane().add(btnParticular);
			btnParticular.setText("Particular");
			btnParticular.setBounds(0,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 5, (pantalla.height - taskBarSize) / 10);
			btnParticular.addActionListener(this);
			btnParticular.setActionCommand("btnParticular");
			btnParticular.setFont(font);

			// Boto per afegir un nou majorista
			btnMajorista = new JButton();
			getContentPane().add(btnMajorista);
			btnMajorista.setText("Majorista");
			btnMajorista.setBounds(pantalla.width / 5,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 5, (pantalla.height - taskBarSize) / 10);
			btnMajorista.addActionListener(this);
			btnMajorista.setActionCommand("btnMajorista");
			btnMajorista.setFont(font);

			// Boto per eliminar un client
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds((pantalla.width / 5) * 2,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 5, (pantalla.height - taskBarSize) / 10);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			btnEliminar.setFont(font);

			// Boto per editar un client
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds((pantalla.width / 5) * 3,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 5, (pantalla.height - taskBarSize) / 10);
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");
			btnEditar.setFont(font);

			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds((pantalla.width / 5) * 4,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 5, (pantalla.height - taskBarSize) / 10);
			btnTornar.addActionListener(this);
			btnTornar.setActionCommand("btnTornar");
			btnTornar.setFont(font);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Métode que s'executara al fer clic a un botó i que realitzara la acció indicada
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnParticular")) {
			UIParticularNou inst = new UIParticularNou(this);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnMajorista")) {
			UIMajoristaNou inst = new UIMajoristaNou(this);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTornar")) {
			this.dispose();
			Menu inst = new Menu();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEditar")) {
			boolean fi = false;
			if (particulars != null) {
				// Busquem el primer client seleccionat i obrim un dialog per
				// editar-lo
				for (int x = 0; x < particulars.getTableModel().getRowCount()
						&& !fi; x++) {
					boolean check = (boolean) particulars.getTableModel()
							.getValueAt(x, 6);
					// Si esta seleccionat guardem les dades a un array i obrim
					// el dialog per modificar
					if (check) {
						String[] dades = new String[6];
						dades[0] = particulars.getTableModel().getValueAt(x, 0)
								.toString();// id
						dades[1] = particulars.getTableModel().getValueAt(x, 1)
								.toString();// Nom
						dades[2] = particulars.getTableModel().getValueAt(x, 2)
								.toString();// telf
						dades[3] = particulars.getTableModel().getValueAt(x, 3)
								.toString();// nif
						dades[4] = particulars.getTableModel().getValueAt(x, 4)
								.toString().replaceAll("-", "/");// Datanaixement
						dades[5] = particulars.getTableModel().getValueAt(x, 5)
								.toString();// mail
						UIParticularNou inst = new UIParticularNou(this, true,
								dades);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						fi = true;
					}
				}
			}
			// Si no hem trobat un seleccionat busquem a la segona taula
			if (!fi && majoristes != null) {
				for (int x = 0; x < majoristes.getTableModel().getRowCount()
						&& !fi; x++) {
					boolean check = (boolean) majoristes.getTableModel()
							.getValueAt(x, 6);
					// Si esta seleccionat guardem les dades a un array i obrim
					// el dialog per modificar
					if (check) {
						String[] dades = new String[6];
						dades[0] = majoristes.getTableModel().getValueAt(x, 0)
								.toString();// id
						dades[1] = majoristes.getTableModel().getValueAt(x, 1)
								.toString();// Nom
						dades[2] = majoristes.getTableModel().getValueAt(x, 2)
								.toString();// telf
						dades[3] = majoristes.getTableModel().getValueAt(x, 3)
								.toString();// nif
						dades[4] = majoristes.getTableModel().getValueAt(x, 4)
								.toString().replaceAll("-", "/");// contacte
						dades[5] = majoristes.getTableModel().getValueAt(x, 5)
								.toString();// mail
						UIMajoristaNou inst = new UIMajoristaNou(this, dades);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						fi = true;
					}
				}
			}
		} else if (e.getActionCommand().equals("btnEliminar")) {
			boolean trobat = false;
			// Si la taula de particulars conté dades busquem quins estan
			// seleccionats
			if (particulars != null) {
				for (int x = 0; x < particulars.getTableModel().getRowCount(); x++) {
					boolean check = (boolean) particulars.getTableModel()
							.getValueAt(x, 6);
					// Si trobem un seleccionat l'eliminem
					if (check) {
						if (BD.deleteParticular(particulars.getTableModel()
								.getValueAt(x, 0).toString())) {
							this.dispose();
							UIClients inst = new UIClients();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al eliminar l'usuari");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					}
					trobat = true;
				}
			}
			// Si no hem trobat cap a la primera taula busquem a la segona
			// sempre que contingui dades
			if (!trobat && majoristes != null) {
				for (int x = 0; x < majoristes.getTableModel().getRowCount(); x++) {
					boolean check = (boolean) majoristes.getTableModel()
							.getValueAt(x, 6);
					// Si trobem un seleccionat l'eliminem
					if (check) {
						if (BD.deleteMajorista(majoristes.getTableModel()
								.getValueAt(x, 0).toString())) {
							this.dispose();
							UIClients inst = new UIClients();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al eliminar l'usuari");
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					}
				}
			}
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
