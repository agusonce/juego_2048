package juego_2048.logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ScoreRanking {

    private static final Logger LOGGER = Logger.getLogger(ScoreRanking.class.getName());
    private static final String LOG_FILE_NAME = "scores.txt"; 
    private List<Integer> scores;

    public ScoreRanking() {
        scores = new ArrayList<>();
        setupLogger();
    }


    private void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE_NAME, true); // El true indica que se agregará al archivo existente si ya hay uno
            LOGGER.addHandler(fileHandler);

            // Configurar un SimpleFormatter para formatear los logs
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addScore(int score) {
        scores.add(score);
        LOGGER.info("Nueva puntuación agregada: " + score);
    }

    public List<Integer> getScores() {
        LOGGER.info("Consultando historial de puntuaciones");
        return scores;
    }
}