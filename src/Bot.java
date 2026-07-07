package src;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bot {

    private static final String BOT_NAME = "Bot";

    public static void autoReply(String msg) {

        String reply;

        if (msg.equalsIgnoreCase("hi") || msg.equalsIgnoreCase("hello")) {
            reply = BOT_NAME + ": Hello! How are you?";

        } else if (msg.equalsIgnoreCase("how are you")) {
            reply = BOT_NAME + ": I'm doing great! Thanks for asking.";

        } else if (msg.equalsIgnoreCase("what is your name")) {
            reply = BOT_NAME + ": My name is ChatBot.";

        } else if (msg.equalsIgnoreCase("who made you")) {
            reply = BOT_NAME + ": I was created by Abdullah.";

        } else if (msg.equalsIgnoreCase("what are you")) {
            reply = BOT_NAME + ": I am a simple Java chatbot.";

        } else if (msg.equalsIgnoreCase("good morning")) {
            reply = BOT_NAME + ": Good morning! Have a wonderful day.";

        } else if (msg.equalsIgnoreCase("good afternoon")) {
            reply = BOT_NAME + ": Good afternoon!";

        } else if (msg.equalsIgnoreCase("good evening")) {
            reply = BOT_NAME + ": Good evening!";

        } else if (msg.equalsIgnoreCase("good night")) {
            reply = BOT_NAME + ": Good night! Sweet dreams.";

        } else if (msg.equalsIgnoreCase("thanks") || msg.equalsIgnoreCase("thank you")) {
            reply = BOT_NAME + ": You're welcome!";

        } else if (msg.equalsIgnoreCase("what is java")) {
            reply = BOT_NAME + ": Java is an object-oriented programming language.";

        } else if (msg.equalsIgnoreCase("what can you do")) {
            reply = BOT_NAME + ": I can reply to simple questions and chat with you.";

        } else if (msg.equalsIgnoreCase("tell me a joke")) {
            reply = BOT_NAME + ": Why do programmers prefer dark mode? Because light attracts bugs!";

        } else if (msg.equalsIgnoreCase("who is the best")) {
            reply = BOT_NAME + ": My creator, Abdullah!";

        } else if (msg.equalsIgnoreCase("bye")) {
            reply = BOT_NAME + ": Goodbye! Have a nice day.";

        } else {
            reply = BOT_NAME + ": Sorry, I don't understand that.";
        }

        String currentTime = getCurrentTime();

        if (MiniChatSystem.count < MiniChatSystem.messages.length) {
            MiniChatSystem.messages[MiniChatSystem.count] =
                    "[" + currentTime + "] " + reply;
            MiniChatSystem.count++;
        }
    }

    private static String getCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        return time.format(format);
    }
}