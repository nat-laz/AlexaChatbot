import java.util.Scanner;

public class Utils {

    public static boolean askYesNoQuestion(String question, Scanner scanner) {
        while (true) {
            System.out.print("Chatbot: " + question + " (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Chatbot: Please answer 'yes' or 'no'.");
            }
        }
    }
}
