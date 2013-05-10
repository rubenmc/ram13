package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UIConsultes extends JFrame implements ActionListener {
	private JTabbedPane panelPestanyes;
	private JButton 	btnTornar;
	private JPanel 		contentPane;

	public UIConsultes() {
		setTitle("Consultes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 835, 386);
		// Generem el panell on iran ubicades les pestanyes
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Generem el panell de pestanyes
		panelPestanyes = new JTabbedPane(SwingConstants.TOP);
		panelPestanyes.setBounds(10, 11, 800, 300);
		contentPane.add(panelPestanyes);
		// Boto per tornar al menu
		btnTornar = new JButton();
		contentPane.add(btnTornar);
		btnTornar.setText("Tornar");
		btnTornar.setBounds(10, 320, 50, 23);
		btnTornar.addActionListener(this);
		btnTornar.setActionCommand("btnTornar");

		// PESTANYA JOCS
		JPanel jocsPane = new JPanel();
		panelPestanyes.addTab("Jocs", null, jocsPane, null);
		jocsPane.setLayout(null);

		// PESTANYA TENDES
		JPanel tendesPane = new JPanel();
		panelPestanyes.addTab("Tendes", null, tendesPane, null);
		tendesPane.setLayout(null);

		// PESTANYA COMANDES
		JPanel comandesPane = new JPanel();
		panelPestanyes.addTab("Comandes", null, comandesPane, null);
		comandesPane.setLayout(null);

		// PESTANYA CLIENTS
		JPanel clientsPane = new JPanel();
		panelPestanyes.addTab("Clients", null, clientsPane, null);
		clientsPane.setLayout(null);

		// PESTANYA MAJORISTES
		JPanel majoristesPane = new JPanel();
		panelPestanyes.addTab("Majoristes", null, majoristesPane, null);
		majoristesPane.setLayout(null);

		// PESTANYA EMPLEATS
		JPanel empleatsPane = new JPanel();
		panelPestanyes.addTab("Empleats", null, empleatsPane, null);
		empleatsPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("btnTornar")) {
			this.dispose();
			Menu inst = new Menu();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
	}

}
