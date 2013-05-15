package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;

import main.BD;

@SuppressWarnings("serial")
public class UIClients extends JFrame implements ActionListener {
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnMajorista;
	private JButton btnEliminar;
	private JButton btnParticular;
	private JLabel lblTitol;
	private Taula clients;
	private Insets scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	private int taskBarSize = scnMax.bottom;
	private Dimension pantalla = getToolkit().getScreenSize();
	private URL imageURL = ClassLoader.getSystemResource("img/clients.png");
	private URL imageURLbg = ClassLoader.getSystemResource("img/fondo2.png");
	private Icon icon = new ImageIcon(imageURL);
	private Icon bgimg = new ImageIcon(imageURLbg);
	public UIClients() {
		try {
			JLabel bg = new JLabel();
			bg.setIcon(bgimg);
			bg.setSize(pantalla.width,pantalla.height);
			setContentPane(bg);
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			calculateLocation();
			setBackground(new Color(140, 210, 228));
			
			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			//lblTitol.setText("GESTIÓ DE TREBALLADORS");
			lblTitol.setIcon(icon);
			lblTitol.setBounds(pantalla.width/4, pantalla.height/40, pantalla.width/2, 60);
			lblTitol.setHorizontalAlignment(SwingConstants.CENTER);

			// Taula amb els clients de la BD
			clients = BD.getDades("provaparticular",pantalla.width,pantalla.height-taskBarSize);
			clients.setBackground(new Color(140, 210, 228));
			clients.setBounds(0, pantalla.height/4,pantalla.width, clients.getTableHeight());
			add(clients);				

			// Boto per afegir un nou particular
			btnParticular = new JButton();
			getContentPane().add(btnParticular);
			btnParticular.setText("Particular");
			btnParticular.setBounds(0,(int) ((pantalla.height-taskBarSize)/1.25),pantalla.width/5, (int) ((pantalla.height-taskBarSize)/10));
			btnParticular.addActionListener(this);
			btnParticular.setActionCommand("btnParticular");

			// Boto per afegir un nou majorista
			btnMajorista = new JButton();
			getContentPane().add(btnMajorista);
			btnMajorista.setText("Majorista");
			btnMajorista.setBounds(pantalla.width/5,(int) ((pantalla.height-taskBarSize)/1.25),pantalla.width/5, (int) ((pantalla.height-taskBarSize)/10));
			btnMajorista.addActionListener(this);
			btnMajorista.setActionCommand("btnMajorista");

			// Boto per eliminar un client
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds((pantalla.width/5)*2,(int) ((pantalla.height-taskBarSize)/1.25),pantalla.width/5, (int) ((pantalla.height-taskBarSize)/10));
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");

			// Boto per editar un client
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds((pantalla.width/5)*3,(int) ((pantalla.height-taskBarSize)/1.25),pantalla.width/5, (int) ((pantalla.height-taskBarSize)/10));
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");

			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds((pantalla.width/5)*4,(int) ((pantalla.height-taskBarSize)/1.25),pantalla.width/5, (int) ((pantalla.height-taskBarSize)/10));
			btnTornar.addActionListener(this);
			btnTornar.setActionCommand("btnTornar");

			//pack();
			//this.setSize(685, 300);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnParticular")) {
			UIClientsNou inst = new UIClientsNou(this, true);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnMajorista")) {
			UIMajoristaNou inst = new UIMajoristaNou(this, true);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTornar")) {
			this.dispose();
			Menu inst = new Menu();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnEditar")) {
			for (int x = 0; x < clients.getTableModel().getRowCount(); x++) {
				boolean check = (boolean) clients.getTableModel().getValueAt(x, 5);
				if (check) {
					String[] dades = new String[5];
					dades[0] = clients.getTableModel().getValueAt(x, 0).toString();// Nom
					dades[1] = clients.getTableModel().getValueAt(x, 1).toString();// telf
					dades[2] = clients.getTableModel().getValueAt(x, 2).toString();// nif
					dades[3] = clients.getTableModel().getValueAt(x, 3).toString()
							.replaceAll("-", "/");// Datanaixement
					dades[4] = clients.getTableModel().getValueAt(x, 4).toString();// mail
					UIClientsNou inst = new UIClientsNou(this, true, dades);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			}
		} else if (e.getActionCommand().equals("btnEliminar")) {
			for (int x = 0; x < clients.getTableModel().getRowCount(); x++) {
				boolean check = (boolean) clients.getTableModel().getValueAt(x, 5);
				if (check) {
					if (BD.eliminarParticular(clients.getTableModel().getValueAt(x,
							2).toString())) {
						this.dispose();
						UIClients inst = new UIClients();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					} else {
						ErrorDialog error = new ErrorDialog(this, true,
								"Error al modificar usuari");
						error.setLocationRelativeTo(null);
						error.setVisible(true);
					}
				}
			}
		}
	}
	
	private void calculateLocation() {
		setSize(pantalla.width, pantalla.height-taskBarSize);
		int locationx = (pantalla.width) / 2;
		int locationy = (pantalla.height) / 2;
		setLocation(locationx, locationy);
	}

}
