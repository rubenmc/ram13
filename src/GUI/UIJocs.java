package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class UIJocs extends JFrame implements ActionListener {
	private JLabel 	lblTitol;
	private JButton btnEditar;
	private JButton btnTornar;
	private JButton btnEliminar;
	private JButton btnNou;
	private Taula 	jocs;

	public UIJocs() {
		super("Apartat de jocs");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("GESTIÓ DE JOCS");
			lblTitol.setBounds(12, 12, 279, 16);
			// Taula per mostrar els jocs de la BD
			jocs = BD.getDades("provaparticular",1,1);
			getContentPane().add(jocs);
			jocs.setBounds(12, 40, 575, 158);
			// Boto per afegir un nou joc
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou");
			btnNou.setBounds(12, 228, 80, 23);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			// Boto per eliminar un joc
			btnEliminar = new JButton();
			getContentPane().add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(97, 228, 80, 23);
			btnEliminar.addActionListener(this);
			btnEliminar.setActionCommand("btnEliminar");
			// Boto per editar un joc
			btnEditar = new JButton();
			getContentPane().add(btnEditar);
			btnEditar.setText("Editar");
			btnEditar.setBounds(182, 228, 80, 23);
			btnEditar.addActionListener(this);
			btnEditar.setActionCommand("btnEditar");
			// Boto per tornar al menu
			btnTornar = new JButton();
			getContentPane().add(btnTornar);
			btnTornar.setText("Tornar");
			btnTornar.setBounds(420, 228, 153, 23);
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
			UIJocsNou inst = new UIJocsNou(this, true);
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
