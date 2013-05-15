package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class UITreballadors extends JFrame implements ActionListener {
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnEliminar;
	private JButton btnNou;
	private JLabel 	lblTitol;
	private Taula 	treballadors;

	public UITreballadors() {
		super("Gestió de treballadors");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("GESTIÓ DE TREBALLADORS");
			lblTitol.setBounds(12, 12, 279, 16);
			// Taula per veure els treballadors de la BD
			treballadors = BD.getDades("provaparticular",1,1);
			getContentPane().add(treballadors);
			treballadors.setBounds(12, 40, 575, 158);
			// Boto per afegir un nou treballador
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou");
			btnNou.setBounds(12, 229, 80, 23);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			// Boto per eliminar un treballador
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(97, 229, 80, 23);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			// Boto per editar un treballador
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds(182, 229, 80, 23);
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");
			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds(435, 229, 153, 23);
			btnTornar.addActionListener(this);
			btnTornar.setActionCommand("btnTornar");

			pack();
			this.setSize(615, 301);
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

}
