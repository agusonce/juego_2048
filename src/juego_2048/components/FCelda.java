package juego_2048.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import juego_2048.components.config.Style;
import java.awt.Color;
import java.awt.Font;


public class FCelda extends JLabel{

	public FCelda() {
		super();
		inicialize();
	}
	protected void inicialize() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		
		if(width>100) {
			setFont(Style.createFont(25));
		}
	}
	
	@Override
	public void setText(String text) {
		if(!text.isEmpty()) {

			setStyle(Integer.valueOf(text));
			
			if("0".equals(text)) {
				super.setText("");
			}else {
				super.setText(text);				
			}
		}
		
	}
	
	private void setStyle(Integer numero) {
		//crear case
		switch (numero) {
        case 2:
        	setBackground(Style.COLOR_2);
        	setForeground(Color.BLACK);
            break;
        case 4:
        	setBackground(Style.COLOR_4);
        	setForeground(Color.BLACK);
        	break;
        case 8:
        	setBackground(Style.COLOR_8);
        	setForeground(Color.BLACK);
            break;
        case 16:
        	setBackground(Style.COLOR_16);
        	setForeground(Color.BLACK);
            break;
        case 32:
        	setBackground(Style.COLOR_32);
        	setForeground(Color.BLACK);
            break;
        case 64:
        	setBackground(Style.COLOR_64);
        	setForeground(Color.BLACK);
            break;
        case 128:
        	setBackground(Style.COLOR_128);
        	setForeground(Color.BLACK);
            break;
        case 256:
        	setBackground(Style.COLOR_256);
        	setForeground(Color.BLACK);
            break;
        case 512:
        	setBackground(Style.COLOR_512);
        	setForeground(Color.BLACK);
            break;
        case 1024:
        	setBackground(Style.COLOR_1024);
        	setForeground(Color.BLACK);
            break;
        default:
        	setBackground(Style.COLOR_VACIO);
            break;
    }
		
	}
}
