import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String gamesFolderPath = "путь_к_папке_Games";
        StringBuilder log = new StringBuilder();

        File gamesFolder = new File(gamesFolderPath);
        if (!gamesFolder.exists()) {
            boolean created = gamesFolder.mkdir();
            log.append("Папка Games создана: ").append(created).append("\n");
        }

        File srcFolder = new File(gamesFolderPath + "/src");
        boolean srcCreated = srcFolder.mkdir();
        log.append("Папка src создана: ").append(srcCreated).append("\n");

        File mainFolder = new File(gamesFolderPath + "/src/main");
        boolean mainCreated = mainFolder.mkdir();
        log.append("Папка main создана: ").append(mainCreated).append("\n");

        File testFolder = new File(gamesFolderPath + "/src/test");
        boolean testCreated = testFolder.mkdir();
        log.append("Папка test создана: ").append(testCreated).append("\n");

        File mainJavaFile = new File(gamesFolderPath + "/src/main/Main.java");
        boolean mainJavaCreated = createNewFile(mainJavaFile);
        log.append("Файл Main.java создан: ").append(mainJavaCreated).append("\n");

        File utilsJavaFile = new File(gamesFolderPath + "/src/main/Utils.java");
        boolean utilsJavaCreated = createNewFile(utilsJavaFile);
        log.append("Файл Utils.java создан: ").append(utilsJavaCreated).append("\n");

        File resFolder = new File(gamesFolderPath + "/res");
        boolean resCreated = resFolder.mkdir();
        log.append("Папка res создана: ").append(resCreated).append("\n");

        File drawablesFolder = new File(gamesFolderPath + "/res/drawables");
        boolean drawablesCreated = drawablesFolder.mkdir();
        log.append("Папка drawables создана: ").append(drawablesCreated).append("\n");

        File vectorsFolder = new File(gamesFolderPath + "/res/vectors");
        boolean vectorsCreated = vectorsFolder.mkdir();
        log.append("Папка vectors создана: ").append(vectorsCreated).append("\n");

        File iconsFolder = new File(gamesFolderPath + "/res/icons");
        boolean iconsCreated = iconsFolder.mkdir();
        log.append("Папка icons создана: ").append(iconsCreated).append("\n");

        File tempFolder = new File(gamesFolderPath + "/temp");
        boolean tempCreated = tempFolder.mkdir();
        log.append("Папка temp создана: ").append(tempCreated).append("\n");

        File tempTxtFile = new File(gamesFolderPath + "/temp/temp.txt");
        boolean tempTxtCreated = createNewFile(tempTxtFile);
        log.append("Файл temp.txt создан: ").append(tempTxtCreated).append("\n");

        writeLogToFile(log.toString(), gamesFolderPath + "/temp/temp.txt");
    }

    private static boolean createNewFile(File file) {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void writeLogToFile(String log, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
