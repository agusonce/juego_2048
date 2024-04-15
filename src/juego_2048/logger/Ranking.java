package juego_2048.logger;

import java.io.FileWriter;
import java.io.IOException;

import java.io.File;

public class Ranking {

    public static void writeToFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(content);
                System.out.println("Contenido escrito en el archivo exitosamente.");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}