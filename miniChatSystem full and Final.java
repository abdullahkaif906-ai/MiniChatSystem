import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 import java.time.LocalTime;
  import java.time.format.DateTimeFormatter;
public class miniChatSystemFinal {
    static Scanner sc = new Scanner(System.in);
    static String[] messages = new String[100];
    static int count = 0;

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
            autoReply(msg);

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
    // METHOD 7: AUTO REPLY
    // =========================
    public static void autoReply(String msg) {

    String reply;

    if (msg.equalsIgnoreCase("hi") || msg.equalsIgnoreCase("hello")) {
        reply = "Bot: Hello! How are you?";

    } else if (msg.equalsIgnoreCase("how are you")) {
        reply = "Bot: I'm doing great! Thanks for asking.";

    } else if (msg.equalsIgnoreCase("what is your name")) {
        reply = "Bot: My name is ChatBot.";

    } else if (msg.equalsIgnoreCase("who made you")) {
        reply = "Bot: I was created by Abdullah.";

    } else if (msg.equalsIgnoreCase("what are you")) {
        reply = "Bot: I am a simple Java chatbot.";

    } else if (msg.equalsIgnoreCase("good morning")) {
        reply = "Bot: Good morning! Have a wonderful day.";

    } else if (msg.equalsIgnoreCase("good afternoon")) {
        reply = "Bot: Good afternoon!";

    } else if (msg.equalsIgnoreCase("good evening")) {
        reply = "Bot: Good evening!";

    } else if (msg.equalsIgnoreCase("good night")) {
        reply = "Bot: Good night! Sweet dreams.";

    } else if (msg.equalsIgnoreCase("thanks") || msg.equalsIgnoreCase("thank you")) {
        reply = "Bot: You're welcome!";

    } else if (msg.equalsIgnoreCase("what is java")) {
        reply = "Bot: Java is an object-oriented programming language.";

    } else if (msg.equalsIgnoreCase("what can you do")) {
        reply = "Bot: I can reply to simple questions and chat with you.";

    } else if (msg.equalsIgnoreCase("tell me a joke")) {
        reply = "Bot: Why do programmers prefer dark mode? Because light attracts bugs!";

    } else if (msg.equalsIgnoreCase("who is the best")) {
        reply = "Bot: My creator, Abdullah!";

    } else if (msg.equalsIgnoreCase("bye")) {
        reply = "Bot: Goodbye! Have a nice day.";

    } else {
        reply = "Bot: Sorry, I don't understand that.";
    }

    LocalTime time = LocalTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
    String currentTime = time.format(format);

    if (count < messages.length) {
        messages[count] = "[" + currentTime + "] " + reply;
        count++;
    }
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