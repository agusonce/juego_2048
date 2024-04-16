package juego_2048.test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import juego_2048.model.Tablero;

class TableroTest {

	private Tablero tablero;

	@Test
	public void doLeftCasoSimple() {

		int[][] matriz = new int[Tablero.SIZE][Tablero.SIZE];
		matriz[0][Tablero.SIZE - 1] = 2;

		tablero = new Tablero(matriz);

		tablero.doLeft();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == 14;

		boolean desplazamientoCorrecto = tablero.getDato(0, 0) == 2;

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doLeftCasoSinSuma() {

		int[][] matriz = new int[][] { { 0, 2, 0, 0 }, { 0, 4, 2, 0 }, { 4, 2, 0, 0 }, { 2, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 2 }, new int[] { 1, 0, 4 },
				new int[] { 1, 1, 2 }, new int[] { 2, 0, 4 }, new int[] { 2, 1, 2 }, new int[] { 3, 0, 2 },
				new int[] { 3, 1, 4 }, new int[] { 3, 2, 2 }, new int[] { 3, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doLeft();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doLeftCasoConSuma() {

		int[][] matriz = new int[][] { { 0, 0, 2, 2 }, { 0, 2, 2, 2 }, { 2, 2, 2, 2 }, { 4, 4, 0, 0 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 4 }, new int[] { 1, 0, 4 },
				new int[] { 1, 1, 2 }, new int[] { 2, 0, 4 }, new int[] { 2, 1, 4 }, new int[] { 3, 0, 8 }));

		tablero = new Tablero(matriz);

		tablero.doLeft();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doLeftCasoSinMovimiento() {

		int[][] matriz = new int[][] { { 2, 0, 0, 0 }, { 2, 4, 0, 0 }, { 2, 4, 2, 0 }, { 2, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 2 }, new int[] { 1, 0, 2 },
				new int[] { 1, 1, 4 }, new int[] { 2, 0, 2 }, new int[] { 2, 1, 4 }, new int[] { 2, 2, 2 },
				new int[] { 3, 0, 2 }, new int[] { 3, 1, 4 }, new int[] { 3, 2, 2 }, new int[] { 3, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doLeft();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size()) + 1;

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doRightCasoSinSuma() {

		int[][] matriz = new int[][] { { 0, 2, 0, 0 }, { 0, 4, 2, 0 }, { 4, 2, 0, 0 }, { 2, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 3, 2 }, new int[] { 1, 3, 2 },
				new int[] { 1, 2, 4 }, new int[] { 2, 3, 2 }, new int[] { 2, 2, 4 }, new int[] { 3, 3, 4 },
				new int[] { 3, 2, 2 }, new int[] { 3, 1, 4 }, new int[] { 3, 0, 2 }));

		tablero = new Tablero(matriz);

		tablero.doRight();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doRightCasoConnSuma() {

		int[][] matriz = new int[][] { { 0, 2, 2, 0 }, { 2, 2, 2, 0 }, { 4, 4, 2, 2 }, { 2, 2, 2, 2 } };

		List<int[]> resultadoEsperado = new ArrayList<>(
				Arrays.asList(new int[] { 0, 3, 4 }, new int[] { 1, 3, 4 }, new int[] { 1, 2, 2 },
						new int[] { 2, 3, 4 }, new int[] { 2, 2, 8 }, new int[] { 3, 3, 4 }, new int[] { 3, 2, 4 }));

		tablero = new Tablero(matriz);

		tablero.doRight();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doRightCasoSinMovimeinto() {

		int[][] matriz = new int[][] { { 0, 0, 0, 2 }, { 0, 0, 4, 2 }, { 0, 2, 4, 2 }, { 2, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 3, 2 }, new int[] { 1, 3, 2 },
				new int[] { 1, 2, 4 }, new int[] { 2, 3, 2 }, new int[] { 2, 2, 4 }, new int[] { 2, 1, 2 },
				new int[] { 3, 3, 4 }, new int[] { 3, 2, 2 }, new int[] { 3, 1, 4 }, new int[] { 3, 0, 2 }));

		tablero = new Tablero(matriz);

		tablero.doRight();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size()) + 1;

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doUpCasoSinSuma() {

		int[][] matriz = new int[][] { { 0, 0, 0, 2 }, { 0, 0, 2, 4 }, { 2, 2, 4, 2 }, { 0, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 2 }, new int[] { 0, 1, 2 },
				new int[] { 0, 2, 2 }, new int[] { 0, 3, 2 }, new int[] { 1, 1, 4 }, new int[] { 1, 2, 4 },
				new int[] { 1, 3, 4 }, new int[] { 2, 2, 2 }, new int[] { 2, 3, 2 }, new int[] { 3, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doUp();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doUpCasoConSuma() {

		int[][] matriz = new int[][] { { 4, 2, 2, 2 }, { 0, 2, 2, 2 }, { 2, 0, 2, 2 }, { 2, 0, 0, 2 } };

		List<int[]> resultadoEsperado = new ArrayList<>(
				Arrays.asList(new int[] { 0, 0, 4 }, new int[] { 0, 1, 4 }, new int[] { 0, 2, 4 },
						new int[] { 0, 3, 4 }, new int[] { 1, 0, 4 }, new int[] { 1, 2, 2 }, new int[] { 1, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doUp();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doUpCasoSinMovimeinto() {

		int[][] matriz = new int[][] { { 2, 2, 2, 2 }, { 0, 4, 4, 4 }, { 0, 0, 2, 2 }, { 0, 0, 0, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 2 }, new int[] { 0, 1, 2 },
				new int[] { 0, 2, 2 }, new int[] { 0, 3, 2 }, new int[] { 1, 1, 4 }, new int[] { 1, 2, 4 },
				new int[] { 1, 3, 4 }, new int[] { 2, 2, 2 }, new int[] { 2, 3, 2 }, new int[] { 3, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doUp();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size()) + 1;

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doDownCasoSinSuma() {

		int[][] matriz = new int[][] { { 0, 0, 0, 2 }, { 0, 0, 2, 4 }, { 2, 2, 4, 2 }, { 0, 4, 2, 4 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 0, 0, 2 }, new int[] { 0, 1, 2 },
				new int[] { 0, 2, 2 }, new int[] { 0, 3, 2 }, new int[] { 1, 1, 4 }, new int[] { 1, 2, 4 },
				new int[] { 1, 3, 4 }, new int[] { 2, 2, 2 }, new int[] { 2, 3, 2 }, new int[] { 3, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doUp();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doDownCasoConSuma() {

		int[][] matriz = new int[][] { { 4, 2, 2, 2 }, { 0, 2, 2, 2 }, { 2, 0, 2, 2 }, { 2, 0, 0, 2 } };

		List<int[]> resultadoEsperado = new ArrayList<>(
				Arrays.asList(new int[] { 3, 0, 4 }, new int[] { 3, 1, 4 }, new int[] { 3, 2, 4 },
						new int[] { 3, 3, 4 }, new int[] { 2, 0, 4 }, new int[] { 2, 2, 2 }, new int[] { 2, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doDown();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size());

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	@Test
	public void doDownCasoSinMovimeinto() {

		int[][] matriz = new int[][] { { 0, 0, 0, 4 }, { 0, 0, 2, 2 }, { 0, 4, 4, 4 }, { 2, 2, 2, 2 } };

		List<int[]> resultadoEsperado = new ArrayList<>(Arrays.asList(new int[] { 3, 0, 2 }, new int[] { 3, 1, 2 },
				new int[] { 3, 2, 2 }, new int[] { 3, 3, 2 }, new int[] { 2, 1, 4 }, new int[] { 2, 2, 4 },
				new int[] { 2, 3, 4 }, new int[] { 1, 2, 2 }, new int[] { 1, 3, 2 }, new int[] { 0, 3, 4 }));

		tablero = new Tablero(matriz);

		tablero.doDown();

		boolean cantidadDeCerosCorrecto = getCantCeros(tablero) == getCantidadEsperado(resultadoEsperado.size()) + 1;

		boolean desplazamientoCorrecto = compararResultado(resultadoEsperado);

		assertTrue(cantidadDeCerosCorrecto && desplazamientoCorrecto);

	}

	private int getCantCeros(Tablero tablero) {
		int celdasVacias = 0;
		for (int i = 0; i < tablero.getSize(); i++) {
			for (int j = 0; j < tablero.getSize(); j++) {
				if (tablero.getDato(i, j) == 0) {
					celdasVacias++;
				}
			}
		}
		return celdasVacias;
	}

	private boolean compararResultado(List<int[]> resultadosEsperados) {

		for (int[] resultadoEsperado : resultadosEsperados) {
			if (tablero.getDato(resultadoEsperado[0], resultadoEsperado[1]) != resultadoEsperado[2]) {
				return false;
			}
		}

		return true;
	}

	private int getCantidadEsperado(int casosEsperados) {
		return (4 * 4) - (casosEsperados + 1);
	}
}
