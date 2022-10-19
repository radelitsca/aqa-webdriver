package streams;

import java.io.*;
import java.util.Scanner;

public class UserDataSaver {
    public void saveUserData(String path) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equalsIgnoreCase("exit")) {
            input = scanner.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
                if (input.equalsIgnoreCase("write")) {
                    writer.flush();
                }
                writer.write(input);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();

    }
}


