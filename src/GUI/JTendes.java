package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JTendes extends JFrame implements ActionListener {
	private JLabel  jlTendes;
	private JButton jbEditar;
	private JButton jbTornar;
	private JButton jbEliminar;
	private JButton jbNou;
	private Taula  jtTendes;
	
	String[] camps = {"CAMP1","CAMP2","CAMP3","CAMP4"};
	Object[][] data = {{"dada1",1,"dada1",1},
			{"dada2",2,"dada2",2},
			{"dada3",3,"dada3",3}};
	
	public JTendes() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
				jlTendes = new JLabel();
				getContentPane().add(jlTendes);
				jlTendes.setText("GESTIÓ DE TREBALLADORS");
				jlTendes.setBounds(12, 12, 279, 16);
				
				jtTendes = new Taula(data, camps);
				getContentPane().add(jtTendes);
				jtTendes.setBounds(12, 40, 487, 158);

				jbNou = new JButton();
				getContentPane().add(jbNou);
				jbNou.setText("Nou");
				jbNou.setBounds(24, 210, 57, 23);
				jbNou.setSize(80, 23);

				jbEliminar = new JButton();
				getContentPane().add(jbEliminar);
				jbEliminar.setText("Eliminar");
				jbEliminar.setBounds(111, 210, 80, 23);

				jbEditar = new JButton();
				getContentPane().add(jbEditar);
				jbEditar.setText("Editar");
				jbEditar.setBounds(196, 210, 57, 23);
				jbEditar.setSize(80, 23);

				jbTornar = new JButton();
				getContentPane().add(jbTornar);
				jbTornar.setText("Tornar");
				jbTornar.setBounds(352, 210, 153, 23);
				
			pack();
			this.setSize(538, 300);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JTendes inst = new JTendes();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
