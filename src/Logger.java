import java.util.ArrayList;
import java.util.List;

class Logger {
    private List<String> messages;

    public Logger() {
        messages = new ArrayList<>();
    }

    public void printAndLog(String message) {
        System.out.println(message);
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
