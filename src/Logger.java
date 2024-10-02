import java.util.ArrayList;
import java.util.List;

abstract class Logger {
    private static final List<String> messages = new ArrayList<>();

    public static void printAndLog(String message) {
        System.out.println(message);
        messages.add(message);
    }

    public static void log(String message) {
        messages.add(message);
    }

    public static List<String> getMessages() {
        return messages;
    }
}
