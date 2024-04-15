package juego_2048.logical;

import juego_2048.model.Tablero;
import java.util.Arrays;
public class JuegoLogica {
	
	public static boolean verificarVictoria(Tablero tablero) {
        int[][] matriz = tablero.getTablero();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 2048) {
                    return true; 
                }
            }
        }
        return false; 
    }
	
	public static boolean verificarDerrota(Tablero tablero) {
		int tempPuntaje = tablero.getPuntaje();
		boolean esValido = !puedeMoverIzquierda(tablero) &&
	               !puedeMoverDerecha(tablero) &&
	               !puedeMoverArriba(tablero) &&
	               !puedeMoverAbajo(tablero);
		tablero.setPuntaje(tempPuntaje);
        return esValido;
	}

    public static boolean puedeMoverIzquierda(Tablero tablero) {
        Tablero tableroIzquierda = new Tablero(tablero.getTablero());
        tableroIzquierda.doLeft();
        return !Arrays.deepEquals(tableroIzquierda.getTablero(),tablero.getTablero());
    }

    public static boolean puedeMoverDerecha(Tablero tablero) {
        Tablero tableroDerecha = new Tablero(tablero.getTablero());
        tableroDerecha.doRight();
        return !Arrays.deepEquals(tableroDerecha.getTablero(),tablero.getTablero());
    }

    public static boolean puedeMoverArriba(Tablero tablero) {
        Tablero tableroArriba = new Tablero(tablero.getTablero());
        tableroArriba.doUp();
        return !Arrays.deepEquals(tableroArriba.getTablero(),tablero.getTablero());
    }

    public static boolean puedeMoverAbajo(Tablero tablero) {
        Tablero tableroAbajo = new Tablero(tablero.getTablero());
        tableroAbajo.doDown();
        return !Arrays.deepEquals(tableroAbajo.getTablero(),tablero.getTablero());
    }

}
