package src;

import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 import java.time.LocalTime;
  import java.time.format.DateTimeFormatter;
public class MiniChatSystem  {
    static Scanner sc = new Scanner(System.in);
    public static String[] messages = new String[100];
    public static int count = 0;

    public static void main(String[] args) {

        runMenu(sc);
        
    }
    
    //=========================
    //Run menu
    //=========================
    public static void runMenu(Scanner sc){
        
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
                    sendMessage(sc);
                    break;

                case 2:
                    viewChat();
                    break;

                case 3:
                    searchMessage(sc);
                    break;

                case 4:
                    deleteMessage(sc);
                    break;

                case 5:
                    totalMessages();
                    break;

                case 6:
                    clearChat();
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
        if (choice!=8){
            runMenu(sc);
        }
        } 

        
    

    // =========================
    // METHOD 1: SEND MESSAGE
    // =========================
    public static void sendMessage(Scanner sc) {

        if (count < messages.length) {

            System.out.print("Enter your message: ");
            String msg = sc.nextLine();

            LocalTime time = LocalTime.now();
              DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
              String currentTime = time.format(format);

            messages[count] = "["+ currentTime +"] You: " + msg;
            count++;

            // Auto Reply Feature
            Bot.autoReply(msg);

            System.out.println("Message sent!");

        } else {
            System.out.println("Chat is full!");
        }
    }

    // =========================
    // METHOD 2: VIEW CHAT
    // =========================
    public static void viewChat() {

        if (count == 0) {
            System.out.println("No messages yet.");
            return;
        }

        System.out.println("\n--- Chat History ---");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + messages[i]);
        }
    }

    // =========================
    // METHOD 3: SEARCH MESSAGE
    // =========================
    public static void searchMessage(Scanner sc) {

        if (count == 0) {
            System.out.println("No messages available.");
            return;
        }

        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (messages[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + messages[i]);
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

    if (count == 0) {
        System.out.println("No messages to delete.");
        return;
    }

    viewChat();

    System.out.print("Enter message number to delete: ");

    try {
        int index = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (index > 0 && index <= count) {

            for (int i = index - 1; i < count - 1; i++) {
                messages[i] = messages[i + 1];
            }
            count--;

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
        System.out.println("Total messages: " + count);
    }

    // =========================
    // METHOD 6: CLEAR CHAT
    // =========================
    public static void clearChat() {

        count = 0;
        System.out.println("Chat cleared!");
    }
   
    // =========================
    // METHOD 8: File Handling
    // =========================
    
    public static void saveData(){
        try{
            File f = new File ("MyFILE.txt");
            FileWriter writer = new FileWriter(f,true);
            for (int i = 0;i<count;i++){
                writer.write(messages[i]+"\n");
            }
            writer.close();
            System.out.println("Data saved");
        }
        catch(IOException e){
            System.out.println("Error saving file");
        }
    
    }

}
