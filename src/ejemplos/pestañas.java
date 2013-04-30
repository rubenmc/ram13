package ejemplos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// Ésta es la clase principal
// es un JFrame...
public class pestañas extends JFrame implements ActionListener {

	// el panel principal donde se pone todo
	private JPanel contentPane;
	JTabbedPane panelDePestanas;

	// ejecuta primero todo ésto
	public static void main(String[] args) {
		// arranca en un hilo de ejecución...
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// creando el frame y lo muestra
					pestañas frame = new pestañas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor de la clase: se configura aquí toda
	// la ventana y los controles...
	public pestañas() {

		// título de la ventana
		setTitle("Pesta\u00F1as con Swing by jnj");
		// operación al cerra la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// coordenadas de las esquinas del frame en el escritorio
		setBounds(100, 100, 419, 234);

		// el panel que contiene todo se crea y se pone en el frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// distribución nula para poder posicionar los elementos
		// en las coordenadas que queramos
		contentPane.setLayout(null);

		// se crea el panel de pestañas
		panelDePestanas = new JTabbedPane(SwingConstants.TOP);
		// se posiciona en el panel
		panelDePestanas.setBounds(10, 11, 383, 174);
		contentPane.add(panelDePestanas);

		// éste es el primer panel
		// que se añade como pestaña al 'tabbedPane'
		JPanel panel1 = new JPanel();
		panelDePestanas.addTab("Panel 1", null, panel1, null);
		// al panel le pongo distribución nula para
		// posicionar los elementos en las coordenadas que
		// quiera
		panel1.setLayout(null);

		// una etiqueta en el panel de la pestaña 1
		JLabel lbl1 = new JLabel("Primera pesta\u00F1a..");
		lbl1.setBounds(10, 11, 348, 14);
		panel1.add(lbl1);

		JButton btn1 = new JButton("PESTAÑA 2");
		btn1.addActionListener(this);
		btn1.setBounds(20, 50, 348, 14);
		panel1.add(btn1);

		// otro panel de igual forma
		JPanel panel2 = new JPanel();
		panelDePestanas.addTab("Panel 2", null, panel2, null);
		panel2.setLayout(null);

		// otra etiqueta ésta vez en el segundo panel
		JLabel lbl2 = new JLabel("Segunda pesta\u00F1a..");
		lbl2.setBounds(10, 11, 290, 14);
		panel2.add(lbl2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		panelDePestanas.setSelectedIndex(1);
	}
}