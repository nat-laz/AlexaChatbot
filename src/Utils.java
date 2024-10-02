import java.util.Scanner;

public class Utils {

    public static boolean askYesNoQuestion(String question, Scanner scanner) {
        while (true) {
            Logger.printAndLog("Chatbot: " + question + " (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            Logger.log(response);
            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                Logger.printAndLog("Chatbot: Please answer 'yes' or 'no'.");
            }
        }
    }
}
