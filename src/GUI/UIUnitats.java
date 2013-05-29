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
public class UIUnitats extends JFrame implements ActionListener {
	private JButton 	btnEditar;
	private JButton 	btnTornar;
	private JButton 	btnEliminar;
	private JButton 	btnNou;
	private JLabel 		lblTitol;
	private Taula 		unitats;
	private Insets 		scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int 		taskBarSize = scnMax.bottom;
	private Dimension 	pantalla = getToolkit().getScreenSize();
	private URL 		imageURL = ClassLoader.getSystemResource("img/unitats.png");
	private URL 		imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon 		icon = new ImageIcon(imageURL);
	private Icon 		bgimg = new ImageIcon(imageURLbg);
	private Font 		font;

	public UIUnitats() {
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
			calculateLocation();
			setBackground(new Color(140, 210, 228));

			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setIcon(icon);
			lblTitol.setBounds(pantalla.width / 4, pantalla.height / 40,
					pantalla.width / 2, 60);
			lblTitol.setHorizontalAlignment(SwingConstants.CENTER);

			// Taula per veure les unitats de la BD
			unitats = BD.getDades("unitats", pantalla.width, pantalla.height
					- taskBarSize);
			if (unitats != null) {
				unitats.setBackground(new Color(140, 210, 228));
				unitats.setBounds(0, pantalla.height / 4, pantalla.width,
						unitats.getTableHeight());
				add(unitats);
			}

			// Boto per afegir una nova unitat
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nova Unitat");
			btnNou.setBounds(0, (int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			btnNou.setFont(font);

			// Boto per eliminar una unitat
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar Unitat");
			btnEliminar.setBounds(pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			btnEliminar.setFont(font);

			// Boto per editar una unitat
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar Unitat");
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
	/**
	 * Métode que s'executara al fer clic a un botó i que realitzara la acció indicada
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnNou")) {
			UIUnitatsNou inst = new UIUnitatsNou(this);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEditar")) {
			if (unitats != null) {
				// Busquem la primera unitat seleccionada i obrim un dialog per
				// editar-la
				boolean fi = false;
				for (int x = 0; x < unitats.getTableModel().getRowCount()
						&& !fi; x++) {
					boolean check = (boolean) unitats.getTableModel()
							.getValueAt(x, 3);
					if (check) {
						String[] dades = new String[3];
						dades[0] = unitats.getTableModel().getValueAt(x, 0)
								.toString();// id
						dades[1] = unitats.getTableModel().getValueAt(x, 1)
								.toString();// idtenda
						dades[2] = unitats.getTableModel().getValueAt(x, 2)
								.toString();// idjoc
						UIUnitatsNou inst = new UIUnitatsNou(this, dades);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						fi = true;
					}
				}
			}
		} else if (e.getActionCommand().equals("btnEliminar")) {
			if (unitats != null) {
				for (int x = 0; x < unitats.getTableModel().getRowCount(); x++) {
					boolean check = (boolean) unitats.getTableModel()
							.getValueAt(x, 3);
					if (check) {
						if (BD.deleteUnitat(unitats.getTableModel()
								.getValueAt(x, 0).toString())) {
							this.dispose();
							UIUnitats inst = new UIUnitats();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al eliminar la unitat");
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
