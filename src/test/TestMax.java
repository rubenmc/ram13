package test;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.WindowConstants;

public class TestMax extends javax.swing.JFrame {
	Insets scnMax = getToolkit().getScreenInsets(getGraphicsConfiguration());
	int taskBarSize = scnMax.bottom;
	private Dimension pantalla = getToolkit().getScreenSize();

	public static void main(String[] args) {

		TestMax inst = new TestMax();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public TestMax() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			calculateLocation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calculateLocation() {
		setSize(pantalla.width, pantalla.height-taskBarSize);
		int locationx = (pantalla.width) / 2;
		int locationy = (pantalla.height) / 2;
		setLocation(locationx, locationy);
	}

}
