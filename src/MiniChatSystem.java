package src;

import java.util.*;

public class MiniChatSystem {
    static final Scanner sc = new Scanner(System.in);
    public static String[] messages = new String[100];
    public static int count = 0;

    public static void main(String[] args) {

        runMenu(sc);

    }

    // =========================
    // Run menu
    // =========================
    public static void runMenu(Scanner sc) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("       MINI CHAT SYSTEM       ");
            System.out.println("=================================");
            System.out.println("1. Send Message");
            System.out.println("2. View Chat History");
            System.out.println("3. Search Message");
            System.out.println("4. Delete Message");
            System.out.println("5. Total Messages");
            System.out.println("6. Clear Chat");
            System.out.println("7. Save Chat");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

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
                    FileManager.saveData();
                    break;

                case 8:
                    FileManager.saveData();
                    System.out.println("Exiting Chat...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
