package juego_2048.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FCelda extends JLabel{

	public FCelda() {
		super();

	}
	protected void inicialize() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setBackground(getBackground());
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		
	}
}
