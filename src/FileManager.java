package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    // =========================
    // METHOD 8: File Handling
    // =========================

    public static void saveData() {
        try {
            File f = new File("MyFILE.txt");
            FileWriter writer = new FileWriter(f);
            for (int i = 0; i < MiniChatSystem.count; i++) {
                writer.write(MiniChatSystem.messages[i] + "\n");
            }
            writer.close();
            System.out.println("Data saved");
        } catch (IOException e) {
            System.out.println("Error saving file");
        }

    }
}
