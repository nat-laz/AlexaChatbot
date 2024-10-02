import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class ChatBot {
    private final IssueResolver issueResolver;

    public ChatBot() {
        issueResolver = new IssueResolver();

    }

    public void start(Scanner scanner) {
        String userInput = "";
        boolean continueChat = true;

        while (continueChat) {
            displayMenu(false);

            Logger.printAndLog("You: ");
            userInput = scanner.nextLine();
            Logger.log(userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                Logger.printAndLog("Chatbot: Goodbye! Hope I could help you.");
                break;
            }

            if (userInput.equalsIgnoreCase("history")) {
                displayHistory();
                continue;
            }

            respondToUser(userInput);

            if (Utils.askYesNoQuestion("Do you need help with anything else?", scanner)) {
                continueChat = true;
            } else {
                Logger.printAndLog("Chatbot: Goodbye! Hope I could help you.");
                continueChat = false;
            }
        }
    }


    private void displayMenu(boolean logMenu) {
        String menu = "\nWhat do you need help with?\n" + "1. Alexa not responding\n" + "2. Wi-Fi connection issues\n" + "3. Volume adjustment\n" + "4. Enabling skills\n" + "5. Updating Alexa\n" + "6. Setting up a device\n" + "7. General troubleshooting\n" + "8. Echo Dot issues\n" + "9. Play music\n" + "10. Schedule a call with our representative\n" + "Type 'history' to view conversation history.\n" + "Insert a keyword with your problem or type your question here.";

        if (logMenu) {
            Logger.printAndLog(menu);
        } else {
            System.out.println(menu);
        }
    }

    private void respondToUser(String input) {
        input = input.toLowerCase();
        Map<String, Integer> keywordCount = new HashMap<>();

        // Count occurrences of keywords for each issue
        countKeywords(input, issueResolver.alexaNotRespondingKeywords(), keywordCount, "alexaNotResponding");
        countKeywords(input, issueResolver.wifiIssuesKeywords(), keywordCount, "wifiIssues");
        countKeywords(input, issueResolver.adjustVolumeKeywords(), keywordCount, "adjustVolume");
        countKeywords(input, issueResolver.enablingSkillsKeywords(), keywordCount, "enablingSkills");
        countKeywords(input, issueResolver.checkForUpdatesKeywords(), keywordCount, "checkForUpdates");
        countKeywords(input, issueResolver.setupDeviceKeywords(), keywordCount, "setupDevice");
        countKeywords(input, issueResolver.generalTroubleshootingKeywords(), keywordCount, "generalTroubleshooting");
        countKeywords(input, issueResolver.echoDotIssuesKeywords(), keywordCount, "echoDotIssues");
        countKeywords(input, issueResolver.playMusicKeywords(), keywordCount, "playMusic");
        countKeywords(input, issueResolver.scheduleACallKeywords(), keywordCount, "scheduleACall");

        // Determine the issue with the highest count
        String mostRelevantIssue = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRelevantIssue = entry.getKey();
            }
        }

        // Respond to the most relevant issue
        if (mostRelevantIssue != null) {
            switch (mostRelevantIssue) {
                case "alexaNotResponding":
                    issueResolver.alexaNotResponding();
                    Logger.printAndLog("Request help with Issue: Alexa is not responding");
                    break;
                case "wifiIssues":
                    issueResolver.wifiIssues();
                    Logger.printAndLog("Request help with Issue: Wi-Fi connection problems");
                    break;
                case "adjustVolume":
                    issueResolver.adjustVolume();
                    Logger.printAndLog("Request help with Issue: Adjusting the volume");
                    break;
                case "enablingSkills":
                    issueResolver.enablingSkills();
                    Logger.printAndLog("Request help with Issue: Enabling Alexa skills");
                    break;
                case "checkForUpdates":
                    issueResolver.checkForUpdates();
                    Logger.printAndLog("Request help with Issue: Checking for updates");
                    break;
                case "setupDevice":
                    issueResolver.setupDevice();
                    Logger.printAndLog("Request help with Issue: Setting up a new device");
                    break;
                case "generalTroubleshooting":
                    issueResolver.generalTroubleshooting();
                    Logger.printAndLog("Request help with Issue: General troubleshooting");
                    break;
                case "echoDotIssues":
                    issueResolver.echoDotIssues();
                    Logger.printAndLog("Request help with Issue: Echo Dot problems");
                    break;
                case "playMusic":
                    issueResolver.playMusic();
                    Logger.printAndLog("Request help with Issue: Playing music");
                    break;
                case "scheduleACall":
                    issueResolver.scheduleACall();
                    Logger.printAndLog("Request help with Issue: Scheduling a call");
                    break;
            }
        } else {
            Logger.printAndLog("Chatbot: I'm sorry, I didn't understand that. Please try asking about common issues with Alexa or refer to the menu.");
            displayMenu(true);
        }
    }

    private void countKeywords(String input, Set<String> keywords, Map<String, Integer> keywordCount, String issueKey) {
        int count = 0;
        for (String keyword : keywords) {
            if (input.contains(keyword)) {
                count++;
            }
        }
        keywordCount.put(issueKey, count);
    }

    private void displayHistory() {
        if (Logger.getMessages().isEmpty()) {
            System.out.println("Chatbot: No conversation history available.");
        } else {
            System.out.println("Chatbot: Here is your conversation history:");
            for (String message : Logger.getMessages()) {
                System.out.println(message);
            }
        }
    }
}
