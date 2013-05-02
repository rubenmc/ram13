package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JTreballadors extends JFrame implements ActionListener {
	private JLabel  jlTreballadors;
	private JButton jbEditar;
	private JButton jbTornar;
	private JButton jbEliminar;
	private JButton jbNou;
	private Taula   jtTreballadors;
	
	String[] camps = {"CAMP1","CAMP2","CAMP3","CAMP4"};
	Object[][] data = {{"dada1",1,"dada1",1},
			{"dada2",2,"dada2",2},
			{"dada3",3,"dada3",3}};
	
	public JTreballadors() {
		super("Gestió de treballadors");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
				jlTreballadors = new JLabel();
				getContentPane().add(jlTreballadors);
				jlTreballadors.setText("GESTIÓ DE TREBALLADORS");
				jlTreballadors.setBounds(12, 12, 279, 16);
				
				jtTreballadors = new Taula(data, camps);
				getContentPane().add(jtTreballadors);
				jtTreballadors.setBounds(12, 40, 575, 158);

				jbNou = new JButton();
				getContentPane().add(jbNou);
				jbNou.setText("Nou");
				jbNou.setBounds(24, 210, 57, 23);
				jbNou.setSize(80, 23);
				jbNou.addActionListener(this);
				jbNou.setActionCommand("btnNou");

				jbEliminar = new JButton();
				getContentPane().add(jbEliminar);
				jbEliminar.setText("Eliminar");
				jbEliminar.setBounds(111, 210, 80, 23);
				jbEliminar.addActionListener(this);
				jbEliminar.setActionCommand("btnEliminar");

				jbEditar = new JButton();
				getContentPane().add(jbEditar);
				jbEditar.setText("Editar");
				jbEditar.setBounds(196, 210, 57, 23);
				jbEditar.setSize(80, 23);
				jbEditar.addActionListener(this);
				jbEditar.setActionCommand("btnEditar");

				jbTornar = new JButton();
				getContentPane().add(jbTornar);
				jbTornar.setText("Tornar");
				jbTornar.setBounds(352, 210, 153, 23);
				jbTornar.addActionListener(this);
				jbTornar.setActionCommand("btnTornar");
				
			pack();
			this.setSize(600, 300);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnNou")) {
			JTreballadorsNou inst = new JTreballadorsNou(this,true);
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		} else if (e.getActionCommand().equals("btnTendes")) {

		} else if (e.getActionCommand().equals("btnComandes")) {

		} else if (e.getActionCommand().equals("btnClients")) {

		} else if (e.getActionCommand().equals("btnEmpleat")) {

		} else if (e.getActionCommand().equals("btnTancar")) {
			
		} else if (e.getActionCommand().equals("btnSortir")) {
			
		}
	}

}
