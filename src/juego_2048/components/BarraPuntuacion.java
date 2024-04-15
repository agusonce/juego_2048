package juego_2048.components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraPuntuacion extends JPanel {
    private JLabel labelPuntuacion;

    public BarraPuntuacion() {
        labelPuntuacion = new JLabel("Puntuación: 0");
        add(labelPuntuacion);
    }

    public void setPuntuacion(int puntuacion) {
        labelPuntuacion.setText("Puntuación: " + puntuacion);
        setPreferredSize(new Dimension(400, 300));
        add(labelPuntuacion);
    }
}
