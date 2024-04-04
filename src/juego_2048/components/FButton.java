package juego_2048.components;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

import juego_2048.components.config.Style;

public class FButton extends JButton{


	public FButton() {
		super();
		init();
	}
	
	public FButton(String text) {
		super();
		this.setText(text);
		init();
	}
//	
//	@Override
//	 protected void init(String text, Icon icon) {
//		super.init(text,icon);
//		this.setBackground(Style.AZUL_CLARO);
//	}
	
	private void init() {
		this.setBackground(Style.AZUL_CLARO);
	}
	
    public void setBounds(int width, int height, String alig) {
		int x =0;
		int y =0;

		Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		if("CENTER".equals(alig)) {
			x = (screen.width / 2) - width/2 ;
			y = (screen.height / 2) - height/2 ;
		}
		super.setBounds(x, y, width, height);
    }
	
}
