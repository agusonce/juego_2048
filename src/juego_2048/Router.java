package juego_2048;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Router extends JFrame {

	private static Router instancia;
	private static List<JFrame> pantallas;

	private Router() {
		pantallas = new ArrayList<>();
	}

	public static Router getInstancia() {
		return instancia == null ? new Router() : instancia;
	}

	public void start() {
		MenuInicio menuInicio = new MenuInicio();
		menuInicio.setVisible(true);
	}

	public static void finishWindows(JFrame cerrar, JFrame abrir, boolean dejarAbierto) {
		if (dejarAbierto) {
			pantallas.add(cerrar);
		} else {
			for (JFrame pantalla : pantallas) {
				pantalla.setVisible(false);
				pantalla.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
			cerrar.setVisible(false);
			cerrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		abrir.setVisible(true);
	}
}
