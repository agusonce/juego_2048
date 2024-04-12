package juego_2048.logical;

import juego_2048.model.Tablero;

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
        return !puedeMoverIzquierda(tablero) &&
               !puedeMoverDerecha(tablero) &&
               !puedeMoverArriba(tablero) &&
               !puedeMoverAbajo(tablero);
	}

    public static boolean puedeMoverIzquierda(Tablero tablero) {
        Tablero tableroIzquierda = new Tablero(tablero.getTablero());
        tableroIzquierda.doLeft();
        return tableroIzquierda.equals(tablero);
    }

    public static boolean puedeMoverDerecha(Tablero tablero) {
        Tablero tableroDerecha = new Tablero(tablero.getTablero());
        tableroDerecha.doRight();
        return tableroDerecha.equals(tablero);
    }

    public static boolean puedeMoverArriba(Tablero tablero) {
        Tablero tableroArriba = new Tablero(tablero.getTablero());
        tableroArriba.doUp();
        return tableroArriba.equals(tablero);
    }

    public static boolean puedeMoverAbajo(Tablero tablero) {
        Tablero tableroAbajo = new Tablero(tablero.getTablero());
        tableroAbajo.doDown();
        return tableroAbajo.equals(tablero);
    }

}
