package juego_2048.components;


import juego_2048.components.config.Aligment;
import juego_2048.model.Tablero;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		
		addKeyListener(new KeyListener() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

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
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
		
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
		tablero.doLeft();
		updateScreen();
	}
	
	public void doRight() {
		tablero.doRight();
		updateScreen();
	}
	
	public void doUp() {
		tablero.doUp();
		updateScreen();
	}
	
	public void doDown() {
		tablero.doDown();
		updateScreen();
	}
	
	private void updateScreen() {
		
		for(int column = 0 ; column <= tablero.getSize() -1; column++) {
			for(int fila = 0 ; fila <= tablero.getSize() -1; fila++) {
				FCelda celda = celdas[column][fila];
				
				celda.setText(String.valueOf(tablero.getDato(fila, column)));
			}
		}
		
	}
}
