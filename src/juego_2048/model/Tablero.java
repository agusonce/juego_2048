package juego_2048.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

public class Tablero {
	private final int SIZE = 4;
	private double probabilidadValor2 = 0.8;
	private List<int[]> celdasVacias;
	private int[][] tablero;
	private Random random;

	public Tablero() {
//		super();
		tablero = new int[SIZE][SIZE];
		random = new Random();
		init();
	}

	public void init() {
		try {
			this.iniciarListadoCeldasVacias();
			this.colocarValoresIniciales();
//			tablero[getPosicionRandom()][getPosicionRandom()] = getValorRandom();
		} catch (Exception e) {
			System.err.println("HA OCURRIDO UN ERROR NEFASTO. DETALLE: " + e.getMessage());
		}
	}

	/**
	 * Será útil para llevar un control de las celdas vacías con el objetivo de
	 * acceder más rápido a la posición donde queremos rellenar con valores.
	 */
	private void iniciarListadoCeldasVacias() {
		try {
			celdasVacias = new ArrayList<>();
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					celdasVacias.add(new int[] { i, j });
				}
			}
		} catch (Exception e) {
			System.err.println("Error: No se iniciar el listado de celdas vacías. Detalle: " + e.getMessage());
		}
	}

	/**
	 * Colocaremos en nuestra matriz los dos primeros valores para comenzar el
	 * juego. Tendremos en cuenta no superponer posiciones y a la vez la
	 * probabilidad que deseamos entre el 2 y el 4
	 */
	private void colocarValoresIniciales() {
		this.colocarValorEnCeldaVacia();
		this.colocarValorEnCeldaVacia();
	}

	/**
	 * Esta funcion evaluara qué lugares están vacios y en uno de ellos asignará un
	 * valor a esta, teniendo en cuenta las probabilidades de 2 o 4.
	 */
	public void colocarValorEnCeldaVacia() {
		try {
			int index = random.nextInt(celdasVacias.size());
			int[] celda = celdasVacias.get(index);
			int fila = celda[0];
			int columna = celda[1];
			tablero[fila][columna] = this.obtenerValorRelleno();
			celdasVacias.remove(index);
		} catch (Exception e) {
			System.err.println("Error: No se pudo colocar un número en una celda vacía. Detalle: " + e.getMessage());
		}
	}

	/**
	 * Establece el valor aleatorio basado en la probabilidad deseada.
	 * 
	 * @return El valor inicial generado (2 o 4).
	 */
	private int obtenerValorRelleno() {
		return random.nextDouble() < this.probabilidadValor2 ? 2 : 4;
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
		return random.nextBoolean() ? 2 : 4;
	}

	private int getPosicionRandom() {
		return random.nextInt(SIZE - 1);
	}

	/**
	 * Realiza un recorrido por el array haciendo el ordenado y suma hacia la
	 * izquierda. Las sumas las realiza de a dos números cuando estos son iguales.
	 * Una vez que efectúa la suma, el valor del array donde está el segundo sumando
	 * es reemplazado por el valor a la derecha de esta posición. En caso de no
	 * existir dicho valor, coloca un 0. A su vez, deja todos los ceros del lado
	 * derecho.
	 * 
	 * @param valores: Array de elementos en fila a realizar las operaciones.
	 * @return un array ordenado de misma dimensión que la entrada y con el orden y
	 *         las sumas deseadas.
	 */
	private static int[] reordenarConSumas(int[] valores) {
		int indiceNoCeros = 0;
		int[] arrayOrdenado = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] != 0) {
				arrayOrdenado[indiceNoCeros++] = valores[i];
			}
		}
		int i = 0;
		while (i + 1 < arrayOrdenado.length) {
			if (arrayOrdenado[i] == arrayOrdenado[i + 1]) {
				arrayOrdenado[i] = arrayOrdenado[i] * 2;
				int j = i + 1;
				while (j + 1 < arrayOrdenado.length) {
					int valorSiguiente = arrayOrdenado[j + 1];
					arrayOrdenado[j] = valorSiguiente;
					j++;
				}
				if (j + 1 == arrayOrdenado.length) {
					arrayOrdenado[j] = 0;
				}
			}
			i++;
		}
		return arrayOrdenado;
	}

	private static int[] reordenarFilaHaciaIzquierda(int[] valores) {
		return reordenarConSumas(valores);
	}

	private static int[] reordenarFilaHaciaDerecha(int[] valores) {
		int[] tempArray = reordenarConSumas(valores);
		int contadorCeros = 0;
		int index = tempArray.length - 1;
		while (index > 0 && tempArray[index] == 0) {
			contadorCeros++;
			index--;
		}
		int[] arrayFinal = valores;
		for (int i = 0; i < contadorCeros; i++) {
			arrayFinal[i] = 0;
		}
		for (int i = contadorCeros; i < tempArray.length; i++) {
			arrayFinal[i] = tempArray[i - contadorCeros];
		}
		return arrayFinal;
	}

	private static int[][] ordenarMatrizHaciaIzq(int[][] matriz) {
		int[][] matrizFinal = matriz;
		for (int i = 0; i < matriz.length; i++) {
			matrizFinal[i] = reordenarFilaHaciaIzquierda(matriz[i]);
		}
		return matrizFinal;
	}
	
    private static int[][] ordenarMatrizHaciaDer(int[][] matriz) {
        int[][] matrizFinal = matriz;
        for (int i = 0; i < matriz.length; i++) {
            matrizFinal[i] = reordenarFilaHaciaDerecha(matriz[i]);
        }
        return matrizFinal;
    }
	
	
	
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
	
	
}
