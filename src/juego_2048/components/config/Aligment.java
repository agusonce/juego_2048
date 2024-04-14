package juego_2048.components.config;

import java.awt.Dimension;

public class Aligment {
	
	private static int CORRECCION_BANNER = 30;
	
	public static final String CENTER = "CENTER";
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	
	private int screenWidth;
	private int screenHeight;
	
	public Aligment() {
		Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.screenHeight = screen.height - CORRECCION_BANNER;
		this.screenWidth = screen.height - CORRECCION_BANNER;
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
		
		int columnWidth = Math.round(screenHeight/col);
		
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
	
	public int getScreenHeight() {
		return screenHeight - CORRECCION_BANNER;
	}
	
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	
}
