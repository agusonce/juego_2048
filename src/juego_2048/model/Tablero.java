package juego_2048.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {

	public static final int SIZE = 4;

	private double probabilidadValor2 = 0.8;
	private List<int[]> celdasVacias;
	private int[][] tablero;
	private Random random;

	public Tablero() {
		tablero = new int[SIZE][SIZE]; //Creo que cuando llamemos al constructor, ya debemos iniciarlo.
		random = new Random(); //Lo mismo con el random.
		celdasVacias = new ArrayList<>();
		init(); 
	}

	public Tablero(int[][] tablero) {
		this.tablero = tablero;
		random = new Random(); //Lo mismo con el random.
		celdasVacias = new ArrayList<>();
	}

	public void init() {
		try {
			this.obtenerListadoCeldasVacias();
			this.colocarValoresIniciales();
		} catch (Exception e) {
			System.err.println("HA OCURRIDO UN ERROR NEFASTO. DETALLE: " + e.getMessage()); //Estaria bueno ver qué hacemos si hay un error en la app. Podríamos redirigir al inicio o algo.
		}
	}

	/**
	 * Será útil para llevar un control de las celdas vacías con el objetivo de
	 * acceder más rápido a la posición donde queremos rellenar con valores.
	 */
	private void obtenerListadoCeldasVacias() {
		try {
			celdasVacias = new ArrayList<>();
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if(this.tablero[i][j] == 0) {
						celdasVacias.add(new int[] { i, j });
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error: No se inicia el listado de celdas vacías. Detalle: " + e.getMessage());
		}
	}

	/**
	 * Colocaremos en nuestra matriz los dos primeros valores para comenzar el
	 * juego. Tendremos en cuenta no superponer posiciones y a la vez la
	 * probabilidad que deseamos entre el 2 y el 4.
	 */
	private void colocarValoresIniciales() {
		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();

		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();
	}

	/**
	 * Esta funcion asignará en una celda vacía un valor teniendo en cuenta las probabilidades de 2 o 4, si es que existe este lugar.
	 */
	public void colocarValorEnCeldaVacia() {
		try {
			if(!celdasVacias.isEmpty()) {
				int index = random.nextInt(celdasVacias.size());
				int[] celda = celdasVacias.get(index);
				int fila = celda[0];
				int columna = celda[1];
				tablero[fila][columna] = this.obtenerValorRelleno();
			}

		} catch (Exception e) {
			System.err.println("Error: No se pudo colocar un número en una celda vacía. Detalle: " + e.getMessage());
		}
	}

	/**
	 * Establece el valor aleatorio basado en la probabilidad deseada.
	 * @return El valor inicial generado (2 o 4).
	 */
	private int obtenerValorRelleno() {
		return random.nextDouble() < this.probabilidadValor2 ? 2 : 4;
	}

	public void doLeft() {
		this.tablero = ordenarMatrizHaciaIzq(this.tablero); //Estos métodos no tienen que ser estáticos, me quedaron estáticos de cuando hice las pruebas.
		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();
	}

	public void doRight() {
		this.tablero = ordenarMatrizHaciaDer(this.tablero); //Estos métodos no tienen que ser estáticos, me quedaron estáticos de cuando hice las pruebas.
		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();
	}

	public void doUp() {
		this.tablero = ordenarMatrizHaciaArriba(this.tablero); //Estos métodos no tienen que ser estáticos, me quedaron estáticos de cuando hice las pruebas.
		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();
	}

	public void doDown() {
		this.tablero = ordenarMatrizHaciaAbajo(this.tablero); //Estos métodos no tienen que ser estáticos, me quedaron estáticos de cuando hice las pruebas.
		this.obtenerListadoCeldasVacias();
		this.colocarValorEnCeldaVacia();
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
	 * Realiza un recorrido por el array haciendo el ordenado y suma dejando los ceros
	 * al final. Las sumas las realiza de a dos números cuando estos son iguales.
	 * Una vez que efectúa la suma, el valor del array donde está el segundo sumando
	 * es reemplazado por el valor a la derecha de esta posición. En caso de no
	 * existir dicho valor, coloca un 0. A su vez, deja todos los ceros en el final
	 * del array, si existen.
	 * @param valores: Array de enteros con los cuales se desea operar.
	 * @return Un array de enterios ordenado de misma dimensión que la entrada con el
	 * orden y las sumas deseadas.
	 */
	private static int[] reordenarConSumas(int[] valores) {
		int[] arrayOperado = ordenarCerosHaciaFinal(valores);
		arrayOperado = realizarSumasDesdeInicio(arrayOperado);
		return arrayOperado;
	}
	
	/**
	 * Se encarga de reordenar el array de forma que los ceros queden en las últimas posiciones.
	 * @param valores: Recibe el array de enteros a ordenar.
	 * @return Un array de enteros con el orden deseado.
	 */
	private static int[] ordenarCerosHaciaFinal(int[] valores) {
		int indiceNoCeros = 0;
		int[] arrayOrdenado = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] != 0) {
				arrayOrdenado[indiceNoCeros++] = valores[i];
			}
		}
		return arrayOrdenado;
	}
	
	/**
	 * Realiza la suma de dos números consecutivos iguales en un array de enteros, dejando el resultado en la primera posición
	 * y en la segunda coloca el valor de la siguiente posición. Para la última posición, en caso de corresponder una suma
	 * entre los dos últimos valores, coloca un 0.
	 * @param valores: Recibe el array de enteros a sumar valores.
	 * @return Retorna un array con los valores sumados.
	 */
	private static int[] realizarSumasDesdeInicio(int[] valores) {
		int[] arrayConSumas = valores.clone();
		int i = 0;
		while (i + 1 < valores.length) {
			if (arrayConSumas[i] == arrayConSumas[i + 1]) {
				arrayConSumas[i] = arrayConSumas[i] * 2;
				int j = i + 1;
				while (j + 1 < arrayConSumas.length) {
					int valorSiguiente = arrayConSumas[j + 1];
					arrayConSumas[j] = valorSiguiente;
					j++;
				}
				if (j + 1 == arrayConSumas.length) {
					arrayConSumas[j] = 0;
				}
			}
			i++;
		}
		return arrayConSumas;
	}
	
	/**
	 * Es el método que se encarga de realizar la operación de suma de valores y 
	 * correr a los números distintos de cero hacia el incio del array.
	 * @param valores: Es el array de enteros que deseamos ordenar.
	 * @return Devuelve un array de enteros ordenado y sumado según lo deseado.
	 */
	private static int[] operarFilaHaciaInicio(int[] valores) {
		return reordenarConSumas(valores);
	}

	/**
	 * Es el método que se encarga de realizar la operación de suma de valores y 
	 * correr a los números distintos de cero hacia el final del array.
	 * @param valores: Es el array de elementos que deseamos ordenar.
	 * @return Devuelve la un array ordenado y sumado según lo deseado.
	 */
	private static int[] operarFilaHaciaFinal(int[] valores) {
		int[] arrayOrdenado = reordenarConSumas(valores);
		arrayOrdenado = ordenarCerosHaciaInicio(arrayOrdenado);
		return arrayOrdenado;
	}
	
	/**
	 * Dado un array de enteros ordenado con los ceros hacia el final, el método se encarga
	 * de realizar un reordenamiento y colocar los ceros al inicio.
	 * @param valoresOrdenadosConCerosAlFinal: Es el array de enteros que contiene los ceros al final.
	 * @return Devuelve el array de enteros con el orden deseado.
	 */
	private static int[] ordenarCerosHaciaInicio(int[] valoresOrdenadosConCerosAlFinal) {
		int[] arrayOrdenado = new int[valoresOrdenadosConCerosAlFinal.length];
		int contadorCeros = 0;
		int index = valoresOrdenadosConCerosAlFinal.length - 1;
		while (index > 0 && valoresOrdenadosConCerosAlFinal[index] == 0) {
			contadorCeros++;
			index--;
		}	
		for (int i = 0; i < contadorCeros; i++) {
			arrayOrdenado[i] = 0;
		}
		for (int i = contadorCeros; i < valoresOrdenadosConCerosAlFinal.length; i++) {
			arrayOrdenado[i] = valoresOrdenadosConCerosAlFinal[i - contadorCeros];
		}
		return arrayOrdenado;
	}

	/**
	 * Reordena una matriz operando de manera que queden los ceros en la parte derecha de la matriz
	 * y a su vez suma los números consecutivos operando de a parejas de dos.
	 * @param matriz: Es la matriz de enteros a realizar la operación.
	 * @return Devuelve una matriz aplicada la operación descrita.
	 */
	private static int[][] ordenarMatrizHaciaIzq(int[][] matriz) {
		int[][] matrizFinal = clonarMatriz(matriz);
		for (int i = 0; i < matriz.length; i++) {
			matrizFinal[i] = operarFilaHaciaInicio(matriz[i]);
		}
		return matrizFinal;
	}
	
	/**
	 * Reordena una matriz operando de manera que queden los ceros en la parte izquierda de la matriz
	 * y a su vez suma los números consecutivos operando de a parejas de dos.
	 * @param matriz: Es la matriz de enteros a realizar la operación.
	 * @return Devuelve una matriz aplicada la operación descrita.
	 */
    private static int[][] ordenarMatrizHaciaDer(int[][] matriz) {
        int[][] matrizFinal = clonarMatriz(matriz);
        for (int i = 0; i < matriz.length; i++) {
            matrizFinal[i] = operarFilaHaciaFinal(matriz[i]);
        }
        return matrizFinal;
    }
    
    /**
     * Dada una matriz cuadrada de enteros, realiza y devuelve su trasversa.
     * @param matriz: La matriz de la cual partiremos.
     * @return Devuelve una nueva matriz trasversa de la recibida por parámetro.
     */
    public static int[][] trasponerMatriz(int[][] matriz) {
        int dimension = matriz.length;
        int[][] matrizTraspuesta = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
            	matrizTraspuesta[j][i] = matriz[i][j];
            }
        }
        return matrizTraspuesta;
    }
    
	/**
	 * Reordena una matriz operando de manera que queden los ceros en la parte de arriba de la matriz
	 * y a su vez suma los números consecutivos operando de a parejas de dos.
	 * @param matriz: Es la matriz de enteros a realizar la operación.
	 * @return Devuelve una matriz aplicada la operación descrita.
	 */
    private static int[][] ordenarMatrizHaciaAbajo(int[][] matriz) {
    	int dimension = matriz.length;
    	int[][] traspuesta = trasponerMatriz(matriz);
        int[][] matrizFinal = new int[dimension][dimension];
        for (int i = 0; i < matriz.length; i++) {
            matrizFinal[i] = operarFilaHaciaFinal(traspuesta[i]);
        }
        matrizFinal = trasponerMatriz(matrizFinal);
        return matrizFinal;
    }
    
	/**
	 * Reordena una matriz operando de manera que queden los ceros en la parte de abajo de la matriz
	 * y a su vez suma los números consecutivos operando de a parejas de dos.
	 * @param matriz: Es la matriz de enteros a realizar la operación.
	 * @return Devuelve una matriz aplicada la operación descrita.
	 */

    private static int[][] ordenarMatrizHaciaArriba(int[][] matriz) {
    	int dimension = matriz.length;
    	int[][] traspuesta = trasponerMatriz(matriz);
        int[][] matrizFinal = new int[dimension][dimension];
        for (int i = 0; i < matriz.length; i++) {
            matrizFinal[i] = operarFilaHaciaInicio(traspuesta[i]);
        }
        matrizFinal = trasponerMatriz(matrizFinal);
        return matrizFinal;
    }
    
    /**
     * Este método clona una matriz.
     * @param matriz: es la matriz a clonar.
     * @return Devuelve una nueva matriz con los valores de la matriz por parámetro.
     */

    public static int[][] clonarMatriz( int[][] matriz){
        int[][] matrizNueva = new int[matriz.length][matriz.length];
        for(int i = 0; i < matriz.length; i++){
          matrizNueva[i] = matriz[i].clone();
        }
        return matrizNueva;
      }
    
	
	/**
	 * Es un método usado para pruebas internas. Imprime una matriz deseada respetando visualmente
	 * el orden de filas y columnas.
	 * @param matriz: Es la matriz de enteros a realizar la operación.
	 */
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
