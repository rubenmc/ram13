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
public class UIJocs extends JFrame implements ActionListener {
	private JLabel 		lblTitol;
	private JButton 	btnEditar;
	private JButton 	btnTornar;
	private JButton 	btnEliminar;
	private JButton 	btnNou;
	private Taula 		jocs;
	private Insets 		scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int 		taskBarSize = scnMax.bottom;
	private Dimension 	pantalla = getToolkit().getScreenSize();
	private URL 		imageURL = ClassLoader.getSystemResource("img/jocs.png");
	private URL 		imageURLbg = ClassLoader.getSystemResource("img/fondo.png");
	private Icon 		icon = new ImageIcon(imageURL);
	private Icon 		bgimg = new ImageIcon(imageURLbg);
	private Font 		font;

	public UIJocs() {
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

			// Taula per veure els jocs de la BD
			jocs = BD.getDades("jocs", pantalla.width, pantalla.height
					- taskBarSize);
			if (jocs != null) {
				jocs.setBackground(new Color(140, 210, 228));
				jocs.setBounds(0, pantalla.height / 4, pantalla.width,
						jocs.getTableHeight());
				add(jocs);
			}

			// Boto per afegir un nou joc
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou joc");
			btnNou.setBounds(0, (int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			btnNou.setFont(font);

			// Boto per eliminar un joc
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar joc");
			btnEliminar.setBounds(pantalla.width / 4,
					(int) ((pantalla.height - taskBarSize) / 1.25),
					pantalla.width / 4, (pantalla.height - taskBarSize) / 10);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			btnEliminar.setFont(font);

			// Boto per editar un joc
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar joc");
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
			UIJocsNou inst = new UIJocsNou(this);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEditar")) {
			if (jocs != null) {
				// Busquem el primer joc seleccionat i obrim un dialog per
				// editar-lo
				boolean fi = false;
				for (int x = 0; x < jocs.getTableModel().getRowCount() && !fi; x++) {
					boolean check = (boolean) jocs.getTableModel().getValueAt(
							x, 5);
					if (check) {
						String[] dades = new String[5];
						dades[0] = jocs.getTableModel().getValueAt(x, 0)
								.toString();// id
						dades[1] = jocs.getTableModel().getValueAt(x, 1)
								.toString();// proveidor
						dades[2] = jocs.getTableModel().getValueAt(x, 2)
								.toString();// nom
						dades[3] = jocs.getTableModel().getValueAt(x, 3)
								.toString();// genere
						dades[4] = jocs.getTableModel().getValueAt(x, 4)
								.toString();// preu
						UIJocsNou inst = new UIJocsNou(this, dades);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						fi = true;
					}
				}
			}
		} else if (e.getActionCommand().equals("btnEliminar")) {
			if (jocs != null) {
				for (int x = 0; x < jocs.getTableModel().getRowCount(); x++) {
					boolean check = (boolean) jocs.getTableModel().getValueAt(
							x, 5);
					if (check) {
						if (BD.deleteJoc(jocs.getTableModel().getValueAt(x, 0)
								.toString())) {
							this.dispose();
							UIJocs inst = new UIJocs();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						} else {
							ErrorDialog error = new ErrorDialog(this,
									"Error al eliminar el joc");
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
