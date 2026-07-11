package src;

import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MiniChatSystem {
    static Scanner sc = new Scanner(System.in);
    public static String[] messages = new String[100];
    public static int count = 0;

    public static void main(String[] args) {

        runMenu(sc);

    }

    // =========================
    // Run menu
    // =========================
    public static void runMenu(Scanner sc) {

        System.out.println("\n===== MINI CHAT SYSTEM =====");
        System.out.println("1. Send Message");
        System.out.println("2. View Chat History");
        System.out.println("3. Search Message");
        System.out.println("4. Delete Message");
        System.out.println("5. Total Messages");
        System.out.println("6. Clear Chat");
        System.out.println("7.Save data in file");
        System.out.println("8. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        switch (choice) {

            case 1:
                ChatManager.sendMessage(sc);
                break;

            case 2:
                ChatManager.viewChat();
                break;

            case 3:
                ChatManager.searchMessage(sc);
                break;

            case 4:
                ChatManager.deleteMessage(sc);
                break;

            case 5:
                ChatManager.totalMessages();
                break;

            case 6:
                ChatManager.clearChat();
                break;

            case 7:
                saveData();
                break;

            case 8:
                System.out.println("Exiting Chat...");
                break;

            default:
                System.out.println("Invalid choice!");
        }
        if (choice != 8) {
            runMenu(sc);
        }
    }

    // =========================
    // METHOD 8: File Handling
    // =========================

    public static void saveData() {
        try {
            File f = new File("MyFILE.txt");
            FileWriter writer = new FileWriter(f, true);
            for (int i = 0; i < count; i++) {
                writer.write(messages[i] + "\n");
            }
            writer.close();
            System.out.println("Data saved");
        } catch (IOException e) {
            System.out.println("Error saving file");
        }

    }

}
