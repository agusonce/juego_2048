package juego_2048;

import java.awt.EventQueue;

public class Juego2048 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego2048 juego = new Juego2048();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Juego2048() {
		Router router = Router.getInstancia();
		router.start();
	}
}
