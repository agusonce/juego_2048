package juego_2048.components.config;

import java.awt.Dimension;

public class Aligment {
	
	public static final String CENTER = "CENTER";
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	
	private int screenWidth;
	private int screenHeight;
	
	public Aligment() {
		Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = screen.width;
		this.screenHeight = screen.height;
	}
	
	public Aligment(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	
	public int getPosicionY(int hight, int col, int posicion, String aligment) {
		
		int columnWidth = Math.round(screenWidth/col);
		
		return calcularPosicion(columnWidth, hight, posicion, aligment);
	}
	
	public int getPosicionX(int width, int col, int posicion, String aligment) {
		
		int columnWidth = Math.round(screenWidth/col);
		
		return calcularPosicion(columnWidth, width, posicion, aligment);
	}
	
	private int calcularPosicion(int columnWidth,int width, int posicion, String aligment) {
		
		switch(aligment) {
		case CENTER:
			return  (columnWidth * posicion) + Math.round((columnWidth - width)/2);
		case LEFT:
			return (columnWidth * posicion) + columnWidth - width;
		case RIGHT:
			return (columnWidth * posicion);
		default:
			return 0;
		}
		
	}
	
	public int getCol6H(int hight, int width, int posicion, String aligment) {
		int columnWidth = Math.round(screenWidth/6);
		
		return calcularPosicion(columnWidth, width, posicion, aligment);
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	
}
