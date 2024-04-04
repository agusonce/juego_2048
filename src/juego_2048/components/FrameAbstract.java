package juego_2048.components;

import javax.swing.JFrame;
import javax.swing.JPanel;

import juego_2048.components.config.Aligment;

public abstract class FrameAbstract extends JFrame{
	
	protected Aligment aligment;
	
	protected void initialize() {
		if(aligment == null) {
			this.aligment = new Aligment();
		}
		
		getContentPane().setLayout(null);
	}
}
