package juego_2048.components;

import javax.swing.JButton;

import juego_2048.components.config.Style;

public class FButton extends JButton {

	public FButton() {
		super();
		init();
	}

	public FButton(String text) {
		super();
		this.setText(text);
		init();
	}

	private void init() {
		this.setBackground(Style.COLOR_MARRON);
	}

}
