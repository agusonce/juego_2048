package juego_2048.backend;

import java.util.Random;

public class Tablero {

	private final int SIZE = 4;
	
	private int[][] tablero;
	private Random random;
	public Tablero() {
		super();
		init();
	}
	
	public void init() {
		
		tablero = new int[SIZE][SIZE];
		random = new Random();
		
		tablero[getPosicionRandom()][getPosicionRandom()] = getValorRandom();
		
	}
	
	public void doLeft() {
		
	}
	
	public void doRight() {
		
	}
	
	public void doUp() {
		
	}
	
	public void doDown() {
		
	}
	
	public int getDato(int x, int y) {
		return tablero[x][y];
	}
	
	public int getSize() {
		return SIZE;
	}
	
	private int getValorRandom() {
		return random.nextBoolean()? 2 : 4;
	}
	
	private int getPosicionRandom() {
		return random.nextInt(SIZE - 1);
	}
	
}
