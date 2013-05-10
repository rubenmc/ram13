package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import main.BD;

@SuppressWarnings("serial")
public class UITendes extends JFrame implements ActionListener {
	private JButton lblEditar;
	private JButton lblTornar;
	private JButton lblEliminar;
	private JButton btnNou;
	private JLabel 	lblTitol;
	private Taula 	tendes;

	public UITendes() {
		super("Apartat de Tendes");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			// Etiqueta de titol
			lblTitol = new JLabel();
			getContentPane().add(lblTitol);
			lblTitol.setText("GESTIÓ DE TENDES");
			lblTitol.setBounds(12, 12, 279, 16);
			// Taula per veure les tendes de la BD
			tendes = BD.getDades("provaparticular");
			getContentPane().add(tendes);
			tendes.setBounds(12, 40, 575, 158);
			// Boto per afegir una nova tenda
			btnNou = new JButton();
			getContentPane().add(btnNou);
			btnNou.setText("Nou");
			btnNou.setBounds(12, 229, 80, 23);
			btnNou.addActionListener(this);
			btnNou.setActionCommand("btnNou");
			// Boto per eliminar una tenda
			lblEliminar = new JButton();
			getContentPane().add(lblEliminar);
			lblEliminar.setText("Eliminar");
			lblEliminar.setBounds(97, 229, 80, 23);
			lblEliminar.addActionListener(this);
			lblEliminar.setActionCommand("btnEliminar");
			// Boto per editar una tenda
			lblEditar = new JButton();
			getContentPane().add(lblEditar);
			lblEditar.setText("Editar");
			lblEditar.setBounds(182, 229, 80, 23);
			lblEditar.addActionListener(this);
			lblEditar.setActionCommand("btnEditar");
			// Boto per tornar al menu
			lblTornar = new JButton();
			getContentPane().add(lblTornar);
			lblTornar.setText("Tornar");
			lblTornar.setBounds(435, 229, 153, 23);
			lblTornar.addActionListener(this);
			lblTornar.setActionCommand("btnTornar");

			pack();
			this.setSize(615, 301);
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

}
