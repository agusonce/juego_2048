package juego_2048.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import juego_2048.components.config.Style;
import java.awt.Color;

public class FCelda extends JLabel{

	public FCelda() {
		super();
		inicialize();
	}
	protected void inicialize() {
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		
		if(!text.isEmpty()) {
			setBackground(getColor(Integer.valueOf(text)));
		}
		
	}
	
	private Color getColor(Integer numero) {
		//crear case
		
		return Style.AZUL_CLARO;
	}
}
