package src;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bot {
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

    if (MiniChatSystem.count < MiniChatSystem.messages.length) {
        MiniChatSystem.messages[MiniChatSystem.count] =
                    "[" + currentTime + "] " + reply;
            MiniChatSystem.count++;
    }
}
}
