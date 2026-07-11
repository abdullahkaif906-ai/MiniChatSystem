package src;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChatManager {
    public static void sendMessage(Scanner sc) {

        if (MiniChatSystem.count < MiniChatSystem.messages.length) {

            System.out.print("Enter your message: ");
            String msg = sc.nextLine();

            LocalTime time = LocalTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
            String currentTime = time.format(format);

            MiniChatSystem.messages[MiniChatSystem.count] = "[" + currentTime + "] You: " + msg;

            MiniChatSystem.count++;

            // Auto Reply Feature
            Bot.autoReply(msg);

            System.out.println("Message sent!");

        } else {
            System.out.println("Chat is full!");
        }
    }

    public static void viewChat() {

        if (MiniChatSystem.count == 0) {
            System.out.println("No messages yet.");
            return;
        }

        System.out.println("\n--- Chat History ---");

        for (int i = 0; i < MiniChatSystem.count; i++) {
            System.out.println((i + 1) + ". " + MiniChatSystem.messages[i]);
        }
    }

    public static void searchMessage(Scanner sc) {

        if (MiniChatSystem.count == 0) {
            System.out.println("No messages available.");
            return;
        }

        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < MiniChatSystem.count; i++) {

            if (MiniChatSystem.messages[i].toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println("Found: " + MiniChatSystem.messages[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching messages found.");
        }
    }

    // =========================
    // METHOD 4: DELETE MESSAGE
    // =========================
    public static void deleteMessage(Scanner sc) {

        if (MiniChatSystem.count == 0) {
            System.out.println("No messages to delete.");
            return;
        }

        viewChat();

        System.out.print("Enter message number to delete: ");

        try {
            int index = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (index > 0 && index <= MiniChatSystem.count) {

                for (int i = index - 1; i < MiniChatSystem.count - 1; i++) {
                    MiniChatSystem.messages[i] = MiniChatSystem.messages[i + 1];
                }
                MiniChatSystem.count--;

                System.out.println("Message deleted!");

            } else {
                System.out.println("Invalid number!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            sc.nextLine(); // remove invalid input
        }
    }

    // =========================
    // METHOD 5: TOTAL MESSAGES
    // =========================
    public static void totalMessages() {
        System.out.println("Total messages: " + MiniChatSystem.count);
    }

    // =========================
    // METHOD 6: CLEAR CHAT
    // =========================
    public static void clearChat() {

        MiniChatSystem.count = 0;
        System.out.println("Chat cleared!");
    }
}
