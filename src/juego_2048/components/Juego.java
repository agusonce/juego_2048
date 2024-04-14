package juego_2048.components;


import juego_2048.MenuInicio;
import juego_2048.PantallaFinal;
import juego_2048.Router;
import juego_2048.components.config.Aligment;
import juego_2048.components.config.Style;
import juego_2048.logical.JuegoLogica;
import juego_2048.model.Tablero;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends FrameAbstract{

	private int PADDING = 5;
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
		
		//configuracion de la ventana
		setBounds(0,0,aligment.getScreenWidth() + 20 ,aligment.getScreenHeight() + 45);
		getContentPane().setBackground(Style.COLOR_FONDO_TABLERO);
		setResizable(false);
		inicializarCeldas();
		
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        doLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        doRight();
                        break;
                    case KeyEvent.VK_UP:
                        doUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        doDown();
                        break;
                }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
        });
		
	}
	
	
	
	private void inicializarCeldas() {
		
		int clTamanio = calcularDimencioCelda();
		for(int column = 0 ; column <= tablero.getSize() -1; column++) {
			for(int fila = 0 ; fila <= tablero.getSize() - 1; fila++) {
				FCelda celda = new FCelda();
				celda.setText(String.valueOf(tablero.getDato(fila, column)));
				
				celda.setBounds(PADDING + aligment.getPosicionX(clTamanio, tablero.getSize(), column, Aligment.CENTER)
								, PADDING + aligment.getPosicionY(clTamanio, tablero.getSize(), fila, Aligment.CENTER)
								,clTamanio
								,clTamanio);
				
				celdas[column][fila] = celda;
				
				getContentPane().add(celda);
			}
		}
	}

	public void doLeft() {
		tablero.doLeft();
		updateScreen();
		checkGameState();
	}
	
	public void doRight() {
		tablero.doRight();
		updateScreen();
		checkGameState();
	}
	
	public void doUp() {
		tablero.doUp();
		updateScreen();
		checkGameState();
	}
	
	public void doDown() {
		tablero.doDown();
		updateScreen();
		checkGameState();
	}
	
	private void updateScreen() {
		
		for(int column = 0 ; column <= tablero.getSize() -1; column++) {
			for(int fila = 0 ; fila <= tablero.getSize() -1; fila++) {
				FCelda celda = celdas[column][fila];
				
				celda.setText(String.valueOf(tablero.getDato(fila, column)));
			}
		}
		repaint();
	}
	
	private int calcularDimencioCelda() {
		return (aligment.getScreenWidth() - tablero.getSize() * PADDING) / tablero.getSize();
	}
	
	private void checkGameState() {
		if (JuegoLogica.verificarVictoria(tablero)) {
			Router.finishWindows(this, new PantallaFinal(true));
		}
		else if (JuegoLogica.verificarDerrota(tablero)) {
			Router.finishWindows(this, new PantallaFinal(false));
		}

	}
}
