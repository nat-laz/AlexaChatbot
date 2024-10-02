import java.util.Scanner;

public class AlexaChatbot {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Alexa Help Chatbot!");
        System.out.println("Type 'exit' to end the conversation.");

        ChatBot chatbot = new ChatBot();
        chatbot.start(scanner);
    }
}


