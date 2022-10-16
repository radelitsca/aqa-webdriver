package work_with_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class WorkWithFile {

    public static void main(String[] args) {
        String path = "src/main/resources/testdata/";
        checkDir(path);
        String fileName = "test_data.yaml";
        checkFile(path, fileName);
        lastModified(path, fileName);
    }

    public static void checkDir(String path) {
        File directory = new File(path);
        try {
            if (!directory.exists()) {
                directory.mkdirs();
            } else {
                System.out.println("Such directory already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkFile(String path, String name) {
        File directory = new File(path);

        File file = new File(directory, name);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("Such file already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lastModified(String path, String name) {
        File file = new File(path, name);
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("File was last modified " + date.format(file.lastModified()));
    }
}
