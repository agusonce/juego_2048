package juego_2048.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ranking {

    public static void writeToFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(content);
                System.out.println("Se escribio exitosamente.");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    // Método para leer las puntuaciones anteriores
    public static ArrayList<Integer> readScoresFromFile(String fileName) throws IOException {
        ArrayList<Integer> scores = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return scores;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(Integer.parseInt(line.trim()));
            }
        }

        return scores;
    }
}