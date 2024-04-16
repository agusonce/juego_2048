package juego_2048.components.config;

import java.awt.Color;
import java.awt.Font;

public class Style {

	public static final Color COLOR_MARRON = new Color(143, 122, 102);

	public static final Color COLOR_VACIO = new Color(238, 228, 218, 30);

	public static final Color COLOR_2 = new Color(238, 228, 218);

	public static final Color COLOR_4 = new Color(238, 225, 201);

	public static final Color COLOR_8 = new Color(243, 178, 122);

	public static final Color COLOR_16 = new Color(246, 150, 100);

	public static final Color COLOR_32 = new Color(247, 124, 95);

	public static final Color COLOR_64 = new Color(247, 95, 59);

	public static final Color COLOR_128 = new Color(237, 208, 115);

	public static final Color COLOR_256 = new Color(238, 128, 218);

	public static final Color COLOR_512 = new Color(237, 201, 80);

	public static final Color COLOR_1024 = new Color(128, 75, 189);

	public static final Color COLOR_FONDO_TABLERO = new Color(119, 110, 101);

	public static Font createFont(int size) {
		return new Font("Arial", Font.PLAIN, size);
	}

}
