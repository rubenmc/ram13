package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class UIClients extends JFrame implements ActionListener {
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnMajorista;
	private JButton btnEliminar;
	private JButton btnParticular;
	private JLabel 	lblTitol;
	private Taula 	clients;

	public UIClients() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("GESTIÓ DE TREBALLADORS");
			lblTitol.setBounds(12, 12, 279, 16);
			
			// Taula amb els clients de la BD
			clients = BD.getDades("provaparticular");
			clients.setBounds(12, 40, 645, 158);
			add(clients);
			
			// Boto per afegir un nou particular
			btnParticular = new JButton();
			getContentPane().add(btnParticular);
			btnParticular.setText("Particular");
			btnParticular.setBounds(12, 228, 100, 23);
			btnParticular.addActionListener(this);
			btnParticular.setActionCommand("btnClient");
			
			// Boto per afegir un nou majorista
			btnMajorista = new JButton();
			getContentPane().add(btnMajorista);
			btnMajorista.setText("Majorista");
			btnMajorista.setBounds(117, 228, 100, 23);
			btnMajorista.addActionListener(this);
			btnMajorista.setActionCommand("btnMajorista");
			
			// Boto per eliminar un client
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(222, 228, 80, 23);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			
			// Boto per editar un client
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds(307, 228, 80, 23);
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");
			
			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds(505, 228, 153, 23);
			btnTornar.addActionListener(this);
			btnTornar.setActionCommand("btnTornar");

			pack();
			this.setSize(685, 300);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnClient")) {
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
		}
	}

}
