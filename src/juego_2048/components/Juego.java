package juego_2048.components;


import juego_2048.backend.Tablero;
import juego_2048.components.config.Aligment;

public class Juego extends FrameAbstract{

	private Tablero tablero;
	private FCelda[][] celdas; 
	
	public Juego() {
		super();
		
		initialize();		
	}
	
	public Juego(Aligment aligment) {
		
		this.aligment = aligment;
		initialize();
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		tablero = new Tablero();
		celdas = new FCelda[tablero.getSize()][tablero.getSize()];
		
		
		this.setBounds(0,0,aligment.getScreenWidth(),aligment.getScreenHeight());
		
		inicializarCeldas();
	}
	
	
	
	private void inicializarCeldas() {
		for(int column = 0 ; column <= tablero.getSize() -1; column++) {
			for(int fila = 0 ; fila <= tablero.getSize() - 1; fila++) {
				FCelda celda = new FCelda();
				celda.setText(String.valueOf(tablero.getDato(fila, column)));
				
				celda.setBounds(aligment.getPosicionX(200, tablero.getSize(), column, Aligment.CENTER)
								,aligment.getPosicionY(200, tablero.getSize(), fila, Aligment.CENTER)
								,200
								,200);
				System.out.println("celda: x =" + celda.getX() + ", y = " + celda.getY() );
				celdas[column][fila] = celda;
				
				getContentPane().add(celda);
			}
		}
	}

	public void doLeft() {
		
	}
	
	public void doRight() {
		
	}
	
	public void doUp() {
		
	}
	
	public void doDown() {
		
	}
	
	private void updateScreen() {
		
		for(int column = 0 ; column <= tablero.getSize(); column++) {
			for(int fila = 0 ; fila <= tablero.getSize(); fila++) {
				FCelda celda = celdas[column][fila];
				
				celda.setText(String.valueOf(tablero.getDato(fila, column)));
			}
		}
		
	}
}
