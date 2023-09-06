import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> directoriesToCreate = new ArrayList<>();
        directoriesToCreate.add("C:/Users/User/Downloads/Games/src");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/res");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/savegames");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/temp");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/src/main");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/src/test");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/res/drawables");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/res/vectors");
        directoriesToCreate.add("C:/Users/User/Downloads/Games/res/icons");


        List<String> filesToCreate = new ArrayList<>();
        filesToCreate.add("C:/Users/User/Downloads/Games/src/main/Main.java");
        filesToCreate.add("C:/Users/User/Downloads/Games/src/main/Utils.java");
        filesToCreate.add("C:/Users/User/Downloads/Games/temp/temp.txt");


        StringBuilder log = new StringBuilder();

        createDirectories(directoriesToCreate, log);

        createFiles(filesToCreate, log);


        writeLogToFile(log.toString(), "C:/Users/User/Downloads/Games/temp/temp.txt");
    }

    private static void createDirectories(List<String> directoriesToCreate, StringBuilder log) {
        for (String path : directoriesToCreate) {
            File directory = new File(path);
            if (directory.mkdir()) {
                log.append("Директория создана: ").append(directory.getPath()).append("\n");
            } else {
                log.append("Не удалось создать директорию: ").append(directory.getPath()).append("\n");
            }
        }
    }

    private static void createFiles(List<String> filesToCreate, StringBuilder log) {
        for (String path : filesToCreate) {
            File file = new File(path);
            try {
                if (file.createNewFile()) {
                    log.append("Файл создан: ").append(file.getPath()).append("\n");
                } else {
                    log.append("Не удалось создать файл: ").append(file.getPath()).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeLogToFile(String log, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(log);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}