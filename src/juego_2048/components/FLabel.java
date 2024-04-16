package juego_2048.components;

import java.awt.Dimension;

import javax.swing.JLabel;

public class FLabel extends JLabel {

	public FLabel(String text) {
		super(text);
	}

	public void setBounds(int width, int height, String alig) {
		int x = 0;
		int y = 0;

		Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		if ("CENTER".equals(alig)) {
			x = (screen.width / 2) - width / 2;
			y = (screen.height / 2) - height / 2;
		}
		super.setBounds(x, y, width, height);
	}
}
