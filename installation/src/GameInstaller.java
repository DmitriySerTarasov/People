import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {
    public static void main(String[] args) {
        String gamesDirPath = "C:\\Users\\itv\\Desktop\\Java\\Games"; // Путь к папке Games
        File gamesDir = new File(gamesDirPath);

        // Создание директории
        String[] directories = {
                "src",
                "res",
                "savegames",
                "temp",
        };

        StringBuilder log = new StringBuilder();

        //Создание директорий в папке Games
        for (String dir : directories) {
            File directory = new File(gamesDir, dir);
            if (directory.mkdir()) {
                log.append("Директория ").append(dir).append(" успешно создана.\n");
            } else {
                log.append("ОЩибка при создании директории ").append(dir).append(". Возможно, она уже существует.\n");
            }

        }
        // Создание поддиректории в src
        String[] srcSubDirs = {
                "main",
                "test"
        };

        File srcDir = new File(gamesDir, "src");
        for (String subDir : srcSubDirs) {
            File directory = new File(srcDir, subDir);
            if (directory.mkdir()) {
                log.append("Директориия ").append(subDir).append(" успешно создана в src.\n");
            } else {
                log.append("Ошибка при создании директории ").append(subDir).append(" в src. возможно. она уже существует.\n");
            }

        }
        //Создание файла в main
        String[] mainFiles = {
                "Main.java",
                "Utils.java"
        };

        File mainDir = new File(srcDir, "main");
        for (String fileName : mainFiles) {
            File file = new File(mainDir, fileName);
            try {
                if (file.createNewFile()) {
                    log.append("Файл ").append(fileName).append(" успешно создан в main.\n");
                } else {
                    log.append("Ошибка при создании файла ").append(fileName).append(" в main. Возможно, он уже существует.\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла ").append(fileName).append(":").append(e.getMessage()).append("\n");
            }
        }

        //Создание поддиректорий в res
        String[] resSubDirs = {
                "drawables",
                "vectors",
                "icons",
        };

        File resDir = new File(gamesDir, "res");
        for (String subDir : resSubDirs) {
            File directory = new File(resDir, subDir);
            if (directory.mkdir()) {
                log.append("Директория ").append(subDir).append(" успешно создана в res.\n");
            } else {
                log.append("ошибка при создании директории ").append(subDir).append(" в res. возможно, она уже существует.\n");
            }
        }
        //Создание терминала temp.txt в temp
        File tempFile = new File(gamesDir, "temp/temp.txt");
        try {
            if (tempFile.createNewFile()) {
                log.append("Файл temp.txt успешно создан в temp.\n");
            } else {
                log.append("ощибка при создании файла temp.txt в temp. возможно, он уже существует.\n");

            }
        } catch (IOException e) {
            log.append("ошибка при создании файла temp.txt :").append(e.getMessage()).append("\n");
        }
        // Запись лога в файл temp.txt
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (Exception e) {
            System.out.println("ошибка при записи лога в файл temp.txt: " + e.getMessage());
        }
        System.out.println("установка завершена. Проверьте папку Games для подтверждения.");
    }
}
