package juego_2048;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Router extends JFrame{

	private static Router instancia;
	
	private Router() {
		
	}
	
	
	public static Router getInstancia() {
		return instancia == null? new Router(): instancia;
	}
	
	public void start() {
		MenuInicio menuInicio = new MenuInicio();
		menuInicio.setVisible(true);
	}
	
	public static void finishWindows(JFrame cerrar, JFrame abrir) {
		cerrar.setVisible(false);
//		System.exit(0);
		cerrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		abrir.setVisible(true);
	}
}
