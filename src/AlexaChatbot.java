import java.util.Scanner;

public class AlexaChatbot {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger.printAndLog("Welcome to the Alexa Help Chatbot!");
        Logger.printAndLog("Type 'exit' to end the conversation.");

        ChatBot chatbot = new ChatBot();
        chatbot.start(scanner);
    }
}


